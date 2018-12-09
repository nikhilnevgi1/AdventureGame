package com.bms;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

    private String name;
    private List<Seat> seats;



    public Theatre(String name,int rows, int seatsPerRow){
        this.name = name;
        int lastRow = 'A' ;
                //+ (rows - 1);
        System.out.println(lastRow);
        seats = new ArrayList<>();
        for( char c = 'A'; c <= lastRow; c++){
            for(int i = 1;i <= seatsPerRow;i++) {
                String seatNumber = c + String.format("%02d", i);
                seats.add(new Seat(seatNumber, false));
                System.out.println(seatNumber);
            }
        }
        this.seats = seats;
    }


    /*public List<Seat> printSeats(){

        *//*int lastRow = 'A' + (rows - 1);
        seats = new ArrayList<>();
        for( char c = 'A'; c <= lastRow; c++){
            String seatNumber = String.format("%02d",c);
            seats.add(new Seat(seatNumber,false));
            System.out.println(seatNumber);
        }
        return seats;*//*

    }*/





    class Seat{
         private String seatNumber;
         private boolean isReserved;

         public Seat(String seatNumber, boolean isReserved){
             this.seatNumber = seatNumber;
             this.isReserved = isReserved;
         }

    }
}
