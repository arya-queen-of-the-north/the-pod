package com.example.thepod.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thepod.Adapter;
import com.example.thepod.R;
import com.example.thepod.data.model.Food;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private List<Food> foods = new ArrayList<>();
    private Adapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        RandomData();

        adapter = new Adapter( getActivity(),(ArrayList<Food>) foods);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        return root;
    }
    public void RandomData(){
        Food food = new Food("Lasagha","the best food ever",23.1);
        foods.add(food);
        food = new Food("Lasagha","the best food ever",23.1);
        foods.add(food);
        food = new Food("Lasagha","the best food ever",23.1);
        foods.add(food);
        food = new Food("Lasagha","the best food ever",23.1);
        foods.add(food);
        food = new Food("Lasagha","the best food ever",23.1);
        foods.add(food);
        food = new Food("Lasagha","the best food ever",23.1);
        foods.add(food);
        food = new Food("Lasagha","the best food ever",23.1);
        foods.add(food);
        food = new Food("Lasagha","the best food ever",23.1);
        foods.add(food);
        food = new Food("Lasagha","the best food ever",23.1);
        foods.add(food);
        food = new Food("Lasagha","the best food ever",23.1);
        foods.add(food);
        food = new Food("Lasagha","the best food ever",23.1);
        foods.add(food);
        food = new Food("Lasagha","the best food ever",23.1);
        foods.add(food);
        food = new Food("Lasagha","the best food ever",23.1);
        foods.add(food);
    }

}