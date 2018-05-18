package view;

import Service.BookService;
import Service.SeatService;
import model.Book;
import model.Seat;

public class SeatsMenu extends AbstractMenu
{	
	private BookService bookService;
	private SeatService seatService; 
	private Seat seat;
	
	public SeatsMenu(SeatService seatService, Seat seat)
	{
		this.seat = seat;
		this.seatService = seatService;
		bookService = new BookService(seatService, seat);
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
				if(confirmation("Do you want to booking?")) {
					System.out.println(Book.count);
					if(Book.count >= 20) {
						System.out.println("\nLimt cross! Book only 20 seats per day.");
					} else {
						bookingProcess();
					}
				}
				
				break;
			case "2":
				if(confirmation("Do you want to delete booking?")) {
					removeBookingProcess();
				}
				
				break;
			case "0":
				bookService.saveData();
				System.out.println("\nGoing back to Movie Session Menu");
				break;
			default:
				System.out.println("\nWARNINIG!! option out of range.");
				System.out.print("\nEnter options from menu list:");
				break;
		}
	}
	
	private void bookingProcess()
	{
		System.out.print("\nEnter the customer email: ");
//		TODO: Check email format
		String email = reader.nextLine();
		
		System.out.print("\nEnter the suburb: ");
		String suburb = reader.nextLine();
		
		if(seat.getBook().equals("available") || seat.getBook().equals("")) 
		{	
			bookService.createBooking(email, suburb);
//			seat.setBook("booked");
			seatService.createBooking(seat);
			System.out.println("\nSeat is Booked");
		} else {
			System.out.println("\nSeat is already booked.");
		}
	}
	
	private void removeBookingProcess()
	{
		if(!seat.getBook().equals("available")) 
		{	
			bookService.removeBooking(seat.getSessionId());
//			seat.setBook("available");
			seatService.removeBooking(seat);
			System.out.println("\nSeat is available");
		} else {
			System.out.println("Seat is not booked.");
		}
	}
	
	private boolean confirmation(String str) {
		System.out.print(str);
		System.out.print("\n Enter (y/n): ");
		String ch = reader.nextLine();
		ch = ch.toLowerCase();
		if(ch.equals("y") || ch.equals("yes"))
		{
		return true;
		} else {
			return false;
		}
	}
}
