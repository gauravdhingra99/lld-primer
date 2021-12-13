package com.navi.Command;

import com.navi.Service.RentalService;

/**
 * @author gauravdhingra
 */
public enum VehiclesDetailsTypes implements ICommand{
    BRANCH {
        @Override
        public void executeCommand(String[] inputValues, RentalService rentalService) {
            rentalService.getAllVehiclesByBranch(inputValues[2]);
        }
    }

}
