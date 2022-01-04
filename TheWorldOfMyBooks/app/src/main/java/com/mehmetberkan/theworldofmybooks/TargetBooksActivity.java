package com.mehmetberkan.theworldofmybooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.mehmetberkan.theworldofmybooks.database.Db_Manager;

import java.util.List;

public class TargetBooksActivity extends AppCompatActivity {

    Db_Manager db_manager;

    private Button buttonAnaEkran, buttonUpdate, buttonDelete;
    private ListView listViewTarget;

    private String selectedItem;
    private int selectedItemId = 0;

    List<String> stringTargetBookList = null;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_books);

        buttonAnaEkran = (Button) findViewById(R.id.buttonTargetAnaEkran);
        buttonUpdate = (Button) findViewById(R.id.buttonTargetUpdate);
        buttonDelete = (Button) findViewById(R.id.buttonTargetDelete);
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
                if(selectedItemId != 0) {
                    Intent bookId = new Intent(TargetBooksActivity.this,UpdateBookActivity.class);
                    bookId.putExtra("bookId",selectedItemId);
                    startActivity(bookId);
                }else {
                    Toast.makeText(getApplicationContext(),"Herhangi Bir Kitap Seçilmedi", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedItemId != 0) {
                    String result = db_manager.delete_book(selectedItemId);
                    Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(TargetBooksActivity.this, TargetBooksActivity.class));
                }else {
                    Toast.makeText(getApplicationContext(),"Herhangi Bir Kitap Seçilmedi", Toast.LENGTH_SHORT).show();
                }
            }
        });

        listViewTarget.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItem = adapterView.getItemAtPosition(i).toString();
                selectedItemId = Integer.valueOf(selectedItem.charAt(4)+"");
            }
        });
    }
}
