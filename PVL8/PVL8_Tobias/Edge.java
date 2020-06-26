package PVL8_Tobias;

public class Edge {

	private int from, to;
		
	public Edge(int from, int to) {
		this.from = from;
		this.to = to;
	}
	
	public int getFrom() {
		return from;
	}
	
	public int getTo() {
		return to;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Edge)) return false;
		return ((from == ((Edge)o).from) && (to == ((Edge)o).to)) || ((from == ((Edge)o).to) && (to == ((Edge)o).from));
	}
}
