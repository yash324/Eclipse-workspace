
public class handler {

	public static void main(String[] args) {
		Employee emp1 = new Employee("Rohit", "Patil", "BA3", new Date("22-12-2016"), 50000);
		System.out.println(emp1.toString());
		Employee emp2 = new Employee("Rohan", "Aggarwal", "BA3", new Date("10-10-2014"), 55000);
		System.out.println(emp2.toString());
		Employee emp3 = new Employee("Abhishek", "Agrawal", "BA3", new Date("29-02-2020"), 52000);
		System.out.println(emp3.toString());
		System.out.println("Number of Employees = " + Employee.getCount());
	}
}
