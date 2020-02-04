package baekjoon;

import java.util.Scanner;

public class Main_B14888_연산자끼워넣기 {

	static int n;
	static int max = Integer.MIN_VALUE; // -10억~ 10억 이니깐 int 형으로 충분함
	static int min = Integer.MAX_VALUE;
	static int[] arr = new int[101];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		// int[] arr = new int[n]; // 변수 최대 갯수 11개
		for (int i = 0; i < n; i++) 
			arr[i] = sc.nextInt();
		

		int[] oper = new int[4]; // +1 -2 *3 /4 순서로

		for (int i = 0; i < 4; i++) 
			oper[i] = sc.nextInt();
		
		multiOper(1, arr[0], oper[0], oper[1], oper[2], oper[3]);
		
		System.out.println(max);
		System.out.println(min);
	}

	public static void multiOper(int count, int result, int op0, int op1, int op2, int op3) { // 연산자 4개 배열에//넣고 싶은데//방법이//없나
		//System.out.println(" count : " + count + "  result :  " + result + " " + op0 + op2 + op2 + op3);
		if (count > n - 1) { // 모든 연산자 사용 = 연산 종료
			max = Math.max(max, result);
			min = Math.min(min, result);
			//System.out.println("   result :    " + max + " " + min);
		} else {// 연산하자
			if (op0 > 0) {
				// System.out.println(count + " " + " " + result + "+" + arr[count + 1]);
				multiOper(count + 1, result + arr[count], op0 - 1, op1, op2, op3); // oper 배열로 받아오면 속성 하나를 -시킬 방법이 안보임
																					// ㅠㅠ
			}
			if (op1 > 0) {
				// System.out.println(count + " " + " " + result + "-" + arr[count + 1]);
				multiOper(count + 1, result - arr[count], op0, op1 - 1, op2, op3);
			}
			if (op2 > 0) {
				// System.out.println(count + " " + " " + result + "*" + arr[count + 1]);
				multiOper(count + 1, result * arr[count], op0, op1, op2 - 1, op3);
			}
			if (op3 > 0) {
				// System.out.println(count + " " + " " + result + "/" + arr[count + 1]);
				multiOper(count + 1, result / arr[count], op0, op1, op2, op3 - 1);
			}
		}
	}
}
