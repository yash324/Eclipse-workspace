import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;

import com.oracle.jrockit.jfr.NoSuchEventException;
import com.sun.corba.se.spi.orbutil.fsm.Input;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import sun.management.AgentConfigurationError;

public class Entry {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		setValue(78); // risky method call
		/*
		 * try { setValue(78); // risky method call } catch (ArithmeticException
		 * e) { e.printStackTrace(); // logged these messages into a file }
		 */
		saveValue(99);

		System.out.println("reached end of main()....");
	}

	static public void setValue(int value) throws ArithmeticException {

		System.out.println("inside setValue()...");

		int denominator = 0;

		if (denominator > 0) {
			int ans = value / denominator;
		} else {
			System.out.println("cannot perform division");
		}

		System.out.println("reached end of setValue()....");

	}

	public static void saveValue(int value) throws FileNotFoundException, IOException{

		try {
			FileOutputStream fOut = new FileOutputStream("\\test\\something.txt");
			fOut.write((byte) value);
		} catch (FileNotFoundException fne) {
			fne.printStackTrace();
			throw new ClassCastException();
		} finally {
			System.out.println("Clean-up code...");
		}

	}

}
