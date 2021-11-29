import java.util.ArrayList;

public class TRAPSCalendar extends java.lang.Object {
	
	private ArrayList<Event> calendar;

	
	public TRAPSCalendar () {
		
		calendar = new ArrayList<Event>();
		
	}
	
	public boolean add(Event evt) {
		
		return calendar.add(evt);
		
	}
	
	public Event get(int i) {
		if (i >= calendar.size() || i < 0)
			return null;
		
		return calendar.get(i);
		
	}
	
	public Event get(java.lang.String name) {
		
		for (int i = 0; i < calendar.size(); i++) {
			Event event = calendar.get(i);
			if (event.getEventName().equals(name))
				return event;
		}
		return null;
	}
	
	public int size() {
		
		return calendar.size();
		
	}
	
	public java.util.ArrayList<Event> list() {
		
		return calendar;
		
	}
	
	public java.lang.String toString() {
		
		return calendar.toString();
	}
	

	public java.util.ArrayList<Event> sortByProfit() {
		
	    java.util.ArrayList<Event> sorted = new ArrayList<Event>();
	    
	    for (int k = 0; k < calendar.size(); k++) {
	    	sorted.add(calendar.get(k));
	    }
	    
		for (int i = 0; i < sorted.size() - 1; i++) {
	        // Find the minimum in the list[i..list.length-1]
	        Event leastProfit = sorted.get(i);
	        int leastProfitIndex = i;

	        for (int j = i + 1; j < sorted.size(); j++) {
	          if (leastProfit.getProfit() > sorted.get(j).getProfit()) {
	        	leastProfit = sorted.get(j);
	        	leastProfitIndex = j;
	          }
	        }

	        // Swap list[i] with list[currentMinIndex] if necessary;
	        if (leastProfitIndex != i) {
	        	sorted.set(leastProfitIndex, sorted.get(i));
	        	sorted.set(i, leastProfit);
	        }
	      }
		return sorted;
	}
	
	public java.util.ArrayList<Event> sortByDate() {
		
	    java.util.ArrayList<Event> sorted = new ArrayList<Event>();
	    
	    for (int k = 0; k < calendar.size(); k++) {
	    	sorted.add(calendar.get(k));
	    }
	    
		for (int i = 0; i < sorted.size() - 1; i++) {
	        // Find the minimum in the list[i..list.length-1]
	        Event earliestDate = sorted.get(i);
	        int earliestDateIndex = i;

	        for (int j = i + 1; j < sorted.size(); j++) {
	          if (earliestDate.getDate().compareTo(sorted.get(j).getDate()) > 0) {
	        	  earliestDate = sorted.get(j);
	        	  earliestDateIndex = j;
	          }
	        }

	        // Swap list[i] with list[currentMinIndex] if necessary;
	        if (earliestDateIndex != i) {
	        	sorted.set(earliestDateIndex, sorted.get(i));
	        	sorted.set(i, earliestDate);
	        }
	      }
		
		return sorted;
	} 
	
}
