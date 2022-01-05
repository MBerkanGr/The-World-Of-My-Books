package com.mehmetberkan.theworldofmybooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mehmetberkan.theworldofmybooks.database.Db_Manager_User;

public class SignupActivity extends AppCompatActivity {

    Db_Manager_User db_manager_user;

    private EditText editTextNameSurname;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editTextNameSurname = (EditText) findViewById(R.id.editTextSignNameSurname);
        editTextUsername = (EditText) findViewById(R.id.editTextSignUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextSignNumberPassword);
        buttonSignup = (Button) findViewById(R.id.buttonSignSignup);

        db_manager_user = new Db_Manager_User(this);
        db_manager_user.open();

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameSurname = editTextNameSurname.getText().toString().trim();
                String userName = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if(!nameSurname.isEmpty() && !userName.isEmpty() && !password.isEmpty()) {
                    db_manager_user.add_user(nameSurname,userName,password);
                    Toast.makeText(getApplicationContext(),"Hoş Geldin "+nameSurname, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignupActivity.this , MainActivity.class));
                }else {
                    Toast.makeText(getApplicationContext(),"Boş kısımlar var!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
