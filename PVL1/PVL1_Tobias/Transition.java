package PVL1_Tobias;

public class Transition {
	private State toState;
	private int input;
	
	public Transition(State z, int input)
	{
		this.toState = z;
		this.input = input;
	}
	
	public State getToState()
	{
		return this.toState;
	}
	
	public int getInput()
	{
		return this.input;
	}
	
	public void setState(State z)
	{
		this.toState = z;
	}
	
	public void setInput(int input)
	{
		this.input = input;
	}
}
