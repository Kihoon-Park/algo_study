package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B14889_스타트와링크 {

	static int N; // N(4 ≤ N ≤ 20, N은 짝수)
	static int[][] arr;
	static int gap = Integer.MAX_VALUE;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated constructor stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");

		N = Integer.parseInt(str[0]);

		arr = new int[N][N];
		v = new boolean[N];
		for (int i = 0; i < N; i++) {
			str = bf.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		// 입력 end

		makeTeam(0, 0);

		System.out.println(gap);
	}

	
	public static void makeTeam(int count, int ptr) {
		// TODO Auto-generated method stub
		if (count == N / 2) { // 절반 나누면 나눈 팀 기반으로 합 구하기
			findSum();
		} else if (ptr == N) { // 배열의 끝까지 접근하면 연산 멈추게
		} else {
			v[ptr] = true;
			makeTeam(count + 1, ptr + 1);
			v[ptr] = false;
			makeTeam(count, ptr + 1);
		}
	}

	static int start;
	static int link;
	
	public static void findSum() {
		// TODO Auto-generated method stub
		start = 0; // 초기화
		link = 0; // 초기화
		for (int x = 0; x < N; x++) {
			for (int y = x; y < N; y++) {
				if(v[x] && v[y]) {
					start += (arr[x][y] + arr[y][x]);
				} else if (!v[x] && !v[y])
					link += (arr[x][y] + arr[y][x]);
			}
		}
		
		gap = Integer.min(gap, Math.abs(start-link));
	}
}
