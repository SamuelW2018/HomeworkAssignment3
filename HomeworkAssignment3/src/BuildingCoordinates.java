/**
 * This function handles the building coordinates. It contains a building object and the X and Y coordinates for the placement of the building.
 * @author swynsma18
 *
 */
public class BuildingCoordinates {
	Building B;
	int X;
	int Y;
	
	/**
	 * Constructor for building coordinates.
	 * @param Bui = Building
	 * @param XVal = X Coordinate of top left corner.
	 * @param YVal = Y Coordinate of top left corner.
	 */
	public BuildingCoordinates(Building Bui, int XVal, int YVal)
	{
		B = Bui;
		X = XVal;
		Y = YVal;
	}
	
	/**
	 * Sets the X coordinate value. Only called once at max.
	 * @param XVal = new X coordinate.
	 */
	public void setX(int XVal) {X = XVal;}
	/**
	 * Sets the Y coordinate value. Only called once at max.
	 * @param YVal = new Y coordinate.
	 */
	public void SetY(int YVal) {Y = YVal;}
	/**
	 * Sets the building object.
	 * @param Bui = new Building.
	 */
	public void setPerson(Building Bui) {B = Bui;}
	
	/**
	 * Gets the current X-Value. Generally called for mouse-clicking functions.
	 * @return X coordinate.
	 */
	public int getX() {return X;}
	/**
	 * Gets the current Y-Value. Generally called for mouse-clicking functions.
	 * @return Y coordinate.
	 */
	public int getY() {return Y;}
	/**
	 * Gets the building object. Called for information on the building.
	 * @return Building object, which then can be used for its other functions.
	 */
	public Building getB() {return B;}
}
