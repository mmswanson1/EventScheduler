import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class WVTrapsEvents {
	
	private JTextField inputName;
	private JTextField inputVenue;
	private JTextField inputCap;
	private JTextField inputDate;
	private JTextField inputTickets;
	private JTextField inputPrice;
	private JTextField inputOC;
	private JTextArea eventListDisplay;
	private JLabel warningDisplay;
	private TRAPSCalendar calendar = new TRAPSCalendar();
	
	public WVTrapsEvents() {
		
		WidgetViewer wv = new WidgetViewer();
		ButtonEvent eventHandler = new ButtonEvent();
		
		JLabel nameLabel = new JLabel("Event Name");
		inputName = new JTextField();
		
		JLabel venueLabel = new JLabel("Event Venue");
		inputVenue = new JTextField();
		
		JLabel capLabel = new JLabel("Venue Capacity");
		inputCap = new JTextField();
		
		JLabel dateLabel = new JLabel("Event Date (YYYY-MM-DD)");
		inputDate = new JTextField("2020-");
		
		JLabel ticketsLabel = new JLabel("Tickets Sold");
		inputTickets = new JTextField();
		
		JLabel priceLabel = new JLabel("Ticket Price");
		inputPrice = new JTextField();
		
		JLabel overheadLabel = new JLabel("Overhead Costs");
		inputOC = new JTextField();
		
		JButton createAction = new JButton("Create an Event");
		createAction.addActionListener(eventHandler);
		JButton sellAction = new JButton("Sell Tickets");
		sellAction.addActionListener(eventHandler);
		JButton resetAction = new JButton("Reset List");
		resetAction.addActionListener(eventHandler);
		JButton sortDateAction = new JButton("Sort by Date");
		sortDateAction.addActionListener(eventHandler);
		JButton sortProfitAction = new JButton("Sort by Profit");
		sortProfitAction.addActionListener(eventHandler);
		
		eventListDisplay = new JTextArea();
		eventListDisplay.setLineWrap(true);
		
		warningDisplay = new JLabel();
		
		wv.add(nameLabel, 10, 30, 120, 20);
		wv.add(inputName, 10, 50, 200, 20);
		wv.add(venueLabel, 10, 70, 200, 20);
		wv.add(inputVenue, 10, 90, 200, 20);
		wv.add(capLabel, 10, 110, 200, 20);
		wv.add(inputCap, 10, 130, 200, 20);
		wv.add(dateLabel, 10, 150, 200, 20);
		wv.add(inputDate, 10, 170, 200, 20);
		wv.add(ticketsLabel, 10, 190, 200, 20);
		wv.add(inputTickets, 10, 210, 200, 20);
		wv.add(priceLabel, 10, 230, 200, 20);
		wv.add(inputPrice, 10, 250, 200, 20);
		wv.add(overheadLabel, 10, 270, 200, 20);
		wv.add(inputOC, 10, 290, 200, 20);

		wv.add(createAction, 10, 320, 200, 20);
		wv.add(sellAction, 10, 340, 200, 20);
		wv.add(resetAction, 10, 360, 200, 20);
		wv.add(sortDateAction, 10, 380, 200, 20);
		wv.add(sortProfitAction, 10, 400, 200, 20);
		wv.add(warningDisplay, 10, 430, 750, 20);
		wv.add(eventListDisplay, 10, 460, 900, 180);
		
	}
	
	
	class ButtonEvent extends WidgetViewerActionEvent {

		public void actionPerformed(ActionEvent e) {
			
			try {
				String action = e.getActionCommand();
				warningDisplay.setText("");
			
				if (action.equals("Create an Event")) {
					createButton();
				}
			
				else if (action.equals("Sell Tickets")) {
					sellButton();
				}
			
				else if (action.contentEquals("Reset List")) {
					resetListButton();
				}
			
				else if (action.equals("Sort by Date")) {
					sortDateButton();
				}
			
				else if (action.equals("Sort by Profit")) {
					sortProfitButton();
				}
			
				reset();
			}	
		catch (NumberFormatException ex) {
			warningDisplay.setText("ERROR: Program only accepts integers where numbers are required. Please try again.");
			}
		catch (Exception ex) {
			warningDisplay.setText("Something went wrong. Please try again.");
			}
		}
	}
	
	public void createButton() {
		
		String eventName = inputName.getText();
		String eventVenue = inputVenue.getText();
		int venueCapacity =  Integer.parseInt(inputCap.getText());
		String eventDate = inputDate.getText();
		int ticketsSold = Integer.parseInt(inputTickets.getText());
		int ticketPrice = Integer.parseInt(inputPrice.getText());
		int eventOC = Integer.parseInt(inputOC.getText());
		
		if (!eventDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
			warningDisplay.setText("ERROR: Incorrect date format (YYYY-MM-DD). Please try again.");
			return;
		}

		Event newEvent = new Event(eventName, eventVenue, venueCapacity, eventDate, ticketsSold, ticketPrice, eventOC);
		calendar.add(newEvent);
		eventListDisplay.setText(calendar.toString());
		
		if (ticketsSold > venueCapacity) {
			warningDisplay.setText("ERROR: Event created successfully, but you attempted to oversell tickets. No tickets have been sold.");
		}
		else {
			warningDisplay.setText("Event successfully created.");
		}
	}
	
	
	public void sellButton() {
		String eventName = inputName.getText();
		int ticketsSold = Integer.parseInt(inputTickets.getText());
		boolean result = true;
		
		for (int i=0; i<calendar.size(); i++) {
			if (calendar.get(i).getEventName().equals(eventName)) {
				result = calendar.get(i).sellTickets(ticketsSold);
				
				if (!result) {
					warningDisplay.setText("ERROR: You attempted to oversell tickets. No additional tickets have been sold for " + calendar.get(i).getEventName() + " event.");
				}
				
				else if (result) {
					warningDisplay.setText("You successfully sold " + ticketsSold + " ticket(s) for " + calendar.get(i).getEventName() + " event.");
				}
			}
		
		}
		
		eventListDisplay.setText(calendar.toString());
	}
	
	
	public void resetListButton() {
		eventListDisplay.setText(calendar.toString());
	}
	
	
	public void sortDateButton() {
		eventListDisplay.setText(calendar.sortByDate().toString());
	}
	
	
	public void sortProfitButton() {
		eventListDisplay.setText(calendar.sortByProfit().toString());
	}
	
	
	public void reset() {
		inputName.setText("");
		inputVenue.setText("");
		inputCap.setText("");
		inputDate.setText("2020-");
		inputTickets.setText("");
		inputPrice.setText("");
		inputOC.setText("");
		
	}
}