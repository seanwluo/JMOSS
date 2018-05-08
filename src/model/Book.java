package model;

public class Book
{	
	public static int count=0;
	private Seat seat;
	private String seatSesionId;
	private String email;
	private String suburb;
	private String time;
	
	public Book(Seat seat)
	{
		this.seat = seat;
		this.seatSesionId = seat.getSessionId();
	}

	public Seat getSeat() {
		return seat;
	}

	public String getSeatSesionId() {
		return seatSesionId;
	}

	public void setSeatSesionId(String seatSesionId) {
		this.seatSesionId = seatSesionId;
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
	
}
