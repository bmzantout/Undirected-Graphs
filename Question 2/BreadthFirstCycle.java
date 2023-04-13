package Assignment1_Q2;
import Assignment1_Q1.Queue;
import Assignment1_Q1.Stack;
import Assignment1_Q1.UndirectedGraph;

public class BreadthFirstCycle {
	

	//-----------------------------------------------------------------
	// Title: Question 2
	// Author: Basme Zantout
	// Description: This class uses the BSF or Breadth First Search 
	//              algorithm to traverse over each vertex in a graph
	//              (finds a path in a graph). It also has methods that
	//              find the shortest cycle including a specific vertex.
	//-----------------------------------------------------------------
	

	
	
	
//-------------------------------------------------------
// Attribute: a boolean array that marks true for each 
//            visited vertex-index in the graph
//-------------------------------------------------------
		

	 private boolean[] marked; 
	 
		
//-------------------------------------------------------
//Attribute: an int array that saves the last vertex on
//         the known path to this vertex
//-------------------------------------------------------

	 private int [] edgeTo; 
	
	 
		
//-------------------------------------------------------
//Attribute: the starting vertex in which the BSF starts
//         traversing from in the graph.
//-------------------------------------------------------

	 private final int s; 
	 
	 
	 
	 
	 public BreadthFirstCycle (UndirectedGraph G, int s)
//----------------------------------------------------------------
// Summary: a Constructor method
// Precondition: this constructor takes the graph to be
//               traversed on as well the the vertex it will
//               start the traversal from as parameter
// Postcondition: the method initializes the "marked",
//                "edgeTo", and source vertex accordingly (1).
//                It also calls the recursive "bsf" method
//                that performs the traversal over the vertices (2).
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
// Summary: a recursive BSF method that finds a path in 
//          a given graph
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
//	        vertex "v".
// Precondition: the method takes the destination vertex "v"
//	             as parameter.
// Postcondition: returns a boolean true when the there is 
//	              a path to a vertex "v" which means when
//	              the array "marked" is true at index "v"
//-------------------------------------------------------

	 {  
		 return marked[v];
	 }
	 
	 
	 
	 
	 public Iterable<Integer> pathTo(int v)
//----------------------------------------------------------------------------
// Summary: finds the shortest path from the source vertex
//	        "s" to a given vertex "v".
// Precondition: the method takes the destination vertex "v"
//		         as parameter.
// Postcondition: The method first defines a Stack data structure that stores 
//                the vertices included in the shortest path (1). It then checks 
//                if there is a possible path to the vertex v. It returns the 
//                source and destination vertices if no such path exists (2). 
//                Otherwise, if there exists a path from "s" to "v" the method 
//                the method finds the shortest path and deletes the vertices 
//                included in the path to avoid repeating the path twice in a 
//                cycle (3). Finally, it returns an Iterable list of the 
//                vertices in the shortest path (4).
//	 
// Note: at step (2) we didn't return null because there might be only one single 
//       path in a cycle including a specific vertex.
//----------------------------------------------------------------------------

	 {
		 // (1)
		 
		 Stack<Integer> path = new Stack<Integer>();
		 
		 
		 // (2)
		 
		 if (!hasPathTo(v)) 
		 {
			path.push(ShortestCycle.Start_point);
			path.push(ShortestCycle.Included_point);
			return (Iterable<Integer>) path;
		 }
		 
		 
		 // (3)
		 
		 for (int x = v; x != s; x = edgeTo[x])
		 {
			 path.push(x);
			 
			 if (x != v)
			 {
				 ShortestCycle.TourGuide_Graph.removeEdge(x,edgeTo[x]);
			 }
		 }
		 
		 path.push(s); 
		 
		 if (path.size() == 2)
		 {
			 ShortestCycle.TourGuide_Graph.removeEdge(ShortestCycle.Start_point, ShortestCycle.Included_point);
		 }
		 
		 // (4)
		 
		 return (Iterable<Integer>) path; 
	 }
	 
}
