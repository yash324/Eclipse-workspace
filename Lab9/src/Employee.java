public class Employee {
	static int count = 0;
	private String fname, lname, grade;
	private Date doj;
	private int salary;
	private EmpKey id;

	public Employee(String fname, String lname, String grade, Date doj, int salary) {
		this.fname = fname;
		this.lname = lname;
		this.grade = grade;
		this.salary = salary;
		this.doj = doj;
		++count;
	}
	public EmpKey getId() {
		return id;
	}
	public void setId(EmpKey id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [fname=" + fname + ", lname=" + lname + ", grade=" + grade + ", doj="
				+ doj.toString() + ", salary=" + salary + "]";
	}

	public static int getCount() {
		return count;
	}

	public Date getDoj() {
		return doj;
	}

	public String getFname() {
		return fname;
	}

	public String getGrade() {
		return grade;
	}

	public String getLname() {
		return lname;
	}

	public int getSalary() {
		return salary;
	}
	

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
