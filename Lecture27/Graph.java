package Lecture27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import Lecture24.Heap;

public class Graph {
	private class Edge {
		Vertex one;
		Vertex two;
		int weight;

		Edge(Vertex one, Vertex two, int weight) {
			this.one = one;
			this.two = two;
			this.weight = weight;
		}
	}

	private class Vertex {
		String name;
		HashMap<Vertex, Edge> adjVer;

		Vertex(String name) {
			this.name = name;
			this.adjVer = new HashMap<>();
		}

		@Override
		public int hashCode() {
			return this.name.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			Vertex ov = (Vertex) obj;
			return this.name.equals(ov.name);
		}

		void addEdge(Edge edge) {
			Vertex otr;
			if (edge.one == this) {
				otr = edge.two;
			} else if (edge.two == this) {
				otr = edge.one;
			} else {
				// throw Exception
				return;
			}
			if (this.isAdjascent(otr)) {
				// throw
				return;
			}
			this.adjVer.put(otr, edge);

		}

		void removeEdgewith(Vertex other) {
			this.adjVer.remove(other);
		}

		boolean isAdjascent(Vertex other) {
			if (!this.adjVer.isEmpty()) {
				return this.adjVer.containsKey(other);
			} else {
				return false;
			}
		}

		ArrayList<Vertex> getNeighbourVertices() {
			return new ArrayList<>(this.adjVer.keySet());
		}

		@Override
		public String toString() {
			String rv = "";
			rv += this.name + " => ";
			ArrayList<Vertex> vertices = this.getNeighbourVertices();
			for (Vertex ver : vertices) {
				rv += ver.name + ", ";
			}
			String ret = rv.substring(0, rv.length() - 2);
			return ret;
		}
	}

	private ArrayList<Vertex> vertices;
	private int numEdges;

	public Graph() {
		this.numEdges = 0;
		this.vertices = new ArrayList<>();
	}

	public int countVertices() {
		return this.vertices.size();
	}

	public void addVertex(String name) {
		if (this.containsVertex(name)) {
			return;
		} else {
			Vertex vtba = new Vertex(name);
			this.vertices.add(vtba);
		}
	}

	public void addVertices(String[] names) {
		for (String name : names) {
			this.addVertex(name);
		}
	}

	public void removeVertex(String name) {
		if (!this.containsVertex(name)) {
			return;
		} else {
			Vertex vtbr = this.getVertex(name);
			ArrayList<Vertex> neighbour = vtbr.getNeighbourVertices();
			for (Vertex neigh : neighbour) {
				neigh.removeEdgewith(vtbr);
				this.numEdges--;
			}
			this.vertices.remove(vtbr);
		}
	}

	public boolean containsVertex(String name) {
		Vertex vrtx = this.getVertex(name);
		return vrtx != null;
	}

	private Vertex getVertex(String name) {
		Vertex rv = null;

		ArrayList<Vertex> list = this.vertices;

		for (Vertex lis : list) {
			if (lis.name.equals(name)) {
				rv = lis;
				break;
			}
		}

		return rv;
	}

	public void display() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		String rv = "*****************\n";

		for (Vertex ver : this.vertices) {
			rv += ver.toString();
			rv += "\n";
		}
		rv += "*****************";
		return rv;
	}

	public void addEdge(String n1, String n2, int weight) {
		Vertex vn1 = this.getVertex(n1);
		Vertex vn2 = this.getVertex(n2);
		if (vn1 != null && vn2 != null) {
			Edge etba = new Edge(vn1, vn2, weight);
			vn1.addEdge(etba);
			vn2.addEdge(etba);
			this.numEdges++;
		}
	}

	public int countEdges() {
		return this.numEdges;
	}

	public void removeEdge(String n1, String n2) {
		Vertex vn1 = this.getVertex(n1);
		Vertex vn2 = this.getVertex(n2);
		if (vn1 != null && vn2 != null && vn1.isAdjascent(vn2)) {
			vn1.removeEdgewith(vn2);
			vn2.removeEdgewith(vn1);
			this.numEdges--;
		}
	}

	public boolean containsEdge(String n1, String n2) {
		Vertex vn1 = this.getVertex(n1);
		Vertex vn2 = this.getVertex(n2);
		if (vn1 == null || vn2 == null || !vn1.isAdjascent(vn2)) {
			return false;
		}
		return true;
	}

	public boolean hasPathBSS(String From, String To) {
		Vertex from = this.getVertex(From);
		Vertex to = this.getVertex(To);
		return this.hasPathBSS(from, to);
	}

	public boolean hasPathDFS(String From, String To) {
		Vertex from = this.getVertex(From);
		Vertex to = this.getVertex(To);
		return this.hasPathDFS(from, to, from, from);
	}

	private boolean hasPathDFS(Vertex from, Vertex to, Vertex initial, Vertex before) {
		if (from.isAdjascent(to)) {
			return true;
		} else {
			ArrayList<Vertex> list = from.getNeighbourVertices();
			for (Vertex lis : list) {
				if (!lis.equals(initial) && !lis.equals(before)) {
					if (this.hasPathDFS(lis, to, initial, from)) {
						return true;
					}
				}
			}
			return false;
		}
	}

	private boolean hasPathBSS(Vertex from, Vertex to) {
		HashMap<Vertex, Boolean> visited = new HashMap<>();
		Queue<Vertex> queue = new LinkedList<>();

		visited.put(from, true);
		queue.offer(from);

		while (!queue.isEmpty()) {
			Vertex vtx = queue.poll();
			// work
			if (vtx.isAdjascent(to)) {
				return true;
			}
			for (Vertex i : vtx.getNeighbourVertices()) {
				if (!visited.containsKey(i)) {
					queue.offer(i);
				}
			}
		}
		return false;
	}

	public boolean isConnected() {
		Vertex vtx = this.vertices.get(1);
		return this.isConnected(vtx);
	}

	private boolean isConnected(Vertex vtx) {
		HashMap<Vertex, Boolean> visit = new HashMap<>();
		visit.put(vtx, true);
		isConnected(vtx, visit);
		return visit.size() == this.vertices.size();
	}

	private void isConnected(Vertex vtx, HashMap<Vertex, Boolean> visited) {
		for (Vertex lis : vtx.getNeighbourVertices()) {
			if (!visited.containsKey(lis)) {
				visited.put(lis, true);
				this.isConnected(lis, visited);
			}
		}
	}

	public void bfTraversal() {
		HashMap<Vertex, Boolean> visited = new HashMap<>();
		Queue<Vertex> queue = new LinkedList<>();

		for (int i = 0; i < this.vertices.size(); i++) {
			if (!visited.containsKey(this.vertices.get(i))) {
				visited.put(this.vertices.get(i), true);
				queue.offer(this.vertices.get(i));
				while (!queue.isEmpty()) {
					Vertex vtx = queue.poll();

					// work
					System.out.print(vtx.name + ", ");

					for (Vertex j : vtx.getNeighbourVertices()) {
						if (!visited.containsKey(j)) {
							visited.put(j, true);
							queue.offer(j);
						}
					}
				}
			}
		}
		System.out.println("END");
	}

	public void dfTraversal() {
		HashMap<Vertex, Boolean> visited = new HashMap<>();
		Stack<Vertex> queue = new Stack<>();
		for (int i = 0; i < this.vertices.size(); i++) {
			if (!visited.containsKey(this.vertices.get(i))) {
				visited.put(this.vertices.get(i), true);
				queue.push(this.vertices.get(i));
				while (!queue.isEmpty()) {
					Vertex vtx = queue.pop();

					// work
					System.out.print(vtx.name + ", ");

					for (Vertex j : vtx.getNeighbourVertices()) {
						if (!visited.containsKey(j)) {
							visited.put(j, true);
							queue.push(j);
						}
					}
				}
			}
		}
		System.out.println("END");
	}

	public ArrayList<ArrayList<String>> getConnectedComponents() {
		HashMap<Vertex, Boolean> visited = new HashMap<>();
		Queue<Vertex> queue = new LinkedList<>();
		ArrayList<ArrayList<String>> rv = new ArrayList<>();

		for (int i = 0; i < this.vertices.size(); i++) {
			if (!visited.containsKey(this.vertices.get(i))) {
				visited.put(this.vertices.get(i), true);
				queue.offer(this.vertices.get(i));
				ArrayList<String> my = new ArrayList<>();
				while (!queue.isEmpty()) {
					Vertex vtx = queue.poll();

					// work
					my.add(vtx.name);

					for (Vertex j : vtx.getNeighbourVertices()) {
						if (!visited.containsKey(j)) {
							visited.put(j, true);
							queue.offer(j);
						}
					}
				}
				rv.add(my);
			}
		}
		return rv;
	}

	public boolean isBartite() {
		HashMap<Vertex, String> visited = new HashMap<>();
		Stack<Vertex> queue = new Stack<>();
		for (int i = 0; i < this.vertices.size(); i++) {
			if (!visited.containsKey(this.vertices.get(i))) {
				visited.put(this.vertices.get(i), "Gr");
				queue.push(this.vertices.get(i));
				while (!queue.isEmpty()) {
					Vertex vtx = queue.pop();

					for (Vertex j : vtx.getNeighbourVertices()) {
						if (!visited.containsKey(j)) {
							if (visited.get(vtx).equals("Gr")) {
								visited.put(j, "Re");
								queue.push(j);
							} else {
								visited.put(j, "Gr");
								queue.push(j);
							}
						} else {
							if (visited.get(j).equals(visited.get(vtx))) {
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}

	public boolean isAcyclic() {
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		Stack<Vertex> queue = new Stack<>();
		for (int i = 0; i < this.vertices.size(); i++) {
			if (!visited.containsKey(this.vertices.get(i))) {
				visited.put(this.vertices.get(i), this.vertices.get(i));
				queue.push(this.vertices.get(i));
				while (!queue.isEmpty()) {
					Vertex vtx = queue.pop();

					for (Vertex j : vtx.getNeighbourVertices()) {
						if (!visited.containsKey(j)) {
							visited.put(j, vtx);
							queue.push(j);
						} else {
							if (!visited.get(vtx).equals(j)) {
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}

	public HashMap<String, Integer> dijkstra(String src) {
		HashMap<String, Integer> rv = new HashMap<>();
		Heap<Integer, Vertex> pq = new Heap<>(true);

		// fill rv
		for (int i = 0; i < this.vertices.size(); i++) {
			if (this.vertices.get(i).name.equals(src)) {
				rv.put(src, 0);
				pq.add(0, this.vertices.get(i));
			} else {
				rv.put(this.vertices.get(i).name, Integer.MAX_VALUE);
				pq.add(Integer.MAX_VALUE, this.vertices.get(i));
			}
		}

		while (!pq.isEmpty()) {
			Vertex vtx = pq.removeHP();

			Set<Map.Entry<Vertex, Edge>> nset = vtx.adjVer.entrySet();
			for (Map.Entry<Vertex, Edge> npair : nset) {
				Vertex ovtx = npair.getKey();
				Edge oedge = npair.getValue();

				int oldscore = rv.get(ovtx.name);
				int newscore = rv.get(vtx.name) + oedge.weight;

				if (newscore < oldscore) {
					pq.updateKey(newscore, ovtx);
					rv.put(ovtx.name, newscore);
				}
			}
		}

		return rv;
	}
}
