
import java.util.*;

public class Main {

	public static long sol(int n, long[] dp) {
		
		if(n == 1) {
			return 2;
		}
		
		if(n == 2) {
			return 3;
		}
		
		if(dp[n] != -1) {
			return dp[n];
		}
		long c1 = sol(n - 1, dp);
		long c2 = sol(n - 2, dp);
		
		return dp[n] = c1 + c2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- != 0) {
			
			int n = sc.nextInt();
		    long[] dp = new long[n + 1];
			Arrays.fill(dp, -1);
			System.out.println(sol(n, dp));
		}
	}
}
