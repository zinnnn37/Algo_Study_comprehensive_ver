package etc;

import java.awt.BorderLayout;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BomBerMan2_BJ16919 {

	private static final int[]	dx = { -1, 1, 0, 0 };
	private static final int[]	dy = { 0, 0, -1, 1 };
	
	private static int	R;
	private static int	C;
	private static int	N;
	
	private static char[][][]	map;
	
	private static StringBuilder	sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

        BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer	st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new char[3][R][C];
		
		for (int i = 0; i < R; i++) {
			String	input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[0][i][j] = input.charAt(j); 
			}
		}
		
		for (int i = 0; i < 2; i++)
			fillMap(i, i+1);
		
		if (N == 1) printMap(map[0]);
		else if (N % 4 == 3) printMap(map[1]);
		else if (N % 2 == 0) printEvenMap();
		else if (N % 4 == 1) printMap(map[2]);
	}
	
	private static void fillMap(int cur, int nxt) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// if bomb
				if (map[cur][i][j] == 'O') {
					map[nxt][i][j] = '.';
					
					for (int d = 0; d < 4; d++) {
						int	nx = i + dx[d];
						int	ny = j + dy[d];
						
						if (checkValid(nx, ny))
							map[nxt][nx][ny] = '.';
					}
				}
			}
		}
		
		fillBlank(nxt);
	}
	
	private static void fillBlank(int idx) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[idx][i][j] == '\0') {
					map[idx][i][j]= 'O'; 
				}
			}
		}
	}
	
	private static boolean checkValid(int i, int j) {
		return 0 <= i && i < R && 0 <= j && j < C;
	}
	
	private static void printMap(char[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				sb.append(mat[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	private static void printEvenMap() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append('O');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}