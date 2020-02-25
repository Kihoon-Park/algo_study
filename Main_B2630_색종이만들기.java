package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B2630_색종이만들기 {
	static int N;
	static int[][] map;
	static int flag;
	static int flag_color;

	static int white;
	static int blue;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Init();
		printMap(map);
		
		
		//checkSquare(0, 0, N);

		
		flag = 0;
		flag_color = map[0][0];
		roop: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (flag_color != map[i][j]) {// 다른색 발견
					flag = 1;
					break roop;
				}
			}
		}

		if (flag == 1) {// 다른색
			checkSquare(0, 0, N);
		} else if (flag == 0) { // 모두 같은색
			if (flag_color == 0)
				white++;
			else
				blue++;
		}
		
		System.out.println(white);
		System.out.println(blue);
	}

	public static void checkSquare(int x, int y, int size) {
		// TODO Auto-generated method stub
		System.out.println("cS x : " +x + "   y : " + y + "   size : " + size);
		if (size == 1) {
			if(map[x][y] == 1)
				blue++;
			else
				white++;
		} else {
			// 4분할

			// 1
			flag = 0;
			flag_color = map[x][y];
			roop1: for (int i = x; i < x + size / 2; i++) {
				for (int j = y; j < y + size / 2; j++) {
					if (flag_color != map[i][j]) {// 다른색 발견
						flag = 1;
						break roop1;
					}
				}
			}

			if (flag == 1) {// 다른색
				checkSquare(x, y, size / 2);
			} else if (flag == 0) { // 모두 같은색
				if (flag_color == 0)
					white++;
				else
					blue++;
			}

			// 2
			flag = 0;
			flag_color = map[x][y+size/2];
			roop2: for (int i = x; i < x + size / 2; i++) {
				for (int j = y + size / 2; j < y + size; j++) {
					if (flag_color != map[i][j]) {// 다른색 발견
						flag = 1;
						break roop2;
					}
				}
			}

			if (flag == 1) {// 다른색
				checkSquare(x, y + size / 2, size / 2);
			} else if (flag == 0) { // 모두 같은색
				if (flag_color == 0)
					white++;
				else
					blue++;
			}

			// 3
			flag = 0;
			flag_color = map[x+size/2][y];
			roop3: for (int i = x + size/2; i < x + size; i++) {
				for (int j = y ; j < y + size/2; j++) {
					if (flag_color != map[i][j]) {// 다른색 발견
						flag = 1;
						break roop3;
					}
				}
			}

			if (flag == 1) {// 다른색
				checkSquare(x+size/2, y, size / 2);
			} else if (flag == 0) { // 모두 같은색
				if (flag_color == 0)
					white++;
				else
					blue++;
			}

			// 4
			
			flag = 0;
			flag_color = map[x+size/2][y+size/2];
			roop4: for (int i = x + size/2; i < x + size; i++) {
				for (int j = y + size/2 ; j < y + size; j++) {
					if (flag_color != map[i][j]) {// 다른색 발견
						flag = 1;
						break roop4;
					}
				}
			}

			if (flag == 1) {// 다른색
				checkSquare(x+size/2, y+size/2, size / 2);
			} else if (flag == 0) { // 모두 같은색
				if (flag_color == 0)
					white++;
				else
					blue++;
			}

		}
	}

	public static void printMap(int[][] map2) {
		// TODO Auto-generated method stub
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				System.out.print(map[x][y] + " ");
			}
			System.out.println();
		}
	}

	public static void Init() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");

		N = Integer.parseInt(str[0]);
		map = new int[N][N];
		for (int x = 0; x < N; x++) {
			str = bf.readLine().split(" ");
			for (int y = 0; y < N; y++) {
				map[x][y] = Integer.parseInt(str[y]);
			}
		}
	}

}
