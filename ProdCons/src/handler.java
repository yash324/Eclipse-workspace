
public class handler {
	public static void main(String[] args) {
		Container con = new Container();
		Thread ProdThread = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						con.put();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		};
		Thread ConsThread = new Thread() {
			@Override
			public void run() {
				while(true)
				{
					try {
						con.get();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		};
		
		ConsThread.start();
		ProdThread.start();
	}
}
