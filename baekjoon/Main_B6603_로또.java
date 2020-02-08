package baekjoon;

import java.util.Scanner;

public class Main_B6603_로또 {

	static int[] arr = new int[13];
	static int length = 0;

	// static boolean[] isUsed = new boolean[13];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			// int
			length = sc.nextInt(); // 입력 숫자

			if (length == 0) { // 0이면 프로그램 종료
				break;
			}

			// int[] arr = new int[13]; // k (6 < k < 13)
			boolean[] isUsed = new boolean[13]; // 사용했을까?

			for (int i = 0; i < length; i++) {
				arr[i] = sc.nextInt();
			}

			Backtracking(0, 0, isUsed);
			System.out.println();
		}
	}

	public static void Backtracking(int ptr, int count, boolean[] isUsed) {
		// TODO Auto-generated method stub
		if (count == 6) {
			// print
			// System.out.print("6완료 : ");
			for (int i = 0; i < length; i++) {
				if (isUsed[i] == true)
					System.out.print(arr[i] + " ");
				// else
				// System.out.print("0 ");

			}
			System.out.println();

		} else {
			//
			// for (int i = 0; i < length; i++) {
			for (int i = ptr; i < length; i++) {
				isUsed[i] = true;
				Backtracking(i + 1, count + 1, isUsed);
				isUsed[i] = false;
			}
		}
	}
}
