package com.example.projectui;

public class Ticket {
    int ticket_id;
    String date_of_issue;
    String arrival_station;
    String departure_station;

    private Ticket(){
        this(0,"","","");
    }
    private static Ticket ticket= new Ticket();
    Ticket(int ticket_id,String date_of_issue,String arrival_station,String departure_station){
        setTicket_id(ticket_id);
        setDate_of_issue(date_of_issue);
        setArrival_station(arrival_station);
        setDeparture_station(departure_station);
    }

    public static Ticket getInstance(){
        if(ticket==null){
            ticket=new Ticket();
        }
        return ticket;
    }


    void setTicket_id(int ticket_id){
        this.ticket_id=ticket_id;
    }
    void setDate_of_issue(String date_of_issue){
        this.date_of_issue=date_of_issue;
    }
    void setArrival_station(String arrival_station){
        this.arrival_station=arrival_station;
    }
    void setDeparture_station(String departure_station){
        this.departure_station=departure_station;
    }
    String getDate_of_issue(){
        return date_of_issue;
    }
    String getArrival_station(){
        return arrival_station;
    }
    String getDeparture_station(){
        return departure_station;
    }
    int getTicket_id(){
        return ticket_id;
    }


    void printTicket(){

    }

    public String cancelTicket(String fullname, String ticketno) {
        FileHandler fileHandler= new FileHandler();
        return fileHandler.cancelTicket(fullname,ticketno);
    }
}
