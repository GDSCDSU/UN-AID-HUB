package com.example.unaidhub.Features;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.unaidhub.DataClasses.donationsClass;
import com.example.unaidhub.GooglePayAPI.CheckoutViewModel;
import com.example.unaidhub.R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wallet.AutoResolveHelper;
import com.google.android.gms.wallet.PaymentData;
import com.google.android.gms.wallet.contract.TaskResultContracts;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;


public class Donation extends AppCompatActivity {

    private View Home;
    private View Services;
    private View Donations;

    private View MyAccount;

    private View Org1,Org2,Org3,Org4,Org5;

    private View Back;

    private View donateNow;

    private PopupWindow popupOrg;

    private PopupWindow popupInstantDonation;

    private PopupWindow popupConfirm;

    private EditText amountbox;

    FirebaseDatabase DB;
    DatabaseReference reference;




    private CheckoutViewModel model;


    private final ActivityResultLauncher<Task<PaymentData>> paymentDataLauncher =
            registerForActivityResult(new TaskResultContracts.GetPaymentDataResult(), result -> {
                int statusCode = result.getStatus().getStatusCode();
                switch (statusCode) {
                    case CommonStatusCodes.SUCCESS:
                        break;
                    case AutoResolveHelper.RESULT_ERROR:
                        handleError(statusCode, result.getStatus().getStatusMessage());
                        break;
                    case CommonStatusCodes.INTERNAL_ERROR:
                        handleError(statusCode, "Unexpected non API" +
                                " exception when trying to deliver the task result to an activity!");
                        break;
                }
            });



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donations);

        Home = findViewById(R.id.home_btn);
        Services = findViewById(R.id.service_btn);
        Donations = findViewById(R.id.donations);
        MyAccount = findViewById(R.id.account_box);
        Org1 = findViewById(R.id.org1);
        Org2 = findViewById(R.id.org2);
        Org3 = findViewById(R.id.org3);
        Org4 = findViewById(R.id.org4);
        Org5 = findViewById(R.id.org5);
        donateNow = findViewById(R.id.donate_now);
        Back = findViewById(R.id.back_btn);
        model = new ViewModelProvider(this).get(CheckoutViewModel.class);





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
                donateOrg(v);
            }
        });

        Org2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                donateOrg(v);
            }
        });

        Org3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                donateOrg(v);
            }
        });

        Org4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                donateOrg(v);
            }
        });

        Org5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                donateOrg(v);
            }
        });

        donateNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instantDonation(v);
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
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

    public void donateOrg(View anchorView){
        // Inflate the popup_layout.xml to a view
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.donate_service_1, null);

        // Initialize a new instance of PopupWindow
        popupOrg = new PopupWindow(
                popupView,
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );

        // Set an elevation value for the popup window
        popupOrg.setElevation(20);

        popupOrg.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                popupOrg.dismiss();
            }
        });
        //amountbox = findViewById(R.id.type_quantity);
        //long amount = amountbox.getText().length();

        /*EditText Opt1 = findViewById(R.id.select_organization);
        EditText Opt2 = findViewById(R.id.select_type);
        EditText Opt3 = findViewById(R.id.type_quantity);

        String opt1 = Opt1.getText().toString();
        String opt2 = Opt2.getText().toString();
        String opt3 = Opt2.getText().toString();*/

        View send = popupView.findViewById(R.id.button2);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*writeDB(opt1,opt2,opt3);
                Opt1.setText("");
                Opt2.setText("");
                Opt3.setText("");*/
                confirmService(v);
            }
        });


        View dismiss = popupView.findViewById(R.id.close_button);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupOrg.dismiss();
            }
        });


        // Show the popup window
        popupOrg.showAsDropDown(anchorView);
    };

    public void requestPayment(long amount,View view) {
        final Task<PaymentData> task = model.getLoadPaymentDataTask(amount);
        confirmService(view);
        task.addOnCompleteListener(task_new -> {
            if (task.isSuccessful()) {
                PaymentData paymentData = task.getResult();
                handlePaymentSuccess(paymentData, amount);
            } else {
                // Handle the case where payment data retrieval failed
                Log.e("requestPayment", "Error retrieving payment data");
            }
        });
    }



    private void handlePaymentSuccess(PaymentData paymentData, long amount) {
        final String paymentInfo = paymentData.toJson();

        try {
            JSONObject paymentMethodData = new JSONObject(paymentInfo).getJSONObject("paymentMethodData");

            final JSONObject info = paymentMethodData.getJSONObject("info");


            Log.d("Google Pay token", paymentMethodData
                    .getJSONObject("tokenizationData")
                    .getString("token"));

            // Here you can use the payment amount received from requestPayment
            // For example, you can display the payment amount in a toast message
            Toast.makeText(this, "Payment amount: " + amount, Toast.LENGTH_SHORT).show();

        } catch (JSONException e) {
            Log.e("handlePaymentSuccess", "Error: " + e);
        }
    }


    private void handleError(int statusCode, @Nullable String message) {
        Log.e("loadPaymentData failed",
                String.format(Locale.getDefault(), "Error code: %d, Message: %s", statusCode, message));
    }

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

        /*EditText Opt1 = findViewById(R.id.select_organization);
        EditText Opt2 = findViewById(R.id.type_quantity);

        String opt1 = Opt1.getText().toString();
        String opt2 = Opt2.getText().toString();*/

        View send = popupView.findViewById(R.id.button2);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*writeDB(opt1,opt2);
                Opt1.setText("");
                Opt2.setText("");*/
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


    public void writeDB(String opt1,String opt2,String opt3){
        donationsClass user = new donationsClass(opt1,opt2,opt3);
        DB = FirebaseDatabase.getInstance();
        reference = DB.getReference("loginUser");
        reference.child(opt1).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
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


    public void writeDB(String opt1,String opt2){
        donationsClass user = new donationsClass(opt1,opt2);
        DB = FirebaseDatabase.getInstance();
        reference = DB.getReference("loginUser");
        reference.child(opt1).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
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