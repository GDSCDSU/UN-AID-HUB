package com.example.unaidhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class Donation extends AppCompatActivity {

    private View Home;
    private View Services;
    private View Donations;

    private View MyAccount;

    private View Org1;

    private View donateNow;

    private PopupWindow popupOrg1;

    private PopupWindow popupInstantDonation;

    private PopupWindow popupConfirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donations);

        Home = findViewById(R.id.home_btn);
        Services = findViewById(R.id.service_btn);
        Donations = findViewById(R.id.donations);
        MyAccount = findViewById(R.id.account_box);
        Org1 = findViewById(R.id.org1);
        donateNow = findViewById(R.id.donate_now);


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

        Org1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                donateOrg1(v);
            }
        });

        donateNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instantDonation(v);
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

    public void donateOrg1(View anchorView){
        // Inflate the popup_layout.xml to a view
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.donate_service_1, null);

        // Initialize a new instance of PopupWindow
        popupOrg1 = new PopupWindow(
                popupView,
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );

        // Set an elevation value for the popup window
        popupOrg1.setElevation(20);

        popupOrg1.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                popupOrg1.dismiss();
            }
        });

        View send = popupView.findViewById(R.id.button2);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmService(v);
            }
        });


        View dismiss = popupView.findViewById(R.id.close_button);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupOrg1.dismiss();
            }
        });


        // Show the popup window
        popupOrg1.showAsDropDown(anchorView);
    };



    public void instantDonation(View anchorView){
        // Inflate the popup_layout.xml to a view
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.donate_service_2, null);

        // Initialize a new instance of PopupWindow
        popupInstantDonation = new PopupWindow(
                popupView,
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );

        // Set an elevation value for the popup window
        popupInstantDonation.setElevation(20);

        popupInstantDonation.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                popupInstantDonation.dismiss();
            }
        });

        View send = popupView.findViewById(R.id.button2);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmService(v);
            }
        });


        View dismiss = popupView.findViewById(R.id.close_button);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupInstantDonation.dismiss();
            }
        });


        // Show the popup window
        popupInstantDonation.showAsDropDown(anchorView);
    };

    public void confirmService(View anchorView){
        // Inflate the popup_layout.xml to a view
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.donate_confirm_1, null);

        // Initialize a new instance of PopupWindow
        popupConfirm = new PopupWindow(
                popupView,
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );

        // Set an elevation value for the popup window
        popupConfirm.setElevation(20);

        popupConfirm.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                popupConfirm.dismiss();
            }
        });




        View dismiss = popupView.findViewById(R.id.close_button);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupConfirm.dismiss();
            }
        });


        // Show the popup window
        popupConfirm.showAsDropDown(anchorView);
    };




}