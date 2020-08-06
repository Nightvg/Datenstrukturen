package PVL9_Tobias;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private int value;
	private ArrayList<Node> edges;
	
	public Node(int v) {
		edges = new ArrayList<>();
		value = v;
	}
	
	public boolean addEdge(Node n) {
		return (edges.contains(n)) ? false : edges.add(n);
	}
	
	public Integer getValue() {
		return value;
	}
	
	public List<Integer> getEdges() {
		ArrayList<Integer> l = new ArrayList<>();
		for(Node n : edges) {
			l.add(n.getValue());
		}
		return l;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Node)) return false;
		return ((Node)obj).value == value;
	}
	
	
}
