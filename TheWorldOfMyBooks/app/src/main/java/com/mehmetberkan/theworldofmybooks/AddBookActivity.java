package com.mehmetberkan.theworldofmybooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.mehmetberkan.theworldofmybooks.database.Db_Manager;

public class AddBookActivity extends AppCompatActivity {

    Db_Manager db_manager;

    private EditText editTextName, editTextAuthor, editTextCategory, editTextNop;
    private Button buttonAdd;
    private Switch switchRead, switchOwned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        db_manager = new Db_Manager(this);
        db_manager.open();

        editTextName = (EditText) findViewById(R.id.editTextAddName);
        editTextAuthor = (EditText) findViewById(R.id.editTextAddAuthor);
        editTextCategory = (EditText) findViewById(R.id.editTextAddCategory);
        editTextNop = (EditText) findViewById(R.id.editTextAddNop);
        buttonAdd = (Button) findViewById(R.id.buttonAddAdd);
        switchRead = (Switch) findViewById(R.id.switchAddRead);
        switchOwned = (Switch) findViewById(R.id.switchAddOwned);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextName.getText().toString().isEmpty() || editTextAuthor.getText().toString().isEmpty() || editTextNop.getText().toString().isEmpty() || editTextCategory.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Boş Kısımlar var!",Toast.LENGTH_SHORT).show();
                }else {
                    if(switchOwned.isChecked() == false && switchRead.isChecked() == true) {
                        Toast.makeText(getApplicationContext(),"Satın alınmadan kitap okundu bilgisi eklenemez!",Toast.LENGTH_SHORT).show();
                    }else {
                        String name = editTextName.getText().toString();
                        String author = editTextAuthor.getText().toString();
                        int nop = Integer.valueOf(editTextNop.getText().toString());
                        String category = editTextCategory.getText().toString();
                        Boolean owned = switchOwned.isChecked();
                        Boolean read = switchRead.isChecked();

                        String message = db_manager.add_book(name,author,nop,category,owned,read);
                        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AddBookActivity.this,AnaEkranActivity.class));
                        }
                }
            }
        });
    }

    @Override
    protected void onResume() {
        db_manager.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        db_manager.close();
        super.onPause();
    }
}
