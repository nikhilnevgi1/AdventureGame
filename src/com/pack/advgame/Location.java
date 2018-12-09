package com.pack.advgame;

import java.util.HashMap;
import java.util.Map;

public class Location {

    private final int locationID;
    private final String description;
    private Map<String,Integer> exits;


    public Location(int locationID,String description){
        this.locationID = locationID;
        this.description = description;
        exits = new HashMap<>();
        exits.put("Q",0);
    }

    public void addExit(String dirn,Integer locationID){
        exits.put(dirn,locationID);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String,Integer> getExits() {
        return exits;
    }


}
