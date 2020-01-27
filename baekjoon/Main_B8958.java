package backjoon;

import java.util.Scanner;

public class Main_B8958 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt(); // T == num of testcases

		for (int test_case = 1; test_case <= T; test_case++) {
			int result = 0;
			int count = 0;
			String ox = sc.next();
			System.out.println(ox);

			for (int i = 0; i < ox.length(); i++) {
				count = 1;
				//System.out.print(ox.charAt(i));
				if (ox.charAt(i) == 'O') {
					while (true) {
						result += count++;

						if (i+1 < ox.length())
							if(ox.charAt(i + 1) == 'X') 
								break;
							else 
								i++;
						else
							break;
					}
				}
			}
			System.out.println(result);
		}
	}

}
