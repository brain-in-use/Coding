import java.util.HashMap;

public class Q6 {

	public static void main(String[] args) {
		HashMap<String,Integer> hm=new HashMap<>();
		hm.put("A",1);
		hm.put("D",2);
		hm.put("C",3);
		hm.put("B",4);
		for(String key : hm.keySet()){
			System.out.println(key + " : " + hm.get(key));
			}
	}

}
