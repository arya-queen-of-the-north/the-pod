package com.example.thepod.foodmenu;

import android.os.Bundle;
import android.util.Log;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thepod.R;
import com.example.thepod.data.source.local.Menu;

import java.util.List;




public class MenuActivity extends AppCompatActivity {

    private MenuViewModel menuViewModel;
    private static final String TAG = "MenuActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        MenuAdapter adapter = new MenuAdapter();
        recyclerView.setAdapter(adapter);


        menuViewModel = ViewModelProviders.of(this).get(MenuViewModel.class);
        menuViewModel.getAllFoodItems().observe(this, menus -> {
            // Update the UI.
            Log.d("Menus: ",String.valueOf(menus.size()));
            adapter.setAllFoodItems(menus);
        });

    }


}
