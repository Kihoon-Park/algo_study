package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_B4949_균형잡힌세상 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String s = bf.readLine();
			if (s.equals("."))
				break;

			/* 연산 시작 */
			System.out.println(s);

			Stack<Character> st = new Stack<Character>();
			boolean result = true;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(') {
					st.push(s.charAt(i));
				} else if (s.charAt(i) == '[') {
					st.push(s.charAt(i));
				}

				else if (s.charAt(i) == ')') {
					if (st.size() == 0 || st.pop() != '(') {
						result = false;
						break;
					}
				}

				else if (s.charAt(i) == ']') {
					if (st.size() == 0 || st.pop() != '[') {
						result = false;
						break;
					}
				}
			}
			if (!st.isEmpty()) {
				result = false;
			}
			if (result)
				System.out.println("yes");
			else
				System.out.println("no");
		} // end of while
	}

}
