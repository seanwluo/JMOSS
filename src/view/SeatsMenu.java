package view;

public class SeatsMenu extends AbstractMenu
{

	@Override
	protected String getMenu() {
		return "\nSeat Menu"
				+ "\n1.  Book a seat"
				+ "\n2.  Remove booking"
				+ "\n0.  Back"
				+ "\nEnter the choice: ";
	}

	@Override
	protected void processChoice(String choice) {
		switch(choice)
		{
			case "1":
				System.out.println("\nBook");
				break;
			case "2":
				System.out.println("\nRemove booking");
				break;
			case "0":
				System.out.println("\nGoing back to Movie Session Menu");
				break;
			default:
				System.out.println("\nWARNINIG!! option out of range.");
				System.out.println("\nEnter options from menu list");
				break;
		}
	}

}
