import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOoperations {
	public static void writeValue(OutputStream out) throws IOException
	{
		DataOutputStream dOut = new DataOutputStream(out);
		dOut.writeLong(1L);
		dOut.writeDouble(5.0);
		dOut.writeBoolean(false);
	}
	public static void readValue(InputStream in) throws IOException
	{
		DataInputStream dIn = new DataInputStream(in);
		System.out.println(dIn.readLong());
		System.out.println(dIn.readDouble());
		System.out.println(dIn.readBoolean());
	}
}
