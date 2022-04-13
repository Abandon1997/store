package com.myc.service;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.myc.entity.User;
import com.myc.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;


@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    void register() {
        try {
            User user = new User();
            user.setUsername("111");
            user.setPassword("111");
            userService.reg(user);
            System.out.println("ok");
        } catch (Exception e) {
            e.printStackTrace();
            // 获取类的对象，在获取类的名称
            System.out.println(e.getClass().getSimpleName());
            // 获取异常的具体描述信息
            System.out.println(e.getMessage());
        }
    }

    @Test
    void login() {
        User user = userService.login("111", "111");
        System.out.println(user);
    }

    @Test
    void uodateusername() {
        userService.changePassword(5, "管理员", "111", "222");
    }
}
