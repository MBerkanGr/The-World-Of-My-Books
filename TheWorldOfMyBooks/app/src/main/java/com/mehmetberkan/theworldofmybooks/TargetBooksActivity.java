package com.mehmetberkan.theworldofmybooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TargetBooksActivity extends AppCompatActivity {

    private Button buttonAnaEkran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_books);

        buttonAnaEkran = (Button) findViewById(R.id.buttonTargetAnaEkran);

        buttonAnaEkran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TargetBooksActivity.this, AnaEkranActivity.class));
            }
        });
    }


}