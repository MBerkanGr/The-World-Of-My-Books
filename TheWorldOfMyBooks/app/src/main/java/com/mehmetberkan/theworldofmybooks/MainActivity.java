package com.mehmetberkan.theworldofmybooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mehmetberkan.theworldofmybooks.database.Db_Manager_Book;
import com.mehmetberkan.theworldofmybooks.database.Db_Manager_User;

public class MainActivity extends AppCompatActivity {

    Db_Manager_User db_manager_user;

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;
    private Button buttonSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonSignup = (Button) findViewById(R.id.buttonSignup);

        db_manager_user = new Db_Manager_User(this);
        db_manager_user.open();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                if(db_manager_user.login(userName,password)) {
                    startActivity(new Intent(MainActivity.this, AnaEkranActivity.class));
                }
                else {
                    Toast.makeText(getApplicationContext(),"Giriş başarısız", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this , SignupActivity.class));
            }
        });
    }
}
