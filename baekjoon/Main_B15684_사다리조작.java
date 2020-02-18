package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B15684_사다리조작 {
	static int N; // 세로선의 개수 2 ≤ N ≤ 10
	static int M; // 가로선의 개수 1 ≤ H ≤ 30
	static int H; // 가로가능의 개수 0 ≤ M ≤ (N-1)×H

	static int[][] map = new int[31][11];
	static int[][] cpyMap = new int[31][11];
	static int[] lineAble = new int[300]; // 새로운 선을 새울 수 있는 곳 9*30 까지 가능
	static int la_count;
	static int[] lable = new int[300];
	static int l_count;
	static int flag;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 초기화&Input 해주고
		Init();

		// printMap(map);

		// 모든 경우의 수에 대해 벽 치기
		insertLine();

		// 모든 연산 끝났는데 답 안나왔으면 -1
		if (flag != N)
			System.out.println(-1);

	}

//n = 5 h = 6
	static boolean[] v = new boolean[300];

	public static void insertLine() {
		// TODO Auto-generated method stub
		// System.out.println("벽을 세우자 뚠뚠");
		for (int i = 0; i < (N - 1) * H; i++) {
			// System.out.print(i + " ");
			// System.out.print(lineAble[i] + " "); // 0인 애들만 벽을 세울 수 있는 곳
			if (lineAble[i] == 0)
				lable[l_count++] = i;
		}
		// System.out.println();
//		for (int i = 0; i < l_count; i++) {
//			// System.out.print(i + " "); }
//			System.out.print(lable[i] + " ");
//		}
//		System.out.println();

		int ptr = 0;

		// System.out.println("l_count : " + l_count);
		for (int i = 0; i <= 3; i++) { // 모든 경우의 수 but 0개부터 마지막까지 순차적으로 찾고 "3 이상이면 종료"
			dfs(ptr, i);
			if (flag == N) {// 다똑같 다똑같
				System.out.println(i);
				break;
			}
		}

	}

	public static void dfs(int ptr, int r) {
		if (flag != N) {
			// TODO Auto-generated method stub
			if (r == 0 && flag != N) {
				connectLine();
				return;
			}
			if (ptr == l_count) {
				return;
			} else {
				v[ptr] = true;
				dfs(ptr + 1, r - 1);
				v[ptr] = false;
				dfs(ptr + 1, r);
			}
		}
	}

	public static void connectLine() {
		// TODO Auto-generated method stub
//		System.out.print("v : ");
//		for (int i = 0; i < l_count; i++) {
//			System.out.print(v[i] + " ");
//		}System.out.println();
		// 모든 경우의수 출력 완료
		// 길 연결 시작
		copyMap(map, cpyMap);

		for (int i = 0; i < l_count; i++) {
			if (v[i] == true) {
				// n = 5
				// if 0 -> 0,0 -> 1,1
				// if 6 -> 1,2 -> 2,3
				// if 16 ->4,0 -> 5,1
				// if 19 ->4,3 -> 5,4
				cpyMap[(lable[i] / (N - 1)) + 1][(lable[i] % (N - 1)) + 1] = 1;

			}
		}

		// printMap(cpyMap);

		// 새로 생성된 이 맵에 대해서 findway 실행 -> i==result[i] 이면 종료
		findway(cpyMap);
	}

	public static void findway(int[][] map) {
		// TODO Auto-generated method stub
		int ptr = 0;
		flag = 0;
		// System.out.println("result : ");
		for (int x = 1; x <= N; x++) {
			ptr = x;
			// System.out.println("출발 ptr :" +ptr);
			for (int i = 1; i <= H; i++) {
				// System.out.println("하단");
				if (map[i][ptr - 1] == 1) {
					// System.out.println("좌행");
					ptr--;
				} else if (map[i][ptr] == 1) {
					// System.out.println("우행");
					ptr++;
				}
			}
			// System.out.print(ptr + " ");
			if (x != ptr)
				break;

			flag += 1;
		}
//		if(flag == N) {//다똑같 다똑같
//			System.out.println("발견!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//			
//		}
		// System.out.println();
	}

	public static void printMap(int[][] map) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void copyMap(int[][] map, int[][] copyiedMap) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				copyiedMap[i][j] = map[i][j];
			}
		}
	}

	public static void Init() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] str = bf.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		H = Integer.parseInt(str[2]);
		// System.out.println(N + " " + M + " " + H);
		la_count = (N - 1) * H - M;
		// System.out.println("생성 가능한 선의 갯수 : " + la_count);
		int la = 0;
		for (int i = 0; i < M; i++) {
			str = bf.readLine().split(" ");
			int x_buf = Integer.parseInt(str[0]);
			int y_buf = Integer.parseInt(str[1]);
			map[x_buf][y_buf] = 1;

			// System.out.println("x_buf :" + x_buf + " y_buf:" + y_buf);
			lineAble[(x_buf - 1) * (N - 1) + (y_buf - 1)] = 1; // 세울수 있는 벽의 위치 저장

		}
	}

}
