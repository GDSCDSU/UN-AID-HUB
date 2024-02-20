package com.example.unaidhub.GooglePayAPI;


import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.google.android.gms.tasks.Task;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.PaymentData;
import com.google.android.gms.wallet.PaymentDataRequest;
import com.google.android.gms.wallet.PaymentsClient;

import org.json.JSONObject;

public class CheckoutViewModel extends AndroidViewModel {


    private final PaymentsClient paymentsClient;


    private final MutableLiveData<Boolean> _canUseGooglePay = new MutableLiveData<>();

    public CheckoutViewModel(@NonNull Application application) {
        super(application);
        paymentsClient = PaymentsUtil.createPaymentsClient(application);

        fetchCanUseGooglePay();
    }

    public final LiveData<Boolean> canUseGooglePay = _canUseGooglePay;


    private void fetchCanUseGooglePay() {
        final JSONObject isReadyToPayJson = PaymentsUtil.getIsReadyToPayRequest();
        if (isReadyToPayJson == null) {
            _canUseGooglePay.setValue(false);
            return;
        }


        IsReadyToPayRequest request = IsReadyToPayRequest.fromJson(isReadyToPayJson.toString());
        Task<Boolean> task = paymentsClient.isReadyToPay(request);
        task.addOnCompleteListener(
                completedTask -> {
                    if (completedTask.isSuccessful()) {
                        _canUseGooglePay.setValue(completedTask.getResult());
                    } else {
                        Log.w("isReadyToPay failed", completedTask.getException());
                        _canUseGooglePay.setValue(false);
                    }
                });
    }


    public Task<PaymentData> getLoadPaymentDataTask(final long priceCents) {
        JSONObject paymentDataRequestJson = PaymentsUtil.getPaymentDataRequest(priceCents);
        if (paymentDataRequestJson == null) {
            return null;
        }

        PaymentDataRequest request =
                PaymentDataRequest.fromJson(paymentDataRequestJson.toString());
        return paymentsClient.loadPaymentData(request);
    }
}