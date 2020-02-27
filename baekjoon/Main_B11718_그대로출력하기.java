package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B11718_그대로출력하기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String str = bf.readLine();
			if(str == null)
				break;
			System.out.println(str);
		}
	}

}
