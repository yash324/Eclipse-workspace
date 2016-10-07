import java.util.HashSet;

public class Entry4 {
	int[] i1 = {1}, i2 = {3};
	  void m1() {
	    m2(i1, i2);
	    System.out.print(i1[0] + "," + i2[0]);
	  }
	  void m2(int[] i1, int[] i2) {
	    int[] i3 = i1;
	    this.i1 = i2;
	    this.i2 = i3;
	  }
	   

	public static void main(String[] s) {
		new Entry4().m1();
	}

}
