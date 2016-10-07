import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TestStringMethods {

	@Test
	@Ignore
	public void testXYZ() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testSomeStringMethods() {
		String message = new String("Hello, world!");
		String message2 = "Hello, world!"; // interned string
		String message3 = "Hello, world!";
		message = null;
		Assert.assertSame(message2, message3);
		// Assert.assertSame(message, message3); //
		Assert.assertEquals(message, message2);
		
	}

	@Test
	public void Check() {
		char a = 061;      // 1
	    char b = '\61';    // 2
	    char c = '\061';   // 3
	    char d = 0x0031;   // 4
	    char e = '\u0031'; // 5
	    System.out.print(""+a+b+c+d+e);



	}
}
