package com.example.thepod.foodmenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thepod.R;
import com.example.thepod.data.source.local.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuHolder> {
    private List<Menu> allFoodItems = new ArrayList<>();
    @NonNull
    @Override
    public MenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_list_cardview,parent,false);
        return new MenuHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolder holder, int position) {
        Menu menu = allFoodItems.get(position);
        holder.imageViewLasagna.setImageResource(menu.getImageViewLasagna());
        holder.textViewTitle.setText(menu.getTitle());
        holder.textViewShortDescription.setText(menu.getShortDescription());
        holder.textViewRating.setText(menu.getTextViewRating());
        holder.textViewPrice.setText(menu.getTextViewPrice());
        holder.imageViewStarIcon.setImageResource(menu.getImageViewStarIcon());
        holder.imageViewAddSymbol.setImageResource(menu.getImageViewAddIcon());


    }

    @Override
    public int getItemCount() {
        return allFoodItems.size();
    }

    public void setAllFoodItems(List<Menu> allFoodItems){
        this.allFoodItems = allFoodItems;
        notifyDataSetChanged();
    }

    class MenuHolder extends RecyclerView.ViewHolder{

        private ImageView imageViewLasagna;
        private TextView textViewTitle;
        private TextView textViewShortDescription;
        private TextView textViewRating;
        private TextView textViewPrice;
        private ImageView imageViewStarIcon;
        private ImageView imageViewAddSymbol;


        public MenuHolder(@NonNull View itemView) {
            super(itemView);
            imageViewLasagna = itemView.findViewById(R.id.image_view_lasagna);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewShortDescription = itemView.findViewById(R.id.text_view_short_desc);
            textViewRating = itemView.findViewById(R.id.text_view_rating);
            textViewPrice = itemView.findViewById(R.id.text_view_price);
            imageViewStarIcon = itemView.findViewById(R.id.image_view_star_icon);
            imageViewAddSymbol = itemView.findViewById(R.id.image_view_add_symbol);
        }
    }
}
