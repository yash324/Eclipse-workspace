
public class handler extends Thread {
	public void run() {
		{
			int i=0;
			while (i!=100) {
				try {
					System.out.print(":");
					System.out.print("-");
					System.out.println(")");
					sleep(10);
					i++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Employee emp1 = new Employee("Rohit", "Patil", "BA3", "aug:2016",
		 * 50000); System.out.println(emp1.toString()); Employee emp2 = new
		 * Employee("Rohan", "Aggarwal", "BA3", "aoa:2016", 55000);
		 * System.out.println(emp2.toString()); Employee emp3 = new
		 * Employee("Abhishek", "Agrawal", "BA3", "aug:2016", 52000);
		 * System.out.println(emp3.toString()); System.out.println(
		 * "Number of Employees = " + Employee.getCount());
		 */
		Thread t1 = new handler();
		t1.start();
		
		t1.join();
		t1.start();
	}
}
