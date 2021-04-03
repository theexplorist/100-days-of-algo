import java.util.*;

public class Main {

	private static boolean isPossible(int[] stalls, int dis, int c) {
		// TODO Auto-generated method stub
		int prev = stalls[0];
		int numC = 1;
		
		for(int i = 1; i < stalls.length; i++) {
			
			if(c == numC) {
				return true;
			}
			int curr = stalls[i];
			if(curr - prev >= dis) {
				numC++;
				prev = curr;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int c = s.nextInt();
		
		int[] stalls = new int[n];
		
		for(int i = 0; i < n; i++) {
			stalls[i] = s.nextInt();
		}

		Arrays.sort(stalls);
		
		int l = 0, r = stalls[n - 1] - stalls[0];
		
		while(r > l + 1) {
			
			int mid = (l + r) / 2;
			if(isPossible(stalls, mid, c)) {
				l = mid;
			} else {
				r = mid;
			}
		}
		
		System.out.println(l);
	}

}
