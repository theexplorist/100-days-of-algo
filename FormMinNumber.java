import java.util.Scanner;
import java.util.Stack;

public class Tester {

	public static void solution(String num) {

		StringBuilder sb = new StringBuilder();
		for (char c : num.toCharArray()) {
			if (Character.getNumericValue(c) % 2 == 0) {
				sb.append('I');
			} else {
				sb.append('D');
			}
		}

		String conv = sb.toString();

		Stack<Integer> st = new Stack<>();

		for (int i = 0; i <= conv.length(); i++) {
			st.push(i + 1);

			if (i == conv.length() || conv.charAt(i) == 'I') {
				while (!st.isEmpty()) {
					System.out.print(st.pop());
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String str = sc.next();
			solution(str);
		}
	}

}
