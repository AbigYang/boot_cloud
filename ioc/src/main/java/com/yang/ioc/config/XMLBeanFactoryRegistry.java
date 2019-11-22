package com.yang.ioc.config;

import com.yang.ioc.IocApplication;
import com.yang.ioc.bean.NewsPersister;
import com.yang.ioc.bean.NewsProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author rycoyang
 * @Date 2019/11/14 16:14
 **/
public class XMLBeanFactoryRegistry {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        NewsProvider provider = context.getBean(NewsProvider.class);
        System.out.println(provider);
        System.out.println(context.getBean(NewsPersister.class));
        System.out.println(context.getBean("localDateTime"));//现在分钟数 Integer
        System.out.println(context.getBean("&localDateTime"));//PersisterFactoryBean这个类的实例
        System.out.println(((PersisterFactoryBean) context.getBean("&localDateTime")).getObject());//现在分钟数 Integer

    }
}
