package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B1182_부분수열의합 {

	static int N;
	static int S;
	static int[] arr;
	static boolean[] v;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");

		N = Integer.parseInt(str[0]);
		S = Integer.parseInt(str[1]);

		arr = new int[N];
		v = new boolean[N];

		str = bf.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		bfs(0, 0);

		System.out.println(result);
	}

	public static void bfs(int ptr, int count) {
		// TODO Auto-generated method stub
		if (ptr == N) {
			if (count != 0)
				// System.out.println("end of bfs");
				sumArr();
		} else {
			v[ptr] = true;
			bfs(ptr + 1, count + 1);
			v[ptr] = false;
			bfs(ptr + 1, count);
		}
	}

	static int sum;

	public static void sumArr() {
		sum = 0;
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			// System.out.print(v[i] + " ");
			if (v[i] == true) {
				sum += arr[i];
			}
		}
		// System.out.println(sum);
		if (sum == S)
			result++;
	}

}
