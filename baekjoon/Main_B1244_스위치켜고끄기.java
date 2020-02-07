package com.ssafy.hw;

import java.util.Scanner;

public class Main_B1244_스위치켜고끄기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 전구 개수

		int bulb[] = new int[101];
		for (int i = 1; i <= N; i++) {
			bulb[i] = sc.nextInt();
		}

		int s_num = sc.nextInt();
		int gen = 0; // 성별
		// 1 : 남자 : 입력 숫자의 배수를 반전
		// 2 : 여자 : 입력 숫자 중심 좌우가 대칭 가장 긴 구간 반전
		int input = 0;
		for (int s = 0; s < s_num; s++) { // s 회 진행
			gen = sc.nextInt();
			input = sc.nextInt();
			if (gen == 1) { // 남자
				// System.out.println("남자");
				for (int x = input; x <= N; x += input) {

					if (bulb[x] == 0) { // 0일때
						bulb[x] = 1;
					} else {// 1일떄
						bulb[x] = 0;
					}
				}

			} else { // 여자
				// System.out.println("여자");
				int x = 1;
				while (input - x >= 1 && input + x <= N ) {
					if( !(bulb[input + x] == bulb[input - x]))
						break;
					x++;
				}
		
				if (bulb[input] == 0) { // 0일때
					// System.out.println("0이네");
					bulb[input] = 1;
				} else {// 1일떄
					bulb[input] = 0;
				}

				for (int i = 1; i <= x; i++) {
					// System.out.println("바뀌냐");
					if (bulb[input + i] == 0) { // 0일때
						// System.out.println("0이네");
						bulb[input + i] = 1;
					} else {// 1일떄
						bulb[input + i] = 0;
					}

					if (bulb[input - i] == 0) { // 0일때
						bulb[input - i] = 1;
					} else {// 1일떄
						bulb[input - i] = 0;
					}
				}

			}

//			for (int i = 1; i <= N; i++) {
//				System.out.print(bulb[i] + " ");
//			}
//			System.out.println();

		}

		for (int i = 1; i <= N; i++) {
			System.out.print(bulb[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}
		System.out.println();
	}
}
