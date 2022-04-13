package com.myc.service.impl;

import com.myc.entity.OrderItem;
import com.myc.mapper.OrderItemMapper;
import com.myc.service.OrderItemService;
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
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

}
