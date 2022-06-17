package com.andyron.ch01;

public class FXNewProvider {
    private IFXNewsListener newsListener;
    private IFXNewPersister newPersister;

    public void getAndPersistNews() {
        // ...
    }

    public FXNewProvider() {
        newsListener = new DowJonesNewsListener();
        newPersister = new DowJonesNewsPersister();
    }
}
