package com.slp.reachable.common;



import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用返回类
 *
 * @param <T>
 * @author slp
 */
@Data
public class BaseResponse<T> implements Serializable {
    @ApiModelProperty(value="请求响应码",name="code",required=true)
    private int code;
    @ApiModelProperty(value="目标数据",name="data",required=true)
    private T data;
    @ApiModelProperty(value="响应信息",name="message",required=true)
    private String message;
    @ApiModelProperty(value="详情描述",name="description",required=true)
    private String description;

    public BaseResponse(int code, T data, String message, String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = description;
    }

    public BaseResponse(int code, T data, String message) {
        this(code, data, message, "");
    }

    public BaseResponse(int code, T data) {
        this(code, data, "", "");
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null, errorCode.getMessage(), errorCode.getDescription());
    }
}
