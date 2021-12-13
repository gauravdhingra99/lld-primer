package com.simpl.Enums;

import com.simpl.Service.PaymentService;
/**
 * @author gauravdhingra
 */
public enum ReportCommandTypes implements ICommand {


    USERS_AT_CREDIT_LIMIT {
        @Override
        public void executeCommand(String[] inputValues, PaymentService paymentService) {
            paymentService.reportUsersAtCreditLimit();
        }
    },
    DISCOUNT {
        @Override
        public void executeCommand(String[] inputValues, PaymentService paymentService) {
            paymentService.reportDiscount(inputValues[2]);
        }
    },
    TOTAL_DUES {
        @Override
        public void executeCommand(String[] inputValues, PaymentService paymentService) {
            paymentService.reportTotalDues();
        }
    },
    DUES {
        @Override
        public void executeCommand(String[] inputValues, PaymentService paymentService) {
            paymentService.reportDues(inputValues[2]);
        }
    }

}
