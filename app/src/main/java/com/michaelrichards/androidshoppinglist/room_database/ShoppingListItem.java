package com.michaelrichards.androidshoppinglist.room_database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "shopping_list_table")
public class ShoppingListItem {

    public ShoppingListItem(@NonNull String item) {
        mItem = item;
    }

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "item")
    private final String mItem;

    public String getItem() {
        return mItem;
    }

}
