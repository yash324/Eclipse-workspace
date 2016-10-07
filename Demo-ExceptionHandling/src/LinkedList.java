import java.util.NoSuchElementException;

public class LinkedList {
	static int size = 0;
	Node head;

	LinkedList() {
		head = null;
	}
	public void printAll()
	{
		Node temp = head;
		while(temp!=null)
		{
			System.out.printf("%d ",temp.val);
			temp = temp.next;
		}
		System.out.printf(" => Size = "+this.getSize()+ "\n");
	}

	public void add(int val) {
		Node n = new Node(val);
		if (head == null)
			head = n;
		else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = n;
		}
		size++;
	}

	public void add(int val, int pos) throws IndexOutOfBoundsException {
		Node n = new Node(val);
		if (pos >= size)
			throw new IndexOutOfBoundsException();
		if (pos == 0) {
			if (head != null)
				n.next = head;
			head = n;
			size++;
			return;
		}

		Node temp = head;
		Node prev = null;
		for (int i = 0; i < pos; i++) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = n;
		n.next = temp;
		size++;
	}

	public Node removeVal(int value) throws NoSuchElementException {
		Node temp = head;
		Node prev = null;
		if(temp.val == value)
		{
			head = temp.next;
			return temp;
		}
		
		while (temp.next != null) {
			prev = temp;
			temp = temp.next;
			if (temp.val == value) {
				prev.next = temp.next;
				if (temp == head)
					head = null;
				size--;
				return temp;
			} else
				temp = temp.next;
		}
		throw new NoSuchElementException();
	}

	public Node removePos(int pos) throws IndexOutOfBoundsException {
		if (pos >= size)
			throw new IndexOutOfBoundsException();
		Node temp = head;
		Node prev = null;
		for (int i = 0; i < pos; i++) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;
		if (temp == head)
			head = null;
		size--;
		return temp;
	}

	public static int getSize() {
		return size;
	}

	public Node getHead() {
		return head;
	}

	class Node {
		int val;
		Node next;

		Node() {
			val = 0;
			next = null;
		}

		Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}

		Node(int val) {
			this.val = val;
			this.next = null;
		}
	}
}
