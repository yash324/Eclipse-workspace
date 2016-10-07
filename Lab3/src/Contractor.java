public class Contractor {
	private String contrName;
	private int empCount = 0;

	public class ContrEmpl extends Employee {
		int hrsWorked, payRate;
		public ContrEmpl(String fname, String lname, String grade, Date doj, int hrsWorked, int payRate) {
			super(fname, lname, grade, doj, hrsWorked*payRate);
			Contractor.this.empCount++;
			this.hrsWorked = hrsWorked;
			this.payRate = payRate;
		}
	}	
	public int getCount() {
		return empCount;
	}

	Contractor(String contrName) {
		this.contrName = contrName;
	}

	public String getContrName() {
		return contrName;
	}

}
