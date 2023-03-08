package com.michaelrichards.androidshoppinglist.room_database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ShoppingListDAO {

    @Insert
    void insetShoppingListItem9(ShoppingListItem shoppingListItem);

    @Query("DELETE FROM shopping_list_table")
    void deleteShoppingList();

    @Delete
    void deleteShoppingListItem(ShoppingListItem shoppingListItem);

    @Query("SELECT * FROM shopping_list_table ORDER BY item ASC")
    LiveData<List<ShoppingListItem>> getAllShoppingListItemsInAlphaOrder();

}
