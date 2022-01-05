package com.mehmetberkan.theworldofmybooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mehmetberkan.theworldofmybooks.database.Db_Manager_Book;

import org.w3c.dom.Text;

public class StatisticsActivity extends AppCompatActivity {

    Db_Manager_Book db_managerBook;

    int sumNopr, sumNobr, sumNob, sumNoda, sumNodc;

    TextView textViewnopr, textViewnobr, textViewnob, textViewnoda, textViewNodc;
    Button buttonAnaMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        textViewnopr = (TextView) findViewById(R.id.textViewStasNopr);
        textViewnobr = (TextView) findViewById(R.id.textViewStasNobr);
        textViewnob = (TextView) findViewById(R.id.textViewStasNobl);
        textViewNodc = (TextView) findViewById(R.id.textViewStasNodc);
        textViewnoda = (TextView) findViewById(R.id.textViewStasNoda);
        buttonAnaMenu = (Button) findViewById(R.id.buttonStasAnaEkran);

        db_managerBook = new Db_Manager_Book(this);
        db_managerBook.open();

        sumNob = db_managerBook.getNob();
        sumNopr = db_managerBook.getNopr();
        sumNobr = db_managerBook.getNobr();
        sumNodc = db_managerBook.getNodc();
        sumNoda = db_managerBook.getNoda();

        textViewnob.setText(sumNob+"");
        textViewnopr.setText(sumNopr+"");
        textViewnobr.setText(sumNobr+"");
        textViewNodc.setText(sumNodc+"");
        textViewnoda.setText(sumNoda+"");

        buttonAnaMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StatisticsActivity.this,AnaEkranActivity.class));
            }
        });
    }
}