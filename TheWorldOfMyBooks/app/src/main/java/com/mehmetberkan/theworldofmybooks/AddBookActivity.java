package com.mehmetberkan.theworldofmybooks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class AddBookActivity extends AppCompatActivity {

    private EditText editTextName, editTextAuthor, editTextCategory, editTextNop;
    private Button buttonAdd;
    private Switch switchRead, switchOwned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        editTextName = (EditText) findViewById(R.id.editTextAddName);
        editTextAuthor = (EditText) findViewById(R.id.editTextAddAuthor);
        editTextCategory = (EditText) findViewById(R.id.editTextAddCategory);
        editTextNop = (EditText) findViewById(R.id.editTextAddNop);
        buttonAdd = (Button) findViewById(R.id.buttonAddAdd);
        switchRead = (Switch) findViewById(R.id.switchAddRead);
        switchOwned = (Switch) findViewById(R.id.switchAddOwned);
    }
}