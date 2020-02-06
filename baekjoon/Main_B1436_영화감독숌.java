package baekjoon;

import java.util.Scanner;

public class Main_B1436_영화감독숌 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();
		String sssix = "666";
		int count = 0;
		for (int i = 0; i < 10000000; i++) {
			if (String.valueOf(i).contains(sssix)) {
				count++;
				if (count == input)
					System.out.println(i);
			}
		}
	}
}
