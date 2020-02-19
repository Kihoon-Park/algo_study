package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B17144_미세먼지안녕 {
	static int R; // 높이 6 ≤ R, C ≤ 50
	static int C; // 넓이 6 ≤ R, C ≤ 50
	static int T; // 시간 1 ≤ T ≤ 1,000
	static int[][] map;
	static int[][] nextMap;
	static int dTmp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Init();

		for (int time = 1; time <= T; time++) {
			spreadDust();

		}

		printMap(map);
	}

	public static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void spreadDust() {
		// TODO Auto-generated method stub
		nextMap = new int[R][C];

		for (int x = 0; x < R; x++) {
			for (int y = 0; y < C; y++) {
				if (map[x][y] == -1) { // 공기청정기
					nextMap[x][y] = -1;
				} else if (map[x][y] != 0) { // 미세먼지 발견
					dTmp = map[x][y];
					for (int i = 0; i < 4; i++) { // 4방향에 대해
						//맵을 벗어나지 않고
						if (x + dir[i][0] >= 0 && x + dir[i][0] < R && y + dir[i][1] >= 0 && y + dir[i][1] < C) { 
							if(map[x][y] != -1) { // 공기청정기가 아닐 떄
								
							}
						}
					}

				}

			} // end of for y
		}
	}

	public static void Init() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] str = bf.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		T = Integer.parseInt(str[2]);

		map = new int[R][C];
		for (int x = 0; x < R; x++) {
			str = bf.readLine().split(" ");
			for (int y = 0; y < C; y++) {
				map[x][y] = Integer.parseInt(str[y]);
			}
		}
	}

	public static void printMap(int[][] arr) {
		// TODO Auto-generated method stub
		for (int x = 0; x < R; x++) {
			for (int y = 0; y < C; y++) {
				System.out.print(arr[x][y] + " ");
			}
			System.out.println();
		}
	}

}
