package com.yang.ioc.bean;

import lombok.Data;

/**
 * @Author rycoyang 新闻提供者
 * @Date 2019/11/1 16:23
 **/
@Data
public class NewsProvider {
    private NewsListener listener;
    private NewsPersister persister;
    private String dependence;
    private int dependence2;
    private int dependence3;

    public NewsProvider(String dependence) {
        this.dependence = dependence;
    }

    public NewsProvider(int dependence2) {
        this.dependence2 = dependence2;
    }

    public NewsProvider(NewsListener listener, NewsPersister persister) {
        this.listener = listener;
        this.persister = persister;
    }

    public NewsProvider(NewsListener listener, NewsPersister persister, int dependence2) {
        this.listener = listener;
        this.persister = persister;
        this.dependence2 = dependence2;
    }

    public NewsProvider(NewsListener listener, NewsPersister persister, String dependence, int dependence2, int dependence3) {
        this.listener = listener;
        this.persister = persister;
        this.dependence = dependence;
        this.dependence2 = dependence2;
        this.dependence3 = dependence3;
    }

    public void getNews() {
        System.out.println(listener);
        System.out.println(persister);
    }

    //setter注入必须要有无参构造
    public NewsProvider() {
    }
}
