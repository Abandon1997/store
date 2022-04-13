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
public class ProductCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId("id")
    private Integer id;

    @ApiModelProperty("父分类id")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty("名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("状态   1：正常   0：删除")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("排序号")
    @TableField("sort_order")
    private Integer sortOrder;

    @ApiModelProperty("是否是父分类   1：是  0：否")
    @TableField("is_parent")
    private Integer isParent;

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
