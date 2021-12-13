package com.navi;

import com.navi.Service.RentalService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] var0) {
        RentalService rentalService = new RentalService();
        rentalService.intialize();

        String var1 = var0[0];
        Scanner var2 = null;

        try {
            var2 = new Scanner(new File(var1));
        } catch (FileNotFoundException var6) {
            System.out.println("File not found.");
        }

        while(var2.hasNextLine()) {
            String command = var2.nextLine();
            if (command == null || command.isEmpty())
                return;
            OutputGenerator.generate(command,rentalService);
        }

//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()) {
//            String command = sc.nextLine();
//            if (command == null || command.isEmpty())
//                return;
//            OutputGenerator.generate(command,rentalService);
//        }
    }

}
