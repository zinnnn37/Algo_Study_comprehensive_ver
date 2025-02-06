package week3;

import java.io.*;
import java.util.Arrays;

public class Q2GoldBachConjecture {
	
	static boolean[]	isPrime = new boolean[10001];

	public static void main(String[] args) throws IOException {
		
		sol();
	}
	
	private static void sol() throws NumberFormatException, IOException {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder	sb = new StringBuilder();
		
		int	T = Integer.parseInt(br.readLine());
		calcPrime();
		
		for (int tc = 0; tc < T; tc++) {
			int	n = Integer.parseInt(br.readLine());

			int	start = n / 2;
			int	end = n / 2;
            while (start >= 2) {
                if (isPrime[start] && isPrime[end]) break;
                
                start--;
                end++;
            }
			
			sb.append(start).append(' ').append(end).append('\n');
		}
		System.out.println(sb);
	}
	
	private static void calcPrime() {
		Arrays.fill(isPrime, 2, 10000, true);
		
		for (int i = 0; i * i <= 10000; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= 10000; j += i) {
					isPrime[j] = false; 
				}
			}
		}
	}

}
