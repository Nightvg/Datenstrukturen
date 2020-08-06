package PVL8_Tobias;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Beteiligte Personen:
 * 
 * Klenke, Susann
 * Geier, Annina Tara Tanita Petra
 * Allrich, Tobias
 * Porrmann, Tim
 * Lange, David
 */

public class PVL8_group29 implements Graph_II{

	private int nodes;
	private ArrayList<Edge> edges;
	
	public PVL8_group29(int n) {
		edges = new ArrayList<>();
		nodes = n;
	}

	@Override
	public Boolean setEdge(int source, int destin) {
		return (edges.contains(new Edge(source, destin)) || source >= nodes || source < 0 || destin >= nodes || source < 0 || source == destin) ? false : edges.add(new Edge(source, destin));
	}

	@Override
	public List<List<Integer>> getEdges() {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		while(result.size() < nodes && result.add(new ArrayList<Integer>()));
		for(Edge i : edges) {
			result.get(i.getTo()).add(i.getFrom());
			result.get(i.getFrom()).add(i.getTo());
		}
		
		return result;
	}

	@Override
	public Boolean hasWay(int source, int destin) {
		if(source < 0 || source >= nodes || destin < 0 || destin >= nodes) return false;
		return hasWayRec(source, destin, 0);
	}
	
	private Boolean hasWayRec(int now, int destin, int step) {
		if(now == destin) return true;
		if(step > nodes) return false;
		boolean result = false;
		for(Integer i : getConnections(now)) {
			result = result || hasWayRec(i, destin, step + 1);
		}
		
		return result;
	}

	@Override
	public Boolean isConnected() {
		boolean result = true;
		for(int i = 1; i < nodes - 1; i++) result = result && hasWay(i, 0);
		return result;
	}

	@Override
	public Boolean isConnected(List<Integer> nodes) {
		ArrayList<Edge> tmp = new ArrayList<>(edges);
		for(Integer j : nodes) if(j < 0 || j >= this.nodes) return false;
		for(Edge i : tmp) {
			if(!nodes.contains(i.getFrom()) || !nodes.contains(i.getTo())) edges.remove(i);
		}
		boolean result = isConnected();
		edges = tmp;
		return result;
	}

	@Override
	public List<List<Integer>> getBridges() {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(isConnected()) {
			ArrayList<Edge> tmp = new ArrayList<>(edges);
			for(Edge e : tmp) {
				edges.remove(e);
				if(!isConnected()) result.add(Arrays.asList(e.getFrom(), e.getTo()));
				edges.add(e);
			}
		}
		return result;
	}

	@Override
	public List<Integer> getArticulations() {
		List<Integer> result = new ArrayList<>();
		for(List<Integer> i : getBridges()) {
			if(!result.contains(i.get(0))) result.add(i.get(0));
			if(!result.contains(i.get(1))) result.add(i.get(1));
		}
		return result;
	}
	
	private List<Integer> getConnections(int source) {
		ArrayList<Integer> result = new ArrayList<>();
		for(Edge e : edges) {
			if(e.getFrom() == source) result.add(e.getTo());
			if(e.getTo() == source) result.add(e.getFrom());
		}
		
		return result;
	}
	
}
