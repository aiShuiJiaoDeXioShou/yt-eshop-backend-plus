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
 * 商品点赞和收藏表
 * </p>
 *
 * @author 林河
 * @since 2022-08-23
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("store_product_relation")
@ApiModel(value = "StoreProductRelation对象", description = "商品点赞和收藏表")
public class StoreProductRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户ID")
    @TableField("uid")
    private Long uid;

    @ApiModelProperty("商品ID")
    @TableField("product_id")
    private Long productId;

    @ApiModelProperty("类型(收藏(collect）、点赞(like))")
    @TableField("type")
    private String type;

    @ApiModelProperty("某种类型的商品(普通商品、秒杀商品)")
    @TableField("category")
    private String category;

    @ApiModelProperty("添加时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField("is_del")
    @TableLogic
    private Boolean isDel;
}
