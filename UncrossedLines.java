import java.util.Arrays;
import java.util.Scanner;

public class LCS {

	public static int lCS(String s1, String s2, int l1, int l2) {

		if (l1 == 0 || l2 == 0) {
			return 0;
		}
		if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
			return 1 + lCS(s1, s2, l1 - 1, l2 - 1);
		} else {
			int c1 = lCS(s1, s2, l1 - 1, l2);
			int c2 = lCS(s1, s2, l1, l2 - 1);

			return Math.max(c1, c2);
		}
	}

	public static int uCL(int[] s1, int[] s2, int l1, int l2, int[][] dp) {

		if (l1 == 0 || l2 == 0) {
			return 0;
		}
		
		if(dp[l1][l2] != -1) {
			return dp[l1][l2];
		}
		
		if (s1[l1 - 1] == s2[l2 - 1]) {
			return dp[l1][l2] = 1 + uCL(s1, s2, l1 - 1, l2 - 1, dp);
		} else {
			int c1 = uCL(s1, s2, l1 - 1, l2, dp);
			int c2 = uCL(s1, s2, l1, l2 - 1, dp);

			return dp[l1][l2] = Math.max(c1, c2);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		
		int[] X = new int[N];
		int[] Y = new int[M];
		
		int[][] dp = new int[X.length + 1][Y.length + 1];
		
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		for(int i = 0; i < N; i++) {
			X[i] = s.nextInt();
		}
		
		for(int i = 0; i < M; i++) {
			Y[i] = s.nextInt();
		}
		
		System.out.println(uCL(X, Y, X.length, Y.length, dp));
	}

}
