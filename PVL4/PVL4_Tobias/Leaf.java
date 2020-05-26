package PVL4_Tobias;

public class Leaf extends Node{
	private char sign;
	
	public Leaf(float prob, char sign)
	{
		super();
		this.prob = prob;
		this.sign = sign;
	}
	
	public char getSign()
	{
		return this.sign;
	}
}
