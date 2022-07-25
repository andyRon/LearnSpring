package com.andyron.ch02.ch21;

/**
 * 抓去新闻内容
 */
public interface IFXNewsListener {

    String[] getAvailableNewsIds();

    FXNewsBean getNewsByPK(String newsId);

    void postProcessIfNecessary(String newsId);
}
