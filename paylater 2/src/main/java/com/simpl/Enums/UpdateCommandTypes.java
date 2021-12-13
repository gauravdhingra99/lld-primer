package com.simpl.Enums;

import com.simpl.Service.PaymentService;
/**
 * @author gauravdhingra
 */
public enum UpdateCommandTypes implements ICommand {


    MERCHANT {
        @Override
        public void executeCommand(String[] inputValues, PaymentService paymentService) {
            paymentService.updateMerchant(inputValues[2],inputValues[3].replace("%",""));
        }
    }
}
