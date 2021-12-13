package com.navi.Repository;

import com.navi.Enums.VehicleStatus;
import com.navi.Model.Vehicle;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author gauravdhingra
 */
public class VehicleRepository {
    Map<String, Vehicle> vehicleMap = new HashMap<>();

    public void save(Vehicle vehicle){
        vehicleMap.put(vehicle.getRegNo(),vehicle);
    }



    public Map<String, Vehicle> getAllVehicle(){
        return vehicleMap;
    }


    public Vehicle getVehicleByRegNo(String regNo){
        return vehicleMap.get(regNo);
    }

    public Map<String, Vehicle> getAllVehicleByBranchName(String branchName){
        Map<String, Vehicle> branchVehicles =new HashMap<>();
        for(Map.Entry<String, Vehicle> vehicles : vehicleMap.entrySet()){
            if(vehicles.getValue().getRentalBranchName().equals(branchName)){
                branchVehicles.put(vehicles.getValue().getRegNo(),vehicles.getValue());
            }
        }
        return branchVehicles;
    }

    public List<Vehicle> getAllAvailableVehicleByBranch(String branchName){
        return vehicleMap.entrySet().stream()
                .filter(v -> v.getValue().getRentalBranchName().equals(branchName))
                .filter(v -> !v.getValue().getVehicleStatus().equals(VehicleStatus.FULLYBOOKED))
                .sorted(Comparator.comparingDouble(o -> o.getValue().getPricePerHour()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
    public int getCountOfVehicleByBranch(String branchName){
        return (int) vehicleMap.entrySet().stream().filter(v->v.getValue().getRentalBranchName().equals(branchName)).count();
    }

    public List<Vehicle> getAvailableVehicleByTimeAndType(String vehicleType , Integer timeSlot){
        return vehicleMap.entrySet()
                .stream()
                .filter(v -> v.getValue().getVehicleType().equals(vehicleType))
                .filter(v -> !v.getValue().getVehicleStatus().equals(VehicleStatus.FULLYBOOKED))
                .filter(v -> timeSlot <= (24 - v.getValue().getBookedSlots()))
                .sorted(Comparator.comparingDouble(o -> o.getValue().getPricePerHour()))
                .map(Map.Entry::getValue).collect(Collectors.toList());
    }

    public Vehicle getAvailableVehicleByBranchAndRegNo( String regNo,String branchName){
        return vehicleMap.get(regNo).getRentalBranchName().equals(branchName)
                && vehicleMap.get(regNo).getVehicleStatus()!=VehicleStatus.FULLYBOOKED ?vehicleMap.get(regNo):null;
    }

    public void update(Vehicle vehicle){
        vehicleMap.put(vehicle.getRegNo(),vehicle);
    }

}
