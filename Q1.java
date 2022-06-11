import java.util.Scanner;
import java.util.TreeSet;

public class Q1 {

	public static void main(String[] args) {
		TreeSet<Integer> ts=new TreeSet<Integer>();
		ts.add(5);
		ts.add(9);
		ts.add(1);
		ts.add(2);
		System.out.println(ts);
		Scanner in=new Scanner(System.in);
		System.out.print("Enter the number to search: ");
		int x=in.nextInt();
		if(ts.contains(x))
			System.out.println("The number is present.");
		else
			System.out.println("The number is not present.");
			
		System.out.print("Enter an element to remove: ");
		x=in.nextInt();
		ts.remove(x);
		System.out.print(ts);
	}

}
