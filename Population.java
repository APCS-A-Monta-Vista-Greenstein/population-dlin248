import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *	Population - This program will sort the population and name of cities 
 * 	in different orders using different sorts. It will store all of the cities
 * 	in a list with variable type City. 
 *
 *	Requires FileUtils and Prompt classes.
 *
 *	@author	Darren Lin
 *	@since	1 - 16 - 2023
 */
public class Population {
	
	// List of cities
	private List<City> cities;
	private SortMethods sort;
	//time it takes to sort
	private long time;
	// US data file
	private final String DATA_FILE = "usPopData2017.txt";
	public Population()
	{
		time = -1;
		cities = new ArrayList<City>();
		sort = new SortMethods();
	}
	
	/**	Prints the introduction to Population */
	public void printIntroduction() {
		System.out.println("   ___                  _       _   _");
		System.out.println("  / _ \\___  _ __  _   _| | __ _| |_(_) ___  _ __ ");
		System.out.println(" / /_)/ _ \\| '_ \\| | | | |/ _` | __| |/ _ \\| '_ \\ ");
		System.out.println("/ ___/ (_) | |_) | |_| | | (_| | |_| | (_) | | | |");
		System.out.println("\\/    \\___/| .__/ \\__,_|_|\\__,_|\\__|_|\\___/|_| |_|");
		System.out.println("           |_|");
		System.out.println();
	}
	
	/**	Print out the choices for population sorting */
	public void printMenu() {
		System.out.println("1. Fifty least populous cities in USA (Selection Sort)");
		System.out.println("2. Fifty most populous cities in USA (Merge Sort)");
		System.out.println("3. First fifty cities sorted by name (Insertion Sort)");
		System.out.println("4. Last fifty cities sorted by name descending (Merge Sort)");
		System.out.println("5. Fifty most populous cities in named state");
		System.out.println("6. All cities matching a name sorted by population");
		System.out.println("9. Quit");
	}
	
	public static void main(String [] args)
	{
		Population pn = new Population();
		pn.run();
	}
	
	public void run()
	{
		Scanner scanner = FileUtils.openToRead(DATA_FILE);
		int counter = 0;
		printIntroduction();
		while(scanner.hasNextLine())
		{
			counter++;
			String str = scanner.nextLine();
			String state = str.substring(0,str.indexOf("\t"));
			str = str.substring(str.indexOf("\t")+1);	
			String city = str.substring(0,str.indexOf("\t"));
			str = str.substring(str.indexOf("\t")+1);
			String cityType = str.substring(0,str.indexOf("\t"));
			str = str.substring(str.indexOf("\t")+1);
			String pop = str.substring(0);
			int population = Integer.parseInt(pop.trim());
			cities.add(new City(city,state,cityType,population));
		}
		System.out.println(counter + " cities in database.");
		printMenu();
		int selection = Prompt.getInt("Enter selection");
		while(selection != 9)
		{
			while(selection < 1 || selection  > 6)
				selection = Prompt.getInt("Enter selection");
			if(selection == 1)
				ascendingPopulationOrder();
			else if(selection == 2)
				descendingPopulationOrder();
			else if(selection == 3)
				ascendingNameOrder();
			else if(selection == 4)
				descendingNameOrder();
			else if(selection == 5)
			{
				String name;
				boolean works = true;
				do
				{
					name = Prompt.getString("Enter state name ( ie. Alabama)");
					works = mostPopular(name);
					if(!works)
					{
						System.out.println("\nERROR: " + name + " is not valid.");
					}
				}while(!works);
			}
			else
			{
				String name = Prompt.getString("\nEnter city name");
				matchingName(name);
			}
			System.out.println("\nElapsed time: " + time);
			
			printMenu();
			selection = Prompt.getInt("Enter selection");
		}
	}
	/**
	 * Sorts the list cities in ascending order by population using selection sort*/
	public void ascendingPopulationOrder()
	{
		long startMillisec = System.currentTimeMillis();
		
		long endMillisec = System.currentTimeMillis();
		time = endMillisec - startMillisec;
	}
	/** Sorts the list cities in descending order by population using merge sort*/
	public void descendingPopulationOrder()
	{
		long startMillisec = System.currentTimeMillis();
		
		long endMillisec = System.currentTimeMillis();
		time = endMillisec - startMillisec;
	}
	/** Sorts the list cities in ascending order based on their name using insertion sort*/
	public void ascendingNameOrder()
	{
		long startMillisec = System.currentTimeMillis();
		
		long endMillisec = System.currentTimeMillis();
		time = endMillisec - startMillisec;
	}
	/** Sorts the list cities in descending order based on their name using merge sort*/
	public void descendingNameOrder()
	{
		long startMillisec = System.currentTimeMillis();
		
		long endMillisec = System.currentTimeMillis();
		time = endMillisec - startMillisec;
	}
	/**Sorts the most popular cities in a state using mergeSort
	 * @param name 		The name of the state that you want sorted*/
	public boolean mostPopular(String name)
	{
		List<City> citiesMatching = new ArrayList<City>();
		for(int i = 0; i < cities.size(); i++)
		{
			if(cities.get(i).getState().equals(name))
				citiesMatching.add(cities.get(i));
		}
		if(citiesMatching.size() == 0)
			return false;
		long startMillisec = System.currentTimeMillis();
		
		long endMillisec = System.currentTimeMillis();
		time = endMillisec - startMillisec;
		return true;
	}
	/**Sorts all the cities matching a name based on population
	 * @param name 		The name of the city that you want sorted*/
	public void matchingName(String name)
	{
		List<City> citiesMatching = new ArrayList<City>();
		for(int i = 0; i < cities.size(); i++)
		{
			if(cities.get(i).getCity().equals(name))
				citiesMatching.add(cities.get(i));
			if(cities.get(i).getCity().equals("Fremont"))
			{System.out.println("cheese");}
		}
		long startMillisec = System.currentTimeMillis();
		sort.mergeSortPopulation(citiesMatching);
		long endMillisec = System.currentTimeMillis();
		System.out.println("City " + name + " by population");
		System.out.printf("%-25s%-25s%-25s%-25s","State", "City","Type","Population");
		int counter = citiesMatching.size()-1;
		int number = 1;
		System.out.println("size" + citiesMatching.size());
		while(citiesMatching.size() > 0)
		{
			City city = citiesMatching.get(counter);
			System.out.printf("\n%4d:%-25s%-25s%-25s%-25d",number,city.getState()
				,city.getCity(),city.getCityType(),city.getPopulation());
			counter++;
		}

		time = endMillisec - startMillisec;
	}
}
