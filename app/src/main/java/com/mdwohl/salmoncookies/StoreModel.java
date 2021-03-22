package com.mdwohl.salmoncookies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class StoreModel extends ViewModel {
    private final StoreRepository storeRepository;
    public StoreModel(StoreRepository storeRepository){
        super();
        this.storeRepository = storeRepository;
    };

    public final LiveData getStores(){
        this.storeRepository.getStores();
    }

    public final void addStore(Store store){
        this.storeRepository.addStore(store);
    }
}
