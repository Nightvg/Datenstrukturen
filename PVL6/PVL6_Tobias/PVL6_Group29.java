package PVL6_Tobias;
import java.util.PriorityQueue;

public class PVL6_Group29 implements SchedulingTask{

	private boolean[] pids;
	private int kernelNumber, qSize;
	private ProcessImplementation[] buffer;
	private PriorityQueue<ProcessImplementation> q;
	
	public PVL6_Group29(int kernelNumber)
	{
		this.kernelNumber = kernelNumber;
		this.pids = new boolean[255];
		this.buffer = new ProcessImplementation[kernelNumber];
		this.q = new PriorityQueue<>(new ProcessComparator());
		this.qSize = 11;
	}
	
	@Override
	public int createProcess(int arrivalTime, int executionTime, int priority) {
		if(q.size() + 1 > qSize)
		{
			PriorityQueue<ProcessImplementation> q2 = new PriorityQueue<>(2*qSize, new ProcessComparator());
			q2.addAll(q);
			q = q2;
			qSize = 2*qSize;
		}
		int i = getLowestPID() + 1;
		if(i == 0) return -1;
		q.add(new ProcessImplementation(i, arrivalTime, executionTime, priority));
		return i;
	}

	@Override
	public boolean deleteProcess(int pid) {
		if(!pids[pid - 1]) return false;
		pids[pid - 1] = false;
		return q.remove(new ProcessImplementation(pid));
	}

	@Override
	public String execute() {
		int i = 0;
		String output = "";
		while(true)
		{
			String line = "";
			line += Integer.toString(i) + " : ";
			
			for(int j = 0; j < kernelNumber; j++)
			{
				if(buffer[j] != null && buffer[j].getExecutionTime() == 0) buffer[j] = null;
				if(!q.isEmpty() && q.peek().getArrivalTime() <= i)
				{
					int buff = getFreeProcessor();
					if(buff >= 0) buffer[buff] = q.poll();
				}
				
				if(buffer[j] != null)
				{
					buffer[j].execute();
					line += Integer.toString(buffer[j].getPID()) + " ";
				}
				else line += "0 ";
				
			}
			line += "\n";
			
			i++;
			if(q.isEmpty() && isBufferEmpty()) break;
			else output += line;
		}
		
		return output;
	}
	
	private int getLowestPID()
	{
		for(int i = 0; i < 256; i++)
		{
			if(!pids[i])
			{
				pids[i] = true;
				return i;
			}
		}
		
		return -1;
	}
	
	private int getFreeProcessor()
	{
		for(int i = 0; i < buffer.length; i++)
		{
			if(buffer[i] == null) return i; 
		}
		return -1;
	}
	
	private boolean isBufferEmpty()
	{
		for(int i = 0; i < buffer.length; i++) if(buffer[i] != null) return false;
		return true;
	}

}
