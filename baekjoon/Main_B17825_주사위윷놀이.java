package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B17825_주사위윷놀이 {
	static int[] dice = new int[10];
	static int p1;
	static int p2;
	static int p3;
	static int p4;

//	static int[] p = new int[4];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] str = bf.readLine().split(" ");

		for (int i = 0; i < 10; i++) {
			dice[i] = Integer.parseInt(str[0]);
		}

		start();
		// basicRoad(0,0,0,0,0);
	}

	private static void start() {
		// TODO Auto-generated method stub
		basicRoad(0, 0, p1, p2, p3, p4);
		basicRoad(0, 1, p1, p2, p3, p4);
		basicRoad(0, 2, p1, p2, p3, p4);
		basicRoad(0, 3, p1, p2, p3, p4);

	}

	public static void basicRoad(int count, int pawn, int p1, int p2, int p3, int p4) {
		// TODO Auto-generated method stub
		if (count == 10) {
			System.out.println(count + "게임 종료 : " + p1 + " " + p2 + " " + p3 + " " + p4 + "  합산 :" + (p1 + p2 + p3 + p4));
		} else {
			if (p1 == 10) {
				
			} else if (p1 == 20) {

			} else if (p1 == 25) {

			} else if (p1 == 30) {

			} else if (p1 == 40) {

			} else {
				basicRoad(count + 1, 1, p1 + 2, p2, p3, p4);
				basicRoad(count + 1, 1, p1 + 2, p2, p3, p4);
				basicRoad(count + 1, 1, p1 + 2, p2, p3, p4);
				basicRoad(count + 1, 1, p1 + 2, p2, p3, p4);
			}
		}
	}

}
