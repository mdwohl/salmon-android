package com.mdwohl.salmoncookies;

import android.app.Application;
import android.app.AsyncNotedAppOp;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class StoreRepository {
    private final StoreDAO storeDAO;
    private LiveData<List<Store>> listAllStores;

    public StoreRepository(Application application){
       StoreDatabase db = StoreDatabase.getInstance(application);
       storeDAO = db.storeDAO();
       listAllStores = storeDAO.getAllStores();
    };
    //Repository API
    public void insert(Store store){
        new insertAsyncTask(storeDAO).execute(store);
    }

    public LiveData<List<Store>> getAllStores(){
        return listAllStores;
    };

    private static class insertAsyncTask extends AsyncTask<Store, Void, Void> {
        private final StoreDAO asyncDAO;

        public insertAsyncTask(StoreDAO storeDAO) {
            asyncDAO = storeDAO;

        }

        @Override
        protected Void doInBackground(Store... stores) {
            asyncDAO.addStore(stores[0]);
            return null;
        }
    }
}
