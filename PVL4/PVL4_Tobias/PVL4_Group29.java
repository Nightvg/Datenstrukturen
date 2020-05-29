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
			this.root = new Leaf(Math.round(probabilities[0]*1000), alphabet[0]);
			return;
		}
		
		for(int i = 0; i < alphabet.length; i++)
		{
			this.alphabet.add(alphabet[i]);
		}
		
		for(int i = 0; i < alphabet.length; i++)
		{
			Leaf tmp = new Leaf(Math.round(probabilities[i]*1000), alphabet[i]);
			list.add(tmp);
		}
		
		while(list.size() > 1)
		{
			int l = this.searchLowest(list);
			int l2 = this.searchLowest(list, l);
			Node tmp = null;
			
			switch(this.compareTo(list.get(l), list.get(l2)))
			{
				case 1:
					tmp = new Node(list.get(l), list.get(l2));
					break;
				case -1:
					tmp = new Node(list.get(l2), list.get(l));
					break;
			}
			
			list.set(Math.min(l, l2), tmp);
			list.remove(Math.max(l, l2));
			
			/*
			int last_index = list.size() - 1;
			
			list.remove(last_index);
			list.remove(last_index - 1);
			addSorted(tmp, list);*/
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
		
		return depthPrint(n.getLeft(), path + 1) + depthPrint(n.getRight(), path + 0);
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
	
			if(this.alphabet.indexOf(getLowestChar(left)) < this.alphabet.indexOf(getLowestChar(right))) return 1;
			else return -1;
		}
		
		return 0;
	}
	
	private char getLowestChar(ArrayList<Character> list)
	{
		char a = list.get(0);
		
		for(int i = 1; i < list.size(); i++)
		{
			if(this.alphabet.indexOf(list.get(i)) < this.alphabet.indexOf(a)) a = list.get(i);
		}
		
		return a;
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
	
	private int searchLowest(ArrayList<Node> list)
	{
		int tmp = 0;
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).getProb() < list.get(tmp).getProb()) tmp = i; 
		}
		
		return tmp;
	}
	
	private int searchLowest(ArrayList<Node> list, int j)
	{
		int tmp = (j == 0) ? 1 : 0;

		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).getProb() < list.get(tmp).getProb() && i != j) tmp = i; 
		}
		
		return tmp;
	}
}
