package view;

import java.util.Scanner;

import Service.SeatService;
import model.MovieSession;
import model.Seat;

public class MovieSessionMenu extends AbstractMenu
{
	private MovieSession movieSession;
	private SeatService seatService;
	/**
	 * reader from parent class
	 */
	public MovieSessionMenu(MovieSession movieSession)
	{	
		this.movieSession = movieSession;
		reader = new Scanner(System.in);
		seatService = new SeatService();
	}
	
	@Override
	protected String getMenu() {
		return "\nMovie session Menu"
				+ "\n1. List seats"
				+ "\n2. Select seat"
				+ "\n0. Back"
				+ "\nEnter the choice: ";
	}

	@Override
	protected void processChoice(String choice) {
		switch(choice)
		{
			case "1":
				System.out.println("\nMovie session seats");
				seatService.seatList();
				break;
			case "2":
				System.out.print("\nEnter the seat Id: ");
				String id = reader.nextLine();
				Seat seat = seatService.findById(id);
				if(seat != null) {
					System.out.print("Seat selected");
					
					SeatsMenu seatsMenu = new SeatsMenu(seatService, seat);
					seatsMenu.show();
				} else {
					System.out.println("\nSeat not found!!!");
				}
				
				break;
			case "0":
				System.out.println("\nGoing back to Main Menu");
				seatService.saveData();
				break;
			default:
				System.out.println("\nWARNINIG!! option out of range.");
				System.out.println("\nEnter options from menu list");
				break;
		}
	}

}
