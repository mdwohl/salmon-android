package com.mdwohl.salmoncookies;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
@Database(entities = {Store.class
}, version = 1)

public abstract class StoreDatabase extends RoomDatabase {
    public abstract StoreDAO storeDAO();
    private static StoreDatabase INSTANCE;

    static StoreDatabase getInstance(final Context context){
        if(INSTANCE == null){
            synchronized (StoreDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    StoreDatabase.class,
                            "db")
                            .fallbackToDestructiveMigration()
                            .addCallback(populateCallback)
                            .build();
                }
            }
        }
        return INSTANCE;

    }
    private static RoomDatabase.Callback populateCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new populateDatabaseAsyncTask(INSTANCE).execute();
        }
    };

    private static class populateDatabaseAsyncTask extends AsyncTask<Void, Void, Void>{
        private StoreDAO storeDAO;
        private populateDatabaseAsyncTask(StoreDatabase db){
            storeDAO = db.storeDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            storeDAO.addStore(new Store("Seattle", 6.3f, 23, 65));
            storeDAO.addStore(new Store("Tokyo", 1.2f, 3, 24));
            storeDAO.addStore(new Store("Dubai", 3.7f, 11, 38));
            storeDAO.addStore(new Store("Paris", 2.3f, 20, 38));
            storeDAO.addStore(new Store("Lima", 4.6f, 2, 16));
            return null;
        }
    }
}

