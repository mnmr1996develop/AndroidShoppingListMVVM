package com.michaelrichards.androidshoppinglist.room_database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ShoppingListItem.class}, version = 1, exportSchema = false)
public abstract class ShoppingListRoomDatabase extends RoomDatabase {

    public abstract ShoppingListDAO mShoppingListDAO();

    public static volatile ShoppingListRoomDatabase INSTANCE;

    public static final int NUMBER_OF_THREADS = 4;

    private static final ExecutorService databaseWriterExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static ShoppingListRoomDatabase getInstance(Context context){
        if (INSTANCE == null){
            synchronized (ShoppingListRoomDatabase.class){
                INSTANCE = Room.databaseBuilder(context, ShoppingListRoomDatabase.class, "shopping_list_database").build();
            }
        }

        return INSTANCE;
    }


}
