package weizheTest;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

public class Ticket {
	private int ticketNum;// 票数
	private String time;
	private String start,end;
   
	Semaphore semaphore = new Semaphore(1);//信号量

    public Ticket(int ticketNum,String time,String start,String end) {
        this.ticketNum = ticketNum;
        this.time = time;
        this.start = start;
        this.end = end;
    }
    // 取票，票数减一
    public  void getTicket(String name) throws InterruptedException {       
    	semaphore.acquire(); //P操作
        if (ticketNum >= 1) {
        	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        	System.out.println("--------------------------------------");
        	System.out.println(time+"--"+start+" 开往 "+end+"的班车");
            System.out.println(name + " 买票成功，号码=" + ticketNum+" 购票时间"+df.format(new Date()));
            this.subTicketNum();
            System.out.println("当前还有 "+semaphore.getQueueLength()+"人在等待买票 ");
           // System.out.println("--------------------------------------");
        } else {// 票数为0
        	System.out.println("--------------------------------------");
            System.out.println("票已经售完 " + name + " 没有买到票");
            System.out.println("--------------------------------------");
        }
        semaphore.release(); //V操作 
    }

    public void subTicketNum() {
        if (this.ticketNum > 0)
            this.ticketNum = this.ticketNum - 1;
    }

    public int getTicketNum() {
        return ticketNum;
    }
   
	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}

}
