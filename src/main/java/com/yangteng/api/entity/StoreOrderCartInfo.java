package com.yangteng.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 订单购物详情表
 * </p>
 *
 * @author 林河
 * @since 2022-08-23
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("store_order_cart_info")
@ApiModel(value = "StoreOrderCartInfo对象", description = "订单购物详情表")
public class StoreOrderCartInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("订单id")
    @TableField("oid")
    private Long oid;

    @ApiModelProperty("购物车id")
    @TableField("cart_id")
    private Long cartId;

    @ApiModelProperty("商品ID")
    @TableField("product_id")
    private Long productId;

    @ApiModelProperty("购买东西的详细信息")
    @TableField("cart_info")
    private String cartInfo;

    @ApiModelProperty("唯一id")
    @TableField("unique")
    private String unique;
}
