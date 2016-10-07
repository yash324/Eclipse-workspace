import java.util.ArrayList;
import java.util.Random;

public class Teller implements Runnable {
	
	@Override
	public void run() {
		ArrayList<Account> myAccts;
		Random rn = new Random();
		int size = Bank.accts.size();
		for(int i=0;i<10;i++)
		{
			Account fromAcc = Bank.accts.get(rn.nextInt(size));
			Account toAcc = Bank.accts.get(rn.nextInt(size));
			double amt = 1+rn.nextInt((int)fromAcc.getBalance()-500);
			//System.out.println("Transferring Rs. "+ amt + " from Account "+fromAcc.getId()+" to Account "+toAcc.getId());
			try {
				Bank.transferAmount(toAcc,fromAcc,amt);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
