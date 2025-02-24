package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1Kitty {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static int    N;
	private static int    len;
	private static int    ans;
	private static String str;
	
	private static int[] cnt;

	public static void main(String[] args) throws IOException {
		sol();
	}
	
	private static void sol() throws IOException {
		init();
		kitty();
		
		System.out.println(ans);
	}

	private static void init() throws IOException {
		N   = Integer.parseInt(br.readLine());
		str = br.readLine().strip();
		len = str.length();
		ans = 0;
		
		cnt = new int[26];
	
		br.close();
	}
	
	
	private static void kitty() {
		int left   = 0;
		int right  = 0;
		int tmpLen = 1;
		int alpha  = 1;
		
		cnt[str.charAt(0) - 'a'] = 1;
		
		while (++right < len) {
			if (str.charAt(right-1) != str.charAt(right)) {
				// alr exists
				if (cnt[str.charAt(right-1) - 'a'] > 0) {
					tmpLen++;
					
					cnt[str.charAt(right) - 'a']++;
				} else {
					alpha++;
					
					if (alpha > N) {
						cnt[str.charAt(left++) - 'a']--;
					}
				}
			} else {
				cnt[str.charAt(right) - 'a']++;
				tmpLen++;
			}
			
			ans = Math.max(ans, tmpLen);
		}
	}
	
}
