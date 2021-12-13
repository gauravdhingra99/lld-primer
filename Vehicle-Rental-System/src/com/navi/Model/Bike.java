package com.navi.Model;

/**
 * @author gauravdhingra
 */
public class Bike extends Vehicle{
    public Bike(String regNo,String name, Double pricePerHour,String rentalBranchName) {
        super(regNo,name, "BIKE", pricePerHour,rentalBranchName);
    }
}
