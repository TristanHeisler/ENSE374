/**
* Lab3.java
*
* DESCRIPTION:
* This file is the main file for the ENSE 374 Lab 3 assignment in the Fall 2016
* semester at the University of Regina. By following the provided prompts, the user is 
* able to manipulate the nodes in a singly linked list.
*
* AUTHOR: Tristan Heisler 200351317
*/

package lab3.linkedList;
import java.util.Scanner;

public class Lab3 {
	public static char getMenuChoice()
	{
		//Declaring local variables
		Scanner menu = new Scanner(System.in);
		String inputString;
		char choice;
		boolean validChoice = false;

		//Present the possible choices to the user in a menu
		System.out.print("/~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\\n"
			+ "|Please indicate what you would like to do next:      |\n"
			+ "|\t1. Add a node to the list                     |\n"
			+ "|\t2. Retrieve a node from the list by its index |\n"
			+ "|\t3. Delete a node from the list by its index   |\n"
			+ "|\t4. Print the linked list from its head        |\n"
			+ "|\t5. Exit the program                           |\n"
			+ "\\~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~/\n\n");
		
		//Create a loop that will run until the user enters a valid choice
		do
		{
			//Obtain the first character of the input string and ignore the rest of the string
			System.out.print("Please enter your selection: ");
			inputString = menu.nextLine();
			choice = inputString.charAt(0);	
			
			//Evaluate the choice that was made
			switch(choice)
			{
				//If the given choice is permitted, exit the loop
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
					validChoice = true;
					break;
				//If the given choice is not permitted, inform the user and prompt them again
				default:
					System.out.print("Invalid selection. ");
					break;
			}			
		}while(!validChoice);		
		
		//Return the user's valid choice		
		return choice;
	}
	
	public static void main(String[] args) 
	{
		//Declaring local variables
		char menuChoice;
		boolean anotherSelection = true;
		
		//Welcome the user to the program
		System.out.print("Welcome! This program allows you to manage a Singly Linked List.\n\n");
				
		//Create a loop that will allow the user to interact with the list for as long as they desire
		do
		{		
			//Display a menu and obtain a valid selection from the user
			menuChoice = getMenuChoice();
		
			//Call the appropriate function based on the user's response
			switch(menuChoice)
			{
				//Add a node to the list
				case '1':
					System.out.print("Add a node!\n\n");
					break;
					
				//Retrieve a node from the list					
				case '2':
					System.out.print("Retrieve a node!\n\n");
					break;
					
				//Delete a node from the list	
				case '3':
					System.out.print("Delete a node!\n\n");
					break;
					
				//Print the list from its head
				case '4':
					System.out.print("Print the list!\n\n");
					break;
					
				//Exit the program	
				case '5':
					System.out.print("Goodbye!\n\n");
					anotherSelection = false;
					break;
			}	
		}while(anotherSelection);
	}
}
