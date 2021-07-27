package com.chitkara.greedycont;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//Activity Selection Problem/Job Scheduling
public class Busy {

	static class Pair {
		int start;
		int end;

		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "start is " + start + " end is " + end;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int t = s.nextInt();

		// for(int i = 0; i < t; i++)
		while (t-- != 0) {
			int n = s.nextInt();

			List<Pair> activities = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				int start = s.nextInt();
				int end = s.nextInt();

				activities.add(new Pair(start, end));
			}

			//System.out.println(activities);

			// Sort on the basis of inc order of end time

			Collections.sort(activities, new Comparator<Pair>() {

				@Override
				public int compare(Pair o1, Pair o2) { // this -> o1, other -> o2
					// TODO Auto-generated method stub
					return o1.end - o2.end;
				}

			});
			
			System.out.println(activities);
			
			//Choose first activity
			int count = 1;
			int currEnd = activities.get(0).end; //e1
			
			//Check for other activities
			for(int i = 1; i < activities.size(); i++) {
				int st = activities.get(i).start; //ith ka start nikala or s2
				
				if(st >= currEnd) {
					//chunlo ith ko
					count++;
					currEnd = activities.get(i).end;
				}
				
			}
			
			System.out.println(count);
		}
	}

}
