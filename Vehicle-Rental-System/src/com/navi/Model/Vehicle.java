package com.navi.Model;

import com.navi.Enums.VehicleStatus;

/**
 * @author gauravdhingra
 */
public abstract class Vehicle implements Comparable<Vehicle> {
    private String regNo;
    private String name;
    private String vehicleType;
    private Double pricePerHour;
    private VehicleStatus vehicleStatus;
    private Integer bookedSlots;
    private String rentalBranchName;

    public Vehicle(String regNo, String name, String vehicleType, Double pricePerHour,String rentalBranchName) {
        this.regNo = regNo;
        this.name = name;
        this.vehicleType = vehicleType;
        this.pricePerHour = pricePerHour;
        this.vehicleStatus = VehicleStatus.AVAILABLE;
        this.bookedSlots = 0;
        this.rentalBranchName = rentalBranchName;
    }

    @Override
    public int compareTo(Vehicle o) {
        return pricePerHour < o.pricePerHour ? -1 : pricePerHour > o.pricePerHour ? 1 : 0;
    }
    public String getRegNo() {
        return regNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }


    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBookedSlots() {
        return bookedSlots;
    }

    public void setBookedSlots(Integer bookedSlots) {
        this.bookedSlots = bookedSlots;
    }

    public String getRentalBranchName() {
        return rentalBranchName;
    }

    public void setRentalBranchName(String rentalBranchName) {
        this.rentalBranchName = rentalBranchName;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    @Override
    public String toString() {
        return "regNo='" + regNo + '\'' +
                ", name='" + name + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", pricePerHour=" + pricePerHour +
                ", vehicleStatus=" + vehicleStatus +
                ", bookedTime=" + bookedSlots +
                ", rentalBranchName='" + rentalBranchName +
                "\n";
    }

}
