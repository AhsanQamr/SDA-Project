package com.example.projectui;

public class TrainDescription {

    private int total_seats;
    private String train_id;
    private String train_name;
    private String current_status;
    private String date;
    private String duration;
    private String fare;
    private int seat;

    private static TrainDescription train= new TrainDescription();
    private TrainDescription(){this(0,"","","","","","");}

    public static TrainDescription getInstance(){
        if(train==null)
            train= new TrainDescription();
        return train;
    }

    public TrainDescription(int total_seats,String train_id,String train_name, String current_status,String date,String duration,String fare){
        setTotal_seats(total_seats);
        setTrain_id(train_id);
        setTrain_name(train_name);
        setCurrent_status(current_status);
        setDate(date);
        setDuration(duration);
        setFare(fare);
    }

    public void setTotal_seats(int total_seats){
        this.total_seats=total_seats;
    }
    public void setTrain_id(String train_id){
        this.train_id=train_id;
    }
    public void setTrain_name(String train_name){
        this.train_name=train_name;
    }
    public void setCurrent_status(String current_status){
        this.current_status=current_status;
    }
    public void setDate(String date){
        this.date=date;
    }
    public void setDuration(String duration){
        this.duration=duration;
    }

    public int getTotal_seats(){
        return total_seats;
    }
    public String getTrain_id(){
        return train_id;
    }
    public String getTrain_name(){
        return train_name;
    }
    public String getDate(){
        return date;
    }
    public void setFare(String fare){
        this.fare=fare;
    }
    public String getFare(){
        return fare;
    }

    public String getDuration(){
        return duration;
    }
    public String getCurrent_status(){
        return current_status;
    }
    public void setSeat(int seat){
        this.seat=seat;
    }
    public int getSeat(){
        return seat;
    }

}
