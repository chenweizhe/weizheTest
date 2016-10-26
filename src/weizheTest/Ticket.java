package weizheTest;


import java.util.concurrent.Semaphore;

public class Ticket {
	private int ticketNum;// 票数
    Semaphore semaphore = new Semaphore(1);//信号量

    public Ticket(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    // 取票，票数减一
    public  void getTicket(String name) throws InterruptedException {       
    	semaphore.acquire(); //P操作
        if (ticketNum >= 1) {
            System.out.println("-----------------------------" + name
                    + " 买票成功，号码=" + ticketNum);
            this.subTicketNum();
            System.out.println("-----------------------------当前还有 "+semaphore.getQueueLength()+"人在等待买票 ");
        } else {// 票数为0
            System.out.println("----------------------票已经售完， " + name
                    + " 没有买到票");
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
}
