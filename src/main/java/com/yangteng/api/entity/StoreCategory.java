package com.yangteng.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品分类表
 * </p>
 *
 * @author 林河
 * @since 2022-08-23
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("store_category")
@ApiModel(value = "StoreCategory对象", description = "商品分类表")
public class StoreCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品分类表ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("父id")
    @TableField("pid")
    private Integer pid;

    @ApiModelProperty("分类名称")
    @TableField("cate_name")
    private String cateName;

    @ApiModelProperty("排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty("图标")
    @TableField("pic")
    private String pic;

    @ApiModelProperty("是否推荐")
    @TableField("is_show")
    private Boolean isShow;

    @ApiModelProperty("添加时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("删除状态")
    @TableField("is_del")
    @TableLogic
    private Byte isDel;
}
