package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main_B3190_뱀 {

	static int n;
	static int k;
	static int l;
	static int[][] map = new int[102][102];

	static class SnakeBody {
		int x;
		int y;
		int dirN;

		public SnakeBody(int x, int y, int dirN) {
			super();
			this.x = x;
			this.y = y;
			this.dirN = dirN;
		}
	}

	static class Order {
		int moveTime;
		char dir;

		public Order(int moveTime, char dir) {
			super();
			this.moveTime = moveTime;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine()); // 보드 크기 (2 ≤ N ≤ 100)
		k = Integer.parseInt(bf.readLine()); // 사과의 개수 K가 주어진다. (0 ≤ K ≤ 100)

		String[] str;
		for (int i = 0; i < k; i++) {
			str = bf.readLine().split(" ");
			map[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 2; // 사과는 2
		}

		Deque<SnakeBody> q = new LinkedList<SnakeBody>();
		int way = 0;
		q.offer(new SnakeBody(1, 1, way));
		map[1][1] = 1;

		int x_pos = 1;
		int y_pos = 1;

		l = Integer.parseInt(bf.readLine()); // 방향 변환 횟수 L (1 ≤ L ≤ 100)

		Order[] od = new Order[l + 1];
		for (int i = 0; i < l; i++) {
			str = bf.readLine().split(" ");
			od[i] = new Order(Integer.parseInt(str[0]), str[1].charAt(0));
		}

		

		int order_ptr = 0;
		int time = 0;
		int next_x = 1;
		int next_y = 1;
		int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 0 1 2 3
		while (true) {
			time++;
			//System.out.println("time: " + time);

			// dir[][0] dir[][1]
			next_x = next_x + dir[q.getLast().dirN][0];
			next_y = next_y + dir[q.getLast().dirN][1];
			// 맵 범위 벗어나면 게임 종료
			if (next_x < 1 || next_x > n || next_y < 1 || next_y > n ) {
				//System.out.println("벽꿍 게임종료");
				break;
			}
			if (map[next_x][next_y] == 1) { // 자기 자신과 부딛히면 게임 종료
				//System.out.println("자해공갈 게임종료");
				break;
			}
			// 꿈틀꿈틀기어서가자

			if (map[next_x][next_y] == 0) { // 앞으로 한칸 일반
				q.add(new SnakeBody(next_x, next_y, q.getLast().dirN));
				map[next_x][next_y] = 1;
				map[q.peek().x][q.peek().y] = 0;
				q.poll();
			}

			if (map[next_x][next_y] == 2) { // 사과 발견
				q.add(new SnakeBody(next_x, next_y, q.getLast().dirN));
				map[next_x][next_y] = 1;

			}

			if (order_ptr < l && od[order_ptr].moveTime == time) {
				//System.out.print("드리프트");
				if (od[order_ptr].dir == 'D') { // 오른쪽
					//System.out.println(" 오른쪽");
					q.getLast().dirN = (q.getLast().dirN + 5) % 4;
				}
				if (od[order_ptr].dir == 'L') { // 왼쪽
					//System.out.println(" 왼쪽");
					q.getLast().dirN = (q.getLast().dirN + 3) % 4;
				}

				order_ptr++;
			}

			//printMap();
		}
		System.out.println(time);

	}

	public static void printMap() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
