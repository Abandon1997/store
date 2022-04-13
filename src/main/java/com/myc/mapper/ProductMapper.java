package com.myc.mapper;

import com.myc.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author myc
 * @since 2022-04-12 16:46:52
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}
