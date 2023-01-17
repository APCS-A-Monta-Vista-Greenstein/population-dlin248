import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *	SortMethods - Sorts an array of Integers in ascending order.
 *
 *	@author Peter Chen
 *	@since	12/5/2022
 */
public class SortMethods {
	
	/**
	 *	Bubble Sort algorithm - in ascending order
	 *	@param arr		array of Integer objects to sort
	 */
	public void bubbleSort(Integer [] arr) {
		for(int outer = arr.length - 1; outer > 0; outer--) {
			for(int inner = 0; inner < outer; inner++) {
				if(arr[inner].compareTo(arr[inner+1]) > 0) {
					swap(arr, inner, inner+1);
				}
			}
		}
	}
	
	/**
	 *	Swaps two Integer objects in array arr
	 *	@param arr		array of Integer objects
	 *	@param x		index of first object to swap
	 *	@param y		index of second object to swap
	 */
	private void swap(Integer[] arr, int x, int y) {
		Integer temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
	/**
	 *	Selection Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	public void selectionSort(Integer [] arr) {
		int largestIndex = 0; 
        for(int i = arr.length - 1; i > 0; i--) {
			largestIndex = i;
            for(int j = 0; j < i; j++) {
                
                if(arr[j] > arr[largestIndex]) {
					largestIndex = j;
				}
			}
			swap(arr, largestIndex, i);
        }
	}
	
	/**
	 *	Insertion Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	public void insertionSort(Integer [] arr) {
		ArrayList<Integer> sorted = new ArrayList<Integer>(Arrays.asList(arr));
	
		for (int i = 0; i < sorted.size(); i++)
		{
			for (int insertLocation = 0; insertLocation < i; insertLocation++) {
				if (sorted.get(i) < sorted.get(insertLocation)) {
					int temp = sorted.remove(i);
					sorted.add(insertLocation, temp);
				}
			}
		}
		arr = sorted.toArray(arr);
	}
	/**
	 *	Merge Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	public void mergeSort(Integer [] arr)
	{

		if (arr.length > 1) 
		{
			Integer[] left = new Integer[arr.length / 2];
			Integer[] right = new Integer[arr.length - left.length];
			for (int i = 0; i < left.length; i++) 
			{
				left[i] = arr[i];
			}
			for (int i = 0; i < right.length; i++) 
			{
				right[i] = arr[i + left.length];
			}
			mergeSort(left);
			mergeSort(right);
			int i1 = 0;
			int i2 = 0;
			for (int i = 0; i < arr.length; i++) 
			{
				if (i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])) 
				{
						arr[i] = left[i1];
						i1++;
				} 
				else 
				{
					arr[i] = right[i2];
					i2++;
				}
			}
		}
	}
	/**
	 *	Modified Merge Sort algorithm - in ascending order (you implement)
	 * 	to handle List<City>
	 * 	Handles population 
	 *	@param arr		list of city objects to sort.
	 */
	public void mergeSortPopulation(List<City> arr)
	{

		if (arr.size() > 1) 
		{
			List<City> left = new ArrayList<City>();
			List<City> right = new ArrayList<City>();
			for (int i = 0; i < arr.size()/2; i++) 
			{
				left.add(arr.get(i));
			}
			for (int i = 0; i < arr.size()-arr.size(); i++) 
			{
				right.add(i,arr.get(i + left.size()));
			}
			mergeSortPopulation(left);
			mergeSortPopulation(right);
			int i1 = 0;
			int i2 = 0;
			int length = arr.size();
			arr.clear();
			for (int i = 0; i < length; i++) 
			{
				if (i2 > right.size() || (i1 < left.size() && left.get(i1).getPopulation()<(right.get(i2).getPopulation()))) 
				{
					arr.add(left.get(i1));
					i1++;
				} 
				else 
				{
					arr.add(i,right.get(i2));
					i2++;
				}
			}
		}
	}
	/**
	 *	Modified Merge Sort algorithm - in ascending order (you implement)
	 * 	to handle List<City>
	 * 	Handles name
	 *	@param arr		List of city objects to sort.
	 */
	public void mergeSortName(List<City> arr)
	{

		if (arr.size() > 1) 
		{
			List<City> left = new ArrayList<City>();
			List<City> right = new ArrayList<City>();
			for (int i = 0; i < arr.size()/2; i++) 
			{
				left.set(i,arr.get(i));
			}
			for (int i = 0; i < arr.size()-left.size(); i++) 
			{
				right.set(i,arr.get(i + left.size()));
			}
			mergeSortName(left);
			mergeSortName(right);
			int i1 = 0;
			int i2 = 0;
			for (int i = 0; i < arr.size(); i++) 
			{
				if (i2 >= right.size() || (i1 < left.size() && left.get(i1).getCity().compareTo(right.get(i2).getCity()) <= 0)) 
				{
						arr.set(i,left.get(i1));
						i1++;
				} 
				else 
				{
					arr.set(i,right.get(i2));
					i2++;
				}
			}
		}
	}
	/*
	public void recursiveMergeSort(Integer [] arr, int from, int to) {
		int length = to - from;
		double temp = new double[length];
		if(length > 2)
		{
			int mid = (to + from) /2;
			recursiveMergeSort(Integer [], from , mid);
			recursiveMergeSort(Integer [], mid + 1; to);
			int i = from; 
			int j = mid + 1;
			int k = from;
			while(i <= mid && j <= to)
			{
				if(arr[i] < a [j])
				{
					
		}
		else if(length == 2)
		{
			if(arr[from] < arr[to])
				swap(arr,from,to);
		}

	}*/
	
	/*****************************************************************/
	/************************* For Testing ***************************/
	/*****************************************************************/
	
	/**
	 *	Print an array of Integers to the screen
	 *	@param arr		the array of Integers
	 */
	public void printArray(Integer[] arr) {
		if (arr.length == 0) System.out.print("(");
		else System.out.printf("( %4d", arr[0]);
		for (int a = 1; a < arr.length; a++) {
			if (a % 10 == 0) System.out.printf(",\n  %4d", arr[a]);
			else System.out.printf(", %4d", arr[a]);
		}
		System.out.println(" )");
	}

	public static void main(String[] args) {
		SortMethods se = new SortMethods();
		se.run();
	}
	
	public void run() {
		Integer[] arr = new Integer[50];
		// Fill arr with random numbers
		/** 
		for (int a = 0; a < 10; a++)
			arr[a] = (int)(Math.random() * 100) + 1;
		System.out.println("\nBubble Sort");
		System.out.println("Array before sort:");
		printArray(arr);
		System.out.println();
		bubbleSort(arr);
		System.out.println("Array after sort:");
		printArray(arr);
		System.out.println();
		*/
	/*
		for (int a = 0; a < 50; a++)
			arr[a] = (int)(Math.random() * 100) + 1;
		System.out.println("\nSelection Sort");
		System.out.println("Array before sort:");
		printArray(arr);
		System.out.println();
		selectionSort(arr);
		System.out.println("Array after sort:");
		printArray(arr);
		System.out.println();
*/
		
		for (int a = 0; a < 50; a++)
			arr[a] = (int)(Math.random() * 100) + 1;
		System.out.println("\nInsertion Sort");
		System.out.println("Array before sort:");
		printArray(arr);
		System.out.println();
		insertionSort(arr);
		System.out.println("Array after sort:");
		printArray(arr);
		System.out.println();

		
		for (int a = 0; a < 10; a++)
			arr[a] = (int)(Math.random() * 100) + 1;
		System.out.println("\nMerge Sort");
		System.out.println("Array before sort:");
		printArray(arr);
		System.out.println();
		mergeSort(arr);
		System.out.println("Array after sort:");
		printArray(arr);
		System.out.println();

	}
}
