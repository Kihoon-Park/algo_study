package baekjoon;

import java.util.Scanner;

public class Main_B2563_색종이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int p_count = sc.nextInt(); // 종이 개수
		int[][] sheet = new int[110][110];
		int[] ptr = new int[2];
		for (int i = 0; i < p_count; i++) {
			ptr[0] = sc.nextInt();
			ptr[1] = sc.nextInt();
			for (int x = ptr[0]; x < ptr[0] + 10; x++) {
				for (int y = ptr[1]; y < ptr[1] + 10; y++) {
					sheet[x][y] = 1;
				}
			}
		}

		int sum = 0;
		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				if (sheet[x][y] == 1)
					sum++;
			}

		}
		System.out.println(sum);
	}

}
