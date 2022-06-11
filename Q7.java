import java.util.*;
public class Q7 {

	public static void main(String[] args) {
		LinkedHashSet<Integer> lhs=new LinkedHashSet<>();
		Scanner in=new Scanner(System.in);
		System.out.print("N= ");
		int n=in.nextInt();
		System.out.println("Enter the elements:");
		for(int i=0;i<n;i++) {
			lhs.add(in.nextInt());
		}
		System.out.println(lhs);
	}

}
