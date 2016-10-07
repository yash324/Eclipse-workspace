import java.util.*;
public class Entry3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Long, String> entries = new TreeMap<>();
		entries.put(987654321L, "Airtel");
		entries.put(887654321L, "Reliance");
		entries.put(787654321L, "Vodafone");
		/*String v = entries.get(new Long("787654321"));
		System.out.println(v);*/
		Set<Map.Entry <Long,String>> set = entries.entrySet();
		for(Map.Entry<Long,String> entry: set)
		{
			System.out.print(entry.getKey()+"\t");
			System.out.println(entry.getValue());
			
		}
		entries.put(787654321L, "Reliance");
	}

}
