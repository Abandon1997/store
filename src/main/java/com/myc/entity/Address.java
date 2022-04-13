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
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("收货地址id")
    @TableId(value = "aid", type = IdType.AUTO)
    private Integer aid;

    @ApiModelProperty("归属的用户id")
    @TableField("uid")
    private Integer uid;

    @ApiModelProperty("收货人姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("省-名称")
    @TableField("province_name")
    private String provinceName;

    @ApiModelProperty("省-行政代号")
    @TableField("province_code")
    private String provinceCode;

    @ApiModelProperty("市-名称")
    @TableField("city_name")
    private String cityName;

    @ApiModelProperty("市-行政代号")
    @TableField("city_code")
    private String cityCode;

    @ApiModelProperty("区-名称")
    @TableField("area_name")
    private String areaName;

    @ApiModelProperty("区-行政代号")
    @TableField("area_code")
    private String areaCode;

    @ApiModelProperty("邮政编码")
    @TableField("zip")
    private String zip;

    @ApiModelProperty("详细地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("手机")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("固话")
    @TableField("tel")
    private String tel;

    @ApiModelProperty("标签")
    @TableField("tag")
    private String tag;

    @ApiModelProperty("是否默认：0-不默认，1-默认")
    @TableField("is_default")
    private Integer isDefault;

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
