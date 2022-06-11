import java.util.TreeMap;

public class Address {
	int plot_no;
	String at,post;
	Address(int p,String a,String po){
		plot_no=p;
		at=a;
		post=po;
	}
	public static void main(String[] args) {
		TreeMap<String,Address> tm= new TreeMap<String,Address>();
		tm.put("Akash" , new Address(19,"Kalna","Wb"));
		tm.put("Rohit" , new Address(32,"Bhubneswar","Odisha"));
		tm.put("Kunal" , new Address(49,"Thar","Rajasthan"));
		for(String key : tm.keySet()){
			System.out.println(key + " : Plot no: " + tm.get(key).plot_no+" at "+tm.get(key).at+" post "+tm.get(key).post);
			}
	}

}
