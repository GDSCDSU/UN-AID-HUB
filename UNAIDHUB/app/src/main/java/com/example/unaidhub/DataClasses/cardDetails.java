package com.example.unaidhub.DataClasses;

public class cardDetails {

    String Name;
    String cardNo;
    String CVV;

    String Month;
    String Year;
    String postalCode;
    public cardDetails(String name, String cardNo, String CVV, String month, String year, String postalCode) {
        Name = name;
        this.cardNo = cardNo;
        this.CVV = CVV;
        Month = month;
        Year = year;
        this.postalCode = postalCode;
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


}
