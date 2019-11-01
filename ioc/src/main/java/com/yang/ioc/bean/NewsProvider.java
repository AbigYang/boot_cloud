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

    public NewsProvider(NewsListener listener, NewsPersister persister) {
        this.listener = listener;
        this.persister = persister;
    }

    public void getNews() {
        System.out.println(listener);
        System.out.println(persister);
    }

    //setter注入必须要有无参构造
    public NewsProvider() {
    }
}
