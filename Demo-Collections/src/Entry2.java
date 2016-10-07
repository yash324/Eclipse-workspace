import java.util.Iterator;
import java.util.TreeSet;

import com.barclays.*;
public class Entry2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person a = new Person("Rohit",19);
		Person b = new Person("Mohit",20);
		Person c = new Person("Rahul",20);
		TreeSet tree1 = new TreeSet();
		tree1.add(a);
		tree1.add(b);
		tree1.add(c);
		Iterator itr = tree1.iterator();
		System.out.println(tree1.size());
		/*while(itr.hasNext())
		{
			Person e = (Person)itr.next();
			System.out.println(e);
		}*/
		for(Object e:tree1)
		{
			System.out.println(e);
		}
		
	}

}
