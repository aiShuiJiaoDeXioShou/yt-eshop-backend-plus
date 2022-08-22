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
 * 商品表
 * </p>
 *
 * @author 林河
 * @since 2022-08-23
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("store_product")
@ApiModel(value = "StoreProduct对象", description = "商品表")
public class StoreProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("商户Id(0为总后台管理员创建,不为0的时候是商户后台创建)")
    @TableField("mer_id")
    private Integer merId;

    @ApiModelProperty("商品图片")
    @TableField("image")
    private String image;

    @ApiModelProperty("轮播图")
    @TableField("slider_image")
    private String sliderImage;

    @ApiModelProperty("商品名称")
    @TableField("store_name")
    private String storeName;

    @ApiModelProperty("商品简介")
    @TableField("store_info")
    private String storeInfo;

    @ApiModelProperty("关键字")
    @TableField("keyword")
    private String keyword;

    @ApiModelProperty("产品条码（一维码）")
    @TableField("bar_code")
    private String barCode;

    @ApiModelProperty("分类id")
    @TableField("cate_id")
    private String cateId;

    @ApiModelProperty("商品价格")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty("会员价格")
    @TableField("vip_price")
    private BigDecimal vipPrice;

    @ApiModelProperty("市场价")
    @TableField("ot_price")
    private BigDecimal otPrice;

    @ApiModelProperty("邮费")
    @TableField("postage")
    private BigDecimal postage;

    @ApiModelProperty("单位名")
    @TableField("unit_name")
    private String unitName;

    @ApiModelProperty("排序")
    @TableField("sort")
    private Short sort;

    @ApiModelProperty("销量")
    @TableField("sales")
    private Integer sales;

    @ApiModelProperty("库存")
    @TableField("stock")
    private Integer stock;

    @ApiModelProperty("状态（0：未上架，1：上架）")
    @TableField("is_show")
    private Boolean isShow;

    @ApiModelProperty("是否热卖")
    @TableField("is_hot")
    private Boolean isHot;

    @ApiModelProperty("是否优惠")
    @TableField("is_benefit")
    private Boolean isBenefit;

    @ApiModelProperty("是否精品")
    @TableField("is_best")
    private Boolean isBest;

    @ApiModelProperty("是否新品")
    @TableField("is_new")
    private Boolean isNew;

    @ApiModelProperty("产品描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("添加时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("是否包邮")
    @TableField("is_postage")
    private Byte isPostage;

    @ApiModelProperty("是否删除")
    @TableField("is_del")
    @TableLogic
    private Byte isDel;

    @ApiModelProperty("商户是否代理 0不可代理1可代理")
    @TableField("mer_use")
    private Byte merUse;

    @ApiModelProperty("获得积分")
    @TableField("give_integral")
    private BigDecimal giveIntegral;

    @ApiModelProperty("成本价")
    @TableField("cost")
    private BigDecimal cost;

    @ApiModelProperty("秒杀状态 0 未开启 1已开启")
    @TableField("is_seckill")
    private Byte isSeckill;

    @ApiModelProperty("砍价状态 0未开启 1开启")
    @TableField("is_bargain")
    private Byte isBargain;

    @ApiModelProperty("是否优品推荐")
    @TableField("is_good")
    private Boolean isGood;

    @ApiModelProperty("虚拟销量")
    @TableField("ficti")
    private Integer ficti;

    @ApiModelProperty("浏览量")
    @TableField("browse")
    private Integer browse;

    @ApiModelProperty("产品二维码地址(用户小程序海报)")
    @TableField("code_path")
    private String codePath;

    @ApiModelProperty("是否单独分佣")
    @TableField("is_sub")
    private Boolean isSub;

    @ApiModelProperty("运费模板ID")
    @TableField("temp_id")
    private Integer tempId;

    @ApiModelProperty("规格 0单 1多")
    @TableField("spec_type")
    private Boolean specType;

    @ApiModelProperty("是开启积分兑换")
    @TableField("is_integral")
    private Byte isIntegral;

    @ApiModelProperty("需要多少积分兑换 只在开启积分兑换时生效")
    @TableField("integral")
    private Integer integral;
}
