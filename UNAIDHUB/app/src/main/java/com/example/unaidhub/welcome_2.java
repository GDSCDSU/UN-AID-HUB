package com.example.unaidhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class welcome_2 extends AppCompatActivity {
    private View welcomeButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_2);

        welcomeButton2 = findViewById(R.id.next_btn_welcome2);

        welcomeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcomeScreen3();
            }
        });
    }

    public void welcomeScreen3() {
        Intent intent = new Intent(this, Welcome3.class);
        startActivity(intent);
    }
}