import java.util.ArrayList;
/**
 * This class is the building class. Buildings have a name and address.
 * @author swynsma18
 * @version 1.00 05 January 2017
 */
public class Building {
	ArrayList<Person> PeoplePresent; 
	String Name;
	String Address;
	
	/**
	 * Initialize the building: this is a default initializer
	 */
	public Building()
	{
		Name = "";
		Address = "";
	}
	
	/**
	 * Initialize the building given a name and address.
	 * @param N is the name
	 * @param A is the address
	 */
	public Building(String N, String A)
	{
		Name = N;
		Address = A;
	}
	
	/**
	 * Returns the name of the building
	 * @return building name
	 */
	public String getName()
	{
		return Name;
	}
	
	/**
	 * Sets the name of the building
	 * @param s is the new name.
	 */
	public void setName(String s) {Name = s;}
	
	public void AddPerson(Person P)
	{
		PeoplePresent.add(P);
	}
}
