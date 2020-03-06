package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B11047_동전0 {

	static int N;
	static int K;
	static int coin[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		coin = new int[N]; // 동전 종류만큼 초기화
		for (int i = N - 1; i >= 0; i--) {
			// (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
			// 높은 수부터 검사하기 위해 반대로 입력
			coin[i] = Integer.parseInt(bf.readLine().split(" ")[0]);
		}

		// 만들어지지 않는 경우의 수는 없다 (예외조건 처리 문제에서 제시 X)

		int coin_count = K / coin[0]; // 맨 처음 넣은 가장 큰 코인의 최대 갯수

		//System.out.println("초기" + coin_count);
		int last = K - coin[0] * coin_count;
		for (int i = 0; i < N; i++) {
			//System.out.println(last + "asdf");
			//System.out.println(coin[i] + "   " + coin_count + " " + last);

			while (last >= coin[i]) { // 배수이기 때문에 그 전 코인을 빼주거나 할 필요 없음
				//System.out.println("빼기");
				last -= coin[i];
				coin_count++;
			}
			
			//연산이 끝난 후애 검사해 주어야 함 (앞으로 빼니깐 1일때 검사를 못하더라)
			if (last == 0) {
				System.out.println(coin_count);
				break;
			}
		}

	}

}
