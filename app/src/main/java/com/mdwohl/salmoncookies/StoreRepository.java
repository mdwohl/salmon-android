package com.mdwohl.salmoncookies;

public class StoreRepository {
    private final StoreDAO storeDAO;
    private static volatile StoreRepository instance;
    private StoreRepository(StoreDAO storeDAO){
        this.storeDAO = storeDAO;
        if(StoreRepository == null){

        }
    };

    public final StoreRepository getInstance(StoreDAO storeDAO){
        this.storeDAO;
    }

    public void getStores() {
    }

    public void addStore(Store store) {
    }
}
