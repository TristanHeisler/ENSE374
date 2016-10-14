/**
* LinkedList.java
*
* DESCRIPTION:
* This file maintains the information required to maintain a linked list. Users can add a node to the list,
* search for a node, delete a node and print the list from its head or from its tail.
*
* AUTHOR: Tristan Heisler 200351317
*/

package lab3.linkedList;

public class LinkedList 
{
	//Private variables
	private ListElement head;
	private ListElement tail;
	private int maxIndex;
	
	//Default constructor
	public LinkedList()
	{
		head = null;
		tail = null;
		maxIndex = 0;
	}
	
	//Add a node
	public void addElement(ListElement newElement)
	{		
		//If the list is empty, add the new element at the head
		if(head == null)
		{
			head = new ListElement(newElement.getData());
			tail = head;
		}
		
		//Otherwise, add the element to the end of the list
		else
		{	
			//Attach the element at the end
			tail.setNext(newElement);
			
			//Link the new tail to the previous tail
			tail.getNext().setPrevious(tail);
			
			//Move the tail to the end of the list
			tail = tail.getNext();		
			
			//Increment the number of nodes in the list
			maxIndex++;
		}			

		//Inform the user that the node was added
		System.out.println("The value was successfully added to the linked list.");
	}

	//Retrieve an element
	public void getElement(int index)
	{
		//If the list is empty, inform the user
		if(head == null)
		{
			System.out.println("The list is currently empty.");
		}
		
		//If the desired index is not present in the list, inform the user
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
	
	//Delete an element
	public void deleteElement(int index)
	{
		//If the list is empty, inform the user
		if(head == null)
		{
			System.out.println("The list is currently empty.");
		}
		
		//If the desired index is not present in the list, inform the user
		else if(index > maxIndex || index < 0)
		{
			System.out.println("The given index lies outside of the bounds of the list.");
		}
		
		//Otherwise, delete the desired node
		else
		{					
			//Handle the case of deleting the only node in the list
			if(head == tail)
			{
				head = null;
				tail = null;
			}
			
			//Handle the case of deleting the head of the list
			else if(index == 0)
			{
				//Move the head to the next position and nullify its previous link
				head = head.getNext();
				head.setPrevious(null);
				
				//Decrement the number of nodes in the list
				maxIndex--;
			}
			
			//Handle the case of deleting the tail of the list
			else if(index == maxIndex)
			{
				//Move the tail to the previous position and nullify its next link
				tail = tail.getPrevious();
				tail.setNext(null);

				//Decrement the number of nodes in the list
				maxIndex--;
			}
			
			else
			{
				//Create an list iterator
				ListElement current = new ListElement();
				current = head;
				
				//Iterate to the node to be deleted
				for(int i = 0; i < index; i++)
				{
					current = current.getNext();
				}			
				
				//Link the previous node to the next node
				current.getPrevious().setNext(current.getNext());
				
				//Link the next node to the previous node
				current.getNext().setPrevious(current.getPrevious());

				//Decrement the number of nodes in the list
				maxIndex--;
			}
						
			//Inform the user that the node was deleted
			System.out.println("The value was successfully deleted from the linked list.");
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

	//Print the list from its head
 	public void printLinkedListTail()
 	{
 		//If the list is empty, inform the user
		if(head == null)
		{
			System.out.println("The list is currently empty.");
		}
		
		//Otherwise, print the list in order from its tail
		else
		{
			//Create an list iterator
			ListElement current = new ListElement();
			current = tail;
			
			//Output information
			System.out.print("\nPrinting the linked list from the tail:\n\t");
			
			//Iterate to the start of the list
			do
			{
				//Print the information at the current node
				System.out.print(current.getData() + " ");
				
				//Move to the next node in the list
				current = current.getPrevious();
			}while(current != null);
			
			//Output a new line
			System.out.println();
		}
 	}
}
