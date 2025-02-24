package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_B02_이진수_표현 {
	
	private static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder   sb = new StringBuilder();
	private static StringTokenizer st;
	
	private static int N;
	private static int M;
	
	public static void main(String[] args) throws IOException {
		sol();
	}
	
	private static void sol() throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			init();
			sb.append('#').append(tc).append(checkBit() ? " ON\n" : " OFF\n");
		}
		System.out.println(sb.toString());
		
		br.close();
	}
	
	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	}
	
	private static boolean checkBit() {
		int len = findLength();
		
		if (N > len) return false;
		
		int mask = (1 << N) - 1; // 우선순위 제발,,
		
		return (mask & M) == mask; // 비교값이 모두 1일 때
	}
	
	private static int findLength() {
		int tmp = M;
		int len = 0;
		
		while (tmp > 0) {
			tmp /= 2;
			len++;
		}
		
		return len;
	}

}
