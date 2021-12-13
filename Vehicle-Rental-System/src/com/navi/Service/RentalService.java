package com.navi.Service;

import com.navi.Enums.VehicleStatus;
import com.navi.Exception.CarNotAvailableException;
import com.navi.Exception.WrongBranchSelectedException;
import com.navi.Model.Bike;
import com.navi.Model.Car;
import com.navi.Model.RentalBranch;
import com.navi.Model.Vehicle;
import com.navi.Repository.RentalBranchRepository;
import com.navi.Repository.VehicleRepository;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @author gauravdhingra
 */
public class RentalService {

    VehicleRepository vehicleRepository = new VehicleRepository();
    RentalBranchRepository rentalBranchRepository = new RentalBranchRepository();

    public void bookVehicle(String vehicleType , Integer timeSlot){
        List<Vehicle> availableBranchVehicleList =
                vehicleRepository.getAvailableVehicleByTimeAndType(vehicleType,timeSlot);
        if (availableBranchVehicleList.size()>0){
            Vehicle vehicle = availableBranchVehicleList.get(0);
            setVehicleBookTimeAndStatus(vehicle,timeSlot);
            vehicleRepository.update(vehicle);
            rentalBranchRepository.update(vehicle.getRentalBranchName(),vehicle);
            System.out.println("Booked Vehicle Model: " + vehicle.getName() +" Reg No. "+ vehicle.getRegNo() +
                    "for " + timeSlot +
                    " Hrs. Amount To be payed Rs."+ vehicle.getPricePerHour() * timeSlot +"   Drive Safely.");

        }else {
            throw new CarNotAvailableException(vehicleType + "Not Available");
        }
    }

    public void returnVehicle(String regNo , Integer usedSlot, String branchName){
        Vehicle vehicle=vehicleRepository.getVehicleByRegNo(regNo);
        if(Objects.isNull(vehicle)){
            throw new CarNotAvailableException("Please return vehicle to the branch where it was picked up");
        }
        else if(!vehicle.getRentalBranchName().equals(branchName)){
            throw new WrongBranchSelectedException("Please return vehicle to the branch where it was picked up");
        }else {
            vehicle.setBookedSlots(vehicle.getBookedSlots()-usedSlot);
            if(vehicle.getBookedSlots()>0)
                vehicle.setVehicleStatus(VehicleStatus.INUSE);
            else {
                vehicle.setVehicleStatus(VehicleStatus.AVAILABLE);
            }
        }
        vehicleRepository.update(vehicle);
        rentalBranchRepository.update(branchName,vehicle);
        System.out.println(vehicle.getVehicleType()+ " "+ vehicle.getName()+" "+vehicle.getRegNo() +"Returned successfully");
    }

    public void getAllVehiclesByBranch(String branchName){
        List<Vehicle> availableVehicleList=vehicleRepository.getAllAvailableVehicleByBranch(branchName);
        surgePricing(availableVehicleList,branchName);
        System.out.println(vehicleRepository.getAllAvailableVehicleByBranch(branchName).toString());

    }

    public void onboardNewBranch(String branchName, String address, String[] vehicleList){
        Map<String,Vehicle>vehicleMap = vehicleRepository.getAllVehicle();
        checkIfVehicleAlreadyExistInDiffBranch(vehicleList,branchName,vehicleMap);
        RentalBranch rentalBranch = new RentalBranch(branchName,address,
                createBranchWiseVehicleMap(vehicleList,branchName,vehicleMap));
        rentalBranchRepository.save(rentalBranch);
        System.out.println("New Branch "+ branchName +"Onboarded with vehicles"+ Arrays.toString(vehicleList));
    }

    public void onboardNewVehicle(String regNo,String name,String vehicleType,Double pricePerHour,String branchName){
        validate(regNo);
        vehicleRepository.save(getVehicleType(regNo,name,vehicleType,pricePerHour,branchName));
        System.out.println("New "+vehicleType + " with regno. " + regNo  +" Onboarded in branch"+ branchName);
    }

    private void validate(String regNo){
        Map<String, Vehicle> vehicleMap = vehicleRepository.getAllVehicle();
        if(vehicleMap.containsKey(regNo)){
            throw new RuntimeException("Vehicle with same registration number already exists");
        }
    }
    private Vehicle getVehicleType(String regNo,String name, String vehicleType,Double pricePerHour,String branchName){
        switch (vehicleType){
            case "CAR":
                return new Car(regNo,name,pricePerHour,branchName);
            case "BIKE":
                return new Bike(regNo,name,pricePerHour,branchName);
            default:
                throw new RuntimeException("wrong vehicle type mentioned");
        }
    }

    private void checkIfVehicleAlreadyExistInDiffBranch(String[] vehicleList,String branchName,Map<String,Vehicle>vehicleMap){
        for (String s : vehicleList) {
            if(vehicleMap.get(s)==null){
                throw new CarNotAvailableException("Vehicle" + s + "Doesnt exist");
            }
            if(vehicleMap.get(s).getRentalBranchName().equals(branchName)){
                throw new RuntimeException("Vehicle"+s+ "already exist in branch" + branchName);
            }
        }
    }

    private Map<String,Vehicle> createBranchWiseVehicleMap(String[] vehicleList,String branchName,Map<String,Vehicle> allVehicleMap){
        Map<String,Vehicle> branchWiseVehicleMap = new HashMap<>();
        for (String s : vehicleList) {
            Vehicle vehicle = allVehicleMap.get(s);
            rentalBranchRepository.remove(vehicle);
            vehicle.setRentalBranchName(branchName);
            vehicleRepository.update(vehicle);
            branchWiseVehicleMap.put(s,vehicle);
        }
        return branchWiseVehicleMap;
    }

    public void bookVehicle(String vehicleType , Integer timeSlot,String regNo,String branchName){
        Vehicle availableVehicle =
                vehicleRepository.getAvailableVehicleByBranchAndRegNo(regNo,branchName);
        if (Objects.nonNull(availableVehicle)){
            setVehicleBookTimeAndStatus(availableVehicle,timeSlot);
            vehicleRepository.update(availableVehicle);
            rentalBranchRepository.update(availableVehicle.getRentalBranchName(),availableVehicle);
            System.out.println("Booked Vehicle Model: " + availableVehicle.getName() +" Reg No. "+ availableVehicle.getRegNo() +
                    " for " + timeSlot +
                    " Hrs. Amount To be payed Rs."+ availableVehicle.getPricePerHour() * timeSlot + " Pick from branch "+ branchName+" Drive Safely.");
        }else {
            throw new CarNotAvailableException(vehicleType + "Not Available");
        }
    }

    private void setVehicleBookTimeAndStatus(Vehicle vehicle,Integer timeSlot){
        vehicle.setBookedSlots(vehicle.getBookedSlots() + timeSlot);
        if(vehicle.getBookedSlots()<24){
            vehicle.setVehicleStatus(VehicleStatus.INUSE);
        }else {
            vehicle.setVehicleStatus(VehicleStatus.FULLYBOOKED);
        }
    }

    private void surgePricing(List<Vehicle> availableVehicleList,String branchName){
        int availableVehicleCount = availableVehicleList.size();
        int totalVehicle =vehicleRepository.getCountOfVehicleByBranch(branchName);
        int percent = availableVehicleCount*100/totalVehicle;
        if(percent<80){
            for (Vehicle vehicle : availableVehicleList) {
                vehicle.setPricePerHour(vehicle.getPricePerHour()+vehicle.getPricePerHour() * 0.1);
                vehicleRepository.update(vehicle);
                rentalBranchRepository.update(branchName,vehicle);
            }
        }
    }
    @PostConstruct
    public void intialize(){
        vehicleRepository.save(new Bike("UP-80-DC-123","R15",150d,"BTM"));
        vehicleRepository.save(new Bike("UP-80-DC-124","Pulsar",100d,"BTM"));
        vehicleRepository.save(new Bike("UP-80-DC-125","Splender",50d,"KORMANGLA"));
        vehicleRepository.save(new Bike("UP-80-DC-126","Bullet",150d,"KORMANGLA"));
        vehicleRepository.save(new Bike("UP-80-DC-127","CBZ",175d,"KORMANGLA"));
        vehicleRepository.save(new Bike("UP-80-DC-128","HARLEY",200d,"KORMANGLA"));
        vehicleRepository.save(new Car("UP-80-DC-127","Innova",300d,"BTM"));
        vehicleRepository.save(new Car("UP-80-DC-128","I20",200d,"BTM"));
        vehicleRepository.save(new Car("UP-80-DC-129","Breeza",250d,"KORMANGLA"));
        vehicleRepository.save(new Car("UP-80-DC-130","Duster",220d,"KORMANGLA"));
        vehicleRepository.save(new Car("UP-80-DC-131","CRETA",270d,"KORMANGLA"));
        vehicleRepository.save(new Car("UP-80-DC-132","SONET",290d,"KORMANGLA"));
        rentalBranchRepository.save(new RentalBranch("BTM","N.S PALYA,Bengaluru",
                vehicleRepository.getAllVehicleByBranchName("BTM")));
        rentalBranchRepository.save(new RentalBranch("KORMANGLA","near kormangla bengaluru",
                vehicleRepository.getAllVehicleByBranchName("KORMANGLA")));
    }
}
