package com.example.projectui;

public class Payment {
    double amount;

    Payment(){
        this(0.0);
    }
    Payment(double amount){
        setAmount(amount);
    }
    void setAmount(double amount){
        this.amount=amount;
    }
    double getAmount(){
        return amount;
    }



}
