package com.michaelrichards.androidshoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewItemActivity extends AppCompatActivity {

    private  EditText editText;
    private static final String TAG = "NewItemActivity";
    public static final String NEW_MARTIAL_ART_KEY = "com.michaelrichards.androidshoppinglist.GET_BACK_SHOPPING_LIST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        Button buttonAdd = findViewById(R.id.addItembutton);
        editText = findViewById(R.id.editShoppingListItem);

        buttonAdd.setOnClickListener(view -> {
            Intent getBackIntent = new Intent();
            if (TextUtils.isEmpty(editText.getText())){
                setResult(RESULT_CANCELED, getBackIntent);
            }
            else {
                String shoppingListItem = editText.getText().toString();
                getBackIntent.putExtra(NEW_MARTIAL_ART_KEY , shoppingListItem);
                setResult(RESULT_OK, getBackIntent);
            }

            finish();
        });
    }
}