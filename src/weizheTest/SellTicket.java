package weizheTest;


public class SellTicket {
	public static void main(String[] args) {
		Ticket ticket = new Ticket(50,"2016-10-26 7:00" , "江门", "广州");
		Ticket ticket2 = new Ticket(60,"2016-10-26 8:00" , "汕头", "广州");
		for(int i = 1; i<=52; i++){
			Person person = new Person(ticket, "买江门到广州的人"+i+" ",1000);
			person.start();
		}
		for(int i = 1; i<=52; i++){
			Person person = new Person(ticket2, "买汕头带广州的人"+i+" ",2000);
			person.start();
		}
	}
}
