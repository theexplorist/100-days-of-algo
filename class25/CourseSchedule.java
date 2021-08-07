package class25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {

	static class Graph {

		// vertex - list of neighbours to that vertex
		Map<Integer, List<Integer>> adjList;

		int numV;

		public Graph(int numV) {
			adjList = new HashMap<>();
			this.numV = numV;
		}

		// u and v mein add edge
		// isBidir = true -> undirected edge, false -> directed edge
		private void addEdge(int u, int v, boolean isBidir) {
			// TODO Auto-generated method stub

			// u -> v edge 1 -> 2

			// 1 ki neighbour list
			List<Integer> uNeighbour = this.adjList.getOrDefault(u, new ArrayList<>());
			uNeighbour.add(v);
			this.adjList.put(u, uNeighbour);

			if (isBidir) {
				// v -> u edge 2 -> 1

				// 2 ki neighbour list
				List<Integer> vNeighbour = this.adjList.getOrDefault(v, new ArrayList<>());

				// 2 ka neighbour 1
				vNeighbour.add(u);

				this.adjList.put(v, vNeighbour);
			}

		}

		private void display() {
			// TODO Auto-generated method stub

			for (Map.Entry<Integer, List<Integer>> entry : this.adjList.entrySet()) {
				int vertex = entry.getKey();
				List<Integer> neighbourList = entry.getValue();
				System.out.println(vertex + " -> " + neighbourList);
			}
		}

		private int[] indegree() {
			// TODO Auto-generated method stub

			int[] indegree = new int[numV];

			for (List<Integer> neighbourList : this.adjList.values()) {

				for (int neighbour : neighbourList) {
					indegree[neighbour]++;
				}
			}

			System.out.println(Arrays.toString(indegree));
			return indegree;
		}

		private void topologicalSorting() {
			// TODO Auto-generated method stub
			Queue<Integer> bfs = new LinkedList<>();
			int[] indegree = indegree();

			for (int vertex = 0; vertex < numV; vertex++) {
				if (indegree[vertex] == 0) {
					bfs.add(vertex);
				}
			}

			while (!bfs.isEmpty()) {
				int frontV = bfs.poll();

				System.out.print(frontV + " ");

				List<Integer> neighbourList = this.adjList.getOrDefault(frontV, new ArrayList<>());

				for (int neighbour : neighbourList) {
					indegree[neighbour]--;

					if (indegree[neighbour] == 0) {
						bfs.add(neighbour);
					}
				}
			}

			// System.out.println(bfs);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph g = new Graph(4);

		int[][] courses = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };

		for (int i = 0; i < courses.length; i++) {
			g.addEdge(courses[i][1], courses[i][0], false);
		}
		g.display();
		g.topologicalSorting();

	}
}
