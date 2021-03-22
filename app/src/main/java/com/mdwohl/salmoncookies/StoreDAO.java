package com.mdwohl.salmoncookies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class StoreDAO {
    private List<Store> storeList;
    private final MutableLiveData stores;
    public final LiveData getStores(){
        return this.stores;
    };

    public final void updateLiveData(){
        this.stores.setValue(this.storeList);
    }

    public StoreDAO(){
        this.stores = new MutableLiveData<>();
        this.storeList = new ArrayList<>();
    }

    public addStore(){

    }
}
