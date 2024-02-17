package com.example.unaidhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Signin extends AppCompatActivity {
    private Button Sign_in;
    private TextView Sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        Sign_in = (Button) findViewById(R.id.Sign_in_btn);
        Sign_up = findViewById(R.id.sign_up_text);

        Sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSign_in();
            }
        });

        Sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSign_up();
            }
        });
    }

    public void setSign_in(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void setSign_up(){
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }
}