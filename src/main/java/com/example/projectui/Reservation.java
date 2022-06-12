package com.example.projectui;


import java.util.Random;

public class Reservation {
    Random random= new Random();
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    private String seatNo;
    private int ticketNo=getRandomNumber(1000,9999);

    private Reservation(){

    }

    private static Reservation reservation= new Reservation();
    public static Reservation getInstance() {
        if(reservation==null)
            reservation=new Reservation();
        return reservation;
    }

    public void setPassengerFullname(String fullname){
        passenger.setFullname(fullname);
    }
    public String getPassengerFullName(){
        return passenger.getFullname();
    }
    public void setPassengerCnic(String cnic){
        passenger.setCnicno(cnic);
    }
    public String getPassengerCnic(){
        return passenger.getCnicno();
    }
    public void setArrivalStation(String arrival){
        trainSchedule.setArrival_platform(arrival);
    }
    public String getArrivalStation(){
        return trainSchedule.getArrival_platform();
    }
    public void setDepartureStation(String depart){
        trainSchedule.setDeparture_platform(depart);
    }
    public String getDepartureStation(){
        return trainSchedule.getDeparture_platform();
    }
    public void setTrainID(String trainID){
        trainDescription.setTrain_id(trainID);
    }
    public String getTrainID(){
        return trainDescription.getTrain_id();
    }

    public void setSeatNo(String seatNo){
        this.seatNo=seatNo;
    }
    public void setTicketNo(int ticketNo){
       this.ticketNo=ticketNo;
    }
    public void setFare(String fare){
        trainDescription.setFare(fare);
    }
    public String getFare(){
        return trainDescription.getFare();
    }
    public String getSeatNo(){
        return seatNo;
    }
    public int getTicketNo(){
        return ticketNo;
    }

    TrainDescription trainDescription= TrainDescription.getInstance();
    TrainSchedule trainSchedule=TrainSchedule.getInstance();
    Passenger passenger=Passenger.getInstance();

    public String setInBookingFile(){
        //int seat=IssueTicketController.getSeat();
        FileHandler fileHandler= new FileHandler();
        return fileHandler.addBooking(trainDescription.getTrain_id(),Passenger.getInstance().getCnicno(), trainSchedule.getArrival_platform(),
                trainSchedule.getDeparture_platform(),passenger.getFullname(),trainDescription.getSeat(),ticketNo,
                trainDescription.getFare());
    }




}
