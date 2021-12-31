package com.mehmetberkan.theworldofmybooks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class UpdateBookActivity extends AppCompatActivity {

    private EditText editTextname, editTextauthor, editTextCategory, editTextNop;
    private Button buttonUpdate;
    private Switch switchRead, switchOwned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_book);

        editTextname = (EditText) findViewById(R.id.editTextUpdateName);
        editTextauthor = (EditText) findViewById(R.id.editTextUpdateAuthor);
        editTextCategory = (EditText) findViewById(R.id.editTextUpdateCategory);
        editTextNop = (EditText) findViewById(R.id.editTextUpdateNop);
        buttonUpdate = (Button) findViewById(R.id.buttonUpdateUpdate);
        switchRead = (Switch) findViewById(R.id.switchUpdateRead);
        switchOwned = (Switch) findViewById(R.id.switchUpdateOwned);

    }
}