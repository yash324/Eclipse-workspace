import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class entry3 {
	static String fname = "test.prmtv";
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		try(FileOutputStream fOut = new FileOutputStream(fname))
		{
			IOoperations.writeValue(fOut);
		}
		
		try(FileInputStream fIn = new FileInputStream(fname))
		{
			IOoperations.readValue(fIn);
		}
		
	}
}
