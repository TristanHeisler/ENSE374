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

public class Lab3 
{
	public Scanner input;
	
	//Default constructor to open a Scanner object
	public Lab3()
	{
		input = new Scanner(System.in);
	}

	//Function for obtaining a valid character menu choice
	public char getMenuChoice()
	{
		//Declaring local variables
		String inputString;
		char choice;
		boolean validChoice = false;

		//Present the possible choices to the user in a menu
		System.out.print("\n/~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\\n"
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
			inputString = input.nextLine();
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
	
	//Function for obtaining a valid integer
	public int getIntegerInput(String promptMessage)
	{
		//Declaring local variables
		String inputString;
		int integer = 0;
		boolean validChoice = false;
		
		//Create a loop to obtain a valid integer value
		do
		{
			//Prompt the user and store their input
			System.out.print("Please enter the " + promptMessage);
			inputString = input.nextLine();
						
			try
			{
				//Try to convert the string to an integer
				integer = Integer.parseInt(inputString);
				
				//If no exception was thrown, exit the loop
				validChoice = true;
			}
			catch(NumberFormatException ex)
			{
				//If the input cannot be expressed as an integer, inform the user and prompt them again
				System.out.print("Invalid input. ");
			}	
		}while(!validChoice);
		
		//Return the valid result
		return integer;
	}
	
	//Main function
	public static void main(String[] args) 
	{
		//Declaring local variables
		Lab3 function = new Lab3();
		char menuChoice;
		LinkedList list = new LinkedList();
		int nodeValue;
		int nodeIndex;
		boolean anotherSelection = true;
		
		//Welcome the user to the program
		System.out.println("Welcome! This program allows you to manage a Singly Linked List.");
				
		//Create a loop that will allow the user to interact with the list for as long as they desire
		do
		{		
			//Display a menu and obtain a valid selection from the user
			menuChoice = function.getMenuChoice();
		
			//Call the appropriate function based on the user's response
			switch(menuChoice)
			{
				//Add a node to the list
				case '1':
					//Obtain a value to add to the list
					nodeValue = function.getIntegerInput("value you would like to add to the list: ");
					
					//Create a new list element using the integer
					ListElement newElement = new ListElement(nodeValue);
					
					//Add the new element to the list
					list.addElement(newElement);
					break;
					
				//Retrieve a node from the list					
				case '2':
					//Obtain the desired retrieval index
					nodeIndex = function.getIntegerInput("index of the node you would like to retrieve: ");
					
					//Output the value stored at the given index
					list.getElement(nodeIndex);
					break;
					
				//Delete a node from the list	
				case '3':
					//Obtain the desired deletion index
					nodeIndex = function.getIntegerInput("index of the node you would like to delete: ");
					
					//Output the value stored at the given index
					list.deleteElement(nodeIndex);
					break;
					
				//Print the list from its head
				case '4':
					list.printLinkedListHead();
					break;
					
				//Exit the program	
				case '5':
					System.out.println("Goodbye!");
					anotherSelection = false;
					break;
			}	
		}while(anotherSelection);
	}
}