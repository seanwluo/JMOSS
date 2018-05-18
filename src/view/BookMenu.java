package view;

import java.util.regex.Pattern;

import Service.BookService;

public class BookMenu extends AbstractMenu
{
	private BookService bkService =  new BookService();
	
	@Override
	protected String getMenu() {
		return "\nBooking Menu"
				+ "\n1. Search by email: "
				+ "\n0. Exit"
				+ "\nEnter the choice";
	}

	@Override
	protected String processChoice(String choice) {
		switch(choice) {
		case "1":
			String email = emailInput();
			bkService.findByEmail(email);
			break;
		case "0":
			System.out.println("\nGoing back to Movie Session Menu");
			break;
		default:
			System.out.println("\nWARNINIG!! option out of range.");
			System.out.println("\nEnter options from menu list");
			break;
		}
		return choice;	
	}
	
	private String emailInput()
	{
		String email = null;
		boolean validEmail = false;
		do {
			System.out.print("\nEnter the customer email: ");
			email = reader.nextLine();
			validEmail = isEmailValid(email);
			if(!validEmail) {
				System.out.println("Invalid email.");
			}
		} while(!validEmail);
		
		return email;
	}
	
	private boolean isEmailValid(String email)
	{
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
							"[a-zA-Z0-9_+&*-]+)*@" +
							"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
							"A-Z]{2,7}$";
							
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null) {
			return false;
		}
		
		return pat.matcher(email).matches();
	}
}
