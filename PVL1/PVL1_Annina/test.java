package PVL1_Annina;

public class test {

	public static void main(String[] args) {
		int [][] automat = {{4},{2},{1,2},{1,0,2,1},{1,2,2,3},{1,0},{}};
		
		PVL1_Group29 auto = new PVL1_Group29(automat);
		auto.setTransition(2, 1, 3);
		auto.setTransition(3, 2, 0);
		auto.setTransition(1, 1, 1);
		auto.setTransition(0, 3, 0); //invalid transition
		
		auto.deleteTransition(2, 1);
		auto.deleteTransition(0, 3);//invalid transition
		
		int []transitions = {1,2,1};
		System.out.println(auto.traverse_input(0, transitions)); // 1
		System.out.println(auto.traverse_input(2, new int[] {1})); //-1
		System.out.println(auto.traverse_input(0, new int[] {2,1,2,2})); //0
		
		System.out.println(auto.traverse_input(0, new int[] {3})); //invalid transition
		System.out.println(auto.traverse_input(3, new int[] {1}));
		
		
		
	}

}
