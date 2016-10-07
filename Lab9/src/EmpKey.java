
public class EmpKey implements Comparable{
	int id;
	String suffix;
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		String s1 = Integer.toString(this.id)+ this.suffix;
		String s2 = Integer.toString(((EmpKey)o).id) + ((EmpKey)o).suffix;
		return s1.compareTo(s2);
	}
	public EmpKey(int id, String suffix) {
		this.id = id;
		this.suffix = suffix;
	}
	 
	@Override
	public boolean equals(Object obj) {
		if(this.id == ((EmpKey)obj).id && this.suffix==((EmpKey)obj).suffix)
			return true;
		return false;
	}
	@Override
	public int hashCode() {
		return this.id +suffix.hashCode();
	}
}
