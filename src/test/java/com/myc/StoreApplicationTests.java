package com.myc;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.myc.entity.User;
import com.myc.mapper.UserMapper;
import com.myc.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.Date;

@SpringBootTest
class StoreApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;


    @Test
    void contextLoads() {
    }

    @Test
    void getConnections() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", "tom");
        User user = userMapper.selectOne(queryWrapper);//只能返回一条记录，多余一条则抛出异常
        System.out.println(user);
    }

}

