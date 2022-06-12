package com.example.projectui;

public class Receipt {
    int receipt_no;
    public Receipt(){
        this(0);
    }
    public Receipt(int receipt_no){
        setReceipt_no(receipt_no);
    }
    void setReceipt_no(int receipt_no){
        this.receipt_no=receipt_no;
    }
    int getReceipt_no(){
        return receipt_no;
    }
}
