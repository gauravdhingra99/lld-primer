package com.simpl;


import com.simpl.Util.OutputGenerator;

import java.util.Scanner;

public class PaylaterApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String command = sc.nextLine();
			if (command == null || command.isEmpty())
				return;
			OutputGenerator.generate(command);
		}
	}

}
