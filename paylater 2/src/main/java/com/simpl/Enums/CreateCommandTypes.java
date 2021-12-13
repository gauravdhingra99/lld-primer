package com.simpl.Enums;

import com.simpl.Service.PaymentService;
/**
 * @author gauravdhingra
 */
public enum CreateCommandTypes implements ICommand {


    USER {
        @Override
        public void executeCommand(String[] inputValues, PaymentService paymentService) {
            paymentService.newUser(inputValues[2],inputValues[3],Double.valueOf(inputValues[4]));
        }
    },
    MERCHANT {
        @Override
        public void executeCommand(String[] inputValues, PaymentService paymentService) {
           paymentService.newMerchant(inputValues[2],inputValues[3],Double.valueOf(inputValues[4].replace("%","")));
        }
    },
    TXN {
        @Override
        public void executeCommand(String[] inputValues, PaymentService paymentService) {
            paymentService.newTransaction(inputValues[2],inputValues[3],Double.valueOf(inputValues[4])  );
        }
    }
}

