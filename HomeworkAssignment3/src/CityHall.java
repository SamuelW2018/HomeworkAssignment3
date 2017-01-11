import java.util.ArrayList;

/**
 * This is a more specific class that models a specific kind of building: a City Hall.
 * @author swynsma18
 *
 */
public class CityHall extends Building{
	private ArrayList<Police> OfficersPresent;
	
	/**
	 * City hall initialized based on an array of police. The name is declared here too.
	 * @param P is the police in city hall.
	 */
	public CityHall(ArrayList<Police> P)
	{
		OfficersPresent = P;
		Name = "CityHall";
	}
	
	/**
	 * Gets the names of all the police in city hall for a method in City.
	 * @return all police in the city hall.
	 */
	public ArrayList<String> GetPolice()
	{
		ArrayList<String> S = new ArrayList<String>();
		for (int i = 0; i < OfficersPresent.size(); i++)
		{
			S.add(OfficersPresent.get(i).getFirstName());
		}
		
		return S;
	}
}
