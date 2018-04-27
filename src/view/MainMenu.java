package view;

import Service.MovieSessionService;

public class MainMenu extends AbstractMenu
{
	@Override
	protected String getMenu()
	{
		return "\nMenu"
				+ "\n1. List movie session"
				+ "\n2. Select movie session"
				+ "\n0. Exit"
				+ "\nEnter the choice: ";
	}
	
	@Override
	protected void processChoice(String choice) {
		switch(choice)
		{
			case "1":
				System.out.println("\nMovie session list");
				MovieSessionService mvService = new MovieSessionService();
				mvService.list();
				break;
			case "2":
				System.out.println("Movie session selected");
				MovieSessionMenu msm = new MovieSessionMenu();
				msm.show();
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
