package com.example.unaidhub.DataClasses;

public class instantDonationClass {
    String orgName,amount;

    public instantDonationClass(String orgName, String amount) {
        this.orgName = orgName;
        this.amount = amount;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
