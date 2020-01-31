package baekjoon;

import java.util.Scanner;

public class Main_B11559_PuyoPuyo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int[][] map = new int[12][6];
		String linebuf;
		for (int x = 11; x >= 0; x--) {
			linebuf = sc.next();
			// System.out.println(linebuf);

			for (int y = 0; y < 6; y++) {
				// System.out.print(linebuf.charAt(y));
				map[x][y] = linebuf.charAt(y);
			}
		}

		print(map);

	}

	public static void print(int[][] map) {
		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 6; y++) {
				System.out.print(map[x][y] + " ");
			}
			System.out.println();
		}
	}

	public static int ispung(int[][] map, int num, int x, int y) { // 반환값 4 이상이면 전부 터트려야함
		// 카운트 4개 이상이면 전부 삭제
		// 4개일떄 터트리는게 아니라 전부 탐색하고 재귀 끝나면 터트려야 함
		return 0;
	}

	public static void pung(int[][] map, int num, int x, int y) {
		
	}

	public static void gravity(int[][] map) {

	}
}
