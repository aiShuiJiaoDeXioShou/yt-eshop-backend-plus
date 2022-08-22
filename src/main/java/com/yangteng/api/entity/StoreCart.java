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
 * 购物车表
 * </p>
 *
 * @author 林河
 * @since 2022-08-23
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("store_cart")
@ApiModel(value = "StoreCart对象", description = "购物车表")
public class StoreCart implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("购物车表ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户ID")
    @TableField("uid")
    private Long uid;

    @ApiModelProperty("类型")
    @TableField("type")
    private String type;

    @ApiModelProperty("商品ID")
    @TableField("product_id")
    private Long productId;

    @ApiModelProperty("商品属性")
    @TableField("product_attr_unique")
    private String productAttrUnique;

    @ApiModelProperty("商品数量")
    @TableField("cart_num")
    private Short cartNum;

    @ApiModelProperty("添加时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("0 = 未购买 1 = 已购买")
    @TableField("is_pay")
    private Boolean isPay;

    @ApiModelProperty("是否删除")
    @TableField("is_del")
    @TableLogic
    private Boolean isDel;

    @ApiModelProperty("是否为立即购买")
    @TableField("is_new")
    private Boolean isNew;

    @ApiModelProperty("拼团id")
    @TableField("combination_id")
    private Integer combinationId;

    @ApiModelProperty("秒杀产品ID")
    @TableField("seckill_id")
    private Integer seckillId;

    @ApiModelProperty("砍价id")
    @TableField("bargain_id")
    private Integer bargainId;
}
