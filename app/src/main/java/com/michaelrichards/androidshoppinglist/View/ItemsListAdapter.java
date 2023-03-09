package com.michaelrichards.androidshoppinglist.View;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.michaelrichards.androidshoppinglist.room_database.ShoppingListItem;

public class ItemsListAdapter extends ListAdapter<ShoppingListItem, ItemViewHolder> {
    protected ItemsListAdapter(@NonNull DiffUtil.ItemCallback<ShoppingListItem> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ItemViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ShoppingListItem curr = getItem(position);
        holder.bind(curr.getItem());
    }

    public static class ShoppingListDiff extends DiffUtil.ItemCallback<ShoppingListItem>{

        @Override
        public boolean areItemsTheSame(@NonNull ShoppingListItem oldItem, @NonNull ShoppingListItem newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull ShoppingListItem oldItem, @NonNull ShoppingListItem newItem) {
            return oldItem.getItem().equals(newItem.getItem());
        }
    }


}
