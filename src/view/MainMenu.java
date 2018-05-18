package view;

import Service.BookService;
import Service.MovieSessionService;
import model.MovieSession;

public class MainMenu extends AbstractMenu
{
	private MovieSessionService mvService;
	
	public MainMenu()
	{
		mvService = new MovieSessionService();
	}
	
	@Override
	protected String getMenu()
	{
		return "\nMenu"
				+ "\n1. List all movie session"
				+ "\n2. List a week movie session"
				+ "\n3. Select movie session"
				+ "\n4 List booking"
				+ "\n0. Exit"
				+ "\nEnter the choice: ";
	}
	
	@Override
	protected String processChoice(String choice) {
		switch(choice)
		{
			case "1":
				System.out.println("\nAll Movie session list");
				mvService.list();
				filterMenu();
				break;
			case "2":
				System.out.println("\nOne week Movie session list");
				mvService.weekData();
				break;
			case "3":
				System.out.println("\nEnter Movie Session Id: ");
				String id = reader.nextLine();
				MovieSession movieSession = mvService.findById(id);
				if(movieSession != null)
				{
					System.out.println("Movie session selected");
					MovieSessionMenu msm = new MovieSessionMenu(movieSession);
					msm.show();
				} else {
					System.out.println("Movie Session Not Found!!!");
				}
				
				break;
			case "4":
				BookService bkService = new BookService();
				bkService.list();
				BookMenu bkMenu = new BookMenu();
				bkMenu.show();
				break;
			case "0":
				System.out.println("\nExiting System. \n Bye!!! ");
				break;
			default:
				System.out.println("\nWARNINIG!! option out of range.");
				System.out.println("\nEnter options from menu list");
				break;
		}
		
		return choice;
	}
	
	private void filterMenu()
	{
		System.out.print("\nOrder by: 1. Movie Name 2. Theater Name 3. Date");
		System.out.print("\nEnter choice");
		String choice = reader.nextLine();
		switch(choice)
		{
			case "1":
				System.out.print("\nEnter Movie name:");
				choice = reader.nextLine();
				mvService.findBy("movieName", choice);
				System.out.print("\nOrder by Movie Name");
				break;
			case "2":
				System.out.print("\nEnter Theater name:");
				choice = reader.nextLine();
				mvService.findBy("theaterName", choice);
				System.out.print("\nOrder by Theather Name");
				break;
			case "3":
				System.out.print("\nEnter Date:");
				choice = reader.nextLine();
				mvService.findBy("date", choice);
				System.out.println("\nOrbder by date");
				break;
			case "4":
				System.out.print("\nEnter Time:");
				choice = reader.nextLine();
				mvService.findBy("time", choice);
				System.out.println("\nOrbder by time");
				break;
		}
	}
}
