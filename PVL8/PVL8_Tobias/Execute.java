package PVL8_Tobias;

import java.util.Arrays;
import java.util.List;

public class Execute {

	public static void main(String[] args) {
		Graph_II graph = new PVL8_group29(6);
		System.out.println(graph.setEdge(0,1)); //true
		System.out.println(graph.setEdge(0,1)); //false
		System.out.println(graph.setEdge(0,2)); //true
		System.out.println(graph.setEdge(1,2)); //true
		System.out.println(graph.setEdge(2,3)); //true
		System.out.println(graph.setEdge(3,4)); //true
		System.out.println(graph.setEdge(3,5)); //true
		System.out.println(graph.setEdge(4,5)); //true
		printLists(graph.getEdges());
		
		//{
		//{1,2},
		//{0,2},
		//{0,1,3},
		//{2,4,5},
		//{3,5},
		//{3,4},
		//}
		System.out.println(graph.hasWay(0,4)); //true
		System.out.println(graph.isConnected()); //true
		System.out.println(graph.isConnected(Arrays.asList(0,1,3))); //false
		printLists(graph.getBridges());
		printList(graph.getArticulations()); //{2,3}
//		Graph_II graph = new PVL8_group29(9);
//		graph.setEdge(0, 1);
//		graph.setEdge(0, 2);
//		graph.setEdge(1, 2);
//		graph.setEdge(0, 4);
//		graph.setEdge(4, 3);
//		graph.setEdge(4, 5);
//		graph.setEdge(3, 5);
//		graph.setEdge(5, 6);
//		graph.setEdge(6, 7);
//		graph.setEdge(6, 8);
//		graph.setEdge(7, 8);
//		
//		printLists(graph.getEdges());
//		printLists(graph.getBridges());
//		printList(graph.getArticulations());
//		
//		/*
//		 * 			1
//		 * 		   / \
//		 * 		  0 - 2
//		 * 		 /
//		 * 		4		7
//		 * 	   / \	   / \
//		 *    3 - 5 - 6 - 8
//		 */
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
