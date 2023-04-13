package Assignment1_Q2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Assignment1_Q1.UndirectedGraph;


public class TourGuide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//-----------------------------------------------------------------
		// Title: Question 2
		// Author: Basme Zantout
		// ID: 99227947762
		// Section: 1
		// Assignment: 1
		// Description: This is the main class for Question 2 which calls 
		//              the methods that perform the needed operations, 
	    //              which are intended to find the shortest cycle 
	    //              starting from one island  and including a given
	    //              specific island
		//-----------------------------------------------------------------
		

		
		
	//-------------------------------------------------------
	// The "readFiles" method reads the given input data
	//-------------------------------------------------------
				
		readFiles("matrixes2/ass1/input4.txt");
		
		 
		
		
	//------------------------------------------------------------
	// The main method calls the static "Find_ShortestCycle()" 
	// method in the "ShortestCycle" class. The following method
	// finds the shortest cyclic trip from the starting island 
	// and including a specific given island
	//
	// Note: check the "Find_ShortestCycle()" method in the 
	//       "ShortestCycle" class for implementation details.
	//------------------------------------------------------------
		
		ShortestCycle.Find_ShortestCycle();
		
	}
	
	
	
	
	
	
	
	
	private static void readFiles(String file) 
//---------------------------------------------------------------
// Summary: scans or reads the given input data
// Precondition: the method initially defines a Scanner object (1).
// Postcondition: First, the number of islands (vertices) in the 
//	              tour graph is scanned and a graph object is
//	              initialized accordingly (2). Next, the number of
//	              connections (edges) is scanned and saved and the 
//                cycle array is initialized accordingly (3). Then,
//	              based on the number of edges, the connections are
//	              scanned and the edges are added to the initialized
//	              graph (4). Finally, the initial and to-be-included 
//	              islands are scanned and saved (5). 
// 
// Note: check the static attributes in the "ShortestCycle" class
//	       as well as the "UndirectedGraph" class for details.
//---------------------------------------------------------------

	{
		
		try
		{
			File f = new File(file);
			
			// (1)
			
			Scanner scan = new Scanner(f);
			
			
			// (2)
			
			ShortestCycle.TourGuide_Graph = new UndirectedGraph(scan.nextInt());
			
		    // (3)
			
			int i = scan.nextInt();
			ShortestCycle.cycle = new int[i];
			
			
			// (4)
			
			for (int z = 0; z < i ; z++)
			{
				ShortestCycle.TourGuide_Graph.addEdge(scan.nextInt(), scan.nextInt());
			}
			
			
			// (5)
			
			ShortestCycle.Start_point = scan.nextInt();
			ShortestCycle.Included_point = scan.nextInt();
			
			scan.close();
		}
		
		catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	

}
