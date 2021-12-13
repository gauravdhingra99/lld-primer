package com.navi;


import com.navi.Command.OnBoardCommandTypes;
import com.navi.Command.RentCommandTypes;
import com.navi.Command.VehiclesDetailsTypes;
import com.navi.Constants.Constants;
import com.navi.Service.RentalService;

/**
 * @author gauravdhingra
 */
public class OutputGenerator {

    public static void generate(String inputCommand,RentalService rentalService) {
        String[] inputs = inputCommand.split(" ");

        if(inputs[0].equals(Constants.ONBOARD))
            OnBoardCommandTypes.valueOf(inputs[1].toUpperCase())
                    .executeCommand(inputs, rentalService);

        if(inputs[0].equals(Constants.GET_ALL_VEHICLES))
            VehiclesDetailsTypes.valueOf(inputs[1].toUpperCase())
                    .executeCommand(inputs, rentalService);

        if(inputs[0].equals(Constants.RENT_VEHICLE_AUTOMATIC))
            RentCommandTypes.valueOf(inputs[0].toUpperCase())
                    .executeCommand(inputs, rentalService);

        if(inputs[0].equals(Constants.RENT_VEHICLE))
            RentCommandTypes.valueOf(inputs[0].toUpperCase())
                    .executeCommand(inputs, rentalService);

        if(inputs[0].equals(Constants.RETURN))
            RentCommandTypes.valueOf(inputs[0].toUpperCase())
                    .executeCommand(inputs, rentalService);

    }

}