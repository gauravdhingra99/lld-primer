package com.navi.Command;

import com.navi.Service.RentalService;

/**
 * @author gauravdhingra
 */
public interface ICommand {
    void executeCommand(String[] inputValues, RentalService rentalService);
}
