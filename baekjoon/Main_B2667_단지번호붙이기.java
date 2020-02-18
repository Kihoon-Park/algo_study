package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_B2667_단지번호붙이기 {

	static int[][] map = new int[27][27];
	static boolean visited[][] = new boolean[27][27];
	static int[] result = new int[1000];
	static int r_size;
	static int N;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InitMap();

		//printMap();

		findComplex();
		
		printResult();
		
	}

	public static void printResult() {
		// TODO Auto-generated method stub
		Arrays.sort(result,0,r_size);
		System.out.println(r_size);
		for (int i = 0; i < r_size; i++) {
			System.out.println(result[i]);
		}
	}

	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void InitMap() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		String s;

		for (int x = 1; x <= N; x++) {
			s = bf.readLine();
			for (int y = 1; y <= N; y++) {
				map[x][y] = s.charAt(y - 1) - 48;
			}
		}
	}

	public static void printMap() {
		// TODO Auto-generated method stub
		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				System.out.print(map[x][y] + " ");
			}
			System.out.println();
		}
	}
	static int size = 0;
	public static void findComplex() {
		// TODO Auto-generated method stub
		
		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				size = 0;
				if(map[x][y]==1 && visited[x][y] == false) {
					dfs(x,y);
					result[r_size++] = size;
				}
			}
		}
	}

	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		
		size++;
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			if(map[x + dir[i][0]][y + dir[i][1]] == 1 && visited[x+ dir[i][0]][y+ dir[i][1]] == false) {
				dfs(x+ dir[i][0],y+ dir[i][1]);
			}
		}
	}
}
