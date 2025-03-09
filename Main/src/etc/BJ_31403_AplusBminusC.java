package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_31403_AplusBminusC {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static int A;
	private static int B;
	private static int C;

	public static void main(String[] args) throws IOException {
		A = Integer.parseInt(br.readLine());
		B = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());

		System.out.println(A + B - C);
		System.out.println(jsCalc());
	}

	private static int jsCalc() {
		String str = "";

		str += A;
		str += B;

		return Integer.parseInt(str) - C;
	}
}
