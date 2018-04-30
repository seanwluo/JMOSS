package main;

import java.util.Scanner;

import Service.UserService;
import view.MainMenu;

public class App
{
	public static void main(String[] args)
	{   
		Scanner reader = new Scanner(System.in);
		boolean exit=false;
		
		System.out.println("Welcome to jMOSS");
	
		do {
			
			System.out.println("\nLogin");
			
			System.out.print("\nUsername: ");
			String username = reader.next();
			
			System.out.print("\nPassword: ");
			String password = reader.next();
			
			UserService usrService = new UserService();
			if( usrService.login(username, password) )
			{
				System.out.println("\nUser Logged in!!");
				MainMenu menu = new MainMenu();
				menu.show();
				exit = true;
			} else
			{
				System.out.println("\nWorng Username or Password");
			}
		} while(exit!=true);

	}
}
