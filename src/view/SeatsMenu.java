package view;

import model.Seat;

public class SeatsMenu extends AbstractMenu
{
	private Seat seat;
	
	public SeatsMenu(Seat seat)
	{
		this.seat = seat;
	}
	
	@Override
	protected String getMenu() {
		return "\nSeat Menu"
				+ "\n1.  Book a seat"
				+ "\n2.  Remove booking"
				+ "\n0.  Back"
				+ "\nEnter the choice: ";
	}

	@Override
	protected void processChoice(String choice) {
		switch(choice)
		{
			case "1":
				if(seat.getBook().equals("available") || seat.getBook().equals("")) 
				{
					seat.setBook("booked");
					System.out.println("\nSeat is Booked");
				} else {
					System.out.println("Seat is already booked.");
				}
				break;
			case "2":
				if(!seat.getBook().equals("available")) 
				{
					seat.setBook("available");
					System.out.println("\nSeat is available");
				} else {
					System.out.println("Seat is not booked.");
				}
				break;
			case "0":
				System.out.println("\nGoing back to Movie Session Menu");
				break;
			default:
				System.out.println("\nWARNINIG!! option out of range.");
				System.out.println("\nEnter options from menu list");
				break;
		}
	}

}
