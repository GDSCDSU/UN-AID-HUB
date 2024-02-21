package com.example.unaidhub.Features;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.unaidhub.R;
import com.example.unaidhub.login.Login;

public class MyAccount extends AppCompatActivity {

    private View Home;
    private View Services;
    private View Donations;

    private View MyAccount;

    private View logoutBtn;

    private View Back,ChangePassword;

    private PopupWindow LogoutScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_account);

        Home = findViewById(R.id.home_btn);
        Services = findViewById(R.id.service_btn);
        Donations = findViewById(R.id.donations);
        MyAccount = findViewById(R.id.account_box);
        logoutBtn =  findViewById(R.id.opt8);
        Back = findViewById(R.id.back_btn);
        ChangePassword = findViewById(R.id.opt2);

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setHome();
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
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

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                triggerLogout(v);
            }
        });

        ChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordSet();
            }
        });

    }

    public void passwordSet(){
        Intent intent = new Intent(this, com.example.unaidhub.passReset.Password.class);
        startActivity(intent);
    }
    public void setHome(){
        Intent intent = new Intent(this, com.example.unaidhub.Features.Home.class);
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

    public void triggerLogout(View anchorView){
            // Inflate the popup_layout.xml to a view
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.logout_confirm, null);

            // Initialize a new instance of PopupWindow
            LogoutScreen = new PopupWindow(
                    popupView,
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT
            );

            // Set an elevation value for the popup window
            LogoutScreen.setElevation(20);

            LogoutScreen.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    LogoutScreen.dismiss();
                }
            });


            View logout = popupView.findViewById(R.id.button2);
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loginScreen();
                }
            });


            View dismiss = popupView.findViewById(R.id.close_button);
            dismiss.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LogoutScreen.dismiss();
                }
            });


            // Show the popup window
            LogoutScreen.showAsDropDown(anchorView);
        };

        public void loginScreen(){
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        };
    };


