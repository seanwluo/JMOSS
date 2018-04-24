package main;

import view.MainMenu;

public class App
{
	public static void main(String[] args)
	{
		System.out.println("Welcome to jMOSS");
		MainMenu menu = new MainMenu();
		menu.show();
	}
}
