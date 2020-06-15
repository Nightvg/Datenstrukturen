package PVL6_Tobias;

public class Execute {

	public static void main(String[] args) {
		PVL6_Group29 scheduler = new PVL6_Group29(2);
		scheduler.createProcess(0, 3, 10); // pid: 1
		scheduler.createProcess(0, 2, 10); // pid: 2
		scheduler.createProcess(2, 1, 10); // pid: 3
		scheduler.createProcess(5, 4, 10); // pid: 4
		scheduler.createProcess(5, 3, 90); // pid: 5
		scheduler.createProcess(9, 1, 10); // pid: 6
		scheduler.deleteProcess(6); //true
		scheduler.createProcess(5, 1, 80); // pid: 6
		String result = scheduler.execute();
		System.out.println(result);
//		
//		PVL6_Group29 scheduler2 = new PVL6_Group29(4);
//        System.out.println("Ergebnis ohne Prozesse, soll: >" + "<");
//        System.out.println("Ergebnis ohne Prozesse, ist:  >" + scheduler2.execute() + "<\n");
//
//        System.out.print("Soll:  1  2  3  4  5  6  7  8  9  10  true  true  false  false  false  4  10  11\n");
//        System.out.print("Ist: ");
//        System.out.print("  " + scheduler2.createProcess(0,  5,  10));  // pid: 1
//        System.out.print("  " + scheduler2.createProcess(0,  5,  20));  // pid: 2
//        System.out.print("  " + scheduler2.createProcess(0, 10, 100));  // pid: 3
//        System.out.print("  " + scheduler2.createProcess(2,  2,   2));  // pid: 4
//        System.out.print("  " + scheduler2.createProcess(1, 10,  10));  // pid: 5
//        System.out.print("  " + scheduler2.createProcess(3,  3,   3));  // pid: 6
//        System.out.print("  " + scheduler2.createProcess(4,  4,   4));  // pid: 7
//        System.out.print("  " + scheduler2.createProcess(5,  5,   5));  // pid: 8
//        System.out.print("  " + scheduler2.createProcess(6,  6,   6));  // pid: 9
//        System.out.print("  " + scheduler2.createProcess(7,  7,   7));  // pid: 10
//        System.out.print("  " + scheduler2.deleteProcess(4));           // true
//        System.out.print("  " + scheduler2.deleteProcess(10));          // true
//        System.out.print("  " + scheduler2.deleteProcess(4));           // false
//        System.out.print("  " + scheduler2.deleteProcess(14));          // false
//        System.out.print("  " + scheduler2.deleteProcess(0));           // false
//        System.out.print("  " + scheduler2.createProcess(8,  1,  80));  // pid: 4
//        System.out.print("  " + scheduler2.createProcess(8,  1,  90));  // pid: 10
//        System.out.print("  " + scheduler2.createProcess(9,  1,  80));  // pid: 11
//        String result = scheduler2.execute();
//        /*
//         * 0 : 3 2 1 0
//         * 1 : 3 2 1 5
//         * 2 : 3 2 1 5
//         * 3 : 3 2 1 5
//         * 4 : 3 2 1 5
//         * 5 : 3 8 7 5
//         * 6 : 3 8 7 5
//         * 7 : 3 8 7 5
//         * 8 : 3 8 7 5
//         * 9 : 3 8 10 5
//         * 10 : 4 11 9 5
//         * 11 : 6 0 9 0
//         * 12 : 6 0 9 0
//         * 13 : 6 0 9 0
//         * 14 : 0 0 9 0
//         * 15 : 0 0 9 0
//         */
//        System.out.println( "\n" + result + "\n");
//        
	}

}
