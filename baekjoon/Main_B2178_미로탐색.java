package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main_B2178_미로탐색 {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] v;
	static int minValue = Integer.MAX_VALUE;
	static Queue<Dot> q = new LinkedList<Dot>();
	static class Dot {
		int x;
		int y;
		int length;
		
		public Dot(int x, int y, int length) {
			super();
			this.x = x;
			this.y = y;
			this.length = length;
		}

		@Override
		public String toString() {
			return "Dot [x=" + x + ", y=" + y + ", length=" + length + "]";
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Init();

		//printMap(map);

		bfs(1, 1, 1);
	}

	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int next_x;
	static int next_y;
	public static void bfs(int x_pos, int y_pos, int length) {		
		
		v[1][1] = true;
		q.offer(new Dot(1,1,1));
		
		while(!q.isEmpty()) {
			Dot d = q.poll();
		
			v[d.x][d.y] = false;
			if(d.x == N && d.y==M) {
				System.out.println(d.length);
				break;
			}
			//System.out.println(d.toString());
			
			for (int i = 0; i < dir.length; i++) {
				next_x = d.x + dir[i][0];
				next_y = d.y + dir[i][1];
				if(map[next_x][next_y] == 1 && v[next_x][next_y] == false) {
					v[next_x][next_y] = true;
					q.offer(new Dot(next_x,next_y,d.length+1));
				}
			}
		}
		
	}

	public static void printMap(int[][] map) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= N + 1; i++) {
			for (int j = 0; j <= M + 1; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void Init() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N + 2][M + 2];
		v = new boolean[N + 2][M + 2];
		for (int x = 1; x <= N; x++) {
			str[0] = bf.readLine();
			for (int y = 1; y <= M; y++) {
				map[x][y] = str[0].charAt(y - 1) - 48;
			}
		}
	}
}
