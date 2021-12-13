package com.navi.Model;

/**
 * @author gauravdhingra
 */
public class Car extends Vehicle{

    public Car(String regNo,String name,Double pricePerHour,String rentalBranchName) {
        super(regNo,name, "CAR", pricePerHour,rentalBranchName);
    }
}
