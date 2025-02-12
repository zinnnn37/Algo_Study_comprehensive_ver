package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q3Wormhole {
	
	private static final int	INF = 50000000;

	private static int	tc;
	private static int	N;
	private static int	M;
	private static int	W;
	
	private static int[]		time;
	private static List<Data>[]	graph;
	
	private static BufferedReader	br;
	private static StringTokenizer	st;
	
	static class Data {
		int	start;
		int	end;
		int	time;
		
		Data(int start, int end, int time) {
			this.start = start;
			this.end = end;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		sol();		
	}
	
	private static void sol() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			init();
			
			if (bellmanFord()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	
	private static void init() throws IOException {
		// vertexes, edges, wormholes
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		// init Data Structure
		graph = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		time = new int[N+1];
		
		// road
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int	S = Integer.parseInt(st.nextToken());
			int	E = Integer.parseInt(st.nextToken());
			int	T = Integer.parseInt(st.nextToken());
			
			graph[S].add(new Data(S, E, T));
			graph[E].add(new Data(E, S, T));
		}
		
		// wormholes
		for (int i = 0; i < W; i++) {
			st = new StringTokenizer(br.readLine());
			
			int	S = Integer.parseInt(st.nextToken());
			int	E = Integer.parseInt(st.nextToken());
			int	T = Integer.parseInt(st.nextToken()) * -1;
			
			graph[S].add(new Data(S, E, T));
		}
	}
	
	static boolean bellmanFord() {
		boolean	updated = false;
		// check N-1 times
		for (int u = 1; u < N+1; u++) {
			updated = false;
			for (int v = 1; v < N+1; v++) {
				for (Data d : graph[v]) {
					if (time[d.start] != INF && time[d.end] > time[d.start] + d.time) {
						time[d.end] = time[d.start] + d.time;
						updated = true;
					}
				}
			}
			if (!updated) break;
		}
		return updated;
	}
	
}
