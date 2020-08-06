package PVL9_Tobias;

public class Execute {

	public static void main(String[] args) {
		Graph_III graph = new PVL9_Group29(4);
		graph.setEdge(0,1);
		graph.setEdge(1,2);
		graph.setEdge(1,3);
		graph.setEdge(2,0);
		graph.setEdge(2,3);
		System.out.println(graph.hasCircle()); //false

	}

}
