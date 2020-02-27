package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_B13460_구슬탈출2 {

	static int M; // N, M (3 ≤ N, M ≤ 10)
	static int N; // N, M (3 ≤ N, M ≤ 10)
	static int map[][];
	static boolean visited[][][][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");

		M = Integer.parseInt(str[0]);
		N = Integer.parseInt(str[1]);

		map = new int[M][N];
		visited = new boolean[M][N][M][N]; // 빨 - 파

		int rx = 0;
		int ry = 0;
		int bx = 0;
		int by = 0;
		for (int x = 0; x < M; x++) {
			str[0] = bf.readLine();
			for (int y = 0; y < N; y++) {
				map[x][y] = str[0].charAt(y) - 35;

				if (map[x][y] == 47) {
					map[x][y] = 11;
					System.out.println("Red  " + x + " " + y);
					rx = x;
					ry = y;
				} else if (map[x][y] == 31) {
					System.out.println("Blue" + x + " " + y);
					map[x][y] = 11;
					bx = x;
					by = y;
				}
			}
		}

		// 빨간공 : 47
		// 파란공 : 31
		
		// 벽 : 0
		// 구멍 : 44
		// 길 : 11
		
		System.out.println(rx + " " + ry + " " + bx + " " + by);
		int count = 1;
		visited[rx][ry][bx][by] = true;

		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(count * 10000 + rx * 1000 + ry * 100 + bx * 10 + by);
		int qbuf;
		int rx_n;
		int ry_n;
		int bx_n;
		int by_n;
		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }; // 0(아래) 1(위) 2(우) 3(좌)
		printMap(map);
		roopq :while (!q.isEmpty()) {
			qbuf = q.poll();
			System.out.println(qbuf/10000+ "번째 실행");
			roopd: for (int i = 0; i < 4; i++) { // 4방향 Move
				// 우선 i ==0 일때만
				rx_n = rx;
				ry_n = ry;
				bx_n = bx;
				by_n = by;
				System.out.println(i +" 방향" );
				while (true) { // 공 이동
					System.out.println("Red: "+ rx_n + " " + ry_n + "  Blue: " + bx_n + " " + by_n);
					if ((map[rx_n + dir[i][0]][ry_n + dir[i][1]] == 0 && map[bx_n + dir[i][0]][by_n + dir[i][1]] == 0)||
							(map[rx_n + dir[i][0]][ry_n + dir[i][1]] == 0 && bx_n + dir[i][0] == rx_n && by_n + dir[i][1] == ry_n)||
							(map[bx_n + dir[i][0]][by_n + dir[i][1]] == 0 && rx_n + dir[i][0] == bx_n && ry_n + dir[i][1] == by_n)) { // 벽 만나면
						break;
					} else {
						if (map[rx_n + dir[i][0]][ry_n + dir[i][1]] ==11 && rx_n + dir[i][0] != bx_n && ry_n + dir[i][1] != by_n) {
							rx_n += dir[i][0];
							ry_n += dir[i][1];
						}
						if (map[bx_n + dir[i][0]][by_n + dir[i][1]] ==11 && bx_n + dir[i][0] != rx_n && by_n + dir[i][1] != ry_n) {
							System.out.println("ggggg");
							bx_n += dir[i][0];
							by_n += dir[i][1];

						}
					}
				}//end of while move
			}//end of for dir

		}
	}

	public static void printMap(int[][] map) {
		// TODO Auto-generated method stub
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
