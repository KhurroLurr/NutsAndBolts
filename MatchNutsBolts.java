// Nicholas Espinosa
// COP 3503 - 0011
// 1.27.2016
// Recitation Assignment Week 2
// Nuts and Bolts

import java.util.Random;

public class MatchNutsBolts
{	
	// Swaps nuts in the given indexes
	private static void swapNuts(Nut[] nuts, int a, int b)
	{
		Nut temp = nuts[a];
		nuts[a] = nuts[b];
		nuts[b] = temp;
	}
	
	// Swaps the bolts in the given indexes
	private static void swapBolts(Bolt[] bolts, int a, int b)
	{
		Bolt temp = bolts[a];
		bolts[a] = bolts[b];
		bolts[b] = temp;
	}
	
	// Partitions the bolt array
	private static int partitionBolts(Nut[] nuts, Bolt[] bolts, int low, int high)
	{
		// Initializing the proper values
		Nut temp = nuts[high];
		int i = low;
		
		for(int j = low; j < high; j++)
		{
			// Smaller values placed at the beginning of the array
			if(bolts[j].compareTo(temp) < 0)
			{
				swapBolts(bolts, i, j);
				i++;
			}
		}
		
		// Matching values are placed in the middle to partition the arrays
		swapNuts(nuts, i, high);
		swapBolts(bolts, i, high);
		
		// The relevant index is returned
		return i;
	}
	
	// Partitions the Nut array
	private static int partitionNuts(Nut[] nuts, Bolt[] bolts, int low, int high)
	{
		// Establishing variables
		Bolt temp = bolts[high];
		int i = low;
		
		for(int j = low; j < high; j++)
		{
			// Smaller values placed at beginning
			if(nuts[j].compareTo(temp) < 0)
			{
				swapNuts(nuts, i, j);
				i++;
			}// Equal value is placed in the relevant location
			else if(nuts[j].compareTo(temp) == 0)
			{
				swapNuts(nuts, j, high);
				j--; // Go back to ensure the nut is placed in the 
			} 	     //right part of the array
		}
		
		// Partitioning the bolts to ensure they're in order
		return partitionBolts(nuts, bolts, low, high);
	}
	
	
	// Quick Sort function
	private static void quickSort(Nut[] nuts, Bolt[] bolts, int low, int high)
	{
		// Ensures that the function remains in bound
		if(low < high)
		{
			// Determines the partition and performs the necessary sorts
			int p = partitionNuts(nuts, bolts, low, high);
			quickSort(nuts, bolts, low, p - 1);
			quickSort(nuts, bolts, p + 1, high);
		}
	}
	// Match function
	private static void match(Nut[] nuts, Bolt[] bolts)
	{
		// Begins quickSort of the arrays 
		quickSort(nuts, bolts, 0, bolts.length - 1);
	}
	
	public static void main(String[] args)
	{
		// This code is used for testing purposes
		// You can either use this code or your own
//		Random r =  new Random();
//		Bolt[] bolts = NutsBolts.makeRandomBolts(r, 1000);
//		Nut[] nuts = NutsBolts.makeMatchingNuts(r, bolts);
//		
//		match(nuts, bolts);
//		
//		System.out.println(NutsBolts.correctFit(nuts, bolts));
	}

}