package com.yangteng.api.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class UpdateTimeHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("开始执行字段插入时操作");
        //设置字段插入时候的操作
        //这里我们给它设置一个值
        this.setFieldValByName("createTime",LocalDateTime.now(),metaObject);
        this.setFieldValByName("updateTime",LocalDateTime.now(),metaObject);
//        updateUserId(metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("开始执行字段更新时操作");
        this.setFieldValByName("updateTime",LocalDateTime.now(),metaObject);
        updateUserId(metaObject);
    }



    // 更新用户id
    public void updateUserId(MetaObject metaObject){
       /* try{
            Long id = LocalUser.getLocalUser().getId();
            this.setFieldValByName("operatingUser",Long.bitCount(id),metaObject);
            System.out.println(id);
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("用户还未登入");
        }*/
    }
}
