package backjoon;

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
		
		
		// 1. 배열 입력 및 1 테두리 치기, 빈칸 개수 카운팅
		for (int i = 0; i <= N + 1; i++) { // fill map
			for (int j = 0; j <= M + 1; j++) {
				if (i > 0 && j > 0 && i <= N && j <= M)
					map[i][j] = sc.nextInt();
				else
					map[i][j] = 1;

				if (map[i][j] == 0) {
					iszero[isz_ptr] = i * (N + 1) + (j + 1); // 1 이면 벽을 세울 수 있는 공간 ( 0 )
					isz_ptr++;
				}
			}
		}
		// end of 1
		
		
		System.out.println("빈칸의 갯수 : " + isz_ptr);
		for (int i = 0; i < isz_ptr; i++) { // 벽 세울 수 있는 모든 공간 출력
			System.out.print(iszero[i] + " ");
		}
		System.out.println();

		
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
		//end of 2
		
		for (int i = 0; i < wall_ptr; i++) {
			System.out.println(wall[i][0] + " " + wall[i][1] + " " + wall[i][2]);
		}
		System.out.println("벽 세우기 경우의 수 : " + wall_ptr);

		
		
		// 3. 3개의 벽을 추가로 친 Map 생성
		int[][] map_buf = new int[N + 2][M + 2];
		//for (int i = 0; i < wall_ptr; i++) {
		for (int i = 0; i < 1; i++) {//디버깅용 첫번째 배열만
			
			map_buf = map.clone();
			
			//map_buf[wall[1][0]%M][wall[1][0]/];
			showMap(N, M, map_buf);
		}
		System.out.println("벽 세우기 경우의 수 : " + wall_ptr);
		
		//end of 3
		
		
		// 4. 생성된  Map 기반  dfs 실행
		//end of 4
		
		
		
		// showMap(N, M, map);
	}

	
	
	public static void showMap(int N, int M, int[][] map) { // Map 출력(디버깅용)
		for (int i = 0; i <= N + 1; i++) { // show map
			for (int j = 0; j <= M + 1; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
