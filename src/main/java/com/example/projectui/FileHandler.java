package com.example.projectui;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileHandler {


    public String signUp(String username, String password, String cnicno, String fullname, String emailID) {
        if (Objects.equals(fullname, "") || Objects.equals(username, "") || Objects.equals(cnicno, "") || Objects.equals(password, "") || Objects.equals(emailID, "")) {
            return "Fields are empty";
        } else {

            boolean flag = false;
            try {
                File F1 = new File("C:\\Users\\AnOnYmous\\IdeaProjects\\projectUI\\Passenger.txt");
                Scanner scanner = new Scanner(F1);
                String line = scanner.nextLine();
                while (scanner.hasNextLine()) {
                    String line2 = scanner.nextLine();
                    StringTokenizer st = new StringTokenizer(line2, ",");
                    String name = st.nextToken();
                    String p=st.nextToken();
                    String cnic=st.nextToken();
                    System.out.println(name);
                    if (name.equals(username) && cnic.equals(cnicno))
                        flag = true;
                }
                scanner.close();

            } catch (FileNotFoundException e) {
                System.out.println("errors are here boi");
                e.printStackTrace();
            }
            if (flag == true)
                return "username or CnicNo already exists";
            else {
                writeToPassengerFile(username, password, cnicno, fullname, emailID);
                return "Success";
            }
        }
    }

    public String login(String userText, String pwdText) {
        if (userText.isEmpty() || pwdText.isEmpty()) {
            return "Fields are empty\n";
        }

        boolean flag = false;
        try {
            File F1 = new File("C:\\Users\\AnOnYmous\\IdeaProjects\\projectUI\\Passenger.txt");
            Scanner scanner = new Scanner(F1);
            String line = scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line2 = scanner.nextLine();
                StringTokenizer st = new StringTokenizer(line2, ",");
                String username = st.nextToken();
                System.out.println(username);
                String pswd = st.nextToken();
                String cnic = st.nextToken();
                String fullname = st.nextToken();
                String email = st.nextToken();
                System.out.println(pswd);
                if (username.equals(userText) && pswd.equals(pwdText)) {
                    flag = true;
                    Passenger P1 = Passenger.getInstance();
                    P1.setUsername(username);
                    P1.setPassword(pswd);
                    P1.setCnicno(cnic);
                    P1.setFullname(fullname);
                    P1.setEmailID(email);
                }


            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("File not opened\n");
            e.printStackTrace();
        }
        if (flag == true)
            return "Success";
        else
            return "Username and Password incorrect";
    }


    void writeToPassengerFile(String un, String pd, String cnc, String fn, String eml) {
        try {
            FileWriter f1 = new FileWriter("Passenger.txt", true);
            String line = "";
            line += un;
            line += ",";
            line += pd;
            line += ",";
            line += cnc;
            line += ",";
            line += fn;
            line += ",";
            line += eml;
            line += "\n";
            f1.append(line);
            System.out.println("Passenger.txt file was updated");
            f1.close();
        } catch (IOException e) {
            System.out.println("An error occured\n");
            e.printStackTrace();
        }
    }

    public String seeSchedule(String departure_platform, String arrival_platform) {
        boolean flag = false;
        try {
            File F1 = new File("C:\\Users\\AnOnYmous\\IdeaProjects\\projectUI\\TrainSchedule.txt");
            Scanner scanner = new Scanner(F1);
            String line = scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line2 = scanner.nextLine();
                StringTokenizer st = new StringTokenizer(line2, ",");
                String dep_st= st.nextToken();
                String arr_st= st.nextToken();
                String train_id= st.nextToken();
                String train_nm=st.nextToken();
                String date= st.nextToken();
                String duration= st.nextToken();
                String toatalseats= st.nextToken();
                String fare=st.nextToken();

                System.out.println("a  " + dep_st);
                System.out.println(departure_platform);

                System.out.println(arr_st);
                System.out.println(arrival_platform);
                System.out.println();
                if(arr_st.equals(arrival_platform) && dep_st.equals(departure_platform)){
                    flag=true;
                    TrainDescription description=TrainDescription.getInstance();
                    TrainSchedule schedule=TrainSchedule.getInstance();
                    schedule.setArrival_platform(arr_st);
                    schedule.setDeparture_platform(dep_st);
                    description.setTrain_id(train_id);
                    description.setTrain_name(train_nm);
                    description.setDate(date);
                    description.setDuration(duration);
                    //description.setSeats(totalseats);
                    description.setFare(fare);
                }
            }
            scanner.close();
        }
        catch (Exception e){
            System.out.println("errors are waiting for you/");
            e.printStackTrace();
        }
        if(flag){
            return "Success";
        }
        else{
            return "No Trains Moving in this route";
        }
    }

    public String seeOnlySchedule(String mydepartStation, String myarrivalStation) {
        return seeSchedule(mydepartStation,myarrivalStation);
    }


    public String addBooking(String t_id,String cnc,String arr_st,String dep_st,String fn,int st_no,int t_no,String fr){
        boolean flag = false;
        String seatn=Integer.toString(st_no);

        try {
            File F1 = new File("C:\\Users\\AnOnYmous\\IdeaProjects\\projectUI\\Booking.txt");
            Scanner scanner = new Scanner(F1);
            String line = scanner.nextLine();
            String set=Integer.toString(st_no);
            while (scanner.hasNextLine()) {
                String line2 = scanner.nextLine();
                StringTokenizer st = new StringTokenizer(line2, ",");
                String trainid=st.nextToken();
                String cnic=st.nextToken();
                String arrival=st.nextToken();
                String depart=st.nextToken();
                String name=st.nextToken();
                String seatno = st.nextToken();
                String ticket=st.nextToken();
                String  fare= st.nextToken();
                System.out.println(seatno);


                int tckt= Integer.parseInt(ticket);


                System.out.println(seatno);
                if(seatno.equals(set) || cnic.equals(cnc) ){
                    flag=true;
                    return "Already Booked";
                }

            }
            writeToBookingFile(t_id,cnc,arr_st,dep_st,fn,st_no,t_no,fr);

            Reservation reservation=Reservation.getInstance();

            reservation.setPassengerFullname(fn);
            reservation.setTrainID(t_id);
            reservation.setArrivalStation(arr_st);
            reservation.setDepartureStation(dep_st);
            reservation.setPassengerCnic(cnc);
            reservation.setSeatNo(Integer.toString(st_no));
            reservation.setTicketNo(t_no);
            reservation.setFare(fr);
            scanner.close();
            return "Success";

        } catch (FileNotFoundException e) {
            System.out.println("errors are here boi");
            e.printStackTrace();
        }

        if(flag)
            return"Seat Or Username already issued";
        else {

            return "Success";
        }
    }
   // ArrayList<Reservation> reservations= new ArrayList<Reservation>();
    public void writeToBookingFile(String t_id,String cnc,String arr_st,String dep_st,String fn,int st_no,int t_no,String fr){
        try {
            FileWriter f1 = new FileWriter("Booking.txt", true);
            String line = "";
            line += t_id;
            line += ",";
            line += cnc;
            line += ",";
            line += arr_st;
            line += ",";
            line += dep_st;
            line += ",";
            line += fn;
            line += ",";
            line += st_no;
            line += ",";
            line += t_no;
            line += ",";
            line += fr;
            line += "\n";
            f1.append(line);
            System.out.println("Booking.txt file was updated");
            f1.close();

        }
        catch (Exception e){
            System.out.println("errors");
            e.printStackTrace();
        }
    }

    void readBookingFile(String cnicNo){
        try {
            File F1 = new File("C:\\Users\\AnOnYmous\\IdeaProjects\\projectUI\\Booking.txt");
            Scanner scanner = new Scanner(F1);
            String line = scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line2 = scanner.nextLine();
                StringTokenizer st = new StringTokenizer(line2, ",");
                String trainid=st.nextToken();
                String cnic=st.nextToken();
                String arrival=st.nextToken();
                String depart=st.nextToken();
                String name=st.nextToken();
                String seatno = st.nextToken();
                String ticket=st.nextToken();
                String  fare= st.nextToken();

                int tckt= Integer.parseInt(ticket);

                if(cnicNo.equals(cnic)){
                    Reservation reservation=Reservation.getInstance();

                    reservation.setPassengerFullname(name);
                    reservation.setTrainID(trainid);
                    reservation.setArrivalStation(arrival);
                    reservation.setDepartureStation(depart);
                    reservation.setPassengerCnic(cnic);
                    reservation.setSeatNo(seatno);
                    reservation.setTicketNo(tckt);
                    reservation.setFare(fare);
                }


            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("errors are here boi");
            e.printStackTrace();
        }
    }

    public String cancelTicket(String fullname, String ticketno) {

        boolean flag = false;
        try {
            File F1 = new File("C:\\Users\\AnOnYmous\\IdeaProjects\\projectUI\\Booking.txt");
            Scanner scanner = new Scanner(F1);
            String line = scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line2 = scanner.nextLine();
                StringTokenizer st = new StringTokenizer(line2, ",");
                String trainid = st.nextToken();
                String cnic = st.nextToken();
                String arrival = st.nextToken();
                String depart = st.nextToken();
                String name = st.nextToken();
                String seatno = st.nextToken();
                String ticket = st.nextToken();
                String fare = st.nextToken();
                int tckt = Integer.parseInt(ticket);
                if(fullname.equals(name) && ticketno.equals(ticket))//{
                    flag=true;
//                    File tempFile= new File("mytempfile.txt");
//                    BufferedReader reader = new BufferedReader(new FileReader(F1));
//                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
//                    String currentLine="";
//                    while((currentLine= reader.readLine())!=null){
//                        String trimmedLine= currentLine.trim();
//                        if(trimmedLine.equals(name) && trimmedLine.equals(cnic))
//                            continue;
//                        writer.write(currentLine+System.getProperty("\n"));
//                    }
//                    writer.close();
//                    reader.close();
//                    boolean successful= tempFile.renameTo(F1);
//                    System.out.println(successful);
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(flag){

                return "Success";
        }
        return "Full Name or TicketNo not correct";
    }

}
