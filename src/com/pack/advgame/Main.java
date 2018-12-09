package com.pack.advgame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer,Location> locs = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the Travel Game !!");
        defineExitMap();
        calculateDirection();
    }


    private static void defineExitMap(){
        locs.put(0,new Location(0,"Pashan"));
        locs.put(1,new Location(1,"Baner"));
        locs.put(2,new Location(2,"Shivajinagar"));
        locs.put(3,new Location(3,"FC Road"));
        locs.put(4, new Location(4, "Kothrud"));
        locs.put(5,new Location(5, "Bavdhan"));


        locs.get(1).addExit("S",2);
        locs.get(1).addExit("W",3);
        locs.get(1).addExit("N",4);
        locs.get(1).addExit("E",5);

        locs.get(2).addExit("W",3);
        locs.get(2).addExit("N",1);

        locs.get(3).addExit("E",1);
        locs.get(3).addExit("N",4);

        locs.get(5).addExit("W",1);
    }


    private static void calculateDirection(){
        Scanner scanner = new Scanner(System.in);
        int loc = 1;
        while(true){

            if(locs.containsKey(loc)){
                System.out.println("You're in "+locs.get(loc).getDescription());
            }else{
                System.out.println("No Location available");
            }

            Location location = locs.get(loc);


            System.out.print("Directions available are : ");
            for(String dirn : location.getExits().keySet()){
                System.out.print(dirn + ",");
            }
            System.out.println();
            String userInput = scanner.nextLine();
            String exitDirn = "";
            if(userInput.length() > 1){
                String[] exitDirnArr = userInput.split(" ");
                if(exitDirnArr.length == 1){
                    exitDirn = exitDirnArr[0];
                }else{
                    exitDirn = exitDirnArr[exitDirnArr.length-1];
                }
            }else{
                exitDirn = userInput;
            }

            loc = location.getExits().get(getDirection(exitDirn));

            if(loc == 0){
                break;
            }

        }
    }

    private static String getDirection(String exitDirection){

        exitDirection = exitDirection.toUpperCase();
        if(exitDirection.length() == 1){
            return exitDirection;
        }else {
            switch (exitDirection) {

                case "EAST":
                    return "E";
                case "WEST":
                    return "W";
                case "NORTH":
                    return "N";
                case "SOUTH":
                    return "S";
                default:
                    return "Q";
            }
        }

    }


}
