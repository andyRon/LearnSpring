package com.andyron.ch02.ch23;

import com.andyron.ch02.ch21.DowJonesNewsListener;
import com.andyron.ch02.ch21.DowJonesNewsPersister;

public class Main {
    public static void main(String[] args) {
        FXNewsProvider dowJonesNewsProvider = new FXNewsProvider(new DowJonesNewsListener(), new DowJonesNewsPersister());

        FXNewsProvider marketWin24NewsProvider = new FXNewsProvider(new MarketWin24NewsListener(), new MarketWin24NewsPersister());

        DowJonesNewsListener newsListener = new DowJonesNewsListener();
        DowJonesNewsPersister newsPersister = new DowJonesNewsPersister();
        FXNewsProvider newsProvider = new FXNewsProvider(newsListener, newsPersister);
        newsProvider.getAndPersistNews();
    }
}
