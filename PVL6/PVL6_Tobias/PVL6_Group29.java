package PVL6_Tobias;
import java.util.PriorityQueue;

/*
 * Beteiligte Personen:
 * 
 * Klenke, Susann
 * Geier, Annina Tara Tanita Petra
 * Allrich, Tobias
 * Porrmann, Tim
 * Lange, David
 */

public class PVL6_Group29 implements SchedulingTask{

	private boolean[] pids;
	private int kernelNumber;
	private ProcessImplementation[] buffer;
	private PriorityQueue<ProcessImplementation> q;
	private PriorityQueue<ProcessImplementation> insert;
	
	public PVL6_Group29(int kernelNumber)
	{
		if(kernelNumber < 1) return;
		this.kernelNumber = kernelNumber;
		this.pids = new boolean[255];
		this.buffer = new ProcessImplementation[kernelNumber];
		this.q = new PriorityQueue<>(255, new ProcessComparator());
		this.insert = new PriorityQueue<>(255, new InsertComparator());
	}
	
	@Override
	public int createProcess(int arrivalTime, int executionTime, int priority) {
		if(arrivalTime < 0 || executionTime < 1) return -1;
		int i = getLowestPID() + 1;
		if(i == 0) return -1;
		q.add(new ProcessImplementation(i, arrivalTime, executionTime, priority));
		return i;
	}

	@Override
	public boolean deleteProcess(int pid) {
		if(pid < 1 || pid > 255 || !pids[pid - 1]) return false;
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
			
			while(!q.isEmpty() && q.peek().getArrivalTime() == i)
			{
				insert.add(q.poll());
			}
			
			for(int j = 0; j < kernelNumber; j++)
			{
				if(buffer[j] != null && buffer[j].getExecutionTime() == 0) buffer[j] = null;
				if(!insert.isEmpty())
				{
					int buff = getFreeProcessor();
					if(buff >= 0) buffer[buff] = insert.poll();
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
			if(isBufferEmpty() && insert.isEmpty() && q.isEmpty()) break;
			output += line;
		}
		
		return output;
	}
	
	private int getLowestPID()
	{
		for(int i = 0; i < 255; i++)
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
