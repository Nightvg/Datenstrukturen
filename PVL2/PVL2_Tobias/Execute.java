package PVL2_Tobias;

public class Execute {

	public static void main(String[] args) {
		PVL2_studentAdministration_Group29 t = new PVL2_studentAdministration_Group29();
		t.matriculate("Alfred", "Quack");
		t.matriculate("Gustav", "Adolf II.");
		t.matriculate("Otto", "von Bismarck");
		System.out.println(t.find(2));
		if(t.deregister(2)) System.out.println("Passt");
		System.out.println(t.dataBase());
		t.matriculate("Franz", "Joseph I.");
		System.out.println(t.dataBase());
		t.takeExam(3, "Mathe", false);
		t.takeExam(3, "Mathe", false);
		t.takeExam(3, "Mathe", false);
		System.out.println(t.dataBase());
		t.takeExam(1, "ET", true);
		t.takeExam(1, "ET", true);
		System.out.println(t.dataBase());
		t.takeExam(2, "Herrsch", false);
		t.takeExam(2, "Herrsch", false);
		t.takeExam(2, "Herrsch", true);
		t.takeExam(2, "Failen", true);
		System.out.println(t.dataBase());

	}

}
