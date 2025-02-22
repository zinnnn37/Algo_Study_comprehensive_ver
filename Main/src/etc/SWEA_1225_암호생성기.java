package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1225_암호생성기 {

	private static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder   sb;

	private static int N;
	private static int s;

	private static int[] pw;

	public static void main(String[] args) throws IOException {
		sol();
	}

	private static void sol() throws IOException {
		for (int tc = 1; tc <= 10; tc++) {
			init();
			cycle();
			printPW(tc);
		}

		br.close();
	}

	private static void init() throws IOException {
		sb = new StringBuilder();

		N  = Integer.parseInt(br.readLine());
		s  = 0;
		st = new StringTokenizer(br.readLine());

		pw = new int[8];
		for (int i = 0; i < 8; i++) {
			pw[i] = Integer.parseInt(st.nextToken());
		}
	}

	private static void cycle() {
		int idx   = 0;
		int minus = 1;

		while (true) {
			pw[idx % 8] -= minus;

			if (pw[idx % 8] <= 0) {
				pw[idx % 8] = 0;

				s = (idx + 1) % 8;
				break;
			}

			idx++;
			minus = (minus % 5) + 1;
		}
	}

	private static void printPW(int tc) {
		sb.append("#").append(tc);

		int cnt = 0;
		while (cnt++ < 8) {
			sb.append(' ').append(pw[s++ % 8]);
		}

		System.out.println(sb.toString());
	}
}