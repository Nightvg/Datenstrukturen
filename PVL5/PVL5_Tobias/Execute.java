package PVL5_Tobias;

import java.util.Iterator;

public class Execute {

	public static void main(String[] args) {
		PVL5_Group29 set1 = new PVL5_Group29(1);
		PVL5_Group29 set2 = new PVL5_Group29(2);
		PVL5_Group29 set3 = new PVL5_Group29(3);
		PVL5_Group29 set4 = new PVL5_Group29(4);
		PVL5_Group29 set5 = new PVL5_Group29(5);
		PVL5_Group29 set6 = new PVL5_Group29(6);
		set1.union(set2).union(set4).union(set5);
		set3.union(set4).union(set5).union(set6);
		
		set1.print();
		set3.print();
		//set1 = {‘1‘, ‘2‘, ‘4‘, ‘5‘}
		//set3 = {‘3‘, ‘4‘, ‘5‘, ‘6‘}
		
		
//		set1.union(set3);
//		set1.print();
		//set1 = {‘1‘, ‘2‘, ‘3‘, ‘4‘, ‘5‘, ‘6‘}
		
//		set1.cut(set3);
//		set1.print();
//		//set1 = {‘4‘, ‘5‘}
		
//		System.out.println(set1.isSubsetOf(set3)); // false
//		System.out.println(set2.isSubsetOf(set1)); // true
//		System.out.println(set1.isSubsetOf(set1)); // true
		
//		set1.relativeComplementWith(set3);
//		set1.print();
//		//set1 = {‘1‘, ‘2‘}

//		System.out.println(set1.equals(set3)); // false
//		System.out.println(set2.equals(set1)); // false
//		System.out.println(set1.equals (set1)); // true
	
//		Iterator<Set> iter = set1.iterator();
//		((PVL5_Group29)iter.next()).print(); // {‘1‘}
//		((PVL5_Group29)iter.next()).print(); // {‘2‘}
//		((PVL5_Group29)iter.next()).print(); // {‘4‘}
//		((PVL5_Group29)iter.next()).print(); // {‘5‘}
	}

}
