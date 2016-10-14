/**
* ListElement.java
*
* DESCRIPTION:
* This file maintains the information required for a single element of a linked list.
* This element contains data and a link to the next element in its list. Users can interact
* with the list element through the use of the provided getters and setters.
*
* AUTHOR: Tristan Heisler 200351317
*/

package lab3.linkedList;

public class ListElement {
	//Private variables
	private int data;	
	private ListElement next;
	private ListElement previous;
	
	//Default constructor
	public ListElement()
	{
		this.data = 0;		
		this.next = null;
		this.previous = null;
	}
	
	//Initializing constructor
	public ListElement(int initialData)
	{
		this.data = initialData;
		this.next = null;
		this.previous = null;
	}
	
	//Setter for data
	public void setData(int newData)
	{
		this.data = newData;
	}
	
	//Getter for data
	public int getData()
	{
		return this.data;
	}
	
	//Setter for next
	public void setNext(ListElement newNext)
	{
		this.next = newNext;
	}
	
	//Getter for next
	public ListElement getNext()
	{
		return this.next;		
	}
}