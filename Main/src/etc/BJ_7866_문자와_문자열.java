package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_7866_문자와_문자열 {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static int    idx;
	private static String input;

	public static void main(String[] args) throws IOException {
		input = br.readLine();
		idx   = Integer.parseInt(br.readLine()) - 1;

		System.out.println(input.charAt(idx));
	}

}
