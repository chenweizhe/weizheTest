package weizheTest;


public class Person extends Thread {
	Ticket ticket;
	String name;
	public Person(Ticket ticket, String name) {
		super();
		this.ticket = ticket;
		this.name = name;
	}
	
	@Override
	public void run() {
		try {
			ticket.getTicket(name);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
}
