package com.michaelrichards.androidshoppinglist.room_database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingListItem that = (ShoppingListItem) o;
        return mItem.equals(that.mItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mItem);
    }
}
