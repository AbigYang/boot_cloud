package com.yang.ioc.config;

import com.yang.ioc.bean.NewsBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author rycoyang 实现PersisterFactoryAware，实例将持有容器BeanFactory的引用
 * @Date 2019/11/22 10:59
 **/
public class PersisterFactoryAware implements BeanFactoryAware {
    private BeanFactory factory;
    //prototype
    private NewsBean newsBean;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.factory = beanFactory;
    }

    private void persistNews() {
        System.out.println("persist bean:" + getNewsBean());
    }

    private NewsBean getNewsBean() {
        return (NewsBean) factory.getBean("newsBean");
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersisterFactoryAware factoryAware = context.getBean(PersisterFactoryAware.class);
        PersisterFactoryAware factoryAware1 = context.getBean(PersisterFactoryAware.class);
        //两个不同的实例
        factoryAware.persistNews();
        factoryAware.persistNews();
        //相同实例
        System.out.println(factoryAware);
        System.out.println(factoryAware1);
    }
}
