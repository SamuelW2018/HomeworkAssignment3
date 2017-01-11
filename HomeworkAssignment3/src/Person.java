
/**
 * Abstract base class of person.
 * @author swynsma18
 *
 */
public abstract class Person {
	String FirstName;
	String LastName;
	int Age;
	String PhoneNumber;
	
	/**
	 * This is the standard constructor for person. It takes a first name, last name, age, and phone number.
	 * @param Fname = first name
	 * @param Lname = last name
	 * @param A = age
	 * @param Pnum = phone
	 */
	public Person(String Fname, String Lname, int A, String Pnum)
	{
		FirstName = Fname;
		LastName = Lname;
		Age = A;
		PhoneNumber = Pnum;
	}
	
	/**
	 * Change the first name.
	 * @param S = new first name.
	 */
	public void setFirstName(String S)
	{
		FirstName = S;
	}
	
	/**
	 * Change the last name.
	 * @param S = new last name.
	 */
	public void setLastName(String S)
	{
		LastName = S;
	}
	
	/**
	 * Change the age.
	 * @param A = new age
	 */
	public void setAge(int A)
	{
		Age = A;
	}
	
	/**
	 * Change the phone number.
	 * @param S = new phone number
	 */
	public void setPhoneNumber(String S)
	{
		PhoneNumber = S;
	}
	
	/**
	 * Get the first name
	 * @return first name
	 */
	public String getFirstName()
	{
		return FirstName;
	}
	
	/**
	 * Gets the last name.
	 * @return last name
	 */
	public String getLastName()
	{
		return LastName;
	}
	
	/**
	 * Gets the age.
	 * @return Age.
	 */
	public int getAge()
	{
		return Age;
	}
	
	/**
	 * gets the phone number
	 * @return phone number.
	 */
	public String getPhoneNumber()
	{
		return PhoneNumber;
	}

}
