package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B9465_스티커 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		int T = Integer.parseInt(str[0]);
		
		for (int test_case = 0; test_case < T; test_case++) {
			str = br.readLine().split(" ");
			
			int len = Integer.parseInt(str[0]);
			
			int[][] arr = new int[len+1][2];
			int[][] dp = new int[len+1][2];
			
			
			str = br.readLine().split(" ");
			for (int i = 1; i <= len; i++) 
				arr[i][0] = Integer.parseInt(str[i-1]);
			str = br.readLine().split(" ");
			for (int i = 1; i <= len; i++) 
				arr[i][1] = Integer.parseInt(str[i-1]);
			
			
//			for (int i = 0; i < len; i++) {
//				System.out.println(arr[i][0] + " " +arr[i][1]);
//			}
			
			dp[1][0] = arr[1][0];
			dp[1][1] = arr[1][1];
			
			
			for (int i = 2; i <= len; i++) {
				dp[i][0] = Math.max(dp[i-1][1], dp[i-2][1]) + arr[i][0];
				dp[i][1] = Math.max(dp[i-1][0], dp[i-2][0]) + arr[i][1]; 
			}
			
			int max = Math.max(dp[len][0], dp[len][1]);
			
			System.out.println(max);
			
		}
	}

}
