package chuliji;

/**
 * 进程控制块
 * @author javazhe
 *
 */
public class PCB4Scheduling {
	/**
	 * 进程号
	 * 优先级
	 * 到达时间
	 * 所需时间
	 */
	private int id;
	private double priority;
	private int arrviteTime;
	private int needTime;
	
	public PCB4Scheduling(int id, int arriveTime, int needTime) {
		this.id = id;
		this.arrviteTime = arriveTime;
		this.needTime = needTime;
	}
	
	

	public PCB4Scheduling(int id, double priority, int arrviteTime, int needTime) {
		super();
		this.id = id;
		this.priority = priority;
		this.arrviteTime = arrviteTime;
		this.needTime = needTime;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPriority() {
		return priority;
	}

	public void setPriority(double priority) {
		this.priority = priority;
	}

	public int getArrviteTime() {
		return arrviteTime;
	}

	public void setArrviteTime(int arrviteTime) {
		this.arrviteTime = arrviteTime;
	}

	public int getNeedTime() {
		return needTime;
	}

	public void setNeedTime(int needTime) {
		this.needTime = needTime;
	}

}
