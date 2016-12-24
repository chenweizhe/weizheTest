package chuliji;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import chuliji.PCB4Scheduling;

/**
 * 抢占式优先级调度
 * @author javazhe
 *
 */

public class PSA {
	private LinkedList<PCB4Scheduling> processQueue;

	public PSA() {
		processQueue = new LinkedList<PCB4Scheduling>();
	}
	
	public void schedule(){
		sortByArriveTime(processQueue);
		PCB4Scheduling process,tempProcess;
		int arriveTime, needTime, runTime, currentTime = 0 ;
		while(!processQueue.isEmpty()){
			process = processQueue.pollFirst();
			arriveTime = process.getArrviteTime();
			if(currentTime < arriveTime)
				currentTime =arriveTime;
			for(int i=0; i<processQueue.size(); i++){
				needTime = process.getNeedTime();
				tempProcess = processQueue.get(i);
				if(tempProcess.getArrviteTime() > currentTime+needTime)
					break;
				//当前进程执行至被高优先级进程抢占
				if(tempProcess.getPriority() < process.getPriority()){
					if(tempProcess.getArrviteTime() != currentTime){
						processQueue.remove(i);
						System.out.print("进程："+process.getId()+" 优先级："+(int)process.getPriority()+" 到达时间："+ process.getArrviteTime()+" 需要时间："+process.getNeedTime()+" 开始时间："+currentTime);
						runTime = tempProcess.getArrviteTime() - currentTime;
						process.setNeedTime(needTime-runTime);
						currentTime += runTime;
						System.out.println(" 进程中断时间："+currentTime);
						processQueue.addFirst(process);
						process = tempProcess;
					}else{
						processQueue.set(i, process);
						process = tempProcess;
						tempProcess = processQueue.get(i);
					}
				}else{
					subSortByPriority(processQueue,0,i + 1);
				}
			}
			
			System.out.print("进程："+process.getId()+" 优先级："+(int)process.getPriority()+" 到达时间: "+process.getArrviteTime()+" 所需时间："+process.getNeedTime()+" 开始时间："+currentTime+" ");
			currentTime += process.getNeedTime();
			System.out.println("结束时间+ "+currentTime);
			
		}
	}
	
	public void addProcess(int id, int priority, int arriveTime, int needTime){
		processQueue.push(new PCB4Scheduling(id,priority,arriveTime,needTime));
	}

	private void subSortByPriority(LinkedList<PCB4Scheduling> processQueue2, int fromIndex, int toIndex) {
	    List<PCB4Scheduling> subQueue = processQueue2.subList(fromIndex, toIndex);
	    Collections.sort(subQueue,new PriorityComparator());	
	}

	private void sortByArriveTime(LinkedList<PCB4Scheduling> processQueue) {
		Collections.sort(processQueue,new queueComparator());
	}
	
}
