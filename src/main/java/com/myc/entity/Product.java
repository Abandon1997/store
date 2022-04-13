package com.myc.entity;

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
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品id")
    @TableId("id")
    private Integer id;

    @ApiModelProperty("分类id")
    @TableField("category_id")
    private Integer categoryId;

    @ApiModelProperty("商品系列")
    @TableField("item_type")
    private String itemType;

    @ApiModelProperty("商品标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("商品卖点")
    @TableField("sell_point")
    private String sellPoint;

    @ApiModelProperty("商品单价")
    @TableField("price")
    private Long price;

    @ApiModelProperty("库存数量")
    @TableField("num")
    private Integer num;

    @ApiModelProperty("图片路径")
    @TableField("image")
    private String image;

    @ApiModelProperty("商品状态  1：上架   2：下架   3：删除")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("显示优先级")
    @TableField("priority")
    private Integer priority;

    @ApiModelProperty("创建时间")
    @TableField("created_time")
    private LocalDateTime createdTime;

    @ApiModelProperty("最后修改时间")
    @TableField("modified_time")
    private LocalDateTime modifiedTime;

    @ApiModelProperty("创建人")
    @TableField("created_user")
    private String createdUser;

    @ApiModelProperty("最后修改人")
    @TableField("modified_user")
    private String modifiedUser;


}
