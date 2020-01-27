package backjoon;

import java.util.Scanner;

public class Main_B4344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt(); // T == num of testcases
		float avg = 0;
		float sum = 0;
		int check = 0;
		for (int test_case = 1; test_case <= T; test_case++) {

			float num = sc.nextInt();

			sum = 0;
			check = 0;
			float arr[] = new float[1000];
			
			for (int i = 0; i < num; i++) { 
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			avg = sum / num;

			for (int i = 0; i < num; i++) {
				if(arr[i]>avg)
					check++;
			}
		
			
			System.out.printf("%.3f%%\n", check/num*100);
		}
	}
}
