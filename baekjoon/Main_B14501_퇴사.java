package baekjoon;

import java.util.Scanner;

public class Main_B14501_퇴사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int day = sc.nextInt();
		Consult[] cons = new Consult[day + 2]; // 0일째 비우기
		int[] dp = new int[day + 2];
		for (int d = 1; d <= day; d++)
			cons[d] = new Consult(sc.nextInt(), sc.nextInt());

		int result = 0;

		for (int i = 1; i <= day + 1; i++) {
			for (int x = 1; x < i; x++) {
				if (x + cons[x].length - 1 < i) {
					dp[i] = Math.max(cons[x].value + dp[x], dp[i]);
				}
			}
			//System.out.println(i + " 일의 dp : " + dp[i]);
			result = Math.max(result, dp[i]);
		}

		System.out.println(result);
		
		// for (int d = 1; d <= day; d++)
		// System.out.println(d + " " + cons[d].length + " " + cons[d].value);

	}

}

class Consult {
	int length;
	int value;

	Consult(int length, int value) {
		this.length = length;
		this.value = value;
	}

}