package Assignment1_Q1;

public class ShortestPath {



	//-----------------------------------------------------------------
	// Title: Question 1
	// Author: Basme Zantout
	// Description: This is a class used by the main class. It 
	//              has the methods that perform the needed operations, 
        //              which are intended to find and calculate the time
	//              taken in the shortest path from one airport to 
        //              another in a given airlines graph.
	//-----------------------------------------------------------------
	
	
	
	
	
//-------------------------------------------------------
// Attribute: the time required by airports to change 
//            their states
//-------------------------------------------------------
			
	public static int ChangeState;
	
	
//-------------------------------------------------------
// Attribute: the time for traveling one city to another
//-------------------------------------------------------
	
	public static int Route_Time;
	
	
//-------------------------------------------------------
// Attribute: the number of cities visited in the path
//-------------------------------------------------------
		
	public static int Number_of_Visited_Cities;
	
	
//-------------------------------------------------------
// Attribute: the vertex/city the trip starts from
//-------------------------------------------------------
		
	public static int Starting_Vertex;
	
	
//-------------------------------------------------------
// Attribute: the vertex/city the trip ends at
//-------------------------------------------------------
			
	public static int Terminating_Vertex;
	
	
//-------------------------------------------------------
// Attribute: the Airlines Graph that stores the airport
//            cities and the connections between them.          
//-------------------------------------------------------
			
	public static UndirectedGraph Airline_Graph;
	
	
	
	
	

	public static void Find_ShortestPath()
//-------------------------------------------------------
// Summary: finds the shortest path from the starting to 
//          the destination airport
// Precondition: initializes a "BreadthFirstPaths" object
//               which is needed to traverse over the airline 
//               graph (1).
// Postcondition: it calls the "pathTo" method in the 
//                "BreadthFirstPaths" class which finds the 
//                shortest path from the source airport to 
//                the given destination airport (2) and 
//                prints out the vertices in the path.
//
// Note: check the "BreadthFirstPaths" class for 
//       implementation details.
//-------------------------------------------------------

	{
		// (1)
		
		BreadthFirstPaths paths = new BreadthFirstPaths(Airline_Graph, Starting_Vertex);
		
		
		// (2)
		
		for (int x: paths.pathTo(Terminating_Vertex))
		{
			System.out.print(x + " ");
		}
		
		System.out.println();
	}

	
	
	
	
	
	public static void Calculate_Time()
//--------------------------------------------------------------------
// Summary: does the needed calculations to find the time 
//          taken by the shortest route.
// Precondition: initializes an integer z as 0 (1).
// Postcondition: The method does the calculation as follows:
//                if the time for traveling one city to another
//                is greater than 2 times the the time required 
//                by airports to change their states then the
//                final time taken the whole route is the 
//                "Route_Time" multiplied by the number of routes
//                or edges. Otherwise, if the time for traveling one 
//                city to another ("Route_Time") is less than 2 times 
//                the the time required by airports to change their 
//                states ("ChangeState"), then the final time is the
//                calculated the same as before but this time we add
//                the difference between the "Route_Time" and "ChangeState"
//                at each city/ vertex visited (2). The output time is then
//                printed according to the calculations above (3).
//---------------------------------------------------------------------

	{
		// (1)
		
		int z = 0;
		
		// (2)
		
		if (Route_Time < (ChangeState*2))
		{
		   z = (ChangeState*2) - Route_Time;
		}
		
		// (3)
		
		System.out.println((Route_Time * (Number_of_Visited_Cities - 1)) + (z * (Number_of_Visited_Cities - 2)));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

