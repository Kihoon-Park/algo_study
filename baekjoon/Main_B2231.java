package backjoon;

import java.util.Scanner;

public class Main_B2231 {
	public static void main(String[] args) {

		// TODO Auto-generated constructor stub

		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt(); // N(1 ≤ N ≤ 1,000,000)

		int ptr = num - 70; // 정답 = n 과 9*7 이상 차이나지 않음
		int tmp = 0;
		int sum = 0;
		int result = 0;
		if (ptr < 0)
			ptr = 1; // 최소숫자 1 부터 시작

		//if (num == 1)// 1일경우 예외처리
		//	System.out.println("0");

		for (int i = ptr; i < num; i++) {

			tmp = i;
			sum = tmp;

			while (tmp > 0) { //분해합 계산
				sum += tmp % 10;
				tmp /= 10;
			}
	
			if (num == sum) {
				result = i;
				break;
			}

		}
		System.out.println(result);
		
	}
}
