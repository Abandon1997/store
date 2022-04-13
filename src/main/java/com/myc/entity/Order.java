package com.myc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>
 *
 * </p>
 *
 * @author myc
 * @since 2022-04-12 16:46:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单id")
    @TableId(value = "oid", type = IdType.AUTO)
    private Integer oid;

    @ApiModelProperty("用户id")
    @TableField("uid")
    private Integer uid;

    @ApiModelProperty("收货人姓名")
    @TableField("recv_name")
    private String recvName;

    @ApiModelProperty("收货人电话")
    @TableField("recv_phone")
    private String recvPhone;

    @ApiModelProperty("收货人所在省")
    @TableField("recv_province")
    private String recvProvince;

    @ApiModelProperty("收货人所在市")
    @TableField("recv_city")
    private String recvCity;

    @ApiModelProperty("收货人所在区")
    @TableField("recv_area")
    private String recvArea;

    @ApiModelProperty("收货详细地址")
    @TableField("recv_address")
    private String recvAddress;

    @ApiModelProperty("总价")
    @TableField("total_price")
    private Long totalPrice;

    @ApiModelProperty("状态：0-未支付，1-已支付，2-已取消，3-已关闭，4-已完成")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("下单时间")
    @TableField("order_time")
    private LocalDateTime orderTime;

    @ApiModelProperty("支付时间")
    @TableField("pay_time")
    private LocalDateTime payTime;

    @ApiModelProperty("创建人")
    @TableField("created_user")
    private String createdUser;

    @ApiModelProperty("创建时间")
    @TableField("created_time")
    private LocalDateTime createdTime;

    @ApiModelProperty("修改人")
    @TableField("modified_user")
    private String modifiedUser;

    @ApiModelProperty("修改时间")
    @TableField("modified_time")
    private LocalDateTime modifiedTime;


}
