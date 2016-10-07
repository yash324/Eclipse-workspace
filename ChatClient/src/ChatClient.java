import java.io.*;
import java.net.Socket;

public class ChatClient {

	public static void main(String args[]) throws Exception {
		Socket sk = new Socket("localhost", 2000);
		Runnable recThread = new Runnable() {

			@Override
			public void run() {
				try {
					BufferedReader sin = new BufferedReader(new InputStreamReader(sk.getInputStream()));
					while (true) {
						String s = sin.readLine();
						System.out.print("Server : " + s + "\n");
						if (s.equalsIgnoreCase("BYE"))
							break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		Runnable sendThread = new Runnable() {
			@Override
			public void run() {
				try {
					PrintStream sout = new PrintStream(sk.getOutputStream());
					BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
					String s;
					while (true) {
						System.out.print("Client : ");
						s = stdin.readLine();
						sout.println(s);
						if(s.equalsIgnoreCase("END"))
							break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		Thread t1 = new Thread(recThread);
		Thread t2 = new Thread(sendThread);
		t1.start();
		t2.start();
		t2.wait();
		t1.wait();
		sk.close();

	}
}