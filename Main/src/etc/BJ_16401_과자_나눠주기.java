import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_16401_과자_나눠주기 {
	
	private static int N;	// nephew
	private static int M;	// num of cookie
	private static int ans;
	
	private static List<Integer> cookies;

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
		
		cookies = new ArrayList<>();
		pq      = new PriorityQueue<>(Collections.reverseOrder());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < N; i++) {
			if (pq.isEmpty()) break;
			
			int c = pq.poll();
			
			cookies.add(c);
			// 쿠키는 큰 것부터 들어가있음!
		}
	}
	
	private static void findLongestCookie() {
		if (cookies.isEmpty()) {
			System.out.println(0);
			return ;
		}
		
		int left  = 1;
		int right = cookies.get(0); // longest cookie
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			
			int cnt = 0;
			
			for (int cookie : cookies) {
				cnt += cookie / mid;
			}
			
			// N명에게 돌아가면 길이 키우기
			if (cnt >= N) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}

}