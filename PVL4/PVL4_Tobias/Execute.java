package PVL4_Tobias;

public class Execute {

	public static void main(String[] args) {
		PVL4_Group29 test = new PVL4_Group29(new char[] {'a','b','c','d','e'}, new float[] {1f/12f, 2f/12f, 2f/12f, 3f/12f, 4f/12f});
		System.out.println(test.getCodes());
		String p = test.encode("abcaa");
		System.out.println(p);
		String d = test.decode(p);
		System.out.println(d);
		p = test.encode(d);
		System.out.println(p);
	}

}
