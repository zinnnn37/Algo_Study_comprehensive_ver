package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q1AdolesentShart {
	
	// ↑, ↖, ←, ↙, ↓, ↘, →, ↗
	private static final int[]	dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	private static final int[]	dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	
	private static int	maxSum;
	
	private static Shark	shark;

	private static int[][]					fishArr;
	private static HashMap<Integer, Fish>	fishMap;
	private static int[][]                  fishArrCopy;
	private static HashMap<Integer, Fish>   fishMapCopy;

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
		
		void setIsAlive(boolean isAlive) {
			this.isAlive = isAlive;
		}

		void updatePoint(int x, int y) {
			this.x = x;
			this.y = y;
		}

		void updateDir(int dir) {
			this.dir = dir;
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

		// initial eating
		fishArr[0][0] = -1;
		shark.dir = eaten.dir;
		eaten.setIsAlive(false);

		moveShark(0);

		System.out.println(maxSum);
	}

	private static void moveShark(int total) {
		// update maximum value
		maxSum = Math.max(maxSum, total);

		fishArrCopy = new int[4][4];
		fishMapCopy = new HashMap<Integer, Fish>();

		deepCopy();
		moveFish();

		// can move 1~3
		for (int i = 1; i < 4; i++) {
			int nx = shark.x + dx[shark.dir] * i;
			int ny = shark.y + dy[shark.dir] * i;

			if (!isValidPoint(nx, ny) || fishArrCopy[nx][ny] <= 0) continue;

			// prev data of shark
			int prevX = shark.x;
			int prevY = shark.y;
			int prevDir = shark.dir;

			// eat
			int     target = fishArrCopy[nx][ny];
			Fish	targetFish = fishMap.get(target);

			fishArrCopy[nx][ny] = -1;
			targetFish.setIsAlive(false);
			shark.x = nx;
			shark.y = ny;
			shark.dir = targetFish.dir;

			moveShark(total + target);

			shark.dir = prevDir;
			shark.y = prevY;
			shark.x = prevX;
			targetFish.setIsAlive(true);
			fishArrCopy[nx][ny] = target;
		}

		fishArr = fishArrCopy;
		fishMap = fishMapCopy;
	}

	private static void moveFish() {
		for (int i = 1; i <= 16; i++) {
			Fish	curFish = fishMap.get(i);

			// if dead
			if (!(curFish.isAlive)) continue;

			int x = curFish.x;
			int y = curFish.y;
			int dir = curFish.dir;

			// rotate fish
			for (int d = 0; d < 8; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				int nxtDir = (dir + d) % 8;

				// out of bound
				if (!isValidPoint(nx, ny) || fishArrCopy[nx][ny] == -1) continue;

				// blank
				if (fishArrCopy[nx][ny] == 0) {
					curFish.updatePoint(nx, ny);
					fishArrCopy[nx][ny] = i;
					fishArrCopy[x][y] = 0;
					break;
				}

				// other fish
				int     target = fishArrCopy[nx][ny];
				Fish    targetFish = fishMapCopy.get(target);

				// switch value
				fishArrCopy[nx][ny] = i;
				fishArrCopy[x][y] = target;
				curFish.updatePoint(nx, ny);
				targetFish.updatePoint(x, y);
				curFish.updateDir(nxtDir);

				break;
			}
		}
	}

	private static void deepCopy() {
		for (int i = 0; i < 4; i++) {
			fishArrCopy[i] = Arrays.copyOf(fishArr[i], 4);
		}

		for (int key : fishMap.keySet()) {
			Fish    curFish = fishMap.get(key);
			Fish	newFish = new Fish(curFish.x, curFish.y, curFish.dir);

			fishMapCopy.put(key, newFish);
			newFish.updateDir(curFish.dir);
		}
	}

	private static boolean isValidPoint(int x, int y) {
		return 0 <= x && x < 4 && 0 <= y && y < 4;
	}

}
