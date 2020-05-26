package PVL3_Tobias;

public class Node {

	private Node left, right;
	private String data;
	
	public Node(String data)
	{
		this.data = data;
		this.left = this.right = null;
	}
	
	public void addLeft(Node n)
	{
		this.left = n;
	}
	
	public void addRight(Node n)
	{
		this.right = n;
	}
	
	public String getData()
	{
		return this.data;
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
