/*
 * Copyright 2024 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.unaidhub.GooglePayAPI;

import android.content.Context;

import com.google.android.gms.wallet.PaymentsClient;
import com.google.android.gms.wallet.Wallet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PaymentsUtil {

    public static final BigDecimal CENTS_IN_A_UNIT = new BigDecimal(100);

    private static JSONObject getBaseRequest() throws JSONException {
        return new JSONObject()
                .put("apiVersion", 2)
                .put("apiVersionMinor", 0);
    }


    public static PaymentsClient createPaymentsClient(Context context) {
        Wallet.WalletOptions walletOptions =
                new Wallet.WalletOptions.Builder().setEnvironment(Constants.PAYMENTS_ENVIRONMENT).build();
        return Wallet.getPaymentsClient(context, walletOptions);
    }


    private static JSONObject getGatewayTokenizationSpecification() throws JSONException {
        return new JSONObject()
                .put("type", "PAYMENT_GATEWAY")
                .put("parameters", new JSONObject()
                        .put("gateway", "example")
                        .put("gatewayMerchantId", "exampleGatewayMerchantId")
                );
    }


    private static JSONObject getDirectTokenizationSpecification()
            throws JSONException, RuntimeException {
        return new JSONObject()
                .put("type", "DIRECT")
                .put("parameters", new JSONObject(Constants.DIRECT_TOKENIZATION_PARAMETERS));
    }


    private static JSONArray getAllowedCardNetworks() {
        return new JSONArray(Constants.SUPPORTED_NETWORKS);
    }


    private static JSONArray getAllowedCardAuthMethods() {
        return new JSONArray(Constants.SUPPORTED_METHODS);
    }

    private static JSONObject getBaseCardPaymentMethod() throws JSONException {
        return new JSONObject()
                .put("type", "CARD")
                .put("parameters", new JSONObject()
                        .put("allowedAuthMethods", getAllowedCardAuthMethods())
                        .put("allowedCardNetworks", getAllowedCardNetworks())
                        .put("billingAddressRequired", true)
                        .put("billingAddressParameters", new JSONObject()
                                .put("format", "FULL")
                        )
                );
    }


    private static JSONObject getCardPaymentMethod() throws JSONException {
        return getBaseCardPaymentMethod()
                .put("tokenizationSpecification", getGatewayTokenizationSpecification());
    }

    public static JSONArray getAllowedPaymentMethods() throws JSONException {
        return new JSONArray().put(getCardPaymentMethod());
    }


    public static JSONObject getIsReadyToPayRequest() {
        try {
            return getBaseRequest()
                    .put("allowedPaymentMethods", new JSONArray().put(getBaseCardPaymentMethod()));
        } catch (JSONException e) {
            return null;
        }
    }


    private static JSONObject getTransactionInfo(String price) throws JSONException {
        return new JSONObject()
                .put("totalPrice", price)
                .put("totalPriceStatus", "FINAL")
                .put("countryCode", Constants.COUNTRY_CODE)
                .put("currencyCode", Constants.CURRENCY_CODE)
                .put("checkoutOption", "COMPLETE_IMMEDIATE_PURCHASE");
    }


    private static JSONObject getMerchantInfo() throws JSONException {
        return new JSONObject().put("merchantName", "Example Merchant");
    }


    public static JSONObject getPaymentDataRequest(long priceCents) {
        try {
            final String price = PaymentsUtil.centsToString(priceCents);
            return PaymentsUtil.getBaseRequest()
                    .put("allowedPaymentMethods", getAllowedPaymentMethods())
                    .put("transactionInfo", getTransactionInfo(price))
                    .put("merchantInfo", getMerchantInfo())
                    .put("shippingAddressRequired", true)
                    .put("shippingAddressParameters", new JSONObject()
                            .put("phoneNumberRequired", false)
                            .put("allowedCountryCodes", new JSONArray(Constants.SHIPPING_SUPPORTED_COUNTRIES))
                    );

        } catch (JSONException e) {
            return null;
        }
    }


    public static String centsToString(long cents) {
        return new BigDecimal(cents)
                .divide(CENTS_IN_A_UNIT, RoundingMode.HALF_EVEN)
                .setScale(2, RoundingMode.HALF_EVEN)
                .toString();
    }
}