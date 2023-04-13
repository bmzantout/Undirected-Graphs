package Assignment1_Q1;

public class BreadthFirstPaths {


	//-----------------------------------------------------------------
	// Title: Question 1
	// Author: Basme Zantout
	// Description: This class uses the BSF or Breadth First Search 
	//              algorithm to traverse over each vertex in a graph
	//              (finds a path in a graph). It also has methods that
	//              find the shortest path from a specific vertex to 
        //              another in the graph.
	//-----------------------------------------------------------------
	

	
	
	
//-------------------------------------------------------
// Attribute: a boolean array that marks true for each 
//            visited vertex-index in the graph
//-------------------------------------------------------
			
	 private boolean [] marked; 
	 
	 
		
//-------------------------------------------------------
// Attribute: an int array that saves the last vertex on
//            the known path to this vertex
//-------------------------------------------------------

	 private int [] edgeTo; 
	
	 
		
//-------------------------------------------------------
// Attribute: the starting vertex in which the BSF starts
//            traversing from in the graph.
//-------------------------------------------------------

	 private final int s; 
	 
	 
	 
	 
	 
	 
	 
	 
	 public BreadthFirstPaths(UndirectedGraph G, int s)
//----------------------------------------------------------------
// Summary: a Constructor method
// Precondition: this constructor takes the graph to be
//               traversed on as well the the vertex it will
//               start the traversal from as parameter
// Postcondition: the method initializes the "marked",
//                "edgeTo", and source vertex accordingly (1).
//                It also calls the "bsf" method that performs the 
//                traversal over the vertices (2).
//----------------------------------------------------------------
		
	 {
		 // (1)
		 
		 marked = new boolean[G.getV()];
		 edgeTo = new int[G.getV()];
		 this.s = s;
		 
		 // (2)
		 
		 bfs(G, s);
	 }
	 
	 
	 
	 
	 
	 
	 private void bfs(UndirectedGraph G, int s)
//--------------------------------------------------------------
// Summary: a BSF method that finds a path in a given graph
//
// Precondition: this method takes the graph to be 
//               traversed on as well the the vertex it will 
//               start the traversal from as parameter.
// Postcondition: the method first initializes a queue to store
//                the vertices it traverses on and marks the source 
//                vertex as visited (1). Then, in a while loop, for 
//                vertex in the graph, it removes it from the queue, 
//                and for every unmarked adjacent vertex, it saves 
//                the last edge on a shortest path, marks it because 
//                path is known, and finally adds it to the queue (2).
//                The loop keeps repeating until the queue is empty
//                and every vertex is visited (3).
//---------------------------------------------------------------
			
	 {
		 // (1)
		 
		 Queue<Integer> queue = new Queue<Integer>();
		 marked[s] = true; 
		 queue.enqueue(s); 
		 
		 
		 // (2)
		 
		 while (!queue.isEmpty())
		 {
			 int v = queue.dequeue(); 
			
			 for (int w : G.adj(v))
			 if (!marked[w])  
			 {
				 edgeTo[w] = v; 
				 marked[w] = true;  
				 queue.enqueue(w);
			 }
			 
		// (3) 
		 }
	 }
	 
	 
	 
	 
	 
	 
	 
	 public boolean hasPathTo(int v)
//-------------------------------------------------------
// Summary: checks whether there is a path to a given 
//          vertex "v".
// Precondition: the method takes the destination vertex "v"
//               as parameter.
// Postcondition: returns a boolean true when the there is 
//                a path to a vertex "v" which means when
//                the array "marked" is true at index "v"
//-------------------------------------------------------

	 {  
		 return marked[v];
	 }
	 
	 
	 
	 
	 
	 
	 public Iterable<Integer> pathTo(int v)
//----------------------------------------------------------------------------
// Summary: finds the shortest path from the source vertex
//          "s" to a given vertex "v".
// Precondition: the method takes the destination vertex "v"
//	             as parameter.
// Postcondition: The method first checks if there is a possible path 
//                to the vertex v (1). It returns null if no such path exists.
//                Otherwise, if there exists a path from "s" to "v" the 
//                method defines a Stack data structure that stores the
//                vertices included in the shortest path (2). Next, the number 
//                of vertices in the shortest path is saved and printed out (3).
//                Finally, it returns an Iterable list of the vertices in the 
//                shortest path (4).
//----------------------------------------------------------------------------

	 {
		// (1)
		 
		 if (!hasPathTo(v)) return null; 
		 
		 
         // (2)
		 
		 Stack<Integer> path = new Stack<Integer>(); 
		 
		 for (int x = v; x != s; x = edgeTo[x])
		 path.push(x);
		 
		 path.push(s);
		 
		 
		// (3)
		 
		 ShortestPath.Number_of_Visited_Cities = path.size(); 
		 System.out.println(ShortestPath.Number_of_Visited_Cities); 
		 
		 
		 // (4)
		 
		 return (Iterable<Integer>) path; 
	 }
	 
	
}
