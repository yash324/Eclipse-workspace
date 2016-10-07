package com.flp.ems.view;

import com.flp.ems.service.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.flp.ems.util.Validate;

public class UserInteraction {
	public static HashMap<String, String> getAllData() {
		Scanner in = new Scanner(System.in);
		String name, email, phone, dob, doj, address;
		String dept, proj, role;
		do {
			System.out.println("Enter Name: ");
			name = in.nextLine();
			if (!Validate.checkName(name))
				System.out.println("Invalid Name.");
		} while (!Validate.checkName(name));
		do {
			System.out.println("Enter Email: ");
			email = in.nextLine();
			if (!Validate.checkEmail(email))
				System.out.println("Invalid Email.");
		} while (!Validate.checkEmail(email));
		do {
			System.out.println("Enter Phone (10 digit numeric): ");
			phone = in.nextLine();
			if (!Validate.checkPhone(phone))
				System.out.println("Invalid Phone.");
		} while (!Validate.checkPhone(phone));
		do {
			System.out.println("Enter Date of Birth (dd/mm/yy): ");
			dob = in.nextLine();
			if (!Validate.checkDate(dob))
				System.out.println("Invalid Date.");
		} while (!Validate.checkDate(dob));
		do {
			System.out.println("Enter Date of Joining (dd/mm/yy): ");
			doj = in.nextLine();
			if (!Validate.checkDate(doj))
				System.out.println("Invalid Date.");
		} while (!Validate.checkDate(doj));
		System.out.println("Enter Address: ");
		address = in.nextLine();
		System.out.println("Enter Department ID: ");
		dept = in.nextLine();
		System.out.println("Enter Project ID: ");
		proj = in.nextLine();
		System.out.println("Enter Role ID: ");
		role = in.nextLine();
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", name);
		data.put("email", email);
		data.put("phone", phone);
		data.put("dob", dob);
		data.put("doj", doj);
		data.put("address", address);
		data.put("dept", dept);
		data.put("proj", proj);
		data.put("role", role);
		return data;
	}

	public static void AddEmployee() {
		if (new EmployeeServiceImpl().AddEmployee(getAllData()))
			System.out.println("Added Successfully.");
		else
			System.out.println("There was an error adding record. Please try again.");
	}

	public static void getAllEmployee() {
		ArrayList<String> empList = new EmployeeServiceImpl().getAllEmployee();
		if (empList.size() == 0)
			System.out.println("No Employees Found");
		else {
			System.out.printf("%4s %25s %10s %4s %4s %4s\n", "EID", "Email", "Name", "Role", "Dept", "Proj");
			for (String s : empList)
				System.out.println(s);
			System.out.println("\n");
		}
	}

	public static void ModifyEmployee() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Employee ID to Search: ");
		String id = in.nextLine();
		System.out.println("Enter New Details: ");
		HashMap<String, String> data = getAllData();
		data.put("modid", id);
		if (new EmployeeServiceImpl().ModifyEmployee(data))
			System.out.println("Modified Successfully.");
		else
			System.out.println("There was an error modifying record. Please try again.");
	}

	public static void RemoveEmployee() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Employee ID to Remove: ");
		String id = in.nextLine();
		if (new EmployeeServiceImpl().RemoveEmployee(id))
			System.out.println("Removed Successfully");
		else
			System.out.println("There was an error removing record. Please try again.");
	}

	public static void SearchEmployee() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Employee ID to Search: ");
		String id = in.nextLine();
		String result = new EmployeeServiceImpl().SearchEmployee(id);
		if(result == null)
			System.out.println("Employee Not Found");
		else
		{
			System.out.printf("%4s %25s %10s %4s %4s %4s\n", "EID", "Email", "Name", "Role", "Dept", "Proj");
			System.out.println(result);
		}
	}
}
