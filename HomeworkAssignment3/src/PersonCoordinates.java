
/**
 * Person Coordinates Class. These keep track of where the people are in the city.
 * @author swynsma18
 *
 */
public class PersonCoordinates {
	Person p;
	int X;
	int Y;
	
	/**
	 * Constructor for the person coordinates.
	 * @param Per = the person that we are passing in for coordinates.
	 * @param XVal = the X-coordinate of the person in the city viewing box (top left corner).
	 * @param YVal = the Y coordinate of the person in the city viewing box (top left corner).
	 */
	public PersonCoordinates(Person Per, int XVal, int YVal)
	{
		p = Per;
		X = XVal;
		Y = YVal;
	}
	
	/**
	 * Sets the X coordinate. Generally called during the dragging function.
	 * @param XVal = new X value.
	 */
	public void setX(int XVal) {X = XVal;}
	/**
	 * Sets the Y coordinate. Generally called during the dragging function.
	 * @param YVal = new Y value.
	 */
	public void SetY(int YVal) {Y = YVal;}
	/**
	 * In case the person object is changed, replaces the person object with a new person.
	 * @param P = new person.
	 */
	public void setPerson(Person P) {p = P;}
	
	/**
	 * Gets the current X coordinate.
	 * @return X coordinate.
	 */
	public int getX() {return X;}
	/**
	 * Gets the current Y coordinate
	 * @return Y coordinate
	 */
	public int getY() {return Y;}
	/**
	 * Gets the information on the current person object. Generally used to find more specific information on the person.
	 * @return Person object.
	 */
	public Person getP() {return p;}
}
