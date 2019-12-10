package com.example.thepod.data.source;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Update;

import com.example.thepod.R;
import com.example.thepod.data.source.local.Menu;
import com.example.thepod.data.source.local.MenuDao;
import com.example.thepod.data.source.local.PodDatabase;

import java.util.List;

public class PodRepository {

    private MenuDao menuDao;
    private LiveData<List<Menu>> allFoodItems;


    public PodRepository(Application application){
        PodDatabase database = PodDatabase.getInstance(application);
        menuDao = database.menuDao();
        allFoodItems = menuDao.getAllFoodItems();
    }

    public void insert(Menu foodItem){
        new InsertNoteAsyncTask(menuDao).execute(foodItem);

    }

    public void update(Menu foodItem){
        new UpdateNoteAsyncTask(menuDao).execute(foodItem);
    }

    public void delete(Menu foodItem){
        new DeleteNoteAsyncTask(menuDao).execute(foodItem);
    }

    public LiveData<List<Menu>> getAllFoodItems() {
        return allFoodItems;
    }


    private static class InsertNoteAsyncTask extends AsyncTask<Menu,Void,Void> {

        private MenuDao menuDao;

        private InsertNoteAsyncTask(MenuDao menuDao){
            this.menuDao = menuDao;
        }

        @Override
        protected Void doInBackground(Menu... menus) {
            menuDao.insert(menus[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Menu,Void,Void> {

        private MenuDao menuDao;

        private UpdateNoteAsyncTask(MenuDao menuDao){
            this.menuDao = menuDao;
        }

        @Override
        protected Void doInBackground(Menu... menus) {
            menuDao.update(menus[0]);
            return null;
        }
    }


    private static class DeleteNoteAsyncTask extends AsyncTask<Menu,Void,Void> {

        private MenuDao menuDao;

        private DeleteNoteAsyncTask(MenuDao menuDao){
            this.menuDao = menuDao;
        }

        @Override
        protected Void doInBackground(Menu... menus) {
            menuDao.delete(menus[0]);
            return null;
        }
    }




}
