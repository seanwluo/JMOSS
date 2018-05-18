package Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import fileService.FileService;
import model.Book;
import model.MovieSession;
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
	
	public BookService() {
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
		String time = Calendar.getInstance().getTime().toString(); 
		book.setTime(time);
		Book.count += 1;
		String data = String.format("%s, %s, %s, %s", book.getSeatSessionId(), email, suburb, time);
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
				Book.count -= 1;
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

	public void list() {
		List<Book> bookings = new ArrayList<Book>();
		System.out.println("seatSessionId, email, suburb, time");
		for(String bookData: bookingData) {
			String[] data = bookData.split(",");
			
			String seatSessionId = data[0].trim();
			String email = data[1].trim();
			String suburb = data[2].trim();
			String time = data[3].trim();
			Book book = new Book(seatSessionId, email, suburb, time);
			System.out.println(book.toString());
			bookings.add(book);
		}
		
	}
}
