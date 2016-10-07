import java.net.*;
import java.io.*;

public class ChatServer {

	public static void main(String args[]) throws Exception {
		Runnable serverTask = new Runnable() {
			@Override
			public void run() {
				try {
					ServerSocket ss = new ServerSocket(2000);
					System.out.println("Waiting for clients to connect...");
					while (true) {
						Socket clientSocket = ss.accept();
						new sendThread(clientSocket).start();
						new recThread(clientSocket).start();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		Thread serverThread = new Thread(serverTask);
		serverThread.start();
	}
}

class recThread extends Thread {
	private final Socket clientSocket;

	public recThread(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	@Override
	public void run() {

	}
}

class sendThread extends Thread {
	private final Socket clientSocket;

	sendThread(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	@Override
	public void run() {
		BufferedReader cin = null;
		PrintStream cout = null;
		BufferedReader stdin = null;
		System.out.println("Got a client !");
		try {
			cin = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			cout = new PrintStream(clientSocket.getOutputStream());
			stdin = new BufferedReader(new InputStreamReader(System.in));
			String s = "";
			System.out.println(cin.readLine());
			cout.println("What's your name?");
			String cName = cin.readLine();
			cout.println("Hi, " + cName + "! What's up?");
			while (true) {
				s = cin.readLine();
				if (s.equalsIgnoreCase("END")) {
					cout.println("BYE");
					break;
				}
				System.out.println(cName + ": " + s);
				System.out.println("Server : ");
				s = stdin.readLine();
				cout.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
