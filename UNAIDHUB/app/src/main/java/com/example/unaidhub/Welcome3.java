package com.example.unaidhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Welcome3 extends AppCompatActivity {
    private View welcomeButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_3);

        welcomeButton3 = findViewById(R.id.next_btn_welcome3);

        welcomeButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcomeScreen4();
            }
        });
    }

    public void welcomeScreen4() {
        Intent intent = new Intent(this, Welcome4.class);
        startActivity(intent);
    }
}