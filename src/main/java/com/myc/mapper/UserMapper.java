package com.myc.mapper;

import com.myc.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author myc
 * @since 2022-04-12 16:46:52
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    Integer updatePasswordByUid(Integer uid,
                                String password,
                                String modfileUser,
                                Date modfileTime);

    User findUid(Integer uid);
}
