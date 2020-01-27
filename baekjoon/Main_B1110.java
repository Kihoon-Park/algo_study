package backjoon;

import java.util.Scanner;

public class Main_B1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(); // 0<N<=99 
		int count = 0;
		int tmp = num;
		while (true) {
			count++;
			tmp = tmp % 10 * 10 + (tmp / 10 + tmp % 10) % 10;
		
			if (num == tmp) {
				System.out.println(count);
				break;
			}	
			
		}//end of while
		
	}//end of main
}//end of class
