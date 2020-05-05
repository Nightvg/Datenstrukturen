package PVL1_Tobias;
import java.util.ArrayList;
import java.util.Iterator;


public class State 
{
	private int statename;
	private ArrayList<Transition> transitions;
	
	public State(int statename)
	{
		this.statename = statename;
		this.transitions = new ArrayList<Transition>();
	}
	
	public void addTransition(State z, int transition)
	{
		Transition tmp = this.containsTransition(transition);
		if(tmp != null)
		{
			tmp.setState(z);
		}
		else
		{
			this.transitions.add(new Transition(z, transition));
		}
	}
	
	public void removeTransition(int transition)
	{
		Transition tmp = this.containsTransition(transition);
		this.transitions.remove(tmp);
	}
	
	public int getState()
	{
		return this.statename;
	}
	
	public State traverse(int transition)
	{
		Transition tmp = this.containsTransition(transition);
		if(tmp != null) return tmp.getToState();
		
		return null;
	}
	
	private Transition containsTransition(int transition)
	{
		Iterator<Transition> iter = this.transitions.iterator();
		Transition tmp = null;
		while(iter.hasNext())
		{
			tmp = iter.next();
			if(tmp.getInput() == transition) return tmp;
		}
		return null;
	}
	
}
