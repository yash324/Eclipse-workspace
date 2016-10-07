import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HandlerHashMap {

	public static void main(String[] args) throws EmployeeNotFoundException{
		Contractor con = new Contractor("Barclays");
		Scanner in = new Scanner(System.in);
		HashMap<EmpKey, Employee> entries = new HashMap<EmpKey, Employee>();
		entries.put(new EmpKey(1, "BCUK"), con.new ContrEmpl("Rohit", "Patil", "BA3", new Date("01-08-2016"), 12, 1200));
		entries.put(new EmpKey(5, "BCUS"), new PermanentEmpl("Rohan", "Aggarwal", "BA4", new Date("01-01-2016"), 1200000));
		entries.put(new EmpKey(7, "BCUK"), con.new ContrEmpl("Abhishek", "Agrawal", "BA3", new Date("01-08-2016"), 12, 1500));
		entries.put(new EmpKey(10, "BCUS"), con.new ContrEmpl("Abhinav", "Angira", "BA3", new Date("01-08-2016"), 12, 1200));
		entries.put(new EmpKey(6, "BCUS"), new PermanentEmpl("Rohan", "Aggarwal", "BA4", new Date("01-01-2016"), 1200000));
		entries.put(new EmpKey(3, "BCUS"), new PermanentEmpl("Anmol", "Bansal", "BA3", new Date("01-08-2016"), 150000));
		entries.put(new EmpKey(12, "BCUS"), new PermanentEmpl("Abhishek", "Jaimini", "BA3", new Date("01-08-2016"), 80000));
		entries.put(new EmpKey(8, "BCUK"), new PermanentEmpl("Tushar", "", "BA3", new Date("01-08-2016"), 90000));
		entries.put(new EmpKey(2, "BCUS"), new PermanentEmpl("Shireen", "Nagdive", "BA3", new Date("01-08-2016"), 75000));
		entries.put(new EmpKey(15, "BCUK"), new PermanentEmpl("Neha", "Kshirsagar", "BA3", new Date("01-08-2016"), 95000));
		EmpKey test = new EmpKey(5, "BCUS");
		in.close();
		Employee emp = entries.get(test);
		if (emp == null)
			throw new EmployeeNotFoundException("Entry Not Found");
		else
			System.out.println(emp);
	}

}
