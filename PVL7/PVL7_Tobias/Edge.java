package PVL7_Tobias;

public class Edge {
	private Node to;
	
	public Edge(Node to) {
		this.to = to;
	}
	
	public Node getTo() {
		return to;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Edge)) return false;
		return ((Edge)o).getTo().getNumber() == this.to.getNumber();
	}
}
