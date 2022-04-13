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
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("购物车数据id")
    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;

    @ApiModelProperty("用户id")
    @TableField("uid")
    private Integer uid;

    @ApiModelProperty("商品id")
    @TableField("pid")
    private Integer pid;

    @ApiModelProperty("加入时商品单价")
    @TableField("price")
    private Long price;

    @ApiModelProperty("商品数量")
    @TableField("num")
    private Integer num;

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
