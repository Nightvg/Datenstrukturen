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
	}

}
