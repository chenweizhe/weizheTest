package chuliji;

import java.util.Comparator;

public class PriorityComparator implements Comparator<PCB4Scheduling>{

	@Override
	public int compare(PCB4Scheduling p1, PCB4Scheduling p2) {
		Double p1Priority = p1.getPriority();
		Double p2Priority = p2.getPriority();
		return p1Priority.compareTo(p2Priority);
	}

}
