package com.andyron.ch02.ch23;

import com.andyron.ch02.ch21.IFXNewsPersister;
import com.andyron.ch02.ch21.IFXNewsListener;

public class FXNewsProvider {
    private IFXNewsListener newsListener;
    private IFXNewsPersister newPersister;


    public void getAndPersistNews() {
        // ...
    }

    public FXNewsProvider(IFXNewsListener ifxNewsListener, IFXNewsPersister ifxNewPersister) {
        this.newPersister = ifxNewPersister;
        this.newPersister = ifxNewPersister;
    }
}
