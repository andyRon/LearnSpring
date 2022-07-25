package com.andyron.ch02.ch23;

import com.andyron.ch02.ch21.FXNewsBean;
import com.andyron.ch02.ch21.IFXNewsListener;

public class MarketWin24NewsListener implements IFXNewsListener {
    @Override
    public String[] getAvailableNewsIds() {
        return new String[0];
    }

    @Override
    public FXNewsBean getNewsByPK(String newsId) {
        return null;
    }

    @Override
    public void postProcessIfNecessary(String newsId) {

    }
}
