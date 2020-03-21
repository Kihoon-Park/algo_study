package baekjoon;

import java.util.Scanner;

public class Main_B1316_그룹단어체커 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		String str;
		
		int tmp;
		int count = N;
		for (int word = 0; word < N; word++) {
			str = sc.next();
			boolean[] isV = new boolean[28];
			
			
			for (int i = 0; i < str.length(); i++) {
				tmp = (int)str.charAt(i)-97;
				if(isV[tmp] == true) { // 이미 isV에 저장된 단어 발견 == 그룹 단어 아님
					//System.out.println("그룹단어 아님");
					count--; // 그룹 단어가 아니면 전체 count-1
					break;
				}else {
					isV[tmp] = true; // 발견한 단어 isV배열에 저장
					while(i+1 < str.length() && tmp == (int)str.charAt(i+1)-97) { // 같은 묶음 패스
						//System.out.println("아이는 " + i);
						i++;
					}
				}
					
			}
			
		}
		System.out.println(count);
	}

}
