package com.example.unaidhub.profilesetups;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.unaidhub.Features.Home;
import com.example.unaidhub.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SetCard extends AppCompatActivity {

    private ImageView next_btn;
    private ImageView Back;
    private PopupWindow popupWindow;

    private EditText nameBox,cardNoBox,cvvBox,monthBox,yearBox,postalCodeBox;
    private String Name,cardNo,CVV,month,year,postalCode;

    FirebaseDatabase DB;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creditcarddetails);

        next_btn = findViewById(R.id.imageButton4);
        Back = findViewById(R.id.back_btn);

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Success(v);
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

        public void Success(View anchorView){
            // Inflate the popup_layout.xml to a view
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.profilesuccesfull, null);

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

            View success = popupView.findViewById(R.id.success_button);
            success.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Home();
                }
            });



            // Show the popup window
            popupWindow.showAsDropDown(anchorView);
        }

    public void Home(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    };

    }



