package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

enum State {
	UP(1),
	DOWN(2),
	LEFT(3),
	RIGHT(4);

	private final int value;

	State(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}

public class Q1AdultShark {

	private static final int[] dx = {-1, 1, 0, 0};
	private static final int[] dy = {0, 0, -1, 1};

	private static int N;  // size
	private static int M;  // nums of shark
	private static int K;  // duration

	private static Shark[]   sharks; // manage shark
	private static Block[][] matrix;
	private static int[][][] priorities;

	public static void main(String[] args) throws IOException {
		sol();
	}

	private static void sol() throws IOException {
		init();
		simul();
	}

	private static void init() throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// TODO 상어 아이디 0부터!!!!!!!!
	}

	private static void simul() {
		int time = -1;

		while (++time <= 1000) {
			if (isOneSharkLeft()) {
				System.out.println(time);
				return;
			}

			moveShark();
			decreaseDurationOfSmell();
		}
		System.out.println(-1);
	}

	private static boolean isOneSharkLeft() {
		// logic,,
		return true;
	}

	private static void moveShark() {
		for (int i = 0; i < M; i++) {

		}
	}

	private static void decreaseDurationOfSmell() {
		// TODO 상어 없는데 냄새는 있는 곳 decreaseDuration()
	}

	private static class Shark {
		int   id;
		int   x;
		int   y;
		State dir;
	}

	private static class Block {
		int   sentOf;
		int   duration;
		Shark shark;

		Block(int sentOf, int duration, Shark shark) {
			this.sentOf = sentOf;
			this.duration = duration;
			this.shark = shark;
		}

		public void decreaseDuration() {
			duration--;
		}

		public void setDuration(int duration) {
			this.duration = duration;
		}

		public void setShark(Shark shark) {
			this.shark = shark;
		}

		public boolean isSmellRemain() {
			return duration > 0;
		}

		public void setNewSmell(int sharkId) {
			this.sentOf = sharkId;
			this.duration = K;
		}
	}

}
