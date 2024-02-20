package com.example.unaidhub.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.unaidhub.login.Login;
import com.example.unaidhub.R;

public class Welcome3 extends AppCompatActivity {
    private View welcomeButton3;
    private TextView skipButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_3);

        welcomeButton3 = findViewById(R.id.next_btn_welcome3);
        skipButton = findViewById(R.id.skip_text);

        welcomeButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcomeScreen4();
            }
        });

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skip_function();
            }
        });
    }

    public void welcomeScreen4() {
        Intent intent = new Intent(this, Welcome4.class);
        startActivity(intent);
    }

    public void skip_function() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}