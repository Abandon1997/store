package com.myc.pojo;

import com.myc.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    Integer updatePasswordByUid() {
        userMapper.updatePasswordByUid(5, "111", "myc", new Date());
        return null;
    }

    @Test
    void findUid() {

    }
}
