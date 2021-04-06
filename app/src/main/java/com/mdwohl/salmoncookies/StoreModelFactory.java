package com.mdwohl.salmoncookies;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class StoreModelFactory extends ViewModelProvider.NewInstanceFactory {
    @NonNull private final Application application;
    public StoreModelFactory(@NonNull Application application){
        this.application = application;
    }
    public <T extends ViewModel> T create(@NonNull Class <T> modelClass){
        return (T) new StoreModel(this.application);
    }

}
