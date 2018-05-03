package Service;

import java.util.ArrayList;
import java.util.List;

import fileService.FileService;
import model.Seat;

public class SeatService
{
	FileService fService = new FileService("seat.txt");
	
	public List<Seat> seatList()
	{
		List<String> seatsData = fService.read();
		List<Seat> seats = new ArrayList<Seat>();
		System.out.println("SeatId, Row No, Seat No, Status");
		for(String seatData: seatsData) {
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
}
