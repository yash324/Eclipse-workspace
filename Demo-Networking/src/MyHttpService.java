import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyHttpService {

	public static void main(String[] args) throws IOException, InterruptedException {
		int port = 80;
		ServerSocket service = new ServerSocket(port);
		System.out.println("Waiting for connection..");
		Socket clientinfo = service.accept();
		System.out.println(clientinfo);
		InputStream in = clientinfo.getInputStream();
		InputStreamReader bridge = new InputStreamReader(in);
		BufferedReader buf = new BufferedReader(bridge);
		PrintWriter out = new PrintWriter(clientinfo.getOutputStream());
		out.write("<p> Hello world </p>");
		out.flush();
		Thread.sleep(1000);
		while (true) {
			String line = buf.readLine();
			if (line == null)
				break;
			System.out.println(line);
		}
		out.close();
		buf.close();
		bridge.close();
		in.close();
		service.close();
	}
}
