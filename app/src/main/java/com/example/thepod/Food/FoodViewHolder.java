package com.example.thepod.Food;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thepod.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.name)
    public TextView foodName;
    //
    @BindView(R.id.description)
    public TextView foodDescription;
    //
    @BindView(R.id.price)
    public TextView foodPrice;

    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
