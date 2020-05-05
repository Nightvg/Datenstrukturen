package PVL1_Tobias;

import java.util.*;

public class PVL1_Group29 {
	private ArrayList<State> states;
	private ArrayList<Integer> valid_transitions;
	public PVL1_Group29(int[][] data)
	{
		this.states = new ArrayList<State>();
		this.valid_transitions = new ArrayList<Integer>();
		
		this.tryDataFormat(data);
		
		for(int i = 0; i < data[1][0]; i++) this.valid_transitions.add(data[2][i]);
		for(int i = 0; i < data[0][0]; i++)	this.states.add(new State(i));		
		for(int i = 0; i < data[0][0]; i++)
		{
			for(int k = 0, l = 0; k < data[1][0]; k++, l += 2)
			{
				State tmp = this.states.get(i);
				
				if(data[3+i].length > l+1)
				{
					tmp.addTransition(this.states.get(data[3+i][l+1]), data[3+i][l]);
				}
				else
				{
					tmp.addTransition(null, k + 1);
				}
			}
		}
		
	}
	
	private void tryDataFormat(int[][] data)
	{
		//Eine genaue Fehleranalyse war nicht gefordert, daher wurde nur oberflaechlich geprueft ob alle Fehler
		//auch wirklich abgedeckt werden
		if(data.length < 4) throw new IllegalArgumentException();
		if(data[0].length > 1) throw new IllegalArgumentException();
		if(data[0][0] < 1) throw new IllegalArgumentException();
		if(data[1].length > 1) throw new IllegalArgumentException();
		if(data[1][0] < 1) throw new IllegalArgumentException();
		if(data[2].length != data[1][0]) throw new IllegalArgumentException();
		if(data.length != 3 + data[0][0]) throw new IllegalArgumentException();
		for(int i = 0; i < data[2].length; i++)
		{
			for(int j = i + 1; j < data[2].length; j++)
			{
				if(data[2][i] == data[2][j]) throw new IllegalArgumentException();
			}
		}
		for(int i = 0; i < data[0][0]; i++)
		{
			if(data[3+i].length > 2*data[1][0]) throw new IllegalArgumentException();
			if(data[3+1].length%2 != 0) throw new IllegalArgumentException();
			
			for(int j = 0; j < data[3+i].length; j++)
			{
				if(j%2 == 0)
				{
					boolean contains = false;
					for(int k = 0; k < data[1][0]; k++)
					{
						if(data[2][k] == data[3+i][j]) contains = true;
					}
					
					if(!contains) throw new IllegalArgumentException();
				}
				else
				{
					if(data[3+i][j] >= data[0][0]) throw new IllegalArgumentException();
				}
			}
		}
		
		
		return;
	}
	
	public void setTransition(int state, int transition, int to)
	{
		if(!this.valid_transitions.contains(transition)) throw new IllegalArgumentException();
		if(state > this.states.size() - 1 || state < 0 || to < 0 || to > this.states.size() - 1) throw new IllegalArgumentException();
		State tmp = this.states.get(state);
		tmp.addTransition(this.states.get(to), transition);
	}
	
	public void deleteTransition(int state, int transition)
	{
		if(!this.valid_transitions.contains(transition)) throw new IllegalArgumentException();
		if(state > this.states.size() - 1 || state < 0) throw new IllegalArgumentException();
		State tmp = this.states.get(state);
		tmp.removeTransition(transition);
	}
	
	public int traverse_input(int startState, int[] transitions)
	{
		if(startState > this.states.size() - 1 || startState < 0) throw new IllegalArgumentException();
		State tmp = this.states.get(startState);
		for(int i = 0; i < transitions.length; i++)
		{
			if(!this.valid_transitions.contains(transitions[i])) throw new IllegalArgumentException();
			if(tmp.traverse(transitions[i]) == null) return -1;
			tmp = tmp.traverse(transitions[i]);
		}
		
		return tmp.getState();
	}
}
