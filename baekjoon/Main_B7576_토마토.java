package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B7576_토마토 {

	public static class tomato {
		private int x;
		private int y;
		private int day;

		tomato(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		int max_day = -1;
		Queue<tomato> tom = new LinkedList<>();

		for (int x = 0; x < n; x++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int y = 0; y < m; y++) {
				arr[x][y] = Integer.parseInt(st.nextToken());
				if (arr[x][y] == 1) {
					tom.add(new tomato(x, y, 0));
				}
			}
		}
		int check = 0;
		int tx;
		int ty;
		int tday= 0;
		while (!tom.isEmpty()) {
			check = 0;
			tomato t = tom.poll();
			tx= t.x;
			ty= t.y;
			tday= t.day;
			for (int i = 0; i < 4; i++) {
				if (tx + dir[i][0] >= 0 && tx + dir[i][0] < n &&
					ty + dir[i][1] >= 0 && ty + dir[i][1] < m ) {
					if (arr[tx + dir[i][0]][ty + dir[i][1]] == 0) {
						arr[tx + dir[i][0]][ty + dir[i][1]] = 1;
						tom.add(new tomato(tx + dir[i][0], ty + dir[i][1], tday + 1));
					}
				}
			}
			
	
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					check = 1;
					break;
				}
			} if(check==1)
				break;
		}
		if (check == 0) {
				max_day = tday;
		}
		
		System.out.println(max_day);
	}
}
