package com.michaelrichards.androidshoppinglist.room_database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ShoppingListItem.class}, version = 2, exportSchema = false)
public abstract class ShoppingListRoomDatabase extends RoomDatabase {

    public abstract ShoppingListDAO mShoppingListDAO();

    public static volatile ShoppingListRoomDatabase INSTANCE;

    public static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseWriterExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static ShoppingListRoomDatabase getInstance(Context context){
        if (INSTANCE == null){
            synchronized (ShoppingListRoomDatabase.class){
                INSTANCE = Room.databaseBuilder(context, ShoppingListRoomDatabase.class, "shopping_list_database").addCallback(dbCallback).build();
            }
        }

        return INSTANCE;
    }

    private static RoomDatabase.Callback dbCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriterExecutor.execute(() -> {
                // DELETE All data
                ShoppingListDAO dao = INSTANCE.mShoppingListDAO();
                dao.deleteShoppingList();

                //add some
                ShoppingListItem shoppingListItem = new ShoppingListItem("Laundry Detergent", 2);
                dao.insetShoppingListItem(shoppingListItem);

                shoppingListItem = new ShoppingListItem("Eggs", 3);
                dao.insetShoppingListItem(shoppingListItem);
            });
        }
    };


}
