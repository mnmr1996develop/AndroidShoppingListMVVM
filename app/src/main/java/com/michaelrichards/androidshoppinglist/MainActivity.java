package com.michaelrichards.androidshoppinglist;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.michaelrichards.androidshoppinglist.View.ItemsListAdapter;
import com.michaelrichards.androidshoppinglist.ViewModel.ShoppingListViewModel;
import com.michaelrichards.androidshoppinglist.room_database.ShoppingListItem;

public class MainActivity extends AppCompatActivity {

    private ShoppingListViewModel mShoppingListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.shoppingListRV);
        ItemsListAdapter listAdapter = new ItemsListAdapter(new ItemsListAdapter.ShoppingListDiff());
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mShoppingListViewModel = new ViewModelProvider(this).get(ShoppingListViewModel.class);
        mShoppingListViewModel.getShoppingList().observe(this, listAdapter::submitList);

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NewItemActivity.class);
            newShoppingListResLauncher.launch(intent);
        });

    }

    ActivityResultLauncher<Intent> newShoppingListResLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                        if (result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();
                            assert data != null;
                            String shoppingListItem = data.getStringExtra(NewItemActivity.NEW_MARTIAL_ART_KEY_ITEM);
                            int shoppingListAmount = data.getIntExtra(NewItemActivity.NEW_MARTIAL_ART_KEY_AMOUNT, 1);
                            mShoppingListViewModel.insertShoppingList(new ShoppingListItem(shoppingListItem, shoppingListAmount));
                        }
    });
}