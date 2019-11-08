package com.example.thepod;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thepod.Food.FoodViewHolder;
import com.example.thepod.data.model.Food;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<FoodViewHolder> {

    private ArrayList<Food> foods;
    private LayoutInflater inflater;

    public Adapter(Context context, ArrayList<Food> foods) {
        this.foods = foods;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.cardview, parent, false);
        return new FoodViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {

        Food food = foods.get(position);
        holder.foodName.setText(food.getName());
        holder.foodDescription.setText(food.getDescription());
        holder.foodPrice.setText(food.getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }
}
