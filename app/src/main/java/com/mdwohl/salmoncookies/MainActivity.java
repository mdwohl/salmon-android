package com.mdwohl.salmoncookies;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Store> storeList = getStores();
        RecyclerView recyclerView = findViewById(R.id.hour_rv);
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

    public void onClickListener(View view){
        Intent intent = new Intent(this, ContactPage.class);
        startActivity(intent);

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

}