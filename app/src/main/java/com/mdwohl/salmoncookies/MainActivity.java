package com.mdwohl.salmoncookies;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StoreModel storeModel;
    private StoreModelFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        factory = new StoreModelFactory(getApplication());
        storeModel = new ViewModelProvider(this,factory).get(StoreModel.class);
        RecyclerView recyclerView = findViewById(R.id.hour_rv);
        List<Store> storeList = storeModel.getStoreList().getValue();
        StoreLocationAdapter storeLocationAdapter = new StoreLocationAdapter(storeList);
        recyclerView.setAdapter(storeLocationAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void intentToContact(View view){
        Intent intent = new Intent(this, ContactPage.class);
        startActivity(intent);

    }

    public void intentToAdd(View view){
        Intent intent = new Intent(this, AddStore.class);
        startActivity(intent);
    }



}