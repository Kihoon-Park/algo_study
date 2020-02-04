package baekjoon;

import java.util.Scanner;

public class Main_B14888_연산자끼워넣기 {
	
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		int[] arr = new int[n]; // 변수 최대 갯수 11개
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int[] oper = new int[4]; // +1 -2 *3 /4 순서로

		for (int i = 0; i < 4; i++) {
			oper[i] = sc.nextInt();
		}

//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println();

//		for (int i = 0; i < oper.length; i++) {
//			System.out.print(oper[i] + " ");
//		}
//		System.out.println();

	}

	
	
	public void multioper(int count,int result,int[] oper) {
		if(count == n) {
			
		}
		
	}
}
