
public class handler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l1 = new LinkedList();
		l1.add(5);
		l1.add(4);
		l1.add(2);
		System.out.println("Added 3 Nodes 5,4,2:");
		l1.printAll();
		l1.add(1);
		l1.add(7,2);
		System.out.println("Added Node4, Node 5 at pos 2.");
		l1.printAll();
		l1.removePos(2); 
		System.out.println("Removed Node at Position 2.");
		l1.printAll();
		l1.removeVal(5);
		System.out.println("Removed Node with Value 5.");
		l1.printAll();
	}

}

