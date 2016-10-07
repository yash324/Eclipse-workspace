import java.util.Random;

public class Account {
	private int id;
	private double balance;
	private double minBalance;

	public Account(int id, double balance, double minBalance) {
		this.id = id;
		this.balance = balance;
		this.minBalance = minBalance;
	}

	public double getBalance() {
		return balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	synchronized public boolean deposit(double amt) throws InterruptedException {
		double balance = this.balance;
		Thread.sleep(200 + new Random().nextInt(200));
		balance += amt;
		this.balance = balance;
		return true;
	}

	synchronized public boolean withdraw(double amt) throws InterruptedException {
		double balance = this.balance;
		Thread.sleep(new Random().nextInt(200));
		balance -= amt;
		if (balance < minBalance)
			return false;
		else
			this.balance = balance;
		return true;
	}

	@Override
	public String toString() {
		return ("Id: " + this.id + "\tBalance: " + this.balance);
	}

}
