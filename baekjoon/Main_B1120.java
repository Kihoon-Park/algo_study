package yaza;

import java.util.Scanner;

public class Main_B1120 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String a = sc.next();
		String b = sc.next();
		int cmp = 0;
		int result = Integer.MAX_VALUE;
		//System.out.println(b.length() + " " + a.length());
		for (int i = 0; i <= b.length() - a.length(); i++) {
		//	System.out.println("gogo");
			cmp = 0;
			for (int x = 0; x < a.length(); x++) {

				if (a.charAt(x) != b.charAt(x + i)) {
				//	System.out.println(a.charAt(x) + " " + b.charAt(x + i));
					cmp++;

				}
				
			}
			result = Math.min(cmp, result);
			//System.out.println(cmp);
			//System.out.println();
			
		}System.out.println(result);
	}
}
