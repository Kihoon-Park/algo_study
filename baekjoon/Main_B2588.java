import java.util.Scanner;

public class Main_B2588 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();

		System.out.println(n1 * (n2%10));
		System.out.println(n1 * (n2/10%10));
		System.out.println(n1 * (n2/10/10%10));
		
		System.out.println(n1 * (n2%10) + (n1 * (n2/10%10))*10 + (n1 * (n2/10/10%10)*100));
	}

}
