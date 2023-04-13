package Assignment1_Q1;

public class Queue<Item> {

	

	//-----------------------------------------------------------------
	// Title: Question 1
	// Author: Basme Zantout
	// ID: 99227947762
	// Section: 1
	// Assignment: 1
	// Description: This is a generic class used by the BreadthFirstPaths
	//              class which traverses over a graph and finds a 
	//              path through all its vertices. So, this data 
	//              structure used in the queue class helps in 
	//              storing the vertices and finding a path in a graph.
	//-----------------------------------------------------------------
	
	

//-------------------------------------------------------
// Attribute: link to least recently added node
//-------------------------------------------------------
		
	 private Node first; 
	 
		
//-------------------------------------------------------
// Attribute: link to most recently added node
//-------------------------------------------------------
	  
	 private Node last; 
	 
		
//-------------------------------------------------------
// Attribute: "N" denotes the number of items in a queue
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
//                is empty and false when it is not
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
	 
	 
	
	 
	 
	 public void enqueue(Item item)
//-------------------------------------------------------
// Summary: adds an item to the queue
// Precondition: takes the item to be added as parameter
// Postcondition: the method creates a new node for the new 
//                item, adds it based on the queue predefined 
//                structure FIFO, and increases the queue size
//-------------------------------------------------------
		
	 { 
		 Node oldlast = last;
		 last = new Node();
		 last.item = item;
		 last.next = null;
		 if (isEmpty()) first = last;
		 else oldlast.next = last;
		 N++;
	 }
	 
	 
	 
	 
	 
	 public Item dequeue()
//-------------------------------------------------------
// Summary: deletes an item from the queue
// Precondition: deletes the first item from the queue based 
//               on the predefined structure FIFO
// Postcondition: the method creates deletes the first node,
//                 adjusts the "first" node pointer, and 
//                 returns the deleted item
//-------------------------------------------------------
			
	 { 
		 Item item = first.item;
		 first = first.next;
		 if (isEmpty()) last = null;
		 N--;
		 return item;
	 }


	}

