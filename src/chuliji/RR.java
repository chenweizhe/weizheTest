package chuliji;

import java.util.Collections;
import java.util.LinkedList;


/**
 * 时间片轮转算法
 * @author javazhe
 *
 */
public class RR {
	private LinkedList<PCB4Scheduling> processQueue;
	
	private static final int TIME_SLICE = 5;
	
	public RR() {
		processQueue = new LinkedList<PCB4Scheduling>();
	}
	
	public void Schedule(){
		sortByArrayTime(processQueue);
		
		PCB4Scheduling process;
		int currentTime = 0;
		int arriveTime;
		int needTime;
		
		while(!processQueue.isEmpty()){
			process = processQueue.pollFirst();
			needTime = process.getNeedTime();
			arriveTime = process.getArrviteTime();
			System.out.println("进程: "+process.getId());
			System.out.println("到达时间： "+process.getArrviteTime());
			System.out.println("还所需时间： "+process.getNeedTime());
			if (currentTime < arriveTime) {
				currentTime = arriveTime;
			}
			System.out.println("开始时间"+currentTime);
			if (TIME_SLICE < needTime) {
				currentTime += TIME_SLICE;
				System.out.println("进程中断时间："+currentTime);
				process.setNeedTime(needTime - TIME_SLICE);
				for(int i=0; i<processQueue.size(); i++){
					if (processQueue.get(i).getArrviteTime() > currentTime) {
						processQueue.add(i, process);
						break;
					}else if (i == processQueue.size() - 1) {
						processQueue.add(process);
						break;
					}
				}
				
			}else {
				currentTime += needTime;
				System.out.println("结束时间："+currentTime);
			}
			
		}
	}
	
	public void addProcess(int id,int arriveTime,int needTime){
		processQueue.push(new PCB4Scheduling(id, arriveTime, needTime));
	}

	private <T> void sortByArrayTime(LinkedList<PCB4Scheduling> processQueue) {
		Collections.sort(processQueue,new queueComparator());
	}
	
	
}
