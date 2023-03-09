package com.michaelrichards.androidshoppinglist.room_database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "shopping_list_table")
public class ShoppingListItem {

    public ShoppingListItem(@NonNull String item, int amountNeeded){
        mItem = item;
        mAmountNeeded = amountNeeded;
    }

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "item")
    private final String mItem;
    @ColumnInfo(name = "amount")
    private int mAmountNeeded;

    public int getAmountNeeded() {
        return mAmountNeeded;
    }

    public void setAmountNeeded(int amountNeeded) {
        this.mAmountNeeded = amountNeeded;
    }

    @NonNull
    public String getItem() {
        return mItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingListItem that = (ShoppingListItem) o;
        return mAmountNeeded == that.mAmountNeeded && mItem.equals(that.mItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mItem, mAmountNeeded);
    }
}
