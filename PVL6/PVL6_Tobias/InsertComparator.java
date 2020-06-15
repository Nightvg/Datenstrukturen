package PVL6_Tobias;

import java.util.Comparator;

public class InsertComparator implements Comparator<ProcessImplementation>  {
	@Override
	public int compare(ProcessImplementation o1, ProcessImplementation o2) {
		if(o1.getPriority() > o2.getPriority()) return -1;
		return 1;
	}
}
