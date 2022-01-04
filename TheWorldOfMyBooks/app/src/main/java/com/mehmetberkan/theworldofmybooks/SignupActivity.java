package com.mehmetberkan.theworldofmybooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {

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

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this , MainActivity.class));
            }
        });
    }
}
