package com.yang.ioc.config;

import com.yang.ioc.bean.NewsListener;
import com.yang.ioc.bean.NewsPersister;
import com.yang.ioc.bean.NewsProvider;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @Author rycoyang
 * @Date 2019/11/1 16:26
 * <p>
 * BeanDefinitionRegistry在BeanFactory的实现中担当Bean注册管理的角色
 * BeanFactory接口只定义如何访问容器内管理的Bean的方法
 **/
public class BeanFactoryRegistry {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        BeanFactory beanFactory = bindViaCode(beanRegistry);
        NewsProvider newsProvider = (NewsProvider) beanFactory.getBean("newsProvider");
        newsProvider.getNews();
    }

    private static BeanFactory bindViaCode(BeanDefinitionRegistry registry) {
        AbstractBeanDefinition newsProvider = new RootBeanDefinition(NewsProvider.class);
        AbstractBeanDefinition newsListener = new RootBeanDefinition(NewsListener.class);
        AbstractBeanDefinition newsPersister = new RootBeanDefinition(NewsPersister.class);

        //将bean定义注册到容器中
        registry.registerBeanDefinition("newsProvider", newsProvider);
        registry.registerBeanDefinition("newsListener", newsListener);
        registry.registerBeanDefinition("newsPersister", newsPersister);

        //指定依赖关系
        //1、通过构造方法注入
//        ConstructorArgumentValues argumentValues = new ConstructorArgumentValues();
//        argumentValues.addIndexedArgumentValue(0, newsListener);
//        argumentValues.addIndexedArgumentValue(1, newsPersister);
//        newsProvider.setConstructorArgumentValues(argumentValues);

        //2、通过setter注入
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        //名字必须为字段名
        propertyValues.addPropertyValue(new PropertyValue("listener", newsListener));
        propertyValues.addPropertyValue(new PropertyValue("persister", newsPersister));
        newsProvider.setPropertyValues(propertyValues);

        return (BeanFactory) registry;
    }


}
