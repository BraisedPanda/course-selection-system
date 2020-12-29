package com.braisedpanda.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @program: course-selection-system
 * @description: 用户信息
 * @author: chenzhen
 * @create: 2020-12-29 16:07
 **/
@Data
@ApiModel(value = "SysUser对象", description = "用户信息")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("登录账号")
    private String loginAccount;

    @ApiModelProperty("登录密码")
    private String password;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("应对角色")
    private String roles;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("创建者")
    private Integer createUser;

    @ApiModelProperty("创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty("更新者")
    private Integer updateUser;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateDate;
}
