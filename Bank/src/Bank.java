import java.util.ArrayList;
import java.util.Random;

public class Bank {
	public static ArrayList<Account> accts = new ArrayList<Account>();

	public static void transferAmount(Account toAcc, Account fromAcc, double amt) throws InterruptedException {
		if (fromAcc.withdraw(amt)) {
			toAcc.deposit(amt);
			// System.out.println("Transferred Successfully.");
		}
		// else
		// System.out.println("Balance not sufficient. Transaction aborted.");
	}

	public static void showTotalBalance() {
		double totBal = 0;
		for (int i = 0; i < accts.size(); i++)
			totBal += accts.get(i).getBalance();
		System.out.println("Total Balance = " + totBal);
	}

	public static void showAccounts() throws InterruptedException {

		for (int i = 0; i < accts.size(); i++)
			System.out.println(accts.get(i).toString());
	}

	public static void main(String[] args) throws InterruptedException {
		Random rn = new Random();
		for (int i = 0; i < 10; i++) {
			double val = 1000 + rn.nextInt(9) * 1000;
			Bank.accts.add(new Account(i + 1, val, 1000));
		}
		Bank.showTotalBalance();
		Teller[] teller = new Teller[10];
		Thread t[] = new Thread[10];
		for (int i = 0; i < 10; i++) {
			teller[i] = new Teller();
			t[i] = new Thread(teller[i]);
			t[i].start();
		}

		for (int i = 0; i < 10; i++) {
			t[i].join();
		}
		Bank.showTotalBalance();
	}
}
