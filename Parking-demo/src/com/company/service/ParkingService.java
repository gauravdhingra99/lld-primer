package com.company.service;

import com.company.exceptions.NoSlotAvailableException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author gauravdhingra
 */
public class ParkingService {

    private static final Integer parkingSize = 3;
    private static final Integer levels = 2;
    TreeMap<Integer,TreeMap<Integer,String>> carSlotMap = new TreeMap<>();

    public String getParkingDetails(){
        return  carSlotMap.toString();
    }

    public String park(String carRegNum){
        ArrayList<Integer> availableLevelSlot = getAvailableSlot();
        TreeMap<Integer,String> carSlotNewMap = new TreeMap<>();
        carSlotNewMap.put(availableLevelSlot.get(1),carRegNum);
        carSlotMap.put(availableLevelSlot.get(0),carSlotNewMap);
        return "Car Parked Successfully at "+carSlotMap.toString();
    }

    private ArrayList<Integer> getAvailableSlot(){
        if(checkAvailableSlot()){
            ArrayList<Integer> levelSlotList = new ArrayList<>();
            getAvailableLevel(levelSlotList);
            if(carSlotMap.get(levelSlotList.get(0))==null){
                levelSlotList.add(1);
            }else if(carSlotMap.get(levelSlotList.get(0)).lastEntry()==){

            }
            levelSlotList.add(carSlotMap.lastEntry()==null
                    ?1:carSlotMap.lastEntry().getValue().lastEntry()==null
                    ?1:carSlotMap.lastEntry().getValue().lastEntry().getKey()+1);
           return levelSlotList;
        }
        throw new NoSlotAvailableException();
    }
    private ArrayList<Integer> getAvailableLevel(ArrayList<Integer> levelSlotList){
        if(carSlotMap.lastEntry()==null){
            levelSlotList.add(1);
        }else if(carSlotMap.lastEntry().getKey()>=levels){
            levelSlotList.add(carSlotMap.lastEntry().getKey());
        }else {
            levelSlotList.add(carSlotMap.lastEntry().getKey()+1);
        }
    }
    private Boolean checkAvailableSlot(){
        if(carSlotMap.keySet().size()==(levels) && carSlotMap.get(levels).size()==parkingSize){
            return false;
        }
        return true;
    }
}
