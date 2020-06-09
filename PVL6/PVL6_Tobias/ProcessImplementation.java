package PVL6_Tobias;

public class ProcessImplementation implements Process{

	private int pid, arrivalTime, executionTime, priority;
	
	public ProcessImplementation(int pid, int arrivalTime, int executionTime, int priority)
	{
		this.pid = pid;
		this.arrivalTime = arrivalTime;
		this.executionTime = executionTime;
		this.priority = priority;
	}
	
	public ProcessImplementation(int pid) {
		this.pid = pid;
	}

	@Override
	public int getPID() {
		return this.pid;
	}

	@Override
	public int getArrivalTime() {
		return (this != null) ? this.arrivalTime : -1;
	}

	@Override
	public int getExecutionTime() {
		return (this != null) ? this.executionTime : -1;
	}

	@Override
	public int getPriority() {
		return (this != null) ? this.priority : -1;
	}

	@Override
	public boolean equals(Object e)
	{
		if(!(e instanceof ProcessImplementation)) return false;
		return (this.pid == ((ProcessImplementation)e).pid) ? true : false;
	}
	
	public void execute()
	{
		this.executionTime--;
	}
}
