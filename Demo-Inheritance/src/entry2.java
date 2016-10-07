
interface MathOperations {
	int operation(int a, int b);
}

public class entry2 {

	public static void main(String[] args) {
		MathOperations ref = new MathOperations() {
			
			@Override
			public int operation(int a, int b) {
				return a+b;
			}
		};
		System.out.println(ref.operation(2, 2));
		
		MathOperations m = (a, b) -> a+b;
		System.out.println(m.operation(5, 5));
		
		
	}


}
