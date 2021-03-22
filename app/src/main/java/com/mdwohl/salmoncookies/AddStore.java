package com.mdwohl.salmoncookies;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddStore extends AppCompatActivity {

    private EditText etStoreLocation;
    private EditText etStoreAverageCookies;
    private EditText etStoreMinCustomers;
    private EditText etStoreMaxCustomers;
    private Button createStore;
    private StoreDatabase storeDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_store);
        initUi();
        storeDatabase = StoreDatabase.get();
        }

    private void initUi() {
        etStoreLocation = findViewById(R.id.editTextLocation);
        etStoreAverageCookies = findViewById(R.id.editTextAverageCustomerSales);
        etStoreMinCustomers = findViewById(R.id.editTextMinCustomers);
        etStoreMaxCustomers = findViewById(R.id.editTextMaxCustomers);
        createStore = findViewById(R.id.buttonAddStore);
    }

    public void addStoreOnClick (View view){
        Log.d("addStore", etStoreLocation.getText().toString());
        String location = etStoreLocation.getText().toString();
        Float averagePerCust = Float.parseFloat(String.valueOf(etStoreAverageCookies.getText()));
        Integer min = Integer.parseInt(String.valueOf(etStoreMinCustomers.getText()));
        Integer max = Integer.parseInt(String.valueOf(etStoreMaxCustomers.getText()));
        Store store = new Store(location, averagePerCust, min, max);
        storeDatabase.addStore(store);

    }

    }
