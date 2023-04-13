package Assignment1_Q1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AirplaneRoute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//-----------------------------------------------------------------
		// Title: Question 1
		// Author: Basme Zantout
		// Description: This is the main class for Question 1 which calls 
		//              the methods that perform the needed operations, 
	        //              which are intended to find and calculate the time
		//              taken in the shortest path from one airport to 
	        //              another in a given airlines graph.
		//-----------------------------------------------------------------
		

		
		
	//-------------------------------------------------------
	// The "readFiles" method reads the given input data
	//-------------------------------------------------------
				
		readFiles("matrixes2/ass1/input1.txt");
		
		 
	//-------------------------------------------------------
	// The main method calls the static "Find_ShortestPath()" 
	// and"Calculate_Time()" methods in the "ShortestPath" 
	// class. The following methods find the shortest path 
	// between 2 specific airports given in the input and 
	// do the needed calculations to find the time consumed 
	// in the taken route, respectively.
	//
	// Note: check the "Find_ShortestPath()" and 
	//       "Calculate_Time()" methods in the "ShortestPath" 
    //        class for implementation details.
	//-------------------------------------------------------
			
		ShortestPath.Find_ShortestPath();
		ShortestPath.Calculate_Time();
		
		
	}

	
	
	
	
	private static void readFiles(String file) 
//---------------------------------------------------------------
// Summary: scans or reads the given input data
// Precondition: the method initially defines a Scanner object (1).
// Postcondition: First, the number of airports (vertices) in the 
//                airline graph is scanned and a graph object is
//                initialized accordingly (2). Next, the number of
//                connections (edges) is scanned and saved (3). The 
//                time taken by the flight is also saved (4). Then,
//                based on the number of edges, the connections are
//                scanned and the edges are added to the initialized
//                graph (5). Finally, the initial and destination 
//                airports are scanned and saved (6). 
// 
// Note: check the static attributes in the "ShortestPath" class
//       as well as the "UndirectedGraph" class for details.
//---------------------------------------------------------------

	{
		
		try
		{
			File f = new File(file);
			
			// (1)
			
			Scanner scan = new Scanner(f);

			
			// (2)
			ShortestPath.Airline_Graph = new UndirectedGraph(scan.nextInt());
			
			
			// (3)
			int i = scan.nextInt();
	
			
			// (4)
			
			ShortestPath.ChangeState = scan.nextInt();
			ShortestPath.Route_Time = scan.nextInt();
			
			
			// (5)
			
			for (int z = 0; z < i ; z++)
			{
				ShortestPath.Airline_Graph.addEdge(scan.nextInt(), scan.nextInt());
			}
				
			
			// (6)
			
			ShortestPath.Starting_Vertex = scan.nextInt();
			ShortestPath.Terminating_Vertex = scan.nextInt();
			
	
			scan.close();
		}
		
		catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
