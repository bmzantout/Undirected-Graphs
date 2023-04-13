package Assignment1_Q1;

public class UndirectedGraph {


	//-----------------------------------------------------------------
	// Title: Question 1
	// Author: Basme Zantout
	// Description: This is an Undirected Graph class, which has the 
        //              methods that create an undirected graph and that perform
        //              basic graph operations based on the Graph data structure.
        //              This class also depends on the Bag.java class in its
	//              implementation
	//-----------------------------------------------------------------
	
	

//-------------------------------------------------------
// Attribute: the number of vertices in the graph
//-------------------------------------------------------
	
   	private final int V;
   	

//-------------------------------------------------------
// Attribute: vertex-indexed array for the adjacency list
//-------------------------------------------------------
  	  	
	private Bag<Integer> [] adj;
	 
	
	
	
	
	
	
	 @SuppressWarnings("unchecked")
	 
	public UndirectedGraph(int V)
//----------------------------------------------------------------
// Summary: a Constructor method
// Precondition: this constructor takes the number of vertices in
//               the graph as parameter
// Postcondition: the method initializes the the number of vertices
//                and the vertex-indexed Bag array (1). It also
//                creates a bag at each index in the Bag array to
//                store the adjacency list of each vertex (2).
// 
// Note: The number of vertices is incremented by one because the
//       airline vertex numbers start from 1 not 0!
//----------------------------------------------------------------
			
	 {
		 // (1)
		 
		 this.V = V+1;
		 adj = (Bag<Integer> []) new Bag[this.V];
		 
		 
		 // (2)
		 
		 for (int v = 1; v < this.V ; v++)
		 {
			 adj[v] = new Bag<Integer>();
		 }
		 
	 }
	 
	 
	 public void addEdge(int v, int w)
//----------------------------------------------------------
// Summary: adds an edge/connection between 2 vertices
// Precondition: takes the vertices as parameters
// Postcondition: calls the "add" method from the Bag class
//                to add a vertex to the the adjacency list 
// 
// Note: check the "add" method in the "Bag" class for details
//----------------------------------------------------------
		
	 {
		 adj[v].add(w);
		 adj[w].add(v);
	 }
	 
	 
	 
	 
	 
	 
	 public void removeEdge(int v, int w)
//----------------------------------------------------------
// Summary: removes an edge/connection between 2 vertices
// Precondition: takes the vertices as parameters
// Postcondition: calls the "remove" method from the Bag class
//	               to remove a vertex from the adjacency list 
// 
// Note: check the "remove" method in the "Bag" class for details
//----------------------------------------------------------
			
	 {
		 adj[v].remove(w);
		 adj[w].remove(v);
	 }
	 
	 
	 
	 
	 public Iterable<Integer> adj(int v)
//----------------------------------------------------------
// Summary: returns the adjacency list of a vertex
// Precondition:  takes the vertex as parameter
// Postcondition: returns adjacency list as an Iterable list.
//
// Note: check the "Bag" class for details
//----------------------------------------------------------
	 
	 {
		 return adj[v];
	 }

	 
	 

	public int getV() 
//-------------------------------------------------------
// Summary: returns the number of vertices in the graph
// Precondition: a getter method
// Postcondition: returns "V" the number of vertices 
//-------------------------------------------------------
		
	{
		return V;
	}

}
