package com.navi.Repository;

import com.navi.Model.RentalBranch;
import com.navi.Model.Vehicle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravdhingra
 */
public class RentalBranchRepository {
    Map<String, RentalBranch> rentalBranchMap = new HashMap<>();


    public void save(RentalBranch rentalBranch){
        rentalBranchMap.put(rentalBranch.getName(),rentalBranch);
    }

    public Map<String, RentalBranch> getAllBranchAndVehicles(){
        return rentalBranchMap;
    }

//    public List<Vehicle> getAllAvailableVehicleByBranch(String branchName){
//        List<Vehicle> availableVehicle = new ArrayList<>();
//        if(rentalBranchMap.containsKey(branchName)){
//            Map<String, Vehicle> vehicles = rentalBranchMap.get(branchName).getVehicles();
//          for(Map.Entry<String,Vehicle> vehicleEntry : vehicles.entrySet()) {
//              if (!vehicleEntry.getValue().getVehicleStatus().equals(VehicleStatus.FULLYBOOKED)) {
//                  availableVehicle.add(vehicleEntry.getValue());
//              }
//          }
//            return availableVehicle;
//        }
//        return null;
//    }

//    public Map<String, List<Vehicle>> getAvailableVehicleByTimeAndType(String vehicleType , Integer timeSlot){
//        Map<String,List<Vehicle>> availableVehicleMap = new HashMap<>();
//        for(Map.Entry<String,RentalBranch> branch : rentalBranchMap.entrySet()){
//            List<Vehicle> availableVehicleList = branch.getValue().getVehicles().entrySet()
//                    .stream()
//                    .filter(v -> v.getValue().getVehicleType().equals(vehicleType))
//                    .filter(v -> v.getValue().getVehicleStatus().equals(VehicleStatus.AVAILABLE))
//                    .filter(v -> timeSlot <= (24 - v.getValue().getBookedTime()))
//                    .sorted()
//                    .map(Map.Entry::getValue).collect(Collectors.toList());
//            if(availableVehicleList.size()>0){
//                availableVehicleMap.put(branch.getKey(),availableVehicleList);
//            }
//        }
//        return availableVehicleMap;
//    }

//    public Map<String, Vehicle> getAvailableVehicleByBranchAndRegNo(String branchName , String regNo){
//        Map<String,Vehicle> availableVehicleMap = new HashMap<>();
//        availableVehicleMap.put(branchName,rentalBranchMap.get(branchName).getVehicles().get(regNo));
//        return availableVehicleMap;
//    }

    public void update(String branchName, Vehicle vehicle){
        rentalBranchMap.get(branchName).getVehicles().put(vehicle.getRegNo(),vehicle);
    }

    public void remove(Vehicle vehicle){
        rentalBranchMap.get(vehicle.getRentalBranchName()).getVehicles().remove(vehicle.getRegNo(),vehicle);
    }
}
