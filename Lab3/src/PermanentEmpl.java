
public class PermanentEmpl extends Employee {
	static int permaCount = 0;

	public PermanentEmpl(String fname, String lname, String grade, Date doj, int salary) {
		super(fname, lname, grade, doj, salary);
		permaCount++;
		// TODO Auto-generated constructor stub
	}

	public static int getCount() {
		return permaCount;
	}

}
