package com.example.thepod.data.source.local;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.thepod.R;


@Database(entities = {User.class,Menu.class}, version = 1)
public abstract class PodDatabase extends RoomDatabase {

    private static PodDatabase instance;

    public abstract MenuDao menuDao();

    public static synchronized PodDatabase getInstance(Context context){

        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
            PodDatabase.class,"pod_database")
            .fallbackToDestructiveMigration()
            .addCallback(roomCallBack)
            .build();
        }
        return instance;

    }

    private static PodDatabase.Callback roomCallBack = new PodDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };


    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private MenuDao menuDao;
        private PopulateDbAsyncTask(PodDatabase db){
            menuDao = db.menuDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            menuDao.insert(new Menu(R.id.image_view_lasagna,"Lasagna","Tasty",
                    "5.0","500",R.id.image_view_star_icon,
                    R.id.image_view_add_symbol));
            menuDao.insert(new Menu(R.id.image_view_lasagna,"Lasagna","Tasty",
                    "5.0","500",R.id.image_view_star_icon,
                    R.id.image_view_add_symbol));
            menuDao.insert(new Menu(R.id.image_view_lasagna,"Lasagna","Tasty",
                    "5.0","500",R.id.image_view_star_icon,
                    R.id.image_view_add_symbol));

            return null;
        }
    }
    

}
