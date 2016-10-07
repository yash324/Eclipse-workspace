import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestProcessingJob implements Runnable {
	private Socket sock;

	public RequestProcessingJob(Socket sock) {
		this.sock = sock;
	}

	@Override
	public void run() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
					while (true) {
						String line = br.readLine();
						System.out.println(line);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			};
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					PrintWriter pw = new PrintWriter(sock.getOutputStream());
					while (true)
						pw.println("test message from " + sock);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
