package Lecture27;

import java.util.ArrayList;

public class Client {

	public static void main(String[] args) {

		Graph gr = new Graph();
		String[] arr = { "A", "B", "C", "D", "E", "F", "G" };
		gr.addVertices(arr);
		gr.addEdge("A", "B", 40);
		gr.addEdge("C", "B", 15);
		gr.addEdge("A", "D", 10);
		gr.addEdge("C", "D", 12);
		gr.addEdge("D", "E", 5);
		gr.addEdge("F", "G", 3);
		gr.addEdge("E", "F", 2);
		gr.addEdge("G", "E", 8);
		gr.display();
		System.out.println(gr.countEdges());
		gr.display();
		System.out.println(gr.countEdges());
		System.out.println(gr.hasPathBSS("C", "A"));
		System.out.println(gr.isConnected());
		gr.bfTraversal();
		gr.dfTraversal();
		System.out.println(gr.getConnectedComponents());
		System.out.println(gr.isBartite());
		System.out.println(gr.isAcyclic());
		System.out.println(gr.dijkstra("A"));

	}
}
