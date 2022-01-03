package com.mehmetberkan.theworldofmybooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.mehmetberkan.theworldofmybooks.database.Db_Manager;

import java.util.ArrayList;
import java.util.List;

public class TargetBooksActivity extends AppCompatActivity {

    Db_Manager db_manager;

    private Button buttonAnaEkran, buttonUpdate;
    private ListView listViewTarget;

    List<String> stringTargetBookList = null;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_books);

        buttonAnaEkran = (Button) findViewById(R.id.buttonTargetAnaEkran);
        buttonUpdate = (Button) findViewById(R.id.buttonTargetUpdate);
        listViewTarget = (ListView) findViewById(R.id.listViewTarget);

        db_manager = new Db_Manager(this);
        db_manager.open();

        if(db_manager.getListTargetBooks() != null) {
            stringTargetBookList = db_manager.getListTargetBooks();
            arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,stringTargetBookList);
            listViewTarget.setAdapter(arrayAdapter);
            arrayAdapter.notifyDataSetChanged();
        }else {
            Toast.makeText(getApplicationContext(),"Almadığınız kitap yok",Toast.LENGTH_LONG).show();
        }

        buttonAnaEkran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TargetBooksActivity.this, AnaEkranActivity.class));
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TargetBooksActivity.this, UpdateBookActivity.class));
            }
        });
    }


}