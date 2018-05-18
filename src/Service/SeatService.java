package Service;

import java.util.ArrayList;
import java.util.List;

import fileService.FileService;
import model.Seat;

public class SeatService
{
	private final FileService fService = new FileService("seat.txt");
	private List<String> seatsData;
	
	public SeatService()
	{
		this.seatsData = fService.read();
	}
	
	public List<Seat> seatList()
	{
		List<Seat> seats = new ArrayList<Seat>();
		System.out.println("SeatId, Row No, Seat No, Status");
		for(String seatData: seatsData) {
			if(seatData.equals(null) || seatData.equals(""))
			{
				continue;
			}
			
			String[] data = seatData.split(",");
			
			String sessionSeatId = data[0].trim();
			String rowNo = data[1].trim();
			String seatNo = data[2].trim();
			String status = data[3].trim();
			Seat seat = new Seat(sessionSeatId, rowNo, seatNo, status);
			System.out.println(seat.toString());
			seats.add(seat);
		}
		
		return seats;
	}
	
	public Seat findById(String seatId)
	{	
		Seat seat = null;
		
		for(String seatData: seatsData) {
			if(seatData.equals(null) || seatData.equals(""))
			{
				continue;
			}
			
			String[] data = seatData.split(",");
			
			String sessionSeatId = data[0].trim();
			if(sessionSeatId.equals(seatId))
			{
				String rowNo = data[1].trim();
				String seatNo = data[2].trim();
				String status = data[3].trim();
				
				seat = new Seat(sessionSeatId, rowNo, seatNo, status);
				break;
			}
		}
		
		return seat;
	}

	public void removeBooking(Seat seat) {
		List<String> newData= new ArrayList<String>();
		seat.setBook("available");
		for(String seatData: seatsData)
		{	
			if(seatData.equals(null) || seatData.equals(""))
			{
				continue;
			}
			
			String[] data = seatData.split(",");
			String seatId = data[0].trim();
			if(!seatId.equals(seat.getSessionId()))
			{	
				newData.add(seatData);
			}
		}
		
		seatsData = newData;
	}
	
	public void saveData()
	{
		String data = "seatSessionId, Row No, Seat No, Status\n";
		for(String seatData : seatsData)
		{
			data += seatData + "\n";
		}
		
		fService.write(data);
	}

	public void createBooking(Seat seat) {
		List<String> newData= new ArrayList<String>();
		seat.setBook("booked");
		for(String seatData: seatsData)
		{	
			if(seatData.equals(null) || seatData.equals(""))
			{
				continue;
			}
			
			String[] data = seatData.split(",");
			String seatId = data[0].trim();
			if(seatId.equals(seat.getSessionId()))
			{	
				newData.add(seat.toString());
			} else {
				newData.add(seatData);
			}
		}
		
		seatsData = newData;
		
	}
}
