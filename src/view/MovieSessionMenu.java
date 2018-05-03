package view;

import Service.SeatService;

public class MovieSessionMenu extends AbstractMenu
{

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
				SeatService seatService = new SeatService();
				seatService.seatList();
				break;
			case "2":
				System.out.println("\nSeat selected");
				SeatsMenu seatsMenu = new SeatsMenu();
				seatsMenu.show();
				break;
			case "0":
				System.out.println("\nGoing back to Main Menu");
				break;
			default:
				System.out.println("\nWARNINIG!! option out of range.");
				System.out.println("\nEnter options from menu list");
				break;
		}
	}

}
