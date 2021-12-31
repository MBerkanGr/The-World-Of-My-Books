package com.mehmetberkan.theworldofmybooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnaEkranActivity extends AppCompatActivity {

    private Button buttonAddBook, buttonUpdateBook, buttonDeleteBook, buttonTargetBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_ekran);

        buttonAddBook = findViewById(R.id.buttonAdd);
        buttonUpdateBook = findViewById(R.id.buttonUpdate);
        buttonDeleteBook = findViewById(R.id.buttonDelete);
        buttonTargetBooks = findViewById(R.id.buttonTargetBooks);

        buttonAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnaEkranActivity.this, AddBookActivity.class));
            }
        });

        buttonUpdateBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnaEkranActivity.this, UpdateBookActivity.class));
            }
        });

        buttonTargetBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnaEkranActivity.this,TargetBooksActivity.class));
            }
        });

    }
}