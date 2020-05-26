package PVL3_Tobias;

import java.util.*;

public class Calculator_Group29 implements Calculator {
	
	private ArrayList<BinaryTree> forrest;
	private int count;
	
	public Calculator_Group29()
	{
		this.forrest = new ArrayList<BinaryTree>();
		count = 0;
	}
	
	public boolean isValidExpression(String expression)
	{
		/*int kla = 0, klz = 0;
		for(int i = 0; i < expression.length(); i++)
		{
			char z = expression.charAt(i);
			switch((int)z)
			{
				case 40: // (
					if(klz > kla) return false;
					if(i < expression.length() - 2 && expression.charAt(i + 1) != ' ') return false;
					kla++;
					break;
				case 41: // )
					if(kla < klz) return false;
					if(i < expression.length() - 2 && expression.charAt(i + 1) != ' ') return false;
					klz++;
					break;
				case 42: // *
				case 43: // +
					if(i > 2 && i < expression.length() - 2)
					{
						if(!((int)expression.charAt(i - 2) >= 48 && (int)expression.charAt(i - 2) <= 57 || (int)expression.charAt(i - 2) == 41)) return false;
						if(!((int)expression.charAt(i + 2) >= 48 && (int)expression.charAt(i + 2) <= 57 || (int)expression.charAt(i + 2) == 40)) return false;
					}
					break;
				case 48:
					if(i > 0)
					{
						if(expression.charAt(i - 1) == ' ') return false;
					}
				case 49:
				case 50:
				case 51:
				case 52:
				case 53:
				case 54:
				case 55:
				case 56:
				case 57:
					if(i < expression.length() - 1)
					{
						if(!((int)expression.charAt(i + 1) >= 48 && (int)expression.charAt(i + 1) <= 57 || (int)expression.charAt(i + 1) == 32)) return false;
					}
					break;	
			}
		}
		
		if(kla != klz) return false;
		*/
		return true;
	}
	
	public int calculate(String expression)
	{
		if(!this.isValidExpression(expression))
		{
			System.out.println("Invalid Expression");
			return -1;
		}
		
		buildTree(expression);
		
		return calcTree(this.forrest.get(this.forrest.size() - 1).root);
	}
	
	private int calcTree(Node n)
	{
		if(n.getLeft() == null && n.getRight() == null)
		{
			return Integer.parseInt(n.getData());
		}
		
		if(n.getData() == "*")
		{
			return calcTree(n.getLeft()) * calcTree(n.getRight());
		}
		
		if(n.getData() == "+")
		{
			return calcTree(n.getLeft()) + calcTree(n.getRight());
		}
		
		return -1;
	}
	
	private String buildTree(String expression)
	{
		String unBracket = expression;
		while(unBracket.indexOf('(') != -1)
		{
			for(int i = 0, kl = 0, kr = 0; i < unBracket.length(); i++)
			{
				if(unBracket.charAt(i) == '(')
				{
					kl = i;
					for(int j = kl + 1, kc = 1; j < unBracket.length(); j++)
					{
						if(unBracket.charAt(j) == '(') kc++;
						if(unBracket.charAt(j) == ')')
						{
							kc--;
							if(kc == 0)
							{
								kr = j;
								break;
							}
						}
					}
				}
				
				if(kr > 0 && kr > kl)
				{
					if(kl == 0 && kr == expression.length() - 1) 
					{
						unBracket = buildTree(expression.substring(2, expression.length() - 2));
						break;
					}
					if(kl == 0) 
					{
						unBracket = buildTree(unBracket.substring(kl + 2, kr - 1)) + unBracket.substring(kr + 1);
						break;
					}
					if(kr == unBracket.length() - 1)
					{
						unBracket = unBracket.substring(0, kl) + buildTree(unBracket.substring(kl + 2, kr - 1));
						break;
					}
					if(kl > 0 && kr < unBracket.length() - 1) unBracket = unBracket.substring(0, kl) + buildTree(unBracket.substring(kl + 2, kr - 1)) + unBracket.substring(kr + 1);
					break;
				}
			}
		}
		
		//Baum bauen
		while(unBracket.indexOf('*') != -1)
		{
			int spl = 0, spr = unBracket.length();
			for(int i = unBracket.indexOf('*'), sc = 0; i > 0 && sc < 2; i--)
			{
				if(unBracket.charAt(i) == ' ') sc++;
				if(sc == 2) spl = i++;
			}
				
			for(int i = unBracket.indexOf('*'), sc = 0; i < unBracket.length() && sc < 2; i++)
			{
				if(unBracket.charAt(i) == ' ') sc++;
				if(sc == 2) spr = i;
			}
			String left, right;
			left = unBracket.substring(spl, unBracket.indexOf('*') - 1);
			right = unBracket.substring(unBracket.indexOf('*') + 2, spr);
			unBracket = unBracket.substring(0,spl) + "b" + String.valueOf(this.count) + unBracket.substring(spr);
			if(left.contains("b"))
			{
				if(right.contains("b"))
				{
					this.forrest.add(new BinaryTree("*", this.forrest.get(Character.getNumericValue(left.charAt(left.indexOf('b') + 1))).root, this.forrest.get(Character.getNumericValue(right.charAt(right.indexOf('b') + 1))).root));
					this.count++;
				}
				else
				{
					this.forrest.add(new BinaryTree("*", this.forrest.get(Character.getNumericValue(left.charAt(left.indexOf('b') + 1))).root, new Node(right)));
					this.count++;
				}
				
			}
			else
			{
				if(right.contains("b"))
				{
					this.forrest.add(new BinaryTree("*", new Node(left), this.forrest.get(Character.getNumericValue(right.charAt(right.indexOf('b') + 1))).root));
					this.count++;
				}
				else
				{
					if(this.forrest.size() == 0 || (unBracket.indexOf('+') == -1 && unBracket.indexOf('*') == -1)) 
					{
						this.forrest.add(new BinaryTree("*", new Node(left), new Node(right)));
						this.count++;
					}
				}
			}
	
		}
		
		while(unBracket.indexOf('+') != -1)
		{
			int spl = 0, spr = unBracket.length();
			for(int i = unBracket.indexOf('+'), sc = 0; i > 0 && sc < 2; i--)
			{
				if(unBracket.charAt(i) == ' ') sc++;
				if(sc == 2) spl = i++;
			}
				
			for(int i = unBracket.indexOf('+'), sc = 0; i < unBracket.length() && sc < 2; i++)
			{
				if(unBracket.charAt(i) == ' ') sc++;
				if(sc == 2) spr = i;
			}
			String left, right;
			left = unBracket.substring(spl, unBracket.indexOf('+') - 1);
			right = unBracket.substring(unBracket.indexOf('+') + 2, spr);
			unBracket = unBracket.substring(0,spl) + "b" + String.valueOf(this.count) + unBracket.substring(spr);
			if(left.contains("b"))
			{
				if(right.contains("b"))
				{
					this.forrest.add(new BinaryTree("+", this.forrest.get(Character.getNumericValue(left.charAt(left.indexOf('b') + 1))).root, this.forrest.get(Character.getNumericValue(right.charAt(right.indexOf('b') + 1))).root));
					this.count++;
				}
				else
				{
					this.forrest.add(new BinaryTree("+", this.forrest.get(Character.getNumericValue(left.charAt(left.indexOf('b') + 1))).root, new Node(right)));
					this.count++;
				}
				
			}
			else
			{
				if(right.contains("b"))
				{
					this.forrest.add(new BinaryTree("+", new Node(left), this.forrest.get(Character.getNumericValue(right.charAt(right.indexOf('b') + 1))).root));
					this.count++;
				}
				else
				{
					if(this.forrest.size() == 0 || (unBracket.indexOf('+') == -1 && unBracket.indexOf('*') == -1)) 
					{
						this.forrest.add(new BinaryTree("+", new Node(left), new Node(right)));
						this.count++;
					}
				}
			}
		}
		
		return unBracket;
		
	}
	
}
