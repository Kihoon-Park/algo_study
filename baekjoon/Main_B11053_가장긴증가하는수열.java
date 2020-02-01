package baekjoon;

import java.util.Scanner;

public class Main_B11053_가장긴증가하는수열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[10001];
		int[] dp = new int[10001];
		int a_len = sc.nextInt(); // 수열 길이

		for (int i = 0; i < a_len; i++) // 수열 뒤집어서 내림차순으로 찾기
			arr[i] = sc.nextInt();

		dp[0] = 1; // 자기자신
		int dp_max = dp[0];

		int result = 1;
		
		for (int i = 1; i < a_len; i++) { // i 기준 탐색 시작
			//System.out.println(i + "   :   " + max + " " + arr[i]);
			dp_max = 0;
			for (int x = 0; x < i; x++) { // 자기 전까지 자기보다 작은 dp[x] 중 최대값+1 가져오기
				if (arr[i] > arr[x]) 
					dp_max = Math.max(dp[x], dp_max);
			}
			dp[i] = Math.max(dp_max+1, dp[i]);
			result = Math.max(result, dp[i]);
		}
		
		//for (int i = 0; i < a_len; i++) {
		//	System.out.print(dp[i] + " ");
		//}
		//System.out.println();

		System.out.println(result);
	}

}
