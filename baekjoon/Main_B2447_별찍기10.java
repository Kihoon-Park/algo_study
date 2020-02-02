package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//import java.util.Scanner;

public class Main_B2447_별찍기10 {
	public static char[][] map = new char[10000][10000];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method

		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		 
		//System.out.println(n);
		//int n = sc.nextInt();

		printTile(0, 0, n); // 27 사이즈 입력되면

		showMap(n, n);
	}

	public static void printTile(int x, int y, int size) {
		if (size == 3) { // 출력부
			//System.out.println("별출력  : " + x + " " + y + " " + size);
			for (int i = x; i < x + 3; i++) {
				for (int j = y; j < y + 3; j++) {
					if (i % 3 == 1 && j % 3 == 1)
						map[i][j] = ' ';
					else
						map[i][j] = '*';
				}
			}
		} else { // 배열장난질 size == 9, 27, 81 ...
			//System.out.println(x + " " + y + " " + size);
			for (int i = x; i < x + size; i += size / 3) {
				for (int j = y; j < y + size; j += size / 3) {
					//System.out.println("재귀 진입  : " + i + " " + j + " " + size);
					if (i != x + size / 3  || j != y + size / 3 ) {
						//System.out.println("별칸");
						printTile(i, j, size / 3);
					} else {
						//System.out.println("빈칸");
						printBlank(i, j, size / 3);
					}
				}
			}

		}
	}

	public static void printBlank(int x, int y, int size) {
		if (size == 3) { // 출력부
			//System.out.println("빈칸출력  : " + x + " " + y + " " + size);
			for (int i = x; i < x + 3; i++) {
				for (int j = y; j < y + 3; j++) {
					if (i % 3 == 1 && j % 3 == 1)
						map[i][j] = ' ';
					else
						map[i][j] = ' ';
				}
			}
		} else { // 배열장난질 size == 9, 27, 81 ...
			//System.out.println(x + " " + y + " " + size);
			for (int i = x; i < x + size; i += size / 3) {
				for (int j = y; j < y + size; j += size / 3) {
					//System.out.println("빈칸칸");
					printBlank(i, j, size / 3);
				}
			}

		}
	}

	public static void showMap(int x, int y) {
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				sb.append(map[i][j]);
				//System.out.print(map[i][j]);
			}
			sb.append("\n");
			//System.out.println();
		}
		
		System.out.println(sb);
	}
}
