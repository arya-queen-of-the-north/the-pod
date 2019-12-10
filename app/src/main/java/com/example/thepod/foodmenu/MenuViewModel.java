package com.example.thepod.foodmenu;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.thepod.R;
import com.example.thepod.data.source.PodRepository;
import com.example.thepod.data.source.local.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuViewModel extends AndroidViewModel {
    private static final String TAG = "MenuViewModel";
    private PodRepository repository;
    private MutableLiveData<List<Menu>> allFoodItems;
    private ArrayList<Menu>listOfMenu = new ArrayList<>();

    public MenuViewModel(@NonNull Application application) {
        super(application);
        allFoodItems=new MutableLiveData<>();
        allFoodItems.setValue(new ArrayList<>());
        repository = new PodRepository(application);
//        listOfMenu.add(new Menu(R.drawable.lasagna,"Lasagna","Tasty",
//                        "5.0","500",R.drawable.ic_star,
//                R.drawable.ic_add_circle_24px));
//        listOfMenu.add(new Menu(R.drawable.lasagna,"Lasagna","Tasty",
//                "5.0","500",R.drawable.ic_star,
//                R.drawable.ic_add_circle_24px));
//        listOfMenu.add(new Menu(R.drawable.lasagna,"Lasagna","Tasty",
//                "5.0","500",R.drawable.ic_star,
//                R.drawable.ic_add_circle_24px));
//        listOfMenu.add(new Menu(R.drawable.lasagna,"Lasagna","Tasty",
//                "5.0","500",R.drawable.ic_star,
//                R.drawable.ic_add_circle_24px));
//        listOfMenu.add(new Menu(R.drawable.lasagna,"Lasagna","Tasty",
//                "5.0","500",R.drawable.ic_star,
//                R.drawable.ic_add_circle_24px));
//        listOfMenu.add(new Menu(R.drawable.lasagna,"Lasagna","Tasty",
//                "5.0","500",R.drawable.ic_star,
//                R.drawable.ic_add_circle_24px));
//        allFoodItems.setValue(listOfMenu);

        allFoodItems = repository.getAllFoodItems();

    }

    public void insert(Menu foodItems){
        repository.insert(foodItems);
    }

    public void update(Menu foodItems){
        repository.update(foodItems);
    }

    public void delete(Menu foodItems){
        repository.update(foodItems);
    }

    public MutableLiveData<List<Menu>> getAllFoodItems() {

        return allFoodItems;
    }
}
