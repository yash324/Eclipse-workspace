import java.util.InputMismatchException;
import java.util.regex.*;

public class Employee {
	static int count = 0;
	private String fname, lname, grade, doj;
	private int id, salary;

	public Employee(String fname, String lname, String grade, String doj, int salary) throws InputMismatchException {
		if (Pattern.matches("[a-zA-Z]{3}:[0-9]{4}", doj))
			this.doj = doj;
		else
			throw new InputMismatchException("Enter date in mmm:yyyy format only.");
		this.fname = fname;
		this.lname = lname;
		this.grade = grade;
		this.salary = salary;
		this.id = ++count;
	}

	@Override
	public String toString() {
		return "Employee [fname=" + fname + ", lname=" + lname + ", grade=" + grade + ", doj=" + doj + ", salary="
				+ salary + "]";
	}

	public static int getCount() {
		return count;
	}

	public String getDoj() {
		return doj;
	}

	public String getFname() {
		return fname;
	}

	public String getGrade() {
		return grade;
	}

	public int getId() {
		return id;
	}

	public String getLname() {
		return lname;
	}

	public int getSalary() {
		return salary;
	}

}
