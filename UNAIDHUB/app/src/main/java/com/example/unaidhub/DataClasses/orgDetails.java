package com.example.unaidhub.DataClasses;

public class orgDetails {
    String org_name;
    String location;

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    String contact;

    public orgDetails(String org_name, String location, String contact, String website) {
        this.org_name = org_name;
        this.location = location;
        this.contact = contact;
        this.website = website;
    }

    String website;
}
