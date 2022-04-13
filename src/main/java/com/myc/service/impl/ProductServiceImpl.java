package com.myc.service.impl;

import com.myc.entity.Product;
import com.myc.mapper.ProductMapper;
import com.myc.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author myc
 * @since 2022-04-12 16:46:52
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
