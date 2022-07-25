package com.andyron.ch02.ch21;

import java.util.Collections;

public class FXNewsProvider {
    private IFXNewsListener newsListener;
    private IFXNewsPersister newsPersister;

    public FXNewsProvider() {
        newsListener = new DowJonesNewsListener();
        newsPersister = new DowJonesNewsPersister();
    }

    public void getAndPersistNews() {
        String[] newsIds = newsListener.getAvailableNewsIds();
        // todo 判断newsIds是否为空
        if (false) {
            return;
        }
        for (String newsId : newsIds) {
            FXNewsBean newsBean = newsListener.getNewsByPK(newsId);
            newsPersister.persistNews(newsBean);
            newsListener.postProcessIfNecessary(newsId);
        }
        System.out.println("获取并存储新闻");
    }

    public IFXNewsListener getNewsListener() {
        return newsListener;
    }

    public void setNewsListener(IFXNewsListener newsListener) {
        this.newsListener = newsListener;
    }

    public IFXNewsPersister getNewsPersister() {
        return newsPersister;
    }

    public void setNewsPersister(IFXNewsPersister newsPersister) {
        this.newsPersister = newsPersister;
    }
}
