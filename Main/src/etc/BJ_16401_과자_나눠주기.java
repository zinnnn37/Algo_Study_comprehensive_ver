package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16401_과자_나눠주기 {

	private static int N;    // nephew
	private static int M;    // num of cookie
	private static int ans;
	private static int max;

	private static int[] cookies;

	public static void main(String[] args) throws IOException {
		sol();
	}

	private static void sol() throws IOException {
		init();
		findLongestCookie();
	}

	private static void init() throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		max     = 0;
		cookies = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			cookies[i] = Integer.parseInt(st.nextToken());
			max        = Math.max(max, cookies[i]);
		}
	}

	private static void findLongestCookie() {
		int left  = 0;
		int right = max;
		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (mid == 0) {
				left++;
				mid++;
			}

			int cnt = 0;

			for (int cookie : cookies) {
				cnt += cookie / mid;
			}

			// N명에게 돌아가면 길이 키우기
			if (cnt >= N) {
				ans  = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}

}