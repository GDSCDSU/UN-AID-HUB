package com.example.unaidhub.Features;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.unaidhub.Chats.BotChat;
import com.example.unaidhub.Chats.LiveChat;
import com.example.unaidhub.R;

public class Home extends AppCompatActivity {

    private View Home;
    private View Services;
    private View Donations;
    private View MyAccount;

    private View Chat_bot;

    private View Search;
    private View Notification;

    private PopupWindow popupWindow;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Home = findViewById(R.id.home_btn);
        Services = findViewById(R.id.services_btn);
        Donations = findViewById(R.id.donations);
        MyAccount = findViewById(R.id.account_box);
        Chat_bot = findViewById(R.id.chat_bot);
        Notification = findViewById(R.id.notification_icon);
        Search = findViewById(R.id.search_badge);



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

        Chat_bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatOptions(v);
            }
        });

        Notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification_box(v);
            }
        });

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearch(v);
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
        Intent intent = new Intent(this, com.example.unaidhub.Features.MyAccount.class);
        startActivity(intent);
    }

    public void chatOptions(View anchorView){
        // Inflate the popup_layout.xml to a view
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.chatsupport, null);

        // Initialize a new instance of PopupWindow
        popupWindow = new PopupWindow(
                popupView,
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );

        // Set an elevation value for the popup window
        popupWindow.setElevation(20);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                popupWindow.dismiss();
            }
        });

        View bot_chat = popupView.findViewById(R.id.bot_chat_button);
        bot_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botChat();
            }
        });

        View live_chat = popupView.findViewById(R.id.live_chat_button2);
        live_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liveChat();
            }
        });

        View dismiss = popupView.findViewById(R.id.close_button);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });


        // Show the popup window
        popupWindow.showAsDropDown(anchorView);
    };


    public void openSearch(View anchorView){
        // Inflate the popup_layout.xml to a view
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.searchbar, null);

        // Initialize a new instance of PopupWindow
        popupWindow = new PopupWindow(
                popupView,
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );

        // Set an elevation value for the popup window
        popupWindow.setElevation(20);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                popupWindow.dismiss();
            }
        });

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                popupWindow.dismiss();
            }
        });

        popupWindow.setBackgroundDrawable(null);


        popupWindow.setOutsideTouchable(true);


        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    popupWindow.dismiss();
                    return true;
                }
                return false;
            }
        });


        popupWindow.setOnDismissListener(null);





        // Show the popup window
        popupWindow.showAsDropDown(anchorView);
    };

    public void botChat(){
        Intent intent = new Intent(this, BotChat.class);
        startActivity(intent);
    }

    public void liveChat(){
        Intent intent = new Intent(this, LiveChat.class);
        startActivity(intent);
    }


    public void notification_box(View anchorView){
        // Inflate the popup_layout.xml to a view
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.notifications, null);

        // Initialize a new instance of PopupWindow
        popupWindow = new PopupWindow(
                popupView,
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );

        // Set an elevation value for the popup window
        popupWindow.setElevation(20);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                popupWindow.dismiss();
            }
        });


        View dismiss = popupView.findViewById(R.id.close_button);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });


        // Show the popup window
        popupWindow.showAsDropDown(anchorView);
    };

}