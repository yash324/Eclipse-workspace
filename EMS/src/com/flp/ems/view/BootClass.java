package com.flp.ems.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.domain.Employee;

public class BootClass {

	public static void main(String[] args) throws ParseException {
		// create objects
		Date dob, doj;
		DateFormat df = new SimpleDateFormat("mm/dd/yy");
		dob = df.parse("01/01/16");
		doj = df.parse("01/08/16");
		Employee e1 = new Employee("Rohit", "rohit.patil@gmail.com", 9494123456L, dob, doj,"Pune", 1, 1, 1);
		Employee e2 = new Employee("Mohit", "mohit123@gmail.com", 9565123456L, dob, doj, "Pune", 1, 1, 1);
		Employee e3 = new Employee("Rohit", "yash324@gmail.com", 9421934379L, dob, doj,"Pune", 1, 1, 1);
		Employee e4 = new Employee("Abhishek", "abhishek@gmail.com", 9120355146L, dob, doj, "Pune", 1, 1, 1);
		Employee e5 = new Employee("Rohan", "rohan@gmail.com", 9823012345L, dob, doj, "Pune", 1, 1, 1);
		EmployeeDaoImplForList list = new EmployeeDaoImplForList();
		list.AddEmployee(e1);
		list.AddEmployee(e2);
		list.AddEmployee(e3);
		list.AddEmployee(e4);
		list.AddEmployee(e5);
		menuSelection();
	}

	public static void menuSelection() {
		int ch = 0;
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("====MENU====");
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
