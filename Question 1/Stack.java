package Assignment1_Q1;
import java.util.Iterator;


public class Stack<Item> implements Iterable<Item>{


	//-----------------------------------------------------------------
	// Title: Question 1
	// Author: Basme Zantout
	// Description: This is a generic class used by the BreadthFirstPaths
	//              class. It is used by the "pathTo" in the BreadthFirstPaths
	//              class. So, this data structure helps in storing the 
        //              vertices and printing them out when finding the shortest
        //              path in a graph.
	//-----------------------------------------------------------------
	


//-------------------------------------------------------
// Attribute: top of stack (most recently added node)
//-------------------------------------------------------
		
	 private Node first; 
	 
	 
//-------------------------------------------------------
// Attribute: number of items in the stack
//-------------------------------------------------------
		 
	 private int N;  
	 
	 
	 
	 
	 
	 
/////////////////////////////////////// NESTED NODE CLASS ///////////////////////////////////////////////
 
	 private class Node
	 {
		 Item item;
		 Node next;
	 }
	 
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	 
	 
	 
	 
	 
	 public boolean isEmpty()
//-------------------------------------------------------
// Summary: checks whether a queue is empty or not
// Precondition: checks the first node in the queue
// Postcondition: returns a boolean true when the queue
//	                is empty and false when it is not
//-------------------------------------------------------

	 {
		 return first == null;
	 }
	 
	 
	 
	 
	 
	 
	 public int size()
//-------------------------------------------------------
// Summary: returns the current size of the queue
// Precondition: a getter method
// Postcondition: returns "N" the number of items in a queue 
//-------------------------------------------------------
		
	 {
		 return N;
	 }
	 
	 
	 
	 
	 
	 public void push(Item item)
//-------------------------------------------------------
// Summary: adds an item to the stack
// Precondition: takes the item to be added as parameter
// Postcondition: the method creates a new node for the new 
//	                item, adds it based on the stack predefined 
//	                structure LIFO, and increases the stack size
//-------------------------------------------------------
		
	 { 
		 Node oldfirst = first;
		 first = new Node();
		 first.item = item;
		 first.next = oldfirst;
		 N++;
	 }
	 
	 
	 
	 
	 
	 
	 
	 public Item pop()
//-------------------------------------------------------
// Summary: deletes an item from the stack
// Precondition: deletes the last item from the stack based 
//	               on the predefined structure LIFO
// Postcondition: the method creates deletes the last node,
//	              adjusts the "first" node pointer, and 
//	              returns the deleted item
//-------------------------------------------------------
		
	 { 
		 Item item = first.item;
		 first = first.next;
		 N--;
		 return item;
	 }

	 
	 
	 
	 
////////////////////////////////// ITERATORS ///////////////////////////////////////
	 
	 public Iterator<Item> iterator()
	 {
		 return new ListIterator();
	 }
	 
	 private class ListIterator implements Iterator<Item>
	 {
		 private Node current = first;
		 
		 public boolean hasNext()
		 { 
			 return current != null;
		 }
		 
		 public void remove() { }
		 
		 public Item next()
		 {
			 Item item = current.item;
			 current = current.next;
			 return item;
		 }
	 } 
	 
}
