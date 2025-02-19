package etc;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BomBerMan2 {

	public static void main(String[] args) throws IOException {
		int[]	dx = { -1, 1, 0, 0 };
		int[]	dy = { 0, 0, -1, 1 };

        BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer	st = new StringTokenizer(br.readLine());
		
		int	r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		String[][]	mine = new String[r][c];
		String[][]	all = new String[r][c];
		String[][]	reverse = new String[r][c];
		String[][]	forward = new String[r][c];
		
		for (int i = 0; i < r; i++) {
			mine[i] = br.readLine().split("");
		}
		
		Queue<Point>	q = new ArrayDeque<>();
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				all[i][j] = "O";
				reverse[i][j] = mine[i][j].equals(".") ? "O" : ".";
				if (reverse[i][j].equals(".")) q.offer(new Point(i, j));
			}
		}
		
		while (!q.isEmpty()) {
			Point	cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int	nx = cur.x + dx[d];
				int	ny = cur.y + dy[d];
				
				if (0 <= nx && nx < r && 0 <= ny && ny < c) {
					reverse[nx][ny] = ".";
				}
			}
		}
		
		for (int i = 0; i < r; i++) {
			Arrays.fill(forward[i], "O");
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (reverse[i][j].equals("."))
					q.offer(new Point(i, j));
			}
		}
		
		while (!q.isEmpty()) {
			Point	cur = q.poll();

			forward[cur.x][cur.y] = ".";
			
			for (int d = 0; d < 4; d++) {
				int	nx = cur.x + dx[d];
				int	ny = cur.y + dy[d];
				
				if (0 <= nx && nx < r && 0 <= ny && ny < c) {
					forward[nx][ny] = ".";
				}
			}
		}
		
		if (n == 1) printMat(mine);
		else if (n % 4 == 3) printMat(reverse);
		else if (n % 2 == 0) printMat(all);
		else if (n % 4 == 1) printMat(forward);
	}
	
	private static void printMat(String[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
	}

}