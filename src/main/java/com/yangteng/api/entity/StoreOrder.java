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
 * 订单表
 * </p>
 *
 * @author 林河
 * @since 2022-08-23
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("store_order")
@ApiModel(value = "StoreOrder对象", description = "订单表")
public class StoreOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("订单号")
    @TableField("order_id")
    private String orderId;

    @ApiModelProperty("额外订单号")
    @TableField("extend_order_id")
    private String extendOrderId;

    @ApiModelProperty("用户id")
    @TableField("uid")
    private Long uid;

    @ApiModelProperty("用户姓名")
    @TableField("real_name")
    private String realName;

    @ApiModelProperty("用户电话")
    @TableField("user_phone")
    private String userPhone;

    @ApiModelProperty("详细地址")
    @TableField("user_address")
    private String userAddress;

    @ApiModelProperty("购物车id")
    @TableField("cart_id")
    private String cartId;

    @ApiModelProperty("运费金额")
    @TableField("freight_price")
    private BigDecimal freightPrice;

    @ApiModelProperty("订单商品总数")
    @TableField("total_num")
    private Integer totalNum;

    @ApiModelProperty("订单总价")
    @TableField("total_price")
    private BigDecimal totalPrice;

    @ApiModelProperty("邮费")
    @TableField("total_postage")
    private BigDecimal totalPostage;

    @ApiModelProperty("实际支付金额")
    @TableField("pay_price")
    private BigDecimal payPrice;

    @ApiModelProperty("支付邮费")
    @TableField("pay_postage")
    private BigDecimal payPostage;

    @ApiModelProperty("抵扣金额")
    @TableField("deduction_price")
    private BigDecimal deductionPrice;

    @ApiModelProperty("优惠券id")
    @TableField("coupon_id")
    private Integer couponId;

    @ApiModelProperty("优惠券金额")
    @TableField("coupon_price")
    private BigDecimal couponPrice;

    @ApiModelProperty("支付状态")
    @TableField("paid")
    private Byte paid;

    @ApiModelProperty("支付时间")
    @TableField("pay_time")
    private LocalDateTime payTime;

    @ApiModelProperty("支付方式")
    @TableField("pay_type")
    private String payType;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("订单状态（-1 : 申请退款 -2 : 退货成功 0：待发货；1：待收货；2：已收货；3：已完成；-1：已退款）")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty("0 未退款 1 申请中 2 已退款")
    @TableField("refund_status")
    private Byte refundStatus;

    @ApiModelProperty("退款图片")
    @TableField("refund_reason_wap_img")
    private String refundReasonWapImg;

    @ApiModelProperty("退款用户说明")
    @TableField("refund_reason_wap_explain")
    private String refundReasonWapExplain;

    @ApiModelProperty("退款时间")
    @TableField("refund_reason_time")
    private LocalDateTime refundReasonTime;

    @ApiModelProperty("前台退款原因")
    @TableField("refund_reason_wap")
    private String refundReasonWap;

    @ApiModelProperty("不退款的理由")
    @TableField("refund_reason")
    private String refundReason;

    @ApiModelProperty("退款金额")
    @TableField("refund_price")
    private BigDecimal refundPrice;

    @ApiModelProperty("快递公司编号")
    @TableField("delivery_sn")
    private String deliverySn;

    @ApiModelProperty("快递名称/送货人姓名")
    @TableField("delivery_name")
    private String deliveryName;

    @ApiModelProperty("发货类型")
    @TableField("delivery_type")
    private String deliveryType;

    @ApiModelProperty("快递单号/手机号")
    @TableField("delivery_id")
    private String deliveryId;

    @ApiModelProperty("消费赚取积分")
    @TableField("gain_integral")
    private BigDecimal gainIntegral;

    @ApiModelProperty("使用积分")
    @TableField("use_integral")
    private BigDecimal useIntegral;

    @ApiModelProperty("实际支付积分")
    @TableField("pay_integral")
    private BigDecimal payIntegral;

    @ApiModelProperty("给用户退了多少积分")
    @TableField("back_integral")
    private BigDecimal backIntegral;

    @ApiModelProperty("备注")
    @TableField("mark")
    private String mark;

    @ApiModelProperty("是否删除")
    @TableField("is_del")
    @TableLogic
    private Byte isDel;

    @ApiModelProperty("唯一id(md5加密)类似id")
    @TableField("unique")
    private String unique;

    @ApiModelProperty("管理员备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("商户ID")
    @TableField("mer_id")
    private Integer merId;

    @TableField("is_mer_check")
    private Byte isMerCheck;

    @ApiModelProperty("拼团产品id0一般产品")
    @TableField("combination_id")
    private Long combinationId;

    @ApiModelProperty("拼团id 0没有拼团")
    @TableField("pink_id")
    private Long pinkId;

    @ApiModelProperty("成本价")
    @TableField("cost")
    private BigDecimal cost;

    @ApiModelProperty("秒杀产品ID")
    @TableField("seckill_id")
    private Long seckillId;

    @ApiModelProperty("砍价id")
    @TableField("bargain_id")
    private Integer bargainId;

    @ApiModelProperty("核销码")
    @TableField("verify_code")
    private String verifyCode;

    @ApiModelProperty("门店id")
    @TableField("store_id")
    private Integer storeId;

    @ApiModelProperty("配送方式 1=快递 ，2=门店自提")
    @TableField("shipping_type")
    private Boolean shippingType;

    @ApiModelProperty("支付渠道(0微信公众号1微信小程序)")
    @TableField("is_channel")
    private Byte isChannel;

    @TableField("is_remind")
    private Byte isRemind;

    @TableField("is_system_del")
    private Boolean isSystemDel;
}
