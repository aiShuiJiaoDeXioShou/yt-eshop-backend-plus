package com.yangteng.api.comm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiRest<T> {
    private Integer status;
    private Boolean success;
    private String message;
    private Object data;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private Date time = new Date();

    public static ApiRest ok(){
        ApiRest apiRest = new ApiRest();
        apiRest.setData("成功了，吃香槟了，啦啦啦啦！！！");
        apiRest.setMessage("成功了，吃香槟了，啦啦啦啦！！！");
        apiRest.setStatus(200);
        apiRest.setSuccess(true);
        return apiRest;
    }

    public static ApiRest fail(){
        ApiRest apiRest = new ApiRest();
        apiRest.setData("失败了，吃屎吧，啦啦啦啦！！！");
        apiRest.setMessage("失败了，吃屎吧，啦啦啦啦！！！");
        apiRest.setStatus(422);
        apiRest.setSuccess(false);
        return apiRest;
    }

    public static ApiRest fail(String message){
        ApiRest apiRest = new ApiRest();
        apiRest.setData("失败了，吃屎吧，啦啦啦啦！！！");
        apiRest.setMessage(message);
        apiRest.setStatus(422);
        apiRest.setSuccess(false);
        return apiRest;
    }

    public static ApiRest ok(Object object){
        ApiRest apiRest = new ApiRest();
        apiRest.setData(object);
        apiRest.setMessage("成功了，吃香槟了，啦啦啦啦！！！");
        apiRest.setStatus(200);
        apiRest.setSuccess(true);
        return apiRest;
    }

    public static ApiRest unauthorized(){
        ApiRest apiRest = new ApiRest();
        apiRest.setMessage("没用该用户的信息，请重新登入");
        apiRest.setStatus(401);
        apiRest.setSuccess(false);
        return apiRest;
    }

    public static ApiRest notFind(){
        ApiRest apiRest = new ApiRest();
        apiRest.setMessage("未找到该信息，请重新确定请求值");
        apiRest.setStatus(404);
        apiRest.setSuccess(false);
        return apiRest;
    }
}
