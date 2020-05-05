package PVL1_Tobias;

public class Execute {

	public static void main(String[] args)
	{
		int[][] data = {{4},{2},{1,2},{1,0,2,1},{1,2,2,3},{1,0},{}};
		
		PVL1_Group29 automat = new PVL1_Group29(data);
		automat.setTransition(3, 1, 0);
		automat.deleteTransition(0, 1);
		System.out.println(automat.traverse_input(0, new int[] {2,2,1}));
		System.out.println(automat.traverse_input(0, new int[] {1,2,1}));
		System.out.println(automat.traverse_input(0, new int[] {2,1}));
		automat.setTransition(2, 1, 3);
		System.out.println(automat.traverse_input(0, new int[] {2,1,1,1}));

	}

}
