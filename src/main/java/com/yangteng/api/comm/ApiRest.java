package com.yangteng.api.comm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class ApiRest {
    private Integer code;
    private Boolean success;
    private String message;
    private Object data;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private Date time = new Date();

    enum Type {
        SUCCESS(0,"成功！",true),
        FAILED(-1,"失败！",false),
        UNAUTHORIZED(-2,"用户未授权！",false),
        NOT_FIND(-3,"未找到该对象！",false);
        final Integer code;
        final String message;

        final Boolean success;

        Type(int code, String message,Boolean success) {
            this.code = code;
            this.message = message;
            this.success = success;
        }

    }

    public ApiRest(Type type, Object data) {
        this.code = type.code;
        this.success = type.success;
        this.message = type.message;
        this.data = data;
    }

    public static ApiRest ok(){
        ApiRest apiRest = new ApiRest();
        apiRest.setData("")
                .setMessage(Type.SUCCESS.message)
                .setCode(Type.SUCCESS.code)
                .setSuccess(true);
        return apiRest;
    }

    public static ApiRest ok(Object object){
        ApiRest apiRest = new ApiRest();
        apiRest.setData(object)
                .setMessage(Type.SUCCESS.message)
                .setCode(Type.SUCCESS.code)
                .setSuccess(true);
        return apiRest;
    }

    public static ApiRest fail(){
        ApiRest apiRest = new ApiRest();
        apiRest.setData("")
                .setMessage(Type.FAILED.message)
                .setCode(Type.FAILED.code)
                .setSuccess(false);
        return apiRest;
    }

    public static ApiRest fail(String message){
        ApiRest apiRest = new ApiRest();
        apiRest.setData("")
                .setMessage(message)
                .setCode(Type.FAILED.code)
                .setSuccess(false);
        return apiRest;
    }



    public static ApiRest unauthorized(){
        ApiRest apiRest = new ApiRest()
                .setMessage("没用该用户的信息，请重新登入")
                .setCode(Type.FAILED.code)
                .setSuccess(false);
        return apiRest;
    }

    public static ApiRest notFind(){
        ApiRest apiRest = new ApiRest();
        apiRest.setMessage("未找到该信息，请重新确定请求值")
                .setCode(Type.FAILED.code)
                .setSuccess(false);
        return apiRest;
    }
}
