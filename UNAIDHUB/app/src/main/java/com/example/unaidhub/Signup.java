package com.example.unaidhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Signup extends AppCompatActivity {
    private Button Sign_up;
    private TextView Sign_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_for_free);

        Sign_up = (Button) findViewById(R.id.Sign_up_btn);
        Sign_in = findViewById(R.id.sign_in_text);

        Sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSign_up();
            }
        });

        Sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSign_in();
            }
        });
    }

    public void setSign_up(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void setSign_in(){
        Intent intent = new Intent(this, Signin.class);
        startActivity(intent);
    }
}