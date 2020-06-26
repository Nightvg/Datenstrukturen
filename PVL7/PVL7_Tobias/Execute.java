package PVL7_Tobias;

import java.util.List;

public class Execute {

	public static void main(String[] args) {
		Graph_I graph = new PVL7_group29(4);
		
		System.out.println(graph.setEdge(0,1)); //true
		System.out.println(graph.setEdge(0,1)); //false
		System.out.println(graph.setEdge(0,0)); //false
		System.out.println(graph.setEdge(0,2)); //true
		System.out.println(graph.setEdge(0,3)); //true
		System.out.println(graph.setEdge(0,4)); //false
		System.out.println(graph.setEdge(1,3)); //true
		System.out.println(graph.setEdge(2,3)); //true

		printLists(graph.getEdges());
//		{
//		{1,2,3},
//		{0,3},
//		{0,3},
//		{0,1,2}
//		}
		printLists(graph.getNGons(3));
		printList(graph.getLongestPath(2, 1));
		System.out.println(graph.hasFullCircle());
		
	}
	
	public static void printList(List<Integer> list) {
		System.out.print('{');
		for(int i = 0; list.size() > 0 && i < list.size() - 1; System.out.print(list.get(i++).toString() + ", ")) ;
		if(list.size() == 0) System.out.println("}\n");
		else System.out.print(list.get(list.size() - 1).toString() + "}\n");
	}
	
	public static void printLists(List<List<Integer>> list) {
		System.out.print("{\n");
		for(int i = 0; i < list.size(); i++) {
			System.out.print('{');
			for(int j = 0; j < list.get(i).size() - 1; System.out.print(list.get(i).get(j++).toString() + ", "));
			if(list.get(i).size() > 0) System.out.print(list.get(i).get(list.get(i).size() - 1).toString());
			if(i + 1 != list.size()) System.out.print("},\n");
			else System.out.print("}\n");
			
		}
		System.out.println("}\n");
	}

}
