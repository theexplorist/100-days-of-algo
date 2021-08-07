package class25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary {

	static class Graph {

		Map<Character, List<Character>> adjL;

		int v;
		public Graph(int v) {
			this.adjL = new HashMap<>();
			this.v = v;
		}

		private void addEdge(String[] dict, int n, int k) {
			// TODO Auto-generated method stub

			for (int i = 0; i < n - 1; i++) {
				String x = dict[i];
				String y = dict[i + 1];

				int j = 0;

				while (j < Math.min(x.length(), y.length())) {

					if (x.charAt(j) != y.charAt(j)) {
						List<Character> neighbourL = this.adjL.getOrDefault(x.charAt(j), new ArrayList<>());
						neighbourL.add(y.charAt(j));
						this.adjL.put(x.charAt(j), neighbourL);
						break;
					}

					j++;
				}
			}
		}

		private int[] indegree() {
			// TODO Auto-generated method stub
			int[] indegree = new int[this.v];
			
			for(List<Character> neighbourL : this.adjL.values()) {
				for(char c : neighbourL) {
					indegree[c - 'a']++;
				}
			}

			System.out.println(Arrays.toString(indegree));
			return indegree;
		}
		
		private void topologicalSorting() {
			// TODO Auto-generated method stub

			Queue<Character> bfs = new LinkedList<>();
			int[] indegree = this.indegree();
			for(int i = 0; i < indegree.length; i++) {
				if(indegree[i] == 0) {
					bfs.add((char)(i + 'a'));
				}
			}
			
			while(!bfs.isEmpty()) {
				char front = bfs.poll();
				
				System.out.print(front + " ");
				
				for(char neighbour : this.adjL.getOrDefault(front, new ArrayList<>())) {
					indegree[neighbour - 'a']--;
					
					if(indegree[neighbour - 'a'] == 0) {
						bfs.add(neighbour);
					}
				}
			}
		}
		private void display() {
			// TODO Auto-generated method stub

			for (var entry : this.adjL.entrySet()) {
				System.out.println(entry.getKey() + " -> " + entry.getValue());
			}
		}

	}

	public static void main(String[] args) {
		int n = 5;
		int k = 4;
		Graph g = new Graph(k);
		String[] s = { "baa", "abcd", "abca", "cab", "cad" };
		

		g.addEdge(s, n, k);
		g.display();
		g.indegree();
		g.topologicalSorting();

	}
}
