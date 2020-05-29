package PVL4_Tobias;

public class Node{

	private Node left, right;
	protected int prob;
	
	protected Node()
	{
		this.left = null;
		this.right = null;
	}

	public Node(Node left, Node right)
	{
		if(left == null || right == null) return;
		this.prob = left.getProb() + right.getProb();
		this.left = left;
		this.right = right;
	}

	public int getProb()
	{
		return this.prob;
	}
	
	public Node getLeft()
	{
		return this.left;
	}
	
	public Node getRight()
	{
		return this.right;
	}
}
