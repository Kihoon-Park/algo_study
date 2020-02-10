package baekjoon;

import java.util.Scanner;

public class Main_B2567 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int p_count = sc.nextInt(); // 종이 개수
		int[][] sheet = new int[110][110];
		int[] ptr = new int[2];
		for (int i = 0; i < p_count; i++) {
			ptr[0] = sc.nextInt()+1;
			ptr[1] = sc.nextInt()+1;
			for (int x = ptr[0]; x < ptr[0] + 10; x++) {
				for (int y = ptr[1]; y < ptr[1] + 10; y++) {
					sheet[x][y] = 1;
				}
			}
		}

		int sum = 0;
		//System.out.println("??");
		for (int x = 0; x < 102; x++) {
			for (int y = 0; y < 102; y++) {
				if(sheet[x][y]==1) {
					if(sheet[x+1][y]==0) {
						sum++;
					}
					if(sheet[x-1][y]==0) {
						sum++;
					}
					if(sheet[x][y+1]==0) {
						sum++;
					}
					if(sheet[x][y-1]==0) {
						sum++;
					}
				}
			}//System.out.println();

		}
		System.out.println(sum);
	}

}
