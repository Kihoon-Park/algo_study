package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B17471_게리맨더링 {
	
	static int n;
	static int[] res = new int[11];
	static boolean[] v = new boolean[11];
	static int[][] connected = new int[11][11];
	static int true_sum;
	static int false_sum;
	static int flag;
	static int d_flag;
	static int last_flag;
	static int min_diff = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken()); // 구역의 갯수 N // 2 ≤ N ≤ 10

		st = new StringTokenizer(br.readLine(), " ");

//		int[] res = new int[n+1];
//		boolean[] visited = new boolean[n+1];
//		int[][] connected = new int[n+1][n+1];

		
		int connected_count = 0;
		int c_buf;
		last_flag = 0;
		
		for (int i = 1; i <= n; i++) {
			res[i] = Integer.parseInt(st.nextToken()); // 각 지역의 인구수 입력
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			connected_count = Integer.parseInt(st.nextToken()); // 각정점 i 에 연결된 접점의 수

			for (int x = 0; x < connected_count; x++) {
				c_buf = Integer.parseInt(st.nextToken());
				connected[i][c_buf] = connected[c_buf][i] = 1; // 접점 연결 및 connected 2차원 배열에 저장
			}
		} // end of for input for

		/* input 종료 */

//		//디버깅 connected 확인 잘 들어감 확인 완료
//		for (int i = 0; i <= n; i++) {
//			for (int j = 0; j <= n; j++) {
//				System.out.print(connected[i][j] + " ");
//			}System.out.println();
//		}

		/* 선거구 나누는 모든 경우의 수 = 조합으로 구현 */
		for (int i = 1; i < n; i++) { // 1개일 부터 n-1개까지 탐색
			combination(1, i);
		}

		
		/* 모든 연산 종료 출력하고 끝*/
		if(last_flag == 0) {
			System.out.println(-1);
		}else
			System.out.println(min_diff);
		//System.out.println();
	}

	static void combination(int depth, int r) {
		if (r == 0) {
			devisionArea();
			return;
		}
		if (depth == n + 1) {
			return;
		} else {
			v[depth] = true;
			combination(depth + 1, r - 1);
			v[depth] = false;
			combination(depth + 1, r);

		}
	}

	public static void devisionArea() {
		// TODO Auto-generated method stub
		
		true_sum = 0;
		false_sum = 0; // 초기화를 생활화 합시다
		flag = 0; // 지역구 분리 하나라도 만족하면 값 넣고 flag 1로 바꿔주기
//		System.out.print("지역구 분리 : ");
//		for (int i = 1; i <= n; i++) {
//			if(v[i] == true)
//				System.out.print(i + " ");
//			else
//				System.out.print(0 + " ");
//			System.out.print(v[i] + " ");
//		}
//		System.out.println();

		/* 지역구 분리 완료 && 분리된 지역구 2 구역에 대해서 탐색 진행해서 가중치의 합 구하기 + 가능 여부 (all visited 확인) */
		boolean[] d_visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) { // true 인 지역구 전체 순회
			if (v[i] == true) {
				dfs(i,d_visited,true);
				//System.out.println();
				break; // 모든 true에 접근해야 하므로 하나에 대해서만 진행
			}
		}
		
		for (int i = 1; i <= n; i++) { // false 인 지역구 전체 순회
			if (v[i] == false) {
				dfs(i,d_visited,false);
				//System.out.println();
				break; // 모든 false에 접근해야 하므로 하나에 대해서만 진행
			}
		}

//		for (int i = 1; i <= n; i++) {
//		System.out.print(d_visited[i] + " ");
//		}System.out.println();
//		
//		System.out.println("true  합 : " + true_sum);
//		System.out.println("false 합 : " + false_sum);
		
		// flag 만 잘 두면 될거 같은데 어떻게 해야할까요
		
		d_flag = 0; // 모든 접점을 방문했으면 0 아니면 1
		for (int i = 1; i <= n; i++) {
			if(d_visited[i] == false) { // 방문하지 않은 접점 확인
				//System.out.println("-1은 아니겠네!");
				d_flag = 1; // 방문하지 않은 접점이 하나라도 있으면 1
				break; // 나머지는 돌 필요 없지
			}
		}
		
		if(d_flag == 0) {// 모든 접점 방문했을때만
			flag = 1; // 답이 -1은 아니겠네
			//System.out.println("비교 실행");
			last_flag = 1; //1일때만 숫자 표시 아니면 -1
			min_diff = Math.min(min_diff, Math.abs(true_sum - false_sum));
		}
		

		
		
		
	}

	public static void dfs(int index, boolean[] d_visited, boolean istrue) {
		// TODO Auto-generated method stub
		d_visited[index] = true; // 방문했음
		//System.out.print(index + " ");
		if(istrue == true)
			true_sum += res[index];
		else if (istrue == false)
			false_sum += res[index];
		
		for (int x = 1; x <= n; x++) {
			if(connected[index][x] == 1 && d_visited[x] == false && v[x] == istrue)
				dfs(x,d_visited,istrue);
		}
		//할일 : dfs 돌고 난 후 접근하지 못한 점 있는지 확인
	}
}

/*
 * 
 * 6 5 2 3 4 1 2 2 2 4 4 1 3 6 5 2 4 2 2 1 3 1 2 1 2
 * 
 */
