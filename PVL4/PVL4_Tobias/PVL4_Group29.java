package PVL4_Tobias;

import java.util.ArrayList;

public class PVL4_Group29 implements HuffmanCode{
	
	public Node root;
	private ArrayList<Character> alphabet;
	
	public PVL4_Group29(char[] alphabet, float[] probabilities)
	{
		ArrayList<Node> list = new ArrayList<Node>();
		this.alphabet = new ArrayList<Character>();
		
		if(alphabet == null || probabilities == null || alphabet.length == 0)
		{
			this.root = null;
			return;
		}
		if(alphabet.length != probabilities.length) return;
		
		if(alphabet.length == 1)
		{
			this.root = new Leaf(probabilities[0], alphabet[0]);
			return;
		}
		
		for(int i = 0; i < alphabet.length; i++)
		{
			this.alphabet.add(alphabet[i]);
		}
		
		for(int i = 0; i < alphabet.length; i++)
		{
			Leaf tmp = new Leaf(probabilities[i], alphabet[i]);
			this.addSorted(tmp, list);
		}
		
		while(list.size() > 1)
		{
			int last_index = list.size() - 1;
			Node tmp = new Node(list.get(last_index - 1), list.get(last_index));
			list.remove(last_index);
			list.remove(last_index - 1);
			addSorted(tmp, list);
		}
		
		this.root = list.get(0);
	}
	
	@Override
	public String getCodes() {
		
		if(this.root == null) return null;
		
		if(this.root instanceof Leaf)
		{
			return ((Leaf) this.root).getSign() + " - 1\n";
		}
		
		return depthPrint(this.root, "");
	}

	@Override
	public String encode(String plainText) {
		String output = "";
		for(int i = 0; i < plainText.length(); i++)
		{
			Node n = this.root;
			output += this.encode(n, plainText.charAt(i));
		}
		return output;
	}

	@Override
	public String decode(String huffmanText) {
		String output = "";
		Node n = this.root;
		for(int i = 0; i < huffmanText.length(); i++)
		{
			switch(huffmanText.charAt(i))
			{
				case '1':
					n = n.getLeft();
					break;
				case '0':
					n = n.getRight();
					break;
			}
			
			if(n instanceof Leaf)
			{
				output += ((Leaf) n).getSign();
				n = this.root;
			}
		}
		
		return output;
	}
	
	private String depthPrint(Node n, String path)
	{
		if(n instanceof Leaf)
		{
			return ((Leaf) n).getSign() + " - " + path + "\n";
		}
		
		String pathL = path + '1';
		String pathR = path + '0';
		
		return depthPrint(n.getLeft(), pathL) + depthPrint(n.getRight(), pathR);
	}
	
	
	private void addSorted(Node n, ArrayList<Node> list)
	{
		if(list.size() == 0)
		{
			list.add(n);
			return;
		}
		
		for(int i = list.size() - 1; i >= 0 ; i--)
		{
			if(this.compareTo(n, list.get(i)) == -1)
			{
				if(i + 1 == list.size()) list.add(n);
				else list.add(i + 1, n);
				return;
			}
		}
		
		list.add(0, n);
	}
	
	private int compareTo(Node n, Node m) {
		if(n.prob > m.prob) return 1;
		if(n.prob < m.prob) return -1;
		if(n.prob == m.prob)
		{
			ArrayList<Character> left = new ArrayList<Character>();
			ArrayList<Character> right = new ArrayList<Character>();
			getSigns(n, left);
			getSigns(m, right);
	
			if(this.alphabet.indexOf(left.get(0)) < this.alphabet.indexOf(right.get(0))) return 1;
			else return -1;
		}
		
		return 0;
	}
	
	private void getSigns(Node n, ArrayList<Character> field)
	{
		if(n instanceof Leaf)
		{
			field.add(((Leaf) n).getSign());
			return;
		}
		
		getSigns(n.getLeft(), field);
		getSigns(n.getRight(), field);
	}
	
	private String encode(Node n, char a)
	{
		if(n instanceof Leaf)
		{
			if(((Leaf) n).getSign() == a) return "";
			else return "#";
		}
		
		String left = '1' + this.encode(n.getLeft(), a); 
		String right = '0' + this.encode(n.getRight(), a);
		
		if(left.contains("#")) return right;
		else return left;	
	}
}
