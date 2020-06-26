package PVL7_Tobias;

import java.util.ArrayList;
import java.util.List;

/*
 * Beteiligte Personen:
 * 
 * Geier, Annina Tara Tanita Petra
 * Allrich, Tobias
 * Porrmann, Tim
 */

public class PVL7_group29 implements Graph_I {

	private ArrayList<Node> nodes;
	
	public PVL7_group29(int n) {
		nodes = new ArrayList<Node>();
		for(;nodes.size() < n && nodes.add(new Node(nodes.size())););
	}
	
	@Override
	public Boolean setEdge(int from, int to) {
		return to < nodes.size() && to >= 0 && from < nodes.size() && from >= 0 && nodes.get(from).addEdge(new Edge(nodes.get(to))) && nodes.get(to).addEdge(new Edge(nodes.get(from)));
	}

	@Override
	public List<List<Integer>> getEdges() {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i = 0; i < nodes.size(); i++) {
			ArrayList<Integer> tmp = new ArrayList<>();
			for(int j = 0; j < nodes.size(); j++) {
				if(nodes.get(j).getEdges().contains(new Edge(new Node(i)))) tmp.add(j);
			}
			result.add(tmp);
		}
		return result;
	}

	@Override
	public List<List<Integer>> getNGons(int n) {	
		return (n >= 3 && n <= nodes.size() ) ? getNGonsRec(n) : new ArrayList<List<Integer>>();
	}

	private List<List<Integer>> getNGonsRec(int step) {
		ArrayList<List<Integer>> result = new ArrayList<>();
		ArrayList<Integer> start_nodes = new ArrayList<>();
		for(int i = 0; i < nodes.size(); start_nodes.add(i++));
		while(!start_nodes.isEmpty()) {
			getNGonsRec(new ArrayList<Node>(), result, start_nodes.get(0), step);
			start_nodes.remove(0);
			removeTuples(result);
		}
		
		return result;
	}
	
	private void getNGonsRec(ArrayList<Node> path, ArrayList<List<Integer>> result, int start, int step) {
		if(step == 1 && path.get(path.size() - 1).getEdges().contains(new Edge(new Node(start)))) {
			ArrayList<Integer> tmp = new ArrayList<>();
			for(Node i : path) tmp.add(i.getNumber());
			
			result.add(tmp);
			return;	
		}
		if(step == 0) return;
		if(path.isEmpty()) path.add(nodes.get(start));
		
		for(int i = 0; i < path.get(path.size() - 1).getEdges().size(); i++) {
			if(!path.contains(path.get(path.size() - 1).getEdges().get(i).getTo())) {
				ArrayList<Node> tmp = new ArrayList<>();
				for(Node n : path) tmp.add(n);
				tmp.add(path.get(path.size() - 1).getEdges().get(i).getTo());
				getNGonsRec(tmp, result, start, step - 1);
			}
		}
		
	}
	
	private void removeTuples(ArrayList<List<Integer>> result) {
		if(result == null || result.size() == 0) return;

		for(int i = 0; i < result.size() - 1; i++) {
			for(int j = i + 1; j < result.size(); j++) {
				int test = 0;
				for(int u = 0; result.get(i) != null && result.get(j) != null && u < result.get(j).size(); u++) {
					if(result.get(i).contains(result.get(j).get(u))) test++;
				}
				
				if(test == result.get(i).size()) {
					result.remove(j);
					j--;
				}
			}
		}
	}
	
	@Override
	public List<Integer> getLongestPath(int from, int to) {
		ArrayList<Integer> result = new ArrayList<>();
		getLongestPath(new ArrayList<Node>(), result, from, to);
		return result;
	}
	
	private void getLongestPath(ArrayList<Node> path, ArrayList<Integer> result, int from, int to) {
		if(path.size() > 0 && path.get(path.size() - 1).getNumber() == to && path.size() > result.size()) {
			for(;result.size() > 0; result.remove(0));
			for(Node n : path) result.add(n.getNumber());
			return;
		}
		if(path.size() >= nodes.size() || result.size() >= nodes.size()) return;
		if(path.isEmpty()) path.add(nodes.get(from));
		
		for(int i = 0; i < path.get(path.size() - 1).getEdges().size(); i++) {
			if(!path.contains(path.get(path.size() - 1).getEdges().get(i).getTo())) {
				ArrayList<Node> tmp = new ArrayList<>();
				for(Node n : path) tmp.add(n);
				tmp.add(path.get(path.size() - 1).getEdges().get(i).getTo());
				getLongestPath(tmp, result, from, to);
			}
		}
	}

	@Override
	public Boolean hasFullCircle() {
		return hasFullCircle(new ArrayList<Node>());
	}
	
	private boolean hasFullCircle(ArrayList<Node> path) {
		if(path.isEmpty()) path.add(nodes.get(0));
		if(path.size() == nodes.size() && path.get(path.size() - 1).getEdges().contains(new Edge(new Node(0)))) {
			return true;
		}
		boolean result = false;
		for(int i = 0; i < path.get(path.size() - 1).getEdges().size(); i++) {
			if(!path.contains(path.get(path.size() - 1).getEdges().get(i).getTo())) {
				ArrayList<Node> tmp = new ArrayList<>();
				for(Node n : path) tmp.add(n);
				tmp.add(path.get(path.size() - 1).getEdges().get(i).getTo());
				result = result || hasFullCircle(tmp);
			}
		}
		
		return result;
	}

}
