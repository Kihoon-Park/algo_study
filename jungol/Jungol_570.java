package com.ssafy.algo;

import java.util.Scanner;

public class Jungol_570 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i == 0 || j == 0)
					arr[i][j] = 1;
				else
					arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
