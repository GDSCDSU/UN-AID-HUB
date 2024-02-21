package com.example.unaidhub.Features;

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

import com.example.unaidhub.DataClasses.serviceClass;
import com.example.unaidhub.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Service extends AppCompatActivity {

    private View Home;
    private View Services;
    private View Donations;
    private View MyAccount;


    private View Service1;
    private View Service2;
    private View Service3;
    private View Service4;
    private View Service5;

    private View Back;

    private PopupWindow popupSevice1;
    private PopupWindow popupSevice2;
    private PopupWindow popupSevice3;
    private PopupWindow popupSevice4;
    private PopupWindow popupSevice5;

    private PopupWindow popupconfirm1;

    FirebaseDatabase DB;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.services);

        Home = findViewById(R.id.home_btn);
        Services = findViewById(R.id.service_btn);
        Donations = findViewById(R.id.donations);
        MyAccount = findViewById(R.id.account_box);
        Service1 = findViewById(R.id.service_1);
        Service2 = findViewById(R.id.service_2);
        Service3 = findViewById(R.id.service_3);
        Service4 = findViewById(R.id.service_4);
        Service5 = findViewById(R.id.service_5);



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

        Service1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supplyService1(v);
            }
        });

        Service2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supplyService2(v);
            }
        });

        Service3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supplyService3(v);
            }
        });

        Service4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supplyService4(v);
            }
        });

        Service5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supplyService5(v);
            }
        });
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
        Intent intent = new Intent(this, com.example.unaidhub.Features.MyAccount.class);
        startActivity(intent);
    }

    public void supplyService1(View anchorView){
        // Inflate the popup_layout.xml to a view
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.blood_donate_service, null);

        // Initialize a new instance of PopupWindow
        popupSevice1 = new PopupWindow(
                popupView,
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );


        // Set an elevation value for the popup window
        popupSevice1.setElevation(20);

        popupSevice1.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                popupSevice1.dismiss();
            }
        });


        EditText Opt1 = popupView.findViewById(R.id.select_organization);
        EditText Opt2 = popupView.findViewById(R.id.select_blood_type);
        EditText Opt3 = popupView.findViewById(R.id.type_quantity);

        String serviceName = "Blood Donation";
        String opt1 = Opt1.getText().toString();
        String opt2 = Opt2.getText().toString();
        String opt3 = Opt3.getText().toString();



        View send = popupView.findViewById(R.id.send_button);
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
                popupSevice1.dismiss();
            }
        });


        // Show the popup window
        popupSevice1.showAsDropDown(anchorView);
    };




    public void confirmService(View anchorView){


        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.blood_donate_confirm, null);

        // Initialize a new instance of PopupWindow
        popupconfirm1 = new PopupWindow(
                popupView,
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );

        // Set an elevation value for the popup window
        popupconfirm1.setElevation(20);

        popupconfirm1.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                popupconfirm1.dismiss();
            }
        });




        View dismiss = popupView.findViewById(R.id.close_button);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupconfirm1.dismiss();
            }
        });


        // Show the popup window
        popupconfirm1.showAsDropDown(anchorView);
    };

    public void supplyService2(View anchorView){
        // Inflate the popup_layout.xml to a view
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.water_relief_service, null);

        // Initialize a new instance of PopupWindow
        popupSevice2 = new PopupWindow(
                popupView,
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        // Set an elevation value for the popup window
        popupSevice2.setElevation(20);

        popupSevice2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                popupSevice2.dismiss();
            }
        });

        EditText Opt1 = popupView.findViewById(R.id.select_organization);
        EditText Opt2 = popupView.findViewById(R.id.type_quantity);

        String serviceName = "Water Relief";
        String opt1 = Opt1.getText().toString();
        String opt2 = Opt2.getText().toString();


        View send = popupView.findViewById(R.id.button2);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeDB(serviceName,opt1,opt2);
                Opt1.setText("");
                Opt2.setText("");
                confirmService(v);
            }
        });


        View dismiss = popupView.findViewById(R.id.close_button);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupSevice2.dismiss();
            }
        });


        // Show the popup window
        popupSevice2.showAsDropDown(anchorView);
    };


    public void supplyService3(View anchorView){
        // Inflate the popup_layout.xml to a view
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.food_type_service, null);

        // Initialize a new instance of PopupWindow
        popupSevice3 = new PopupWindow(
                popupView,
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        // Set an elevation value for the popup window
        popupSevice3.setElevation(20);

        popupSevice3.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                popupSevice3.dismiss();
            }
        });

        EditText Opt1 = popupView.findViewById(R.id.select_organization);
        EditText Opt2 = popupView.findViewById(R.id.select_food_type);
        EditText Opt3 = popupView.findViewById(R.id.type_quantity);

        String serviceName = "Food Service";
        String opt1 = Opt1.getText().toString();
        String opt2 = Opt2.getText().toString();
        String opt3 = Opt3.getText().toString();

        View send = popupView.findViewById(R.id.button2);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                writeDB(serviceName,opt1,opt2,opt3);
                Opt1.setText("");
                Opt2.setText("");
                Opt3.setText("");
                confirmService(v);
            }
        });



        View dismiss = popupView.findViewById(R.id.close_button);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupSevice3.dismiss();
            }
        });


        // Show the popup window
        popupSevice3.showAsDropDown(anchorView);
    };


    public void supplyService4(View anchorView){
        // Inflate the popup_layout.xml to a view
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.medical_supplies_service, null);

        // Initialize a new instance of PopupWindow
        popupSevice4 = new PopupWindow(
                popupView,
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        // Set an elevation value for the popup window
        popupSevice4.setElevation(20);

        EditText Opt1 = popupView.findViewById(R.id.select_organization);
        EditText Opt2 = popupView.findViewById(R.id.select_medical_supplies);
        EditText Opt3 = popupView.findViewById(R.id.type_quantity);

        String serviceName = "Medical Supplies";
        String opt1 = Opt1.getText().toString();
        String opt2 = Opt2.getText().toString();
        String opt3 = Opt3.getText().toString();

        popupSevice4.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                popupSevice4.dismiss();
            }
        });


        View send = popupView.findViewById(R.id.button2);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeDB(serviceName,opt1,opt2,opt3);
                Opt1.setText("");
                Opt2.setText("");
                Opt3.setText("");
                confirmService(v);
            }
        });

        View dismiss = popupView.findViewById(R.id.close_button);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupSevice4.dismiss();
            }
        });


        // Show the popup window
        popupSevice4.showAsDropDown(anchorView);
    };


    public void supplyService5(View anchorView){
        // Inflate the popup_layout.xml to a view
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.emergency_shelter_service, null);

        // Initialize a new instance of PopupWindow
        popupSevice5 = new PopupWindow(
                popupView,
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );

        // Set an elevation value for the popup window
        popupSevice5.setElevation(20);

        popupSevice5.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                popupSevice2.dismiss();
            }
        });

        EditText Opt1 = popupView.findViewById(R.id.select_organization);
        EditText Opt2 = popupView.findViewById(R.id.type_quantity);

        String serviceName = "Medical Supplies";
        String opt1 = Opt1.getText().toString();
        String opt2 = Opt2.getText().toString();

        View location = popupView.findViewById(R.id.send_button);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                writeDB(serviceName,opt1,opt2);
                Opt1.setText("");
                Opt2.setText("");
                locationSelector();
            }
        });


        View dismiss = popupView.findViewById(R.id.close_button);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupSevice5.dismiss();
            }
        });


        // Show the popup window
        popupSevice5.showAsDropDown(anchorView);
    };


    public void locationSelector(){
        Intent intent = new Intent(this, Location.class);
        startActivity(intent);
    };

    public void writeDB(String serviceName,String opt1,String opt2,String opt3){
        serviceClass user = new serviceClass(serviceName,opt1,opt2,opt3);
        DB = FirebaseDatabase.getInstance();
        reference = DB.getReference("loginUser");
        reference.child(serviceName).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.e("Firebase", "Success " + task.isSuccessful());
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
    };


    public void writeDB(String serviceName,String opt1,String opt2){
        serviceClass user = new serviceClass(serviceName,opt1,opt2);
        DB = FirebaseDatabase.getInstance();
        reference = DB.getReference("loginUser");
        reference.child(serviceName).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.e("Firebase", "Success " + task.isSuccessful());
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
    };


}