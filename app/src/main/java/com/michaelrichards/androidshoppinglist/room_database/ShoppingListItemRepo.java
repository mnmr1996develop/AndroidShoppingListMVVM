package com.michaelrichards.androidshoppinglist.room_database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ShoppingListItemRepo {

    private ShoppingListDAO mShoppingListDAO;
    private LiveData<List<ShoppingListItem>> allItems;

    public ShoppingListItemRepo(Application application) {

        ShoppingListRoomDatabase shoppingListRoomDatabase = ShoppingListRoomDatabase.getInstance(application);
        mShoppingListDAO = shoppingListRoomDatabase.mShoppingListDAO();

        allItems = mShoppingListDAO.getAllShoppingListItemsInAlphaOrder();
    }

    public LiveData<List<ShoppingListItem>> getAllItems() {
        return allItems;
    }

    public void insertShoppingListItem(ShoppingListItem shoppingListItem){
        ShoppingListRoomDatabase.databaseWriterExecutor.execute(() -> mShoppingListDAO.insetShoppingListItem(shoppingListItem));
    }

    public void deleteShoppingListItem(ShoppingListItem shoppingListItem){
        ShoppingListRoomDatabase.databaseWriterExecutor.execute(() -> mShoppingListDAO.deleteShoppingListItem(shoppingListItem));
    }

}
