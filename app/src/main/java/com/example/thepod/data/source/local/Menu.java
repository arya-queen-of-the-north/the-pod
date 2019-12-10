package com.example.thepod.data.source.local;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "menu_table")
public class Menu {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int imageViewLasagna;

    private String title;

    private String shortDescription;

    private String textViewRating;

    private String textViewPrice;

    private int imageViewStarIcon;

    private int imageViewAddIcon;

    public Menu(int imageViewLasagna, String title, String shortDescription, String textViewRating,
                String textViewPrice, int imageViewStarIcon, int imageViewAddIcon) {
        this.imageViewLasagna = imageViewLasagna;
        this.title = title;
        this.shortDescription = shortDescription;
        this.textViewRating = textViewRating;
        this.textViewPrice = textViewPrice;
        this.imageViewStarIcon = imageViewStarIcon;
        this.imageViewAddIcon = imageViewAddIcon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageViewLasagna() {
        return imageViewLasagna;
    }

    public String getTitle() {
        return title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getTextViewRating() {
        return textViewRating;
    }

    public String getTextViewPrice() {
        return textViewPrice;
    }

    public int getImageViewStarIcon() {
        return imageViewStarIcon;
    }

    public int getImageViewAddIcon() {
        return imageViewAddIcon;
    }




}
