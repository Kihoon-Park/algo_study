package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B17143_낚시왕 {

	public static int r;
	public static int c;
	public static int m;
	public static Shark[] sk = new Shark[10000];
	public static int[][] map = new int[100][100];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		r = Integer.parseInt(st.nextToken()); // (2 ≤ R, C ≤ 100, 0 ≤ M ≤ R×C)
		c = Integer.parseInt(st.nextToken()); // (2 ≤ R, C ≤ 100, 0 ≤ M ≤ R×C)
		m = Integer.parseInt(st.nextToken()); // 상어의 수 (0 ≤ M ≤ R×C)

		int sr;
		int sc;
		for (int i = 1; i <= m; i++) { // 상어의 수 만큼 정보 입력
			// 다섯 정수 r, c, s, d, z (1 ≤ r ≤ R, 1 ≤ c ≤ C, 0 ≤ s ≤ 1000, 1 ≤ d ≤ 4, 1 ≤ z ≤
			// 10000)
			st = new StringTokenizer(bf.readLine());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			sk[i] = new Shark(sr, sc, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
			map[sr][sc] = i;
		} // end of for i
		/** end of input */

		for (int i = 1; i <= m; i++) {
			if (sk[i].isAlive) { // 상어새끠 살아있으면 움직여야지
				moveShark();
			}
		}
		printMap();

	}// end of Main

	static int r_buf = 0;
	static int c_buf = 0;
	static int left_len;
	public static void moveShark() {
		// 시작 위치 받고 꺾이면 반대방향으로

	}

	public static void printMap() {
		// TODO Auto-generated method stub
		for (int x = 1; x <= r; x++) {
			for (int y = 1; y <= c; y++) {
				System.out.print(map[x][y] + " ");
			}
			System.out.println();
		}
	}
}

class Shark {

	int r; // 상어 위치 1 ≤ r ≤ R
	int c; // 상어 위치 1 ≤ c ≤ C
	int s; // 속력 0 ≤ s ≤ 1000
	int d; // 이동 방향 1위 2아래 3오른쪽 4왼쪽 1 ≤ d ≤ 4
	int z; // 크기 1 ≤ z ≤ 10000
	boolean isAlive = true;

	public Shark(int r, int c, int s, int d, int z) {

		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}

}