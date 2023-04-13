package Assignment1_Q2;
import Assignment1_Q1.UndirectedGraph;


public class ShortestCycle {


	//-----------------------------------------------------------------
	// Title: Question 2
	// Author: Basme Zantout
	// ID: 99227947762
	// Section: 1
	// Assignment: 1
	// Description: This is a class used by the main class. It 
	//              has the methods that perform the needed operations, 
    //              which are intended to find the shortest cycle starting
    //              from a given vertex and including a specific vertex.
	//-----------------------------------------------------------------
	
	
	
		
	
//-------------------------------------------------------
// Attribute: the Tour Guide Graph that stores the islands
//            and the connections between them.          
//-------------------------------------------------------

	public static UndirectedGraph TourGuide_Graph;
	
	
//-------------------------------------------------------
// Attribute: the vertex/island the trip starts from
//-------------------------------------------------------
		
	public static int Start_point;
	
	
//-------------------------------------------------------
// Attribute: the vertex/island that should be included  
//            in the trip
//-------------------------------------------------------
		
	public static int Included_point;
	
	
//-------------------------------------------------------
// Attribute: an array that stores all the vertices/islands 
//	          visited in the trip cycle.
//-------------------------------------------------------
 
	public static int [] cycle;
	
	
	
	
	
	
	
	
	
	public static void Find_ShortestCycle()
//---------------------------------------------------------------------
// Summary: finds the shortest cyclic trip from the starting 
//          island and including a specific given island
// Precondition: the method finds the shortest path from the 
//               starting vertex to the included vertex and 
//               then finds another shortest path from the 
//               included vertex back to the starting vertex.
//
// Postcondition: initializes 2 "BreadthFirstPathsCycle" objects
//                one for going to the included vertex and one for 
//                returning back. It calls the "pathTo" method in the 
//	              "BreadthFirstCycle" class which finds the shortest 
//                path from the source island to the destination island.
//                Additionally, the visited islands are stored in the
//                "cycle" array making sure each island is stored once.
//                Finally, the islands are sorted by calling the "sort"
//                method
//
// Note:  - check the "sort" method below for implementation details.
//        - check the "BreadthFirstCycle" class for implementation details.
//---------------------------------------------------------------------

	{
		cycle[0] = Start_point;
		cycle[1] = Included_point;
		int count = 2;
		
		
		// initializing a "BreadthFirstPathsCycle" object 
		
		BreadthFirstCycle Going = new BreadthFirstCycle(TourGuide_Graph, Start_point);
		
		for (int x: Going.pathTo(Included_point))
		{
			// storing the visited islands
			
			if ((x != cycle[0]) && (x != cycle[1])) 
			{
				cycle[count] = x;
				count++;
			}
		}
		
		
		// initializing a "BreadthFirstPathsCycle" object 
		
        BreadthFirstCycle Returning = new BreadthFirstCycle(TourGuide_Graph, Start_point);
		
		for (int x: Returning.pathTo(Included_point))
		{
			// storing the visited islands
			
			if ((x != cycle[0]) && (x != cycle[1])) 
			{
				cycle[count] = x;
				count++;
			}
		}
		
		// sorting the "cycle" array
		
		sort(cycle, count);
		
	}
	
	
	
	
	

	
	
	private static void sort(int [] path_array, int count)
//---------------------------------------------------------------
// Summary: sorts a given array
// Precondition: takes the array and the number of elements 
//               in the array "count" as parameter
// Postcondition: the method uses the standard Selection Sort
//                algorithm to sort the array (1) . It also 
//                class the "print_path" method that prints
//                out the sorted array.
//
// Note: check the "print_path" method below for implementation
//       details.
//---------------------------------------------------------------
		
    {
		// (1)
		
        for (int i = 0; i < count; i++)
        {
            int min = i;
            
            for (int j = i+1; j < count; j++)
            {
            	if (path_array[min] > path_array[j])
            	{
            		min = j;
            	}
                    
            }

            int temp = path_array[min];
            path_array[min] = path_array[i];
            path_array[i] = temp;
            
        }
        
        print_path(cycle, count);
    }
	
	
	
	
	
	
	
	
	private static void print_path(int [] path_array, int count)
//---------------------------------------------------------------
// Summary: prints a given array
// Precondition: takes the array and the number of elements 
//	             in the array "count" as parameter
// Postcondition: the method prints the elements of the array 
//                based on its count using a for-loop 
//---------------------------------------------------------------
		
	{
		for (int i = 0 ; i < count ; i++)
			System.out.print(path_array[i] + " ");
	}
	
	
	
	
	
	
	
	
	
	
}
