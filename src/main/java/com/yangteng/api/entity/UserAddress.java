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
 * 用户地址表
 * </p>
 *
 * @author 林河
 * @since 2022-08-23
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("user_address")
@ApiModel(value = "UserAddress对象", description = "用户地址表")
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户地址id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户id")
    @TableField("uid")
    private Long uid;

    @ApiModelProperty("收货人姓名")
    @TableField("real_name")
    private String realName;

    @ApiModelProperty("收货人电话")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("收货人所在省")
    @TableField("province")
    private String province;

    @ApiModelProperty("收货人所在市")
    @TableField("city")
    private String city;

    @TableField("city_id")
    private Integer cityId;

    @ApiModelProperty("收货人所在区")
    @TableField("district")
    private String district;

    @ApiModelProperty("收货人详细地址")
    @TableField("detail")
    private String detail;

    @ApiModelProperty("邮编")
    @TableField("post_code")
    private String postCode;

    @ApiModelProperty("经度")
    @TableField("longitude")
    private String longitude;

    @ApiModelProperty("纬度")
    @TableField("latitude")
    private String latitude;

    @ApiModelProperty("是否默认")
    @TableField("is_default")
    private Byte isDefault;

    @ApiModelProperty("是否删除")
    @TableField("is_del")
    @TableLogic
    private Byte isDel;

    @ApiModelProperty("添加时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
