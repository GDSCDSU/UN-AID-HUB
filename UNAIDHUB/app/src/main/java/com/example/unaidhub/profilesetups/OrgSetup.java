package com.example.unaidhub.profilesetups;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.unaidhub.DataClasses.orgDetails;
import com.example.unaidhub.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OrgSetup extends AppCompatActivity {

    private ImageView next_btn;
    private ImageView Back;
    private EditText org_box,contact_box,location_box,url_link;

    private String org_name,contact,location,website;

    FirebaseDatabase DB;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_setup_org);

        org_box=findViewById(R.id.Organization);
        contact_box=findViewById(R.id.contact);
        location_box=findViewById(R.id.location);
        url_link=findViewById(R.id.website);
        next_btn = findViewById(R.id.imageButton4);
        Back = findViewById(R.id.back_btn);

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                org_name = org_box.getText().toString();
                location= location_box.getText().toString();
                contact= contact_box.getText().toString();
                website= url_link.getText().toString();



                orgDetails organization = new orgDetails(org_name,location,contact,website);
                DB = FirebaseDatabase.getInstance();
                reference = DB.getReference("loginUser");
                reference.child(org_name).setValue(organization).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            // Data successfully written to the database
                            org_box.setText("");
                            location_box.setText("");
                            contact_box.setText("");
                            url_link.setText("");
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

                setCreditCard();
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


    public void setCreditCard(){
        Intent intent = new Intent(this, SetCard.class);
        startActivity(intent);
    };
}