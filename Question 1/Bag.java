package Assignment1_Q1;
import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
	

	//-----------------------------------------------------------------
	// Title: Question 1
	// Author: Basme Zantout
	// Description: This is a generic class used by the UndirectedGraph
	//              class. It is used to as a data structure to store the
	//              a graph in the form of an adjacency list of vertices.
	//-----------------------------------------------------------------
	
	

//-------------------------------------------------------
// Attribute: first node in list
//-------------------------------------------------------
		
	 private Node first; 
	 
	 
	 
	 
	 
	 
/////////////////////////////////////// NESTED NODE CLASS ///////////////////////////////////////////////
	 
	 
	 private class Node
	 {
		 Item item;
		 Node next;
	 }
	 
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	 
	 
	 
	 
	 
	 
	 public void add(Item item)
//-------------------------------------------------------
// Summary: adds an item to the Bag 
// Precondition: takes the item to be added as parameter
// Postcondition: the method creates a new node for the new 
//		          item, and adds it to the Bag (similar to 
//                the push() method in Stack)
//-------------------------------------------------------

	 {  
		 Node oldfirst = first;
		 first = new Node();
		 first.item = item;
		 first.next = oldfirst;
	 }
	 
	 
	 
	 
	 public void remove(Item item)
//-------------------------------------------------------
// Summary: deletes an item from the Bag
// Precondition: the item to be deleted is passed as a 
//               parameter
// Postcondition: the method first searches for the node to be 
//                deleted and performs the deletion operation
//-------------------------------------------------------
		
	 {
		 Node currNode = first;
	     Node prevNode = null;
	        
	        while(currNode != null)
	        {
	            if(item.equals(currNode.item))
	            {
	                if(prevNode  == null) 
	                {
	                  first = (Node) currNode.next;
	                }
	                else 
	                {
	                  prevNode.next = currNode.next;
	                }
	            }
	            
	            else 
	            {
	              prevNode = currNode;
	            }
	            currNode = currNode.next;
	        }
	 }
	 
	 
	 
	 
	 
	 
	 
	 
//////////////////////////////////ITERATORS ///////////////////////////////////////
	 
	 
	 
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

