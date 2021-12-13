package com.simpl.Enums;

import com.simpl.Service.PaymentService;
/**
 * @author gauravdhingra
 */
interface ICommand {
    void executeCommand(String[] inputValues, PaymentService paymentService);
}
