package com.yangteng.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户充值表
 * </p>
 *
 * @author 林河
 * @since 2022-08-23
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("user_recharge")
@ApiModel(value = "UserRecharge对象", description = "用户充值表")
public class UserRecharge implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("充值用户UID")
    @TableField("uid")
    private Long uid;

    @TableField("nickname")
    private String nickname;

    @ApiModelProperty("订单号")
    @TableField("order_id")
    private String orderId;

    @ApiModelProperty("充值金额")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty("购买赠送金额")
    @TableField("give_price")
    private BigDecimal givePrice;

    @ApiModelProperty("充值类型")
    @TableField("recharge_type")
    private String rechargeType;

    @ApiModelProperty("是否充值")
    @TableField("paid")
    private Boolean paid;

    @ApiModelProperty("充值支付时间")
    @TableField("pay_time")
    private LocalDateTime payTime;

    @ApiModelProperty("充值时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("退款金额")
    @TableField("refund_price")
    private BigDecimal refundPrice;

    @TableField("is_del")
    @TableLogic
    private Byte isDel;
}
