package com.example.unaidhub.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.unaidhub.DataClasses.loginUser;
import com.example.unaidhub.Features.Home;
import com.example.unaidhub.R;
import com.example.unaidhub.profilesetups.OrgSetup;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    private View loginButton;
    private View setAccount;
    private PopupWindow popupWindow;
    String email;

    private EditText emailbox;
    FirebaseDatabase DB;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginButton = findViewById(R.id.login_button);
        emailbox=findViewById(R.id.email);
        setAccount=findViewById(R.id.account_create);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = emailbox.getText().toString();

                loginUser user = new loginUser(email);
                DB = FirebaseDatabase.getInstance();
                reference = DB.getReference("loginUser");
                reference.child(email).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            // Data successfully written to the database
                            emailbox.setText("");
                        } else {
                            // Failed to write data to the database
                            Log.e("Firebase", "Error writing data to the database: " + task.getException().getMessage());
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Handle any exceptions thrown during the database operation
                        Log.e("Firebase", "Database operation failed: " + e.getMessage());
                    }
                });
                setHome();
            }
        });

        setAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProfile(v);
            }
        });
    }

    private void setProfile(View anchorView) {
        // Inflate the popup_layout.xml to a view
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.profile_set_up, null);

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

        View orgButton = popupView.findViewById(R.id.Org_btn);
        orgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Org_Profile_setup();
            }
        });



        // Show the popup window
        popupWindow.showAsDropDown(anchorView);
    }

    public void setHome(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
    public void Org_Profile_setup(){
        Intent intent = new Intent(this, OrgSetup.class);
        startActivity(intent);
    };
}
