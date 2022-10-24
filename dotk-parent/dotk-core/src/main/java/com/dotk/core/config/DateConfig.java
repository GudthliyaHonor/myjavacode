package com.dotk.core.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DateConfig implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        //设置属性值
        this.setFieldValByName("aid",1,metaObject);
        this.setFieldValByName("createdBy",2,metaObject);
        this.setFieldValByName("created",new Date(),metaObject);
        this.setFieldValByName("updated",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updatedBy",2,metaObject);
        this.setFieldValByName("updated",new Date(),metaObject);
    }

}
