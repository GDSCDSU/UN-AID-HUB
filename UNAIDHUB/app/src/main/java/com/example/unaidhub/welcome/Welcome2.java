package com.example.unaidhub.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.unaidhub.login.Login;
import com.example.unaidhub.R;

public class Welcome2 extends AppCompatActivity {
    private View welcomeButton2;
    private TextView skipButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_2);

        welcomeButton2 = findViewById(R.id.next_btn_welcome2);
        skipButton = findViewById(R.id.skip_text);

        welcomeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcomeScreen3();
            }
        });

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skip_function();
            }
        });
    }

    public void welcomeScreen3() {
        Intent intent = new Intent(this, Welcome3.class);
        startActivity(intent);
    }

    public void skip_function() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

}