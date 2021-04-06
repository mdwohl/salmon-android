package com.mdwohl.salmoncookies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static android.icu.text.MessagePattern.ArgType.SELECT;

@Dao

public interface StoreDAO {
  @Insert void addStore(Store store);

  @Query("SELECT * FROM `table` ORDER BY store_location DESC")
  LiveData<List<Store>> getAllStores();
}

