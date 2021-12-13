package com.company;

import com.company.service.ParkingService;

public class Main {

    public static void main(String[] args) {
        ParkingService parkingService = new ParkingService();
        parkingService.park("UP-1");
        parkingService.park("UP-2");
        parkingService.park("UP-3");
        parkingService.park("UP-4");
        parkingService.park("UP-5");
        parkingService.park("UP-6");
        parkingService.getParkingDetails();

    }
}
