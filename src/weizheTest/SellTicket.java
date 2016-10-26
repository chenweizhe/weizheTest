package weizheTest;


public class SellTicket {
	public static void main(String[] args) {
		Ticket ticket = new Ticket(50);
		for(int i = 1; i<=52; i++){
			Person person = new Person(ticket, "买票者"+i+" ");
			person.start();
		}
	}
}
