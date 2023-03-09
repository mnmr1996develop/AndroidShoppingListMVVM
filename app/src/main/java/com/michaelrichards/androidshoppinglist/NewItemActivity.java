package com.michaelrichards.androidshoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewItemActivity extends AppCompatActivity {

   
    private  EditText editItemName;
    private EditText editItemAmount;
    private static final String TAG = "NewItemActivity";
    public static final String NEW_MARTIAL_ART_KEY_ITEM = "com.michaelrichards.androidshoppinglist.GET_BACK_SHOPPING_LIST_ITEM";
    public static final String NEW_MARTIAL_ART_KEY_AMOUNT = "com.michaelrichards.androidshoppinglist.GET_BACK_SHOPPING_LIST_AMOUNT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        Button buttonAdd = findViewById(R.id.addItembutton);
        editItemName = findViewById(R.id.editShoppingListItem);
        editItemAmount = findViewById(R.id.editShoppingListAmount);

        buttonAdd.setOnClickListener(view -> {
            Intent getBackIntent = new Intent();
            if (TextUtils.isEmpty(editItemName.getText())){
                setResult(RESULT_CANCELED, getBackIntent);
            }
            else {
                String shoppingListItemName = editItemName.getText().toString();
                int shoppingListAmount = Integer.parseInt(editItemAmount.getText().toString());
                getBackIntent.putExtra(NEW_MARTIAL_ART_KEY_ITEM , shoppingListItemName);
                getBackIntent.putExtra(NEW_MARTIAL_ART_KEY_AMOUNT, shoppingListAmount);
                setResult(RESULT_OK, getBackIntent);
            }

            finish();
        });
    }
}