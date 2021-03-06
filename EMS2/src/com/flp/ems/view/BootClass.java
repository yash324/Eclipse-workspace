package com.flp.ems.view;

import java.text.ParseException;
import java.util.Scanner;

public class BootClass {

	public static void main(String[] args) throws ParseException {
		menuSelection();
	}

	public static void menuSelection() {
		int ch = 0;
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("\n=============================MENU=============================");
			System.out.println("1. Add Employee");
			System.out.println("2. Modify Employee");
			System.out.println("3. Remove Employee");
			System.out.println("4. Search Employee");
			System.out.println("5. Get All Employees");
			System.out.println("6. Exit Program");
			System.out.println("\nEnter your choice: ");
			ch = in.nextInt();
			switch (ch) {
			case 1:
				UserInteraction.AddEmployee();
				break;
			case 2:
				UserInteraction.ModifyEmployee();
				break;
			case 3:
				UserInteraction.RemoveEmployee();
				break;
			case 4:
				UserInteraction.SearchEmployee();
				break;
			case 5:
				UserInteraction.getAllEmployee();
				break;
			case 6:
				break;
			default:
				System.out.println("Invalid Choice");
			}
		} while (ch != 6);
		in.close();
	}
}
