package com.slp.reachable.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author slp
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;
    @ApiModelProperty(value="用户账号",name="userAccount",required=true)
    private String userAccount;
    @ApiModelProperty(value="用户密码",name="userPassword",required=true)
    private String userPassword;
    @ApiModelProperty(value="用户确认密码",name="checkPassword",required=true)
    private String checkPassword;
    @ApiModelProperty(value="用户学号",name="planetCode",required=true)
    private String StudentCode;
}
