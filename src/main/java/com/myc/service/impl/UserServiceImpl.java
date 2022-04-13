package com.myc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.myc.entity.User;
import com.myc.mapper.UserMapper;
import com.myc.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author myc
 * @since 2022-04-12 16:46:52
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        //判断是否被注册过
        User result = userMapper.selectOne(queryWrapper);//只能返回一条记录，多余一条则抛出异常
        if (result != null) {
            throw new UsernameDuplicateException("用户名被占用");
        }

        /** 加密算法 */
        String oldPassword = user.getPassword();
        String salt = UUID.randomUUID().toString().toUpperCase();
        String md5Password = getMd5Password(oldPassword, salt);
        /*user.setSalt(md5Password);*/
        user.setPassword(md5Password);
        // 补全数据：盐值
        user.setSalt(salt);

        //补全数据
        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);
        //执行注册
        Integer rows = userMapper.insert(user);
        if (rows != 1) {
            throw new InsertException("用户在注册过程中产生了未知的异常");
        }

    }

    @Override
    public User login(String username, String password) {
        //查询用户是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User result = userMapper.selectOne(queryWrapper);

        /*User result = userMapper.findByUsername(username);*/
        if (result == null) {
            throw new UserNotFoundException("用户不数据存在");
        }
        //判断isdelete是否为1
        if (result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户数据不存在");
        }
        //检查用户的密码是否匹配
        String oldPassword = result.getPassword();
        //获取盐值
        String salt = result.getSalt();
        String newMd5Password = getMd5Password(password, salt);
        //将密码进行比较
        if (!result.getPassword().equals(newMd5Password)) {
            // 是：抛出PasswordNotMatchException异常
            throw new PasswordNotMatchException("密码验证失败的错误");
        }

        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setPassword(result.getPassword());

        return user;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("uid", uid);
        User result = userMapper.selectOne(updateWrapper);
        if (result == null || result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户数据不存在");
        }
        String oldMd5Password = getMd5Password(oldPassword, result.getSalt());
        if (!result.getPassword().contentEquals(oldMd5Password)) {
            throw new PasswordNotMatchException("与原密码相同，请重新输入");
        }
        String newMd5Password = getMd5Password(newPassword, result.getSalt());

        User user = new User();
        user.setPassword(newMd5Password);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        Integer rows = userMapper.update(user, updateWrapper);
        if (rows != 1) {
            throw new UpdateException("更新时产生未知的异常");
        }
    }

    /**
     * 执行密码加密
     *
     * @param password 原始密码
     * @param salt     盐值
     * @return 加密后的密文
     */
    private String getMd5Password(String password, String salt) {
        /*
         * 加密规则：
         * 1、无视原始密码的强度
         * 2、使用UUID作为盐值，在原始密码的左右两侧拼接
         * 3、循环加密3次
         */
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }
}
