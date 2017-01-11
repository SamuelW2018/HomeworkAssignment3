/**
 * A kid is a specific kind of person who doesnt have a job and has a favorite candy.
 * @author swynsma18
 *
 */
public class Kid extends Person{
	String favoriteCandy;
	
	/*
	 * Standard constructor for kid: calls the basic person constructor.
	 */
	
	/**
	 * Calls the person constructor with all of attributes below.
	 * @param FN = first name
	 * @param LN = last name
	 * @param A = age
	 * @param PN = phone
	 */
	public Kid(String FN, String LN, int A, String PN)
	{
		super(FN, LN, A, PN);
	}
	
	public String getCandy() {return favoriteCandy;}
	
	public void setCandy(String C) {favoriteCandy = C;}
}
