package backjoon;

import java.util.Scanner;

public class Main_B7568 {
	public static void main(String[] args) {
		// 7568_µ¢Ä¡
		Scanner sc = new Scanner(System.in);
		int N;
		N = sc.nextInt(); 
		
		int[][] arr = new int[51][2]; // 2 ¡Â N ¡Â 50, 10 ¡Â x,y ¡Â 200
		int[] result = new int[51];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		int rank =0;
		for (int i = 0; i < N; i++) {
			rank = 1;
			for (int j = 0; j < N; j++) {
				if(i!=j && arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++;
				}
			}//eof forj
			
			result[i] = rank;
		}//eof fori
		
		for (int i = 0; i < N; i++) {
			System.out.print(result[i]+ " ");
		}System.out.println();
	}//eof class
}
