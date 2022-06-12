package com.example.projectui;

import java.io.FileWriter;
import java.io.IOException;

public class Passenger {

    private String fullname;
    private String cnicno;
    private String password;
    private String username;
    private String emailID;

    private static Passenger P1 = new Passenger();

    private Passenger(){
        this("","","","","");
    }
    public static Passenger getInstance(){
        if(P1==null)
            P1= new Passenger();
        return P1;
    }

    public Passenger(String fullname,String cnicno,String password,String username,String emailID){
        setFullname(fullname);
        setCnicno(cnicno);
        setPassword(password);
        setUsername(username);
        setEmailID(emailID);
    }

    public void setFullname(String fullname){
        this.fullname=fullname;
    }
    public void setUsername(String username){
        this.username= username;
    }
    public void setCnicno(String cnicno){
        this.cnicno=cnicno;
    }
    public void setPassword(String password){
        this.password= password;
    }
    public void setEmailID(String emailID){
        this.emailID= emailID;
    }
    public String getFullname(){
        return  fullname;
    }
    public String getUsername(){
        return username;
    }
    public String getCnicno(){
        return cnicno;
    }
    public String getPassword(){
        return password;
    }
    public String getEmailID(){
        return emailID;
    }

    FileHandler fileHandler= new FileHandler();

    public String login(String name,String passwd) {
        return fileHandler.login(name,passwd);
    }

    public String signUp() {
        return fileHandler.signUp(username,password,cnicno,fullname,emailID);
    }

}
