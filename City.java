/**
 *	City data - the city name, state name, location designation,
 *				and population est. 2017
 *
 *	@author	Darren Lin
 *	@since	1 - 16 - 2023
 */
public class City implements Comparable<City> {
	
	// fields
	private String name, state, cityType;
	private int population;
	// constructor
	public City(String nameIn, String stateIn, String cityTypeIn, int populationIn)
	{
		name = nameIn;
		state = stateIn;
		cityType = cityTypeIn;
		population = populationIn;
	}
	/**	Compare two cities populations
	 *	@param other		the other City to compare
	 *	@return				the following value:
	 *		If populations are different, then returns (this.population - other.population)
	 *		else if states are different, then returns (this.state - other.state)
	 *		else returns (this.name - other.name)
	 */
	public int compareTo(City other)
	{
		if(this.population - other.population != 0)
			return this.population - other.population;
		else if (!state.equals(other.state))
			return state.compareTo(other.state);
		else
			return name.compareTo(other.name);
		
	}
	/**	Equal city name and state name
	 *	@param other		the other City to compare
	 *	@return				true if city name and state name equal; false otherwise
	 */
	public boolean equals(City  other)
	{
		if(name.equals(other.name) && state.equals(other.state))
			return true;
		return false;
	}
	/**	Accessor methods */
	public String getCity(){return name;}
	public String getState(){return state;}
	public String getCityType(){return cityType;}
	public int getPopulation(){return population;} 
	/**	toString */
	@Override
	public String toString() {
		return String.format("%-22s %-22s %-12s %,12d", state, name, cityType,
						population);
	}
}
