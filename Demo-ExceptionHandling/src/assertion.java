
public class assertion {

	public static void main(String[] args) {
		int distance = 90;
		assert (distance > 0) : "Distance <0. Distance = " + distance;
		distance = -20;
		assert (distance > 0) : "Distance <0. Distance = " + distance;
		System.out.println("End of main");
	}

}
