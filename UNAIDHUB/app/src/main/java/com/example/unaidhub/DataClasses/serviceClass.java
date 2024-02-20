package com.example.unaidhub.DataClasses;

public class serviceClass {
    String serviceName,opt1,opt2,opt3;

    public serviceClass(String serviceName, String opt1, String opt2, String opt3) {
        this.serviceName = serviceName;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
    }

    public serviceClass(String serviceName, String opt1, String opt2) {
        this.serviceName = serviceName;
        this.opt1 = opt1;
        this.opt2 = opt2;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }
}
