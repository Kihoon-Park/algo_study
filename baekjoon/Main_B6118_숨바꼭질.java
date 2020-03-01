package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_B6118_숨바꼭질 {
	static int N; // 헛간의 개수는 N(2 <= N <= 20,000)
	static int M; // M(1<= M <= 50,000)개의 양방향 길

	static ArrayList<ArrayList<Integer>> list = new <ArrayList<Integer>>ArrayList<ArrayList<Integer>>();
	static Queue<Integer> q = new LinkedList<Integer>();
	static boolean[] v;
	static int[] length;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);

		length = new int[N + 1];
		v = new boolean[N+1];
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < M; i++) {
			str = bf.readLine().split(" ");
			list.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
			list.get(Integer.parseInt(str[1])).add(Integer.parseInt(str[0]));
		}

		//System.out.println(list);

		q.offer(1);
		v[1] = true;

		int ptr;

		while (!q.isEmpty()) {
			ptr = q.poll();
			//System.out.println(ptr + "방문");
			for (int i = 0; i < list.get(ptr).size(); i++) {
				//System.out.println(i+"포문");
				if (!v[list.get(ptr).get(i)]) {
					//System.out.println(list.get(ptr).get(i) + " hi");
					q.offer(list.get(ptr).get(i));
					length[list.get(ptr).get(i)] = length[ptr] + 1;
					v[list.get(ptr).get(i)] = true;
				}
			}
		}
		
		//System.out.println(Arrays.toString(length));
		
		int max = 0;
		int m_size = 0;
		int minHouse = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, length[i]);
		}
		
		for (int i = N; i >= 1; i--) {
			if(max == length[i]) {
				m_size++;
				minHouse = i;
			}
		}
		
		
		System.out.println(minHouse + " " +max + " " + m_size);
	}
}
