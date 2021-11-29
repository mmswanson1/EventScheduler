
public class Event extends java.lang.Object {
	
	private String eventName;
	private String eventVenue;
	private int venueCapacity;
	private String date;
	private int ticketsSold;
	private int ticketPrice;
	private int overhead;
	
	
	public Event() {
		
	}
	
	public Event(java.lang.String eventName, java.lang.String eventVenue) {
		this.eventName = eventName;
		this.eventVenue = eventVenue;
		
	}
	
	public Event(String eventName, String eventVenue, int venueCapacity, String date, int ticketsSold, int ticketPrice, int overhead) {
		this.eventName = eventName;
		this.eventVenue = eventVenue;
		this.venueCapacity = venueCapacity;
		this.ticketPrice = ticketPrice;
		this.overhead = overhead;
		this.date = date;
		if (ticketsSold <= venueCapacity) {
			this.ticketsSold = ticketsSold;
		}
		else {
			this.ticketsSold = 0;
		}
	}
	
	
	public boolean sellTickets(int numberOfTickets) {
		if ((numberOfTickets > 0) && ((numberOfTickets + ticketsSold) <= venueCapacity)) {
			ticketsSold += numberOfTickets;
			return true;
		}
		
		return false;		
	}
	
	
	public int getProfit() {
		int profit = (ticketsSold * ticketPrice) - overhead;
		return profit;
	}
	
	
	public int getBreakEvenPoint() {
		int breakEven = (int) Math.ceil(overhead/(double)ticketPrice);
		return breakEven;
	}
	
	
	public int compareName(Event other) {
		return this.eventName.compareTo(other.eventName);
	}
	
	
	public int compareDate(Event other) {
		return this.date.compareTo(other.date);
	}
	
	
	public int compareProfit(Event other) {
		if (this.getProfit() < other.getProfit())
			return -1;
		else if (this.getProfit() > other.getProfit())
			return 1;
		else
			return 0;
	}
	
	
	public String getEventName() {
		return eventName;
	}
	
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	
	public String getEventVenue() {
		return eventVenue;
	}
	
	
	public void setEventVenue(String eventVenue) {
		this.eventVenue = eventVenue;
	}
	
	
	public int getTicketsSold() {
		return ticketsSold;
	}
	
	
	public void setTicketsSold(int ticketsSold) {
		if ((ticketsSold > 0) && (ticketsSold < venueCapacity)) {
			this.ticketsSold = ticketsSold;
		}
	}
	
	
	public int getTicketPrice() {
		return ticketPrice;
	}
	
	
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	
	public int getOverhead() {
		return overhead;
	}
	
	
	public void setOverhead(int overhead) {
		this.overhead = overhead;
	}
	
	
	public String getDate() {
		return date;
	}
	
	
	public void setDate(String date) {
			this.date = date;
	}
	
	
	public String toString() {
		return "Event: " + this.eventName + ", Venue: " + this.eventVenue + ", Date: " + this.date + ", Tickets Sold: "
				+ this.ticketsSold + ", Ticket Price: $" + this.ticketPrice + ", Overhead: $" + this.overhead + ", Venue Capacity: "
				+ this.venueCapacity + ", Profit: $" + this.getProfit() + ", Break Even Point: " + this.getBreakEvenPoint() + "\n";
	}
	
	
	public int getVenueCapacity() {
		return venueCapacity;
	}
	
	
	public void setVenueCapacity(int venueCapacity) {
		this.venueCapacity = venueCapacity;
	}

}
