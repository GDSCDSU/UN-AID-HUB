package com.example.unaidhub.DataClasses;

public class donationsClass {
    String orgName,type,amount;


    public donationsClass(String orgName, String type, String amount) {
        this.orgName = orgName;
        this.type = type;
        this.amount = amount;
    }

    public donationsClass(String orgName, String amount) {
        this.orgName = orgName;
        this.amount = amount;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
