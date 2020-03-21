package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_B_9205_맥주마시면서걸어가기 {

	static class Dot{
		int x;
		int y;
		
		public Dot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = bf.readLine().split(" ");
		
		int T = Integer.parseInt(str[0]);
		
		for (int test_case = 0; test_case < T; test_case++) {
			str = bf.readLine().split(" ");
			int n = Integer.parseInt(str[0]); // 편의점 개수
			
			str = bf.readLine().split(" ");
			Dot home = new Dot(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
			
			//System.out.println(home.x +" "+ home.y);
			
			Dot[] store = new Dot[n];
			boolean[] visited = new boolean[n];
			for (int i = 0; i < n; i++) {
				str = bf.readLine().split(" ");
				//store.add(new Dot(Integer.parseInt(str[0]),Integer.parseInt(str[1])));
			    store[i] = new Dot(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
			}
			str = bf.readLine().split(" ");
			Dot goal = new Dot(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
			
			// 입력 완료
			
			// bfs 로 goal 찾아가기 - 범위 내 goal&store 찾아야함 
			// 중간에 아무 목적지도 찾지 못하면 return false
			Queue<Dot> q = new LinkedList<Dot>();
			q.add(home);
			
			Dot dbuf;
			boolean istrue = false;
			
			while(!q.isEmpty()) {
				//System.out.println("INTO THE WHILE~~");
				dbuf = q.poll();
				
				if(Math.abs(dbuf.x-goal.x) + Math.abs(dbuf.y-goal.y) <= 1000) {
					// 목적지 도착
					istrue = true;
					//System.out.println("GOALLLLLLL");
				}
				
				for (int i = 0; i < n; i++) {
					if(!visited[i] && Math.abs(dbuf.x-store[i].x) + Math.abs(dbuf.y-store[i].y) <= 1000) {
						visited[i] = true;
						q.add(store[i]);
					}
				}
				
				
				
			}
			
			if(istrue) {
				System.out.println("happy");
			} else
				System.out.println("sad");
		}
	}

}
