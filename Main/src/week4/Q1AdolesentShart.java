package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q1AdolesentShart {
	
	// ↑, ↖, ←, ↙, ↓, ↘, →, ↗
	private static final int[]	dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	private static final int[]	dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	
	private static int	sum;
	private static int	maxSum;
	
	private static Shark	shark;
	
	private static int[][]					fishArr;
	private static HashMap<Integer, Fish>	fishMap;
	
	static enum Dir {
		UP(1),
		UPLEFT(2),
		LEFT(3),
		DOWNLEFT(4),
		DOWN(5),
		DOWNRIGHT(6),
		RIGHT(7),
		UPRIGHT(8);
		
		public final int value;

		Dir(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
	}
	
	static class Fish {
		int		x;
		int		y;
		int		dir;
		boolean	isAlive;
		
		Fish(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.isAlive = true;
		}
		
		void update() {
			isAlive = false;
		}
	}
	
	static class Shark {
		int	x;
		int	y;
		int	dir;
		
		Shark() {
			this.x = 0;
			this.y = 0;
			this.dir = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}
	
	private static void init() throws IOException {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer	st;
		
		shark = new Shark();
		
		fishArr = new int[4][4];
		fishMap = new HashMap<>();
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int	key = Integer.parseInt(st.nextToken());
				int	dir = Integer.parseInt(st.nextToken());
				
				fishArr[i][j] = key; 
				fishMap.put(key, new Fish(i, j, dir));
			}
		}
	}
	
	private static void sol() {
		// start to eat
		int		key = fishArr[0][0];
		Fish	eaten = fishMap.get(key);

		fishArr[0][0] = 0;
		shark.dir = eaten.dir;
		eaten.update();
		
		
		moveFish();
	}
	
	private static void moveFish() {
		for (int i = 0; i <= 16; i++) {
			Fish	curFish = fishMap.get(i);
			
			// if dead
			if (!(curFish.isAlive)) continue;
			
			
		}
	}
	
	private static boolean isValidPoint(int x, int y) {
		return 0 <= x && x < 4 && 0 <= y && y < 4;
	}
	
}
