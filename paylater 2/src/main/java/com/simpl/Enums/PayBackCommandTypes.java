package com.simpl.Enums;

import com.simpl.Service.PaymentService;
/**
 * @author gauravdhingra
 */
public enum PayBackCommandTypes implements ICommand {


    PAYBACK {
        @Override
        public void executeCommand(String[] inputValues, PaymentService paymentService) {
            paymentService.payBack(inputValues[1],Double.valueOf(inputValues[2]));
        }

    }
}
