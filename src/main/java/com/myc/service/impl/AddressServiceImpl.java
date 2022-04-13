package com.myc.service.impl;

import com.myc.entity.Address;
import com.myc.mapper.AddressMapper;
import com.myc.service.AddressService;
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
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

}
