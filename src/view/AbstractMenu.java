package view;

import java.util.Scanner;

public abstract class AbstractMenu {
	protected Scanner reader = new Scanner(System.in);
	
	public void show()
	{
		String choice="";
		
		do {
			System.out.print(getMenu());
			choice = reader.nextLine();
			processChoice(choice);
		} while(!choice.equals("0"));
	}
	
	protected abstract String getMenu();
	protected abstract void processChoice(String choice);
}
