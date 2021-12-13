package com.navi.Model;

import java.util.Map;

/**
 * @author gauravdhingra
 */
public class RentalBranch {
    private final String name;
    private final String address;
    private Map<String,Vehicle> vehicles;

    public RentalBranch(String name, String address, Map<String,Vehicle> vehicles) {
        this.name = name;
        this.address = address;
        this.vehicles = vehicles;
    }


    public String getName() {
        return name;
    }


    public Map<String,Vehicle> getVehicles() {
        return vehicles;
    }

}
