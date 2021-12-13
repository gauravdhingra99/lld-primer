package com.simpl.Util;


import com.simpl.Constant.PaymentConstants;
import com.simpl.Enums.CreateCommandTypes;
import com.simpl.Enums.PayBackCommandTypes;
import com.simpl.Enums.ReportCommandTypes;
import com.simpl.Enums.UpdateCommandTypes;
import com.simpl.Model.Contact;
import com.simpl.Service.PaymentService;
import com.simpl.Service.PaymentServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;
import sun.rmi.rmic.Constants;

/**
 * @author gauravdhingra
 */
public class OutputGenerator {
    static PaymentService paymentService = new PaymentServiceImpl();

    public static void generate(String inputCommand) {
        String[] inputs = inputCommand.split(" ");

        if(inputs[0].equals(PaymentConstants.NEW))
            CreateCommandTypes.valueOf(inputs[1].toUpperCase())
                    .executeCommand(inputs, paymentService);

        if(inputs[0].equals(PaymentConstants.REPORTS))
            ReportCommandTypes.valueOf(inputs[1].toUpperCase().replace("-","_"))
                    .executeCommand(inputs, paymentService);

        if(inputs[0].equals(PaymentConstants.UPDATE))
            UpdateCommandTypes.valueOf(inputs[1].toUpperCase())
                    .executeCommand(inputs, paymentService);

        if(inputs[0].equals(PaymentConstants.PAYBACK))
            PayBackCommandTypes.valueOf(inputs[0].toUpperCase().replace("-","_"))
                    .executeCommand(inputs, paymentService);

    }

}