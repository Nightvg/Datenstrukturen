package PVL9_Tobias;

import java.util.ArrayList;
import java.util.List;

import PVL8_Tobias.Edge;

public class PVL9_Group29 implements Graph_III{

	private Node[] nodes;
	
	public PVL9_Group29(int n) {
		nodes = new Node[n];
		for(int i = 0; i < n; nodes[i] = new Node(i++));
	}
	
	@Override
	public Boolean setEdge(int source, int destin) {
		return (source >= 0 && source < nodes.length && destin >= 0 && destin < nodes.length && source != destin) ? nodes[source].addEdge(nodes[destin]) : false;
	}

	@Override
	public List<List<Integer>> getEdges() {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		while(result.size() < nodes.length) result.add(nodes[result.size()].getEdges());
		return result;
	}

	@Override
	public Boolean hasCircle() {
		for(int i = 0; i < nodes.length; i++) {
			if(hasCircleRec(i, i, 0)) return true;
		}
		return false;
	}
	
	private boolean hasCircleRec(int start, int now, int step) {
		if(start == now && step > 0) return true;
		if(step > nodes.length) return false;
		boolean result = false;
		for(Integer i : nodes[now].getEdges()) {
			result = result || hasCircleRec(start, i, step + 1);
		}
		return result;
	}

	@Override
	public List<Integer> topSort() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<List<Integer>> getStronglyConnectedComponents() {
		// TODO Auto-generated method stub
		return null;
	}

}
