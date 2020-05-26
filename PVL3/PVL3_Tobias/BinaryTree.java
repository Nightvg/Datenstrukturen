package PVL3_Tobias;

public class BinaryTree {
	public Node root;
	
	public BinaryTree(String data)
	{
		Node n = new Node(data);
		this.root = n;
	}
	
	public BinaryTree(String data, Node left, Node right)
	{
		Node n = new Node(data);
		this.root = n;
		
		n.addLeft(left);
		n.addRight(right);
	}
}
