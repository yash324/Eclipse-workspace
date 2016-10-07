
public class handler {

	public static void main(String[] args) {
		Contractor con = new Contractor("Barclays");
		Contractor.ContrEmpl emp1 = con.new ContrEmpl("Rohit", "Patil", "BA3", new Date("01-08-2016"), 12, 1200);
		PermanentEmpl emp2 = new PermanentEmpl("Rohan", "Aggarwal", "BA4", new Date("01-01-2016"), 1200000);
		Contractor.ContrEmpl emp3 = con.new ContrEmpl("Abhishek", "Agrawal", "BA3", new Date("01-08-2016"), 12, 1500);
		Contractor.ContrEmpl emp4 = con.new ContrEmpl("Abhinav", "Angira", "BA3", new Date("01-08-2016"), 12, 1200);
		PermanentEmpl emp5 = new PermanentEmpl("Rohan", "Aggarwal", "BA4", new Date("01-01-2016"), 1200000);
		System.out.println("Contractor: " + con.getContrName() + " Employees= " + con.getCount());
		System.out.println("Permanent Employees= " + PermanentEmpl.getCount());
		System.out.println("Total Employee Count= " + Employee.getCount());

		}
}
