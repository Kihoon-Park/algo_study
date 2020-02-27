package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B1012_유기농배추 {

	static int M; // 가로길이 M(1 ≤ M ≤ 50)
	static int N; // 세로길이 N(1 ≤ N ≤ 50)
	static int K; // 배추개수 N(1 ≤ N ≤ 50)
	static int[][] map;
	static boolean[][] v;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");

		int T = Integer.parseInt(str[0]);
		for (int test_case = 0; test_case < T; test_case++) {
			str = bf.readLine().split(" ");

			M = Integer.parseInt(str[0]);
			N = Integer.parseInt(str[1]);
			K = Integer.parseInt(str[2]);
			map = new int[N + 2][M + 2];
			v = new boolean[N + 2][M + 2];
			int count = 0;
			for (int i = 0; i < K; i++) {
				str = bf.readLine().split(" ");
				map[Integer.parseInt(str[1]) + 1][Integer.parseInt(str[0]) + 1] = 1;
			}

//			 출력확인
//			System.out.println();
//			for (int x = 0; x < N + 2; x++) {
//				for (int y = 0; y < M + 2; y++) {
//					System.out.print(map[x][y] + " ");
//				}
//				System.out.println();
//			}

			for (int x = 1; x < N + 1; x++) {
				for (int y = 1; y < M + 1; y++) {
					if (map[x][y] == 1 && !v[x][y]) {
						kkomulkkomul(x, y);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int nx;
	static int ny;

	public static void kkomulkkomul(int x, int y) {
		// TODO Auto-generated method stub
		v[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			nx = x + dir[i][0];
			ny = y + dir[i][1];
			if(map[nx][ny] == 1 && !v[nx][ny]) {
				kkomulkkomul(nx, ny);
			}
		}
	}

}
