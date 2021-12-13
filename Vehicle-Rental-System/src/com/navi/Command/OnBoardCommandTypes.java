package com.navi.Command;

import com.navi.Service.RentalService;


/**
 * @author gauravdhingra
 */
public enum OnBoardCommandTypes implements ICommand{

    VEHICLE{
        @Override
        public void executeCommand(String[] inputValues, RentalService rentalService) {
            rentalService.onboardNewVehicle(inputValues[2], inputValues[3],inputValues[4],Double.valueOf(inputValues[5]),inputValues[6]);
        }
    },
    BRANCH{
        @Override
        public void executeCommand(String[] inputValues, RentalService rentalService) {
            rentalService.onboardNewBranch(inputValues[2], inputValues[3],
                    String.valueOf(inputValues[4]).split(","));
        }
    }
}
