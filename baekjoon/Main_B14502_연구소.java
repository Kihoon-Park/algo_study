
package baekjoon;

import java.util.Scanner;

public class Main_B14502_연구소 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 배열 최소 크기 = 3 * 3
		// 배열 최대 크기 = 8 * 8
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] map = new int[N + 2][M + 2];
		int[] iszero = new int[238328]; // (64-2)^3 (N*M*N*M*N*M)
		int isz_ptr = 0;
		int[][] sas_ptr = new int[10][2]; // 바이러스 개수 최대 10개
		int sas_count = 0; // 바이러스 개수

		int max = 0;

		// 1. 배열 입력 및 1 테두리 치기, 빈칸 개수 카운팅
		for (int i = 0; i <= N + 1; i++) { // fill map
			for (int j = 0; j <= M + 1; j++) {
				if (i > 0 && j > 0 && i <= N && j <= M)
					map[i][j] = sc.nextInt();
				else
					map[i][j] = 1;

				if (map[i][j] == 0) { // 빈칸
					iszero[isz_ptr] = i * (M + 2) + j; // 1 이면 벽을 세울 수 있는 공간 ( 0 )
					isz_ptr++;
				}
				if (map[i][j] == 2) { // 바이러스
					sas_ptr[sas_count][0] = i;
					sas_ptr[sas_count][1] = j;
					sas_count++;
				}
			}
		}
		// end of 1

		// System.out.println("빈칸의 갯수 : " + isz_ptr);
		/*
		 * for (int i = 0; i < isz_ptr; i++) { // 벽 세울 수 있는 모든 공간 출력
		 * System.out.print(iszero[i] + " "); } System.out.println();
		 */

		// 2. 3개의 벽 세우기 모든 경우의 수 구하기
		int[][] wall = new int[238328][3];

		int wall_ptr = 0;
		for (int i = 0; i < isz_ptr; i++) { // 벽 세울 수 있는 모든 공간 출력
			for (int j = i + 1; j < isz_ptr; j++) {
				if (i != j) {
					for (int k = j + 1; k < isz_ptr; k++) {
						if (k != i && k != j) {
							// System.out.println(iszero[i] + " " + iszero[j] + " " + iszero[k]);
							wall[wall_ptr][0] = iszero[i];
							wall[wall_ptr][1] = iszero[j];
							wall[wall_ptr][2] = iszero[k];
							wall_ptr++;
						}
					}
				}
			}
		}
		// end of 2

		// for (int i = 0; i < wall_ptr; i++) {
		// System.out.println(wall[i][0] + " " + wall[i][1] + " " + wall[i][2]);
		// }
		// System.out.println("벽 세우기 경우의 수 : " + wall_ptr);

		// for (int v = 0; v < sas_count; v++) {
		// System.out.println("바이러스 초기 위치 : " + sas_ptr[v][0] + " " + sas_ptr[v][1]);

		// }
		int[][] map_buf = new int[N + 2][M + 2];
		// 3. 3개의 벽을 추가로 친 Map 생성
		// int[][] map_buf = new int[N + 2][M + 2];

		// showMap(map);

		// for (int i = 0; i < wall_ptr; i++) {
		for (int i = 0; i < wall_ptr; i++) {// 디버깅용 첫번째 배열만

			// System.out.println(wall[i][0] + " " + wall[i][1] + " " + wall[i][2]);

			copyMap(map, map_buf);

			int z1 = wall[i][0];
			int z2 = wall[i][1];
			int z3 = wall[i][2];

			map_buf[z1 / (M + 2)][z1 % (M + 2)] = 8;
			map_buf[z2 / (M + 2)][z2 % (M + 2)] = 8;
			map_buf[z3 / (M + 2)][z3 % (M + 2)] = 8;

			// showMap(map_buf);

			// 4. 생성된 Map 기반 dfs 실행

			for (int v = 0; v < sas_count; v++) {
				//fillSas(map_buf, sas_ptr[v][0], sas_ptr[v][1]);
				fillSas2(map_buf, sas_ptr[v][0], sas_ptr[v][1]);
			}
			// end of 4
			// showMap(map_buf);

			// 5. 빈칸의 갯수 최대값 구하기

			max = findMax(map_buf, max);
			// end of 5

		}

		// end of 3

		System.out.println(max); // 정답 제출
	}

	public static void showMap(int[][] map) { // Map 출력(디버깅용)

		for (int i = 0; i < map.length; i++) { // show map
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void copyMap(int[][] map, int[][] cpy) { // Map 출력(디버깅용)

		for (int i = 0; i < map.length; i++) { // show map
			for (int j = 0; j < map[0].length; j++) {
				cpy[i][j] = map[i][j];
			}
		}
	}

	public static int [][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
	
	public static void fillSas(int[][] map, int x, int y) {
		//int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
		for (int i = 0; i < dir.length; i++) {
			if (map[x + dir[i][0]][y + dir[i][1]] == 0) {
				map[x + dir[i][0]][y + dir[i][1]] = 2;
				fillSas(map, x + dir[i][0], y+ dir[i][1]);
			}
		}


	}
	public static void fillSas2(int[][] map, int x, int y) {
		if (map[x + 1][y] == 0) {
			map[x + 1][y] = 2;
			fillSas2(map, x + 1, y);
		}
		if (map[x - 1][y] == 0) {
			map[x - 1][y] = 2;
			fillSas2(map, x - 1, y);
		}
		if (map[x][y + 1] == 0) {
			map[x][y + 1] = 2;
			fillSas2(map, x, y + 1);
		}
		if (map[x][y - 1] == 0) {
			map[x][y - 1] = 2;
			fillSas2(map, x, y - 1);
		}

	}

	public static int findMax(int[][] map, int max) {
		int tmp = 0;
		for (int i = 0; i < map.length; i++) { // show map
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 0)
					tmp++;
			}
		}

		return Math.max(tmp, max);
	}
}