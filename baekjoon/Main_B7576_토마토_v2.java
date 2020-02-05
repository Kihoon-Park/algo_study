package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B7576_토마토_v2 {

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

	static int max_day = 0; // 결과값

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// Scanner sc = new Scanner(System.in);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// int m = sc.nextInt(); // 가로 칸 수
		// int n = sc.nextInt(); // 세로 칸 수
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		// System.out.println(m + " " + n);
		int[][] arr = new int[n + 2][m + 2];

		// tomato[] tom = new tomato[10000001];
		Queue<tomato> tom = new LinkedList<>();

		for (int x = 0; x <= n + 1; x++) {
			if (x != 0 && x != n + 1)
				st = new StringTokenizer(br.readLine(), " ");

			for (int y = 0; y <= m + 1; y++) {
				if (x != 0 && y != 0 && x != n + 1 && y != m + 1) {
					arr[x][y] = Integer.parseInt(st.nextToken());
					// arr[x][y] = sc.nextInt();
					if (arr[x][y] == 1) {

						tom.add(new tomato(x, y, 0));
					}
				} else
					arr[x][y] = -1;
			}
		}

		// showMap(arr);

		// System.out.println(tom.poll().x + " " + tom.peek().y);

		// ripeningT(arr, tom);
		while (!tom.isEmpty()) {
			// x = tom.peek().x;
			// y = tom.peek().y;
			// day = tom.peek().day;
			tomato t = tom.poll();
			for (int i = 0; i < 4; i++) {
				if (arr[t.x + dir[i][0]][t.y + dir[i][1]] == 0) {
					arr[t.x + dir[i][0]][t.y + dir[i][1]] = t.day + 1;
					tom.add(new tomato(t.x + dir[i][0], t.y + dir[i][1], t.day + 1));
				}
			}
			if (checkDone(arr)) {
				if (max_day < t.day)
					max_day = t.day;
				// max_day = Math.max(t.day, max_day);
			} else
				max_day = -1;
		}

		System.out.println(max_day);
	}

	static int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	public static void ripeningT(int[][] arr, Queue<tomato> tom) {
		while (!tom.isEmpty()) {
			// x = tom.peek().x;
			// y = tom.peek().y;
			// day = tom.peek().day;
			tomato t = tom.poll();
			for (int i = 0; i < 4; i++) {
				if (arr[t.x + dir[i][0]][t.y + dir[i][1]] == 0) {
					arr[t.x + dir[i][0]][t.y + dir[i][1]] = t.day + 1;
					tom.add(new tomato(t.x + dir[i][0], t.y + dir[i][1], t.day + 1));
				}
			}
			if (checkDone(arr)) {
				if (max_day < t.day)
					max_day = t.day;
				// max_day = Math.max(t.day, max_day);
			} else
				max_day = -1;
		}

	}

//	public static void showMap(int[][] arr) {
//		for (int x = 0; x < arr.length; x++) {
//			for (int y = 0; y < arr[0].length; y++) {
//				System.out.printf("%3d", arr[x][y]);
//				// System.out.print(arr[x][y] + " ");
//			}
//			System.out.println();
//		}
//	}

	public static boolean checkDone(int[][] arr) {
		for (int i = 1; i < arr.length - 1; i++) {
			for (int j = 1; j < arr[0].length - 1; j++) {
				if (arr[i][j] == 0)
					return false;
			}
		}
		return true;
		// System.out.println(max_day-1);
	}
}
