package com.navi.Command;

import com.navi.Service.RentalService;

/**
 * @author gauravdhingra
 */
public enum RentCommandTypes implements ICommand{

    AUTO_RENT{
        @Override
        public void executeCommand(String[] inputValues, RentalService rentalService) {
            rentalService.bookVehicle(inputValues[1],Integer.valueOf(inputValues[2]));
        }
    },
    RENT{
        @Override
        public void executeCommand(String[] inputValues, RentalService rentalService) {
            rentalService.bookVehicle(inputValues[1],
                    Integer.valueOf(inputValues[2]),inputValues[3],inputValues[4]);
        }
    },
    RETURN{
        @Override
        public void executeCommand(String[] inputValues, RentalService rentalService) {
            rentalService.returnVehicle(inputValues[1],Integer.valueOf(inputValues[2]),inputValues[3]);
        }
    }
}
