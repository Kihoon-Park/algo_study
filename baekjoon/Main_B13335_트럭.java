package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Truck {
	int weight;
	int pos;

	public Truck(int weight, int pos) {
		super();
		this.weight = weight;
		this.pos = pos;
	}

	@Override
	public String toString() {
		return "Truck [weight=" + weight + ", pos=" + pos + "]";
	}
}

public class Main_B13335_트럭 {

	static int n; // 트럭의 수
	static int w; // 다리의 길이
	static int l; // 최대하중
	static Truck[] tk = new Truck[1001];
	static int t_ptr = 0;
	static Queue<Truck> q = new LinkedList<Truck>();
	static int time;
	static int arrive;
	static int sum;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Init();

		// 넣을떄 조건 : q안의 weight 합이 L 이하
		// 빠질때 조건 : q안의 truck pos가 w 이상일떄?초과일때? (들어올 떄부터 pos++)

		roop: while (true) {
			time++;
			// 먼저 빼고
			if (!q.isEmpty()) {
				if (q.peek().pos >= w) { // 다리 끝 도달
					sum -= q.poll().weight;
					arrive++;
					if (arrive >= n) {
						System.out.println(time);
						break roop;
					}
				}
			}
			// 들어 오고
			if (t_ptr < n) {
				if (tk[t_ptr].weight + sum <= l) {
					sum += tk[t_ptr].weight;
					q.offer(tk[t_ptr++]);
				}
			}
			for (int i = 0; i < t_ptr; i++) { // 내부 모든 트럭의 거리 1씩 증가
				tk[i].pos++;
			}

			//checkQ();
		} // end of while

	}

//	private static void checkQ() {
//		// TODO Auto-generated method stub
//		System.out.println(q.toString());
//	}

	public static void Init() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] str = bf.readLine().split(" ");

		n = Integer.parseInt(str[0]); // 1 ≤ n ≤ 1,000
		w = Integer.parseInt(str[1]); // 1 ≤ w ≤ 100
		l = Integer.parseInt(str[2]); // 10 ≤ L ≤ 1,000

		str = bf.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			tk[i] = new Truck(Integer.parseInt(str[i]), 0);
		}
	}

}
