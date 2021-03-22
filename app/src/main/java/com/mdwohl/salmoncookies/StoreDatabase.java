package com.mdwohl.salmoncookies;

import java.util.ArrayList;
import java.util.List;

public class StoreDatabase {
    private List<Store> mStores;
    private StoreDAO storeDAO;
    private StoreDatabase(){
        this.mStores = getStores();
        this.storeDAO = new StoreDAO();
    }

    public List<Store> getmStores() {
        return mStores;
    }
    public List<Store> getStores() {
        List<Store> storeList = new ArrayList();
        storeList.add(new Store("Seattle", 6.3f, 23, 65));
        storeList.add(new Store("Tokyo", 1.2f, 3, 24));
        storeList.add(new Store("Dubai", 3.7f, 11, 38));
        storeList.add(new Store("Paris", 2.3f, 20, 38));
        storeList.add(new Store("Lima", 4.6f, 2, 16));
        return storeList;
    }

    public void addStore(Store store){
        this.mStores.add(store);
    }

    private static StoreDatabase storeDB;
    public static StoreDatabase get(){
        if(storeDB == null){
            storeDB = new StoreDatabase();
        }
        return storeDB;
    };

}

