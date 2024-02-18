package com.example.unaidhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Service extends AppCompatActivity {

    private View Home;
    private View Services;
    private View Donations;
    private View MyAccount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.services);

        Home = findViewById(R.id.home_btn);
        Services = findViewById(R.id.service_btn);
        Donations = findViewById(R.id.donations);
        MyAccount = findViewById(R.id.my_account);



        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setHome();
            }
        });

        Services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setServices();
            }
        });

        Donations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDonations();
            }
        });

        MyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMyAccount();
            }
        });
    }

    public void setHome(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void setServices(){
        Intent intent = new Intent(this, Service.class);
        startActivity(intent);
    }

    public void setDonations(){
        Intent intent = new Intent(this, Donation.class);
        startActivity(intent);
    }

    public void setMyAccount(){
        Intent intent = new Intent(this, MyAccount.class);
        startActivity(intent);
    }



}