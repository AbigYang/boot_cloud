package com.yang.ioc.config;

import org.springframework.beans.factory.FactoryBean;

import java.time.LocalDateTime;

/**
 * @Author rycoyang
 * @Date 2019/11/15 17:34
 **/
public class PersisterFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return LocalDateTime.now().getMinute();
    }

    @Override
    public Class<?> getObjectType() {
        return Integer.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
