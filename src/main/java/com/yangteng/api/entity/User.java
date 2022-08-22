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
 * 系统用户
 * </p>
 *
 * @author 林河
 * @since 2022-08-23
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("user")
@ApiModel(value = "User对象", description = "系统用户")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("头像")
    @TableField("avatar_id")
    private Long avatarId;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("状态：1启用、0禁用")
    @TableField("enabled")
    private Long enabled;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("部门名称")
    @TableField("dept_id")
    private Long deptId;

    @ApiModelProperty("手机号码")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("岗位名称")
    @TableField("job_id")
    private Long jobId;

    @ApiModelProperty("创建日期")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("最后修改密码的日期")
    @TableField("last_password_reset_time")
    private LocalDateTime lastPasswordResetTime;

    @TableField("nick_name")
    private String nickName;

    @TableField("sex")
    private String sex;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField("is_del")
    @TableLogic
    private Boolean isDel;
}
