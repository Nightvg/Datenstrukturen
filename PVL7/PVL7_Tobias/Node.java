package PVL7_Tobias;

import java.util.ArrayList;

public class Node {
	private ArrayList<Edge> edges;
	private int number;
	
	public Node(int number) {
		edges = new ArrayList<Edge>();
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
	
	public ArrayList<Edge> getEdges() {
		return edges;
	}
	
	public boolean addEdge(Edge edge) {
		 return (edges.contains(edge) || edge.getTo().number == this.number) ? false : edges.add(edge); 
	}
}
