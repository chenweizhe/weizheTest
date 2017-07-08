package chuliji;

import java.util.Collections;
import java.util.LinkedList;
/**
 * 高响应比优先调度
 * @author javazhe
 *
 */
public class HRRN {
	private LinkedList<PCB4Scheduling> proessQueue;

	public HRRN() {
		proessQueue = new LinkedList<PCB4Scheduling>();
	}
	
	public void schedule(){
		sortByArrayTime(proessQueue);
		PCB4Scheduling process,tempProcess;
		int arriveTime, needTime,maxIndex;
		int currentTime = 0;
		double respRatio,maxPriority=0;
		
		while(!proessQueue.isEmpty()){
			process = proessQueue.pollFirst();
			arriveTime = process.getArrviteTime();
			needTime = process.getNeedTime();
			if(currentTime  < arriveTime)
				currentTime = arriveTime;
			maxIndex = -1;
			maxPriority = -1;
			//当前进程完成后，选择到达的最高相应比的进程
			for(int i=0; i<proessQueue.size(); i++){
				tempProcess = proessQueue.get(i);
				if(tempProcess.getArrviteTime() > currentTime + needTime)
					break;
				respRatio = (currentTime + needTime -tempProcess.getArrviteTime())/(double)tempProcess.getNeedTime() + 1;
				tempProcess.setPriority(respRatio);
				if(respRatio > maxPriority){
					maxIndex = i;
					maxPriority = respRatio;
				}
			}
			//响应比高的放在队头
			if(maxIndex != -1){
				tempProcess = proessQueue.remove(maxIndex);
				proessQueue.addFirst(tempProcess);
			}
			System.out.print("进程："+process.getId()+"  响应比："+process.getPriority()+" 到达时间："+
			process.getArrviteTime()+" 所需时间："+process.getNeedTime()+" 开始时间："+currentTime+" ");
			currentTime += needTime;
			System.out.println("结束时间："+currentTime);	
		}
	}
	
	public void addProcess(int id, int arriveTime, int needTime){
		PCB4Scheduling process = new PCB4Scheduling(id, arriveTime, needTime);
		proessQueue.push(process);
	}
	/**
	 * 对进程队列进行排序
	 * @param proessQueue
	 */
	private void sortByArrayTime(LinkedList<PCB4Scheduling> proessQueue) {
		Collections.sort(proessQueue,new queueComparator());
	}
	
}
