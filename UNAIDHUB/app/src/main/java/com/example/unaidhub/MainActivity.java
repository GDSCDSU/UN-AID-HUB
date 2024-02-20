package com.example.unaidhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.unaidhub.login.Login;
import com.example.unaidhub.welcome.Welcome2;

public class MainActivity extends AppCompatActivity {
    private View welcomeButton;
    private TextView sign_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_1);

        welcomeButton = findViewById(R.id.welcome_button);
        sign_in = findViewById(R.id.Sign_in);

        welcomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcomeScreen2();
            }
        });

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSign_in();
            }
        });
    }

    public void welcomeScreen2() {
        Intent intent = new Intent(this, Welcome2.class);
        startActivity(intent);
    }

    public void setSign_in(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
