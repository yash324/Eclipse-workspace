import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class a5 {

	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		System.out.println("Enter File Content. Press # to stop.");
		PrintWriter printwriter=null;
		try {
			printwriter = new PrintWriter("myFile.txt");
			char c;
			do {
				c = (char) isr.read();
				if (Character.isAlphabetic(c))
					if (Character.isUpperCase(c))
						c = Character.toLowerCase(c);
					else
						c = Character.toUpperCase(c);
				else if (Character.isDigit(c))
					c = '*';
				if(c!= '#')
					printwriter.append(c);
			} while (c!= '#');

		} catch (FileNotFoundException e) {
			System.out.println("File Does not Exist");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			printwriter.close();
		}
		
	}

}
