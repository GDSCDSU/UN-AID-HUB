package com.example.unaidhub.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.unaidhub.login.Login;
import com.example.unaidhub.R;

public class Welcome4 extends AppCompatActivity {

    private View welcomeButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_4);

        welcomeButton4 = findViewById(R.id.next_btn_welcome4);

        welcomeButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp();
            }
        });
    }

    public void SignUp() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

}