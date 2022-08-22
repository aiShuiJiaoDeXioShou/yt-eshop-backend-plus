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
 * 用户表
 * </p>
 *
 * @author 林河
 * @since 2022-08-23
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("eshop_user")
@ApiModel(value = "EshopUser对象", description = "用户表")
public class EshopUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id")
    @TableId(value = "uid", type = IdType.AUTO)
    private Long uid;

    @ApiModelProperty("用户账户(跟accout一样)")
    @TableField("username")
    private String username;

    @ApiModelProperty("用户密码（跟pwd）")
    @TableField("password")
    private String password;

    @ApiModelProperty("真实姓名")
    @TableField("real_name")
    private String realName;

    @ApiModelProperty("生日")
    @TableField("birthday")
    private Integer birthday;

    @ApiModelProperty("身份证号码")
    @TableField("card_id")
    private String cardId;

    @ApiModelProperty("用户备注")
    @TableField("mark")
    private String mark;

    @ApiModelProperty("合伙人id")
    @TableField("partner_id")
    private Integer partnerId;

    @ApiModelProperty("用户分组id")
    @TableField("group_id")
    private Integer groupId;

    @ApiModelProperty("用户昵称")
    @TableField("nickname")
    private String nickname;

    @ApiModelProperty("用户头像")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty("手机号码")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("添加ip")
    @TableField("add_ip")
    private String addIp;

    @ApiModelProperty("添加时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("最后一次登录时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("最后一次登录ip")
    @TableField("last_ip")
    private String lastIp;

    @ApiModelProperty("用户余额")
    @TableField("now_money")
    private BigDecimal nowMoney;

    @ApiModelProperty("佣金金额")
    @TableField("brokerage_price")
    private BigDecimal brokeragePrice;

    @ApiModelProperty("用户剩余积分")
    @TableField("integral")
    private BigDecimal integral;

    @ApiModelProperty("连续签到天数")
    @TableField("sign_num")
    private Integer signNum;

    @ApiModelProperty("1为正常，0为禁止")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty("等级")
    @TableField("level")
    private Byte level;

    @ApiModelProperty("推广元id")
    @TableField("spread_uid")
    private Long spreadUid;

    @ApiModelProperty("推广员关联时间")
    @TableField("spread_time")
    private LocalDateTime spreadTime;

    @ApiModelProperty("用户类型")
    @TableField("user_type")
    private String userType;

    @ApiModelProperty("是否为推广员")
    @TableField("is_promoter")
    private Byte isPromoter;

    @ApiModelProperty("用户购买次数")
    @TableField("pay_count")
    private Integer payCount;

    @ApiModelProperty("下级人数")
    @TableField("spread_count")
    private Integer spreadCount;

    @ApiModelProperty("详细地址")
    @TableField("addres")
    private String addres;

    @ApiModelProperty("管理员编号 ")
    @TableField("adminid")
    private Integer adminid;

    @ApiModelProperty("用户登陆类型，h5,wechat,routine")
    @TableField("login_type")
    private String loginType;

    @ApiModelProperty("微信用户json信息")
    @TableField("wx_profile")
    private String wxProfile;

    @TableField("is_del")
    @TableLogic
    private Boolean isDel;
}
