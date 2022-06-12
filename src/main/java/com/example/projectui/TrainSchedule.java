package com.example.projectui;

public class TrainSchedule {
    String  arrival_platform;
    String departure_platform;
//    String duration;
//    String date;

    private TrainSchedule(){
        arrival_platform="";
        departure_platform="";
/*        duration="";
        date="";*/
    }

    private static TrainSchedule trainSchedule= new TrainSchedule();

    public static TrainSchedule getInstance(){
        if(trainSchedule==null)
            trainSchedule= new TrainSchedule();
        return trainSchedule;
    }

/*    public void setDuration(String duration){
        this.duration=duration;
    }
    public void setDate(String date){
        this.date=date;
    }*/
    public void setArrival_platform(String arrival_platform){
        this.arrival_platform=arrival_platform;
    }
    public void setDeparture_platform(String departure_platform){
        this.departure_platform=departure_platform;
    }

/*    public String getDuration(){
        return duration;
    }
    public String getDate(){
        return date;
    }*/
    public String getArrival_platform(){
        return arrival_platform;
    }
    public String getDeparture_platform(){
        return departure_platform;
    }
    FileHandler fileHandler= new FileHandler();
    public String seeSchedule(String arr_platform,String dep_platform) {
        return fileHandler.seeSchedule(arr_platform,dep_platform);
    }

    public String seeOnlySchedule(String mydepartStation, String myarrivalStation) {
        return fileHandler.seeOnlySchedule(mydepartStation,myarrivalStation);
    }

    // set value gained from checktrain
    //make train and train schedule singleton

}
