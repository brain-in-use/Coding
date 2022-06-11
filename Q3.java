import java.util.TreeMap;

public class Q3 {

	public static void main(String[] args) {
		TreeMap<Integer,String> tm= new TreeMap<Integer,String>();
		tm.put(5, "A1");
		tm.put(9, "A2");
		tm.put(1, "A3");
		tm.put(4, "A4");
		tm.put(3, "A5");
		for(Integer key : tm.keySet()){
			System.out.println(tm.get(key) + " = " +key );
		}

	}

}
