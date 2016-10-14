/**
* LinkedList.java
*
* DESCRIPTION:
* This file maintains the information required to maintain a linked list. Users can add a node to the list,
* search for a node, delete a node and print the list from its head.
*
* AUTHOR: Tristan Heisler 200351317
*/

package lab3.linkedList;

public class LinkedList 
{
	//Private variables
	private ListElement head;
	private int maxIndex;
	
	//Default constructor
	public LinkedList()
	{
		head = null;
		maxIndex = 0;
	}
	
	//Add a node
	public void addElement(ListElement newElement)
	{		
		//If the list is empty, add the new element at the head
		if(head == null)
		{
			head = new ListElement(newElement.getData());
		}
		
		//Otherwise, add the element to the end of the list
		else
		{		
			//Create an list iterator
			ListElement current = new ListElement();
			current = head;
			
			//Iterate to the end of the list
			while(current.getNext() != null)
			{
				current = current.getNext();
			}
			
			//Attach the element to the end of the list
			current.setNext(newElement);
			
			//Increment the number of nodes in the list
			maxIndex++;
		}		
	}

	//Retrieve an element
	public void getElement(int index)
	{
		//If the list is empty, inform the user
		if(head == null)
		{
			System.out.println("The list is currently empty.");
		}
		
		//If the desired index is not present in the list, return null
		else if(index > maxIndex || index < 0)
		{
			System.out.println("The given index lies outside of the bounds of the list.");
		}
		//Otherwise, iterate to the desired node and return it
		else
		{
			//Create an list iterator
			ListElement current = new ListElement();
			current = head;
			
			//Iterate to the correct node
			for(int i = 0; i < index; i++)
			{
				current = current.getNext();
			}
			
			//Output the value stored at the node
			System.out.println("Index " + index + " corresponds to a value of " + current.getData() + ".");
		}
	}
	
	//Print the list from its head
	public void printLinkedListHead()
	{
		//If the list is empty, inform the user
		if(head == null)
		{
			System.out.println("The list is currently empty.");
		}
		
		//Otherwise, print the list in order from its head
		else
		{
			//Create an list iterator
			ListElement current = new ListElement();
			current = head;
			
			//Output information
			System.out.print("\nPrinting the linked list from the head:\n\t");
			
			//Iterate to the end of the list
			do
			{
				//Print the information at the current node
				System.out.print(current.getData() + " ");
				
				//Move to the next node in the list
				current = current.getNext();
			}while(current != null);
			
			//Output a new line
			System.out.println();
		}
	}
}