package com.mdwohl.salmoncookies;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class StoreModel extends ViewModel {
    private StoreRepository storeRepository;
    private LiveData<List<Store>> storeList;

    public LiveData<List<Store>> getStoreList() {
        return storeList;
    }

    public StoreModel(@NonNull Application application){
        storeRepository = new StoreRepository(application);
        storeList = storeRepository.getAllStores();
    };
}
