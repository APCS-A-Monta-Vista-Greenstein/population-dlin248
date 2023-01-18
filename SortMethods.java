import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *	SortMethods - Different ways to sort arrays and list that are much different
 * 	in total computing time. 
 *
 *	@author Darren Lin
 *	@since	12/5/2022
 */
public class SortMethods {
	
	/**
	 *	Bubble Sort algorithm - in ascending order
	 *	@param arr		array of Integer objects to sort
	 */
	/**public void bubbleSort(Integer [] arr) {
		for(int outer = arr.length - 1; outer > 0; outer--) {
			for(int inner = 0; inner < outer; inner++) {
				if(arr[inner].compareTo(arr[inner+1]) > 0) {
					swap(arr, inner, inner+1);
				}
			}
		}
	}*/
	
	/**
	 *	Swaps two Integer objects in array arr
	 *	@param arr		List of City objects
	 *	@param x		index of first object to swap
	 *	@param y		index of second object to swap
	 */
	private void swap(List<City>arr, int x, int y) {
		City temp = arr.get(x);
		arr.set(x,arr.get(y));
		arr.set(y,temp);
	}
	
	/**
	 *	Selection Sort algorithm - in ascending order (you implement)
	 *	@param arr		List of city objects to sort
	 * 	@return 		The sorted list
	 */
	public List<City> selectionSort(List<City>arr) 
	{
		int largestIndex = 0; 
        for(int i = arr.size() - 1; i > 0; i--) 
        {
			largestIndex = i;
            for(int j = 0; j < i; j++) 
            {	   
                if(arr.get(j).getPopulation() > arr.get(largestIndex).getPopulation())
                {
					largestIndex = j;
				}
			}
			swap(arr, largestIndex, i);
        }
        return arr;
	}
	
	/**
	 *	Insertion Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	public void insertionSort(List<City>arr) {
		for (int i = 0; i < arr.size(); i++)
		{
			for (int insertLocation = 0; insertLocation < i; insertLocation++) 
			{
				if (arr.get(i).getCity().compareTo(arr.get(insertLocation).getCity()) < 0)
				{
					City temp = arr.remove(i);
					arr.add(insertLocation, temp);
				}
			}
		}
	}
	/**
	 *	Merge Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	/**
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
			/**for (int i = 0; i < arr.length; i++) 
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
			for(int i = 0; i < arr.length;i++)
			{
				if(i2 >= right.length || left[i1] < right[i2])
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
	}*/
	/**
	 *	Modified Merge Sort algorithm - in descending order (you implement)
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
			for (int i = 0; i < arr.size()-left.size(); i++) 
			{
				right.add(i,arr.get(i + left.size()));
			}
			mergeSortPopulation(left);
			mergeSortPopulation(right);
			int i1 = 0;
			int i2 = 0;
			int length = arr.size();
			arr.clear();
			while(i1 < left.size() || i2 < right.size())
			{
				if(i2 >= right.size())
				{
					if(i1 < left.size())
					{
						arr.add(left.get(i1));
						i1++;
					}
				}
				else if(i1 >= left.size())
				{
					arr.add(right.get(i2));
					i2++;
				}
				else if(left.get(i1).getPopulation() > right.get(i2).getPopulation())
				{
					arr.add(left.get(i1));
					i1++;
				}
				else
				{
					arr.add(right.get(i2));
					i2++;
				}
				
			}
		}
		else if( arr.size() == 2 )
		{
			if(arr.get(0).getPopulation() > arr.get(1).getPopulation())
			{
				swap(arr,0,1);
			}
			return;
		}
		else
			return;	 
	}
	/**
	 *	Modified Merge Sort algorithm - in descending order (you implement)
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
				left.add(arr.get(i));
			}
			for (int i = 0; i < arr.size()-left.size(); i++) 
			{
				right.add(i,arr.get(i + left.size()));
			}
			mergeSortName(left);
			mergeSortName(right);
			int i1 = 0;
			int i2 = 0;
			int length = arr.size();
			arr.clear();
			while(i1 < left.size() || i2 < right.size())
			{
				if(i2 >= right.size())
				{
					if(i1 < left.size())
					{
						arr.add(left.get(i1));
						i1++;
					}
				}
				else if(i1 >= left.size())
				{
					arr.add(right.get(i2));
					i2++;
				}
				else if(left.get(i1).getCity().compareTo(right.get(i2).getCity()) > 0)
				{
					arr.add(left.get(i1));
					i1++;
				}
				else
				{
					arr.add(right.get(i2));
					i2++;
				}
				
			}
		}
		else if( arr.size() == 2 )
		{
			if(arr.get(0).getCity().compareTo(arr.get(1).getCity()) > 0)
			{
				swap(arr,0,1);
			}
			return;
		}
		else
			return;	 
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
	

