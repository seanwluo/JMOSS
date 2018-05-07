package Service;

import java.util.ArrayList;
import java.util.List;

import fileService.FileService;
import model.Book;
import model.Seat;

public class BookService
{
	private final FileService fService = new FileService("book.txt");
	private List<String> bookingData;
	private Seat seat;
	private SeatService seatService;
	
	public BookService(SeatService seatService, Seat seat)
	{
		this.seat = seat;
		this.seatService = seatService;
		this.bookingData = fService.read();
	}
	
	public Book findById(String seatId)
	{
		Book book = null;
		
		for(String booking: bookingData) {
			String[] data = booking.split(",");
			
			String sessionSeatId = data[0].trim();
			if(sessionSeatId.equals(seatId))
			{
				String email = data[1].trim();
				String suburb = data[2].trim();
				String time = data[3].trim();
				
				book = new Book(seat);
				book.setEmail(email);
				book.setSuburb(suburb);
				book.setTime(time);
				
				break;
			}
		}
		
		return book;
	}
	
	public void createBooking(String email, String suburb) {
		Book book = new Book(seat);
		
		book.setEmail(email);
		book.setEmail(suburb);
		String data = String.format("%s, %s, %s", book.getSeatSesionId(), email, suburb);
		bookingData.add(data);
	}

	public void removeBooking(String seatSessionId) {
		List<String> newBookingData = new ArrayList<String>();
		boolean deleted = false;
		for(String booking: bookingData)
		{
			String[] data = booking.split(",");
			String seatId = data[0].trim();
			if(seatId.equals(seatId))
			{	
				deleted = true;
				seatService.removeBooking(seat);
			} else {
				newBookingData.add(booking);
			}
		}
		
		bookingData = newBookingData;
		
		if(deleted) {
			System.out.print("\nDeleted successfully.");
		} else {
			System.out.print("\nRecord noy found.");
		}
	}

	public void saveData() {
		String data = "seatSessionId, email, suburb, time\n";
		for(String bookData : bookingData)
		{
			data += bookData + "\n";
		}
		
		fService.write(data);
	}
}
