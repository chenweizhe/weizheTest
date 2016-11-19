package chuliji;

import java.util.Comparator;

public class queueComparator implements Comparator<PCB4Scheduling> {

	@Override
	public int compare(PCB4Scheduling p1, PCB4Scheduling p2) {
		Integer p1time = p1.getArrviteTime();
		Integer p2time = p2.getArrviteTime();
		return p1time.compareTo(p2time);
	}

}
