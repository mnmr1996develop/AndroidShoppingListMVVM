package com.michaelrichards.androidshoppinglist.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.michaelrichards.androidshoppinglist.room_database.ShoppingListItem;
import com.michaelrichards.androidshoppinglist.room_database.ShoppingListItemRepo;

import java.util.List;

public class ShoppingListViewModel extends AndroidViewModel {

    private ShoppingListItemRepo mShoppingListItemRepo;

    private final LiveData<List<ShoppingListItem>> mShoppingList;

    public ShoppingListViewModel(@NonNull Application application) {
        super(application);
        mShoppingListItemRepo = new ShoppingListItemRepo(application);
        mShoppingList = mShoppingListItemRepo.getAllItems();
    }

    public LiveData<List<ShoppingListItem>> getShoppingList() {
        return mShoppingList;
    }

    public void insertShoppingList(ShoppingListItem shoppingListItem){
        mShoppingListItemRepo.insertShoppingListItem(shoppingListItem);
    }

    public void deleteShoppingListItem(ShoppingListItem shoppingListItem){
        mShoppingListItemRepo.deleteShoppingListItem(shoppingListItem);
    }
}
