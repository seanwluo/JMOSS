package view;

import java.util.regex.Pattern;

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
				+ "\n00. Main menu"
				+ "\nEnter the choice: ";
	}

	@Override
	protected String processChoice(String choice) {
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
			case "00":
				bookService.saveData();
//				System.out.println("\nGoing back to Main Menu");
				break;
			default:
				System.out.println("\nWARNINIG!! option out of range.");
				System.out.print("\nEnter options from menu list:");
				break;
		}
		
		return choice;
	}
	
	private void bookingProcess()
	{
		String email = emailInput();
		
		System.out.print("\nEnter the suburb: ");
		String suburb = reader.nextLine();
		
		if(seat.getBook().equals("available") || seat.getBook().equals("")) 
		{	
			bookService.createBooking(email, suburb);
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
	
	private String emailInput()
	{
		String email = null;
		boolean validEmail = false;
		do {
			System.out.print("\nEnter the customer email: ");
			email = reader.nextLine();
			validEmail = isEmailValid(email);
			if(!validEmail) {
				System.out.println("Invalid email.");
			}
		} while(!validEmail);
		
		return email;
	}
	
	private boolean isEmailValid(String email)
	{
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
							"[a-zA-Z0-9_+&*-]+)*@" +
							"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
							"A-Z]{2,7}$";
							
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null) {
			return false;
		}
		
		return pat.matcher(email).matches();
	}
	
}
