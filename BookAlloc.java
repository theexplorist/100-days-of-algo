import java.util.Scanner;

public class Main {

	private static boolean isValid(int[] pages, int mid, int st) {
		// TODO Auto-generated method stub
		int num = 1;
		int numP = 0;
		
		int i = 0;
		while(i < pages.length) {
			
			if(numP + pages[i] <= mid) {
				numP += pages[i];
				i++;
			} else {
				numP = 0;
				num++;
			}
			
			if(num > st) {
				return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		int t = s.nextInt();

		while (t-- != 0) {
			int n = s.nextInt();
			int st = s.nextInt();

			int[] pages = new int[n];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				pages[i] = s.nextInt();
				sum += pages[i];
			}
			
			int l = 0, r = sum;
			
			while(r > l + 1) {
				int mid = l +  (r - l) / 2;
				
				if(isValid(pages, mid, st)) {
					r = mid;
				} else {
					l = mid;
				}
			}
			
			System.out.println(r);
		}
	}

}
