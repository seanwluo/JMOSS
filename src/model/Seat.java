package model;

public class Seat {
	private String sessionSeatId;
	private String rowNo;
	private String seatNo;
	private String book;
	
	public Seat() {};
	
	public Seat(String sessionSeatId)
	{
		this.sessionSeatId = sessionSeatId;
	}

	public Seat(String sessionSeatId, String rowNo, String seatNo, String book)
	{
		this.sessionSeatId = sessionSeatId;
		this.rowNo = rowNo;
		this.seatNo = seatNo;
		this.book = book;
	}
	
	public String getSessionId() {
		return sessionSeatId;
	}

	public void setSessionId(String sessionId) {
		this.sessionSeatId = sessionId;
	}

	public String getRowNo() {
		return rowNo;
	}

	public void setRowNo(String rowNo) {
		this.rowNo = rowNo;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}
	
	public String toString()
	{
		return String.format("%s, %s, %s, %s", sessionSeatId, rowNo, seatNo, book);
	}
}
