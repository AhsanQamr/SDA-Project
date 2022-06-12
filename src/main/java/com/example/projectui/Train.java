package com.example.projectui;

public class Train {
    private String company;
    private int purchase_year;

    public Train(){
        this("",0000);
    }

    public Train(String company,int purchase_year){
        setCompany(company);
        setPurchase_year(purchase_year);
    }

    public void setCompany(String company){
        this.company=company;
    }

    public void setPurchase_year(int purchase_year){
        this.purchase_year=purchase_year;
    }

    public String getCompany(){
        return company;
    }

    public int getPurchase_year(){
        return purchase_year;
    }

}
