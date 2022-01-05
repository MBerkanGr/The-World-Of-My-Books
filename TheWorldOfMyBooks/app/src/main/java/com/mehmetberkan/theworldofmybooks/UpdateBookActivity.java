package com.mehmetberkan.theworldofmybooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.mehmetberkan.theworldofmybooks.database.Db_Manager_Book;
import com.mehmetberkan.theworldofmybooks.entity.Book;

public class UpdateBookActivity extends AppCompatActivity {

    Db_Manager_Book db_managerBook;

    private EditText editTextname, editTextauthor, editTextCategory, editTextNop;
    private TextView textViewbookId;
    private Button buttonUpdate;
    private Switch switchRead, switchOwned;

    private int book_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_book);

        textViewbookId = (TextView) findViewById(R.id.textViewUpdateBookId);
        editTextname = (EditText) findViewById(R.id.editTextUpdateName);
        editTextauthor = (EditText) findViewById(R.id.editTextUpdateAuthor);
        editTextCategory = (EditText) findViewById(R.id.editTextUpdateCategory);
        editTextNop = (EditText) findViewById(R.id.editTextUpdateNop);
        buttonUpdate = (Button) findViewById(R.id.buttonUpdateUpdate);
        switchRead = (Switch) findViewById(R.id.switchUpdateRead);
        switchOwned = (Switch) findViewById(R.id.switchUpdateOwned);

        db_managerBook = new Db_Manager_Book(this);
        db_managerBook.open();

        Intent mIntent = getIntent();
        book_id = mIntent.getIntExtra("bookId",0);
        Book book = db_managerBook.getByBookId(book_id);

        textViewbookId.setText("No : "+book.getId());
        editTextname.setText(book.getName());
        editTextauthor.setText(book.getAuthor());
        editTextCategory.setText(book.getCategory());
        editTextNop.setText(Integer.valueOf(book.getNumberofsize()).toString());
        switchOwned.setChecked(book.isOwned());
        switchRead.setChecked(book.isRead());

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextname.getText().toString().isEmpty() || editTextauthor.getText().toString().isEmpty() || editTextNop.getText().toString().isEmpty() || editTextCategory.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Boş kısımlar var!",Toast.LENGTH_SHORT).show();
                }else {
                    if(switchOwned.isChecked() == false && switchRead.isChecked() == true) {
                        Toast.makeText(getApplicationContext(),"Satın alınmadan kitap okundu bilgisi eklenemez!",Toast.LENGTH_SHORT).show();
                    }else {
                        int id = book_id;
                        String name = editTextname.getText().toString();
                        String author = editTextauthor.getText().toString();
                        int nop = Integer.valueOf(editTextNop.getText().toString());
                        String category = editTextCategory.getText().toString();
                        Boolean owned = switchOwned.isChecked();
                        Boolean read = switchRead.isChecked();

                        String message = db_managerBook.update_book(id,name,author,nop,category,owned,read);
                        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(UpdateBookActivity.this,AnaEkranActivity.class));
                    }
                }
            }
        });
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
