package week3;

import java.io.*;
import java.util.*;

public class Q5GasStation {

	private static int	N;
	
	private static int[]	road;
	private static int[]	gas;
	
	public static void main(String[] args) throws IOException {
		
		init();
		sol();
		
	}
	
	private static void init() throws IOException {
		
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer	st;
		
		N = Integer.parseInt(br.readLine());
		
		road = new int[N-1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N-1; i++) {
			road[i] = Integer.parseInt(st.nextToken()); 
		}
		
		gas = new int[N-1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N-1; i++) {
			gas[i] = Integer.parseInt(st.nextToken());
		}
		st.nextElement();	// 버림
	}
	
	private static void sol() {

		int cur;
		int lowest = gas[0];
		int total = gas[0] * road[0];
		
		for (int i = 1; i < N-1; i++) {
			cur = gas[i];
			
			if (cur < lowest) lowest = cur;
			
			total += lowest * road[i];
		}
		
		System.out.println(total);
	}

}
