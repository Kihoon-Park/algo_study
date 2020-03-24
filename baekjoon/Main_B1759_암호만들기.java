import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_B1759_암호만들기 {

	static int L;
	static int C;
	static char[] arr;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] str = bf.readLine().split(" ");

		// (3 ≤ L ≤ C ≤ 15)
		L = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);

		// 최소 한 개의 모음 a e i o u
		// 최소 두 개의 자음
		// 정렬

		// 처음에 분류할까 나중에 분류할까

		arr = new char[C];
		v = new boolean[C];
		str = bf.readLine().split(" ");

		for (int i = 0; i < C; i++) {
			arr[i] = str[i].charAt(0);
		}
		Arrays.sort(arr);

		dfs(0, 0, 0);

	}

	public static void dfs(int con, int vow, int ptr) {
		// TODO Auto-generated method stub
		if (con + vow == L) {
			if(con >= 2 && vow >= 1)
			printArr();
		} else if (ptr >= C) {
			//nothing
		} else {
			v[ptr] = true;
			if(isAEIOU(arr[ptr]))
				dfs(con,vow+1,ptr+1);
			else
				dfs(con+1,vow,ptr+1);
			
			v[ptr] = false;
			dfs(con,vow,ptr+1);
		}
	}

	public static void printArr() {
		// TODO Auto-generated method stub
		for (int i = 0; i < C; i++) {
			if(v[i])
				System.out.print(arr[i]);
		}System.out.println();
	}

	public static boolean isAEIOU(int e) {
		if (e == 'a' || e == 'e' || e == 'i' || e == 'o' || e == 'u')
			return true;
		else
			return false;
	}

}
