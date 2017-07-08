package chuliji;

import java.util.Random;
import java.util.Scanner;

public class ProcessorScheduling {
	
	private static final int MAX_ARRIVE_TIME = 5;
	private static final int MAX_NEED_TIME = 10;
	private static final int MAX_PROCESS_NUM = 5;
	private static final int MAX_PRIORITY = 10;
	private final static int MAX_ID = 10000;
	private static Scanner scanner;
	
	public static void main(String[] args) {
		System.out.println("请输入选择的处理机调度算法：");
		scanner = new Scanner(System.in);
		int choose = scanner.nextInt();
		switch (choose) {
		    case 1:
			   RR();
			   break;
			case 2:
			   HRRN();
			   break;
			case 3:
				PSA();
		}
	}

	/**
	 * 抢占式优先级调度
	 */
	private static void PSA() {
	   PSA  psa = new PSA();
	   Random random = new Random();
	   for(int i=0; i<MAX_PROCESS_NUM;i++){
		   psa.addProcess(random.nextInt(MAX_ID), random.nextInt(MAX_PRIORITY), 
				   random.nextInt(MAX_ARRIVE_TIME), random.nextInt(MAX_NEED_TIME)+1);
	   }
	   psa.schedule();
	}

	/**
	 * 高响应比优先调度
	 */
	private static void HRRN() {
		HRRN hrrn = new HRRN();
		Random random = new Random();
		for(int i=0; i< MAX_PROCESS_NUM; i++){
			hrrn.addProcess(random.nextInt(MAX_ID), random.nextInt(MAX_ARRIVE_TIME), random.nextInt(MAX_NEED_TIME)+1);
		}
		
		hrrn.schedule();
		
	}
	
	/**
	 * 时间片轮转
	 */
	private static void RR() {
		RR rr = new RR();
		Random random = new Random();
		for(int i=0; i<MAX_PROCESS_NUM; i++){
			rr.addProcess(random.nextInt(MAX_ID), random.nextInt(MAX_ARRIVE_TIME), random.nextInt(MAX_NEED_TIME)+1);
		}
		rr.Schedule();
	}

}
