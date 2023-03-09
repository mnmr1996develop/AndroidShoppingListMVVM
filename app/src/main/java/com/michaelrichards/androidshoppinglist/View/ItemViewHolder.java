package com.michaelrichards.androidshoppinglist.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.michaelrichards.androidshoppinglist.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    private TextView mItemNameTextview;
    private TextView mItemAmountTextView;

    private ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        mItemNameTextview = itemView.findViewById(R.id.textShoppingListItem);
        mItemAmountTextView = itemView.findViewById(R.id.textShoppingListAmount);
    }
    public TextView getItemName() {
        return mItemNameTextview;
    }

    public TextView getItemAmount() {
        return mItemAmountTextView;
    }

    public void bind(String text, int amount){
        mItemNameTextview.setText(text);
        mItemAmountTextView.setText(String.valueOf(amount));
    }

    public static ItemViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        return new ItemViewHolder(view);
    }

}
