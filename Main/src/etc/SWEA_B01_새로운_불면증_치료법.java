package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_B01_새로운_불면증_치료법 {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder  sb = new StringBuilder();;
	
	private static int N;
	private static int cnt;
	private static int ans;
	
	private static boolean[] checkNum;
	
	public static void main(String[] args) throws IOException {
		sol();
	}
	
	private static void sol() throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			init();

			countingSheep();
			
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb.toString());
	}
	
	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		cnt = 0;
		ans = 0;
		checkNum = new boolean[10];
	}
	
	private static void countingSheep() {
		int multi = 1;
		
		while (cnt != 10) {
			int tmp = N * multi++;
			
			countDigit(tmp);
			ans = tmp;
		}
	}
	
	private static void countDigit(int tmp) {
		while (tmp > 0) {
			int mod = tmp % 10;
			
			if (!checkNum[mod]) cnt++;

			checkNum[mod] = true;
			tmp /= 10;
		}
	}

}
