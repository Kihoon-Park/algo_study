package yaza;

import java.util.Scanner;

public class Main_B2991 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt(); // 1�۸��� A �� ����
		int B = sc.nextInt(); // 1�۸��� B �� �޽�
		int C = sc.nextInt(); // 2�۸��� C �� ����
		int D = sc.nextInt(); // 2�۸��� D �� �޽�

		int[] mans = new int[3];
		int[] bit = new int[3];

		for (int x = 0; x < mans.length; x++) {
			mans[x] = sc.nextInt();
		}

		
		for (int x = 0; x < mans.length; x++) {
			//System.out.println("A : " + mans[x] % (A + B) + " " + A);
			if (mans[x] % (A + B) <= A && mans[x] % (A + B)  !=0) { // 1�� ����Ÿ��
				bit[x]++;
			}
			if (mans[x] % (C + D) <= C && mans[x] % (C + D)  !=0) { // 1�� ����Ÿ��
				bit[x]++;
			}
			System.out.println(bit[x]);
		}

	}

}
