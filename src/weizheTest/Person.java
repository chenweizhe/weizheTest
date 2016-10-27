package weizheTest;


public class Person extends Thread {
	Ticket ticket;
	String name;
	private int time;
	public Person(Ticket ticket, String name,int time) {
		super();
		this.ticket = ticket;
		this.name = name;
		this.time = time;
	}
	
	@Override
	public void run() {
		try {
			ticket.getTicket(name);
			sleep(time);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
}
