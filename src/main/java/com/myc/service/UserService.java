package com.myc.service;

import com.myc.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author myc
 * @since 2022-04-12 16:46:52
 */
public interface UserService extends IService<User> {
    /**
     * 用户注册方法
     *
     * @param user 用户的数据对象
     */
    void reg(User user);

    User login(String username, String password);

    void changePassword(Integer uid,
                        String username,
                        String oldPassword,
                        String newPassword);
}
