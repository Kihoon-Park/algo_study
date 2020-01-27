package backjoon;

import java.util.Scanner;

public class Main_B2798 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n, m;
		int max = 0;

		n = sc.nextInt();
		m = sc.nextInt();

		int[] arr = new int[100];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				if (x != y) {
					for (int z = 0; z < n; z++) {
						if (x != z && y != z) {						
							if(arr[x]+arr[y]+arr[z] >= max && arr[x]+arr[y]+arr[z] <=m)
								max = arr[x]+arr[y]+arr[z];
						}//end of if
					}//eof z
				}//eof if
			}//eof y
		}//eof x
		
		System.out.println(max);
	}

}
