package com.myc.service.impl;

import com.myc.entity.Cart;
import com.myc.mapper.CartMapper;
import com.myc.service.CartService;
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
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

}
