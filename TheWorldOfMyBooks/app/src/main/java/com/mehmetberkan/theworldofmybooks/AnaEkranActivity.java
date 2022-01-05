package com.mehmetberkan.theworldofmybooks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.mehmetberkan.theworldofmybooks.database.Db_Manager_Book;

import java.util.List;

public class AnaEkranActivity extends AppCompatActivity {

    Db_Manager_Book db_managerBook;

    private Button buttonAddBook, buttonUpdateBook, buttonDeleteBook, buttonTargetBooks;
    private ListView listViewLibrary;
    ArrayAdapter<String> arrayAdapter;
    List<String> stringBookList = null;
    String selectedItem;
    int selectedItemId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_ekran);

        buttonAddBook = findViewById(R.id.buttonAdd);
        buttonUpdateBook = findViewById(R.id.buttonUpdate);
        buttonDeleteBook = findViewById(R.id.buttonDelete);
        buttonTargetBooks = findViewById(R.id.buttonTargetBooks);
        listViewLibrary = findViewById(R.id.listViewLibrary);

        db_managerBook = new Db_Manager_Book(this);
        db_managerBook.open();

        if(db_managerBook.getListBooks() != null) {
            stringBookList = db_managerBook.getListBooks();
            arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,stringBookList);
            listViewLibrary.setAdapter(arrayAdapter);
            arrayAdapter.notifyDataSetChanged();
        }
        else {
            Toast.makeText(getApplicationContext(),"Hiç bir kitap yok",Toast.LENGTH_SHORT).show();
        }

        buttonAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnaEkranActivity.this, AddBookActivity.class));
            }
        });

        buttonUpdateBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedItemId != 0) {
                    Intent bookId = new Intent(AnaEkranActivity.this,UpdateBookActivity.class);
                    bookId.putExtra("bookId",selectedItemId);
                    startActivity(bookId);
                }else {
                    Toast.makeText(getApplicationContext(),"Herhangi bir kitap seçilmedi", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonDeleteBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedItemId != 0) {
                    String result = db_managerBook.delete_book(selectedItemId);
                    Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AnaEkranActivity.this, AnaEkranActivity.class));
                }else {
                    Toast.makeText(getApplicationContext(),"Herhangi bir kitap seçilmedi", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonTargetBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnaEkranActivity.this,TargetBooksActivity.class));
            }
        });

        listViewLibrary.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItem = adapterView.getItemAtPosition(i).toString();
                selectedItemId = Integer.valueOf(selectedItem.substring(4,selectedItem.indexOf("\n")).trim());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.book_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.add_book) {
            Intent intent = new Intent(this,AddBookActivity.class);
            startActivity(intent);

        } else if (item.getItemId() == R.id.library) {
            Intent intent = new Intent(this,AnaEkranActivity.class);
            startActivity(intent);

        } else if (item.getItemId() == R.id.target_library) {
            Intent intent = new Intent(this,TargetBooksActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        db_managerBook.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        db_managerBook.close();
        super.onPause();
    }
}
