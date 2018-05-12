package view;

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
				+ "\n2. Select movie session"
				+ "\n0. Exit"
				+ "\nEnter the choice: ";
	}
	
	@Override
	protected void processChoice(String choice) {
		switch(choice)
		{
			case "1":
				System.out.println("\nAll Movie session list");
				mvService.list();
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
			case "0":
				System.out.println("\nExiting System. \n Bye!!! ");
				break;
			default:
				System.out.println("\nWARNINIG!! option out of range.");
				System.out.println("\nEnter options from menu list");
				break;
		}
	}
}
