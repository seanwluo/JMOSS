package view;

import java.util.Scanner;

public abstract class AbstractMenu {
	protected Scanner reader = new Scanner(System.in);
	
	public String show()
	{
		String choice="";
		
		do {
			System.out.print(getMenu());
			choice = reader.nextLine();
			choice = processChoice(choice);
		} while((!choice.equals("0")) && (!choice.equals("00")));
		
		return choice;
	}
	
	protected abstract String getMenu();
	protected abstract String processChoice(String choice);
}
