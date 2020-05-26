package PVL4_Tobias;

public class Execute {

	public static void main(String[] args) {
		PVL4_Group29 test = new PVL4_Group29(new char[] {'a','b','c'}, new float[] {0.25f, 0.5f, 0.25f});
		System.out.println(test.getCodes());
		String p = test.encode("abcaa");
		System.out.println(p);
		String d = test.decode(p);
		System.out.println(d);
		p = test.encode(d);
		System.out.println(p);
	}

}
