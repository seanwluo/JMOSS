package model;

public class Book
{	
	public static int count=0;
	private Seat seat;
	private String seatSessionId;
	private String email;
	private String suburb;
	private String time;
	
	public Book(Seat seat)
	{
		this.seat = seat;
		this.seatSessionId = seat.getSessionId();
	}

	public Book(String seatSessionId, String email, String suburb, String time) {
		this.seatSessionId = seatSessionId;
		this.email = email;
		this.suburb = suburb;
		this.time = time;
	}

	public Seat getSeat() {
		return seat;
	}

	public String getSeatSessionId() {
		return seatSessionId;
	}

	public void setSeatSessionId(String seatSessionId) {
		this.seatSessionId = seatSessionId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public String toString()
	{
		return String.format("%s, %s, %s, %s", seatSessionId, email, suburb, time);
	}
}
