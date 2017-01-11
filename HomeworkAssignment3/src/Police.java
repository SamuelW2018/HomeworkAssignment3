
/**
 * The police class is a type of person that is also an employee and has a role.
 * @author swynsma18
 *
 */
public class Police extends Person implements Employee{
	public enum Role{Patrol, Sergeant, Captain, Chief};
	Role R;
	float PolicePay = 25000;
	private static int IncreasingID = 1000;
	private int ID;
	
	/**
	 * This is the standard constructor.
	 * @param R = role
	 * @param FN = first name
	 * @param LN = last name
	 * @param A = age
	 * @param PN = phone number
	 */
	public Police(Role R, String FN, String LN, int A, String PN)
	{
		super(FN, LN, A, PN);
		ID = IncreasingID;
		IncreasingID++;
		this.R = R;
	}
	
	/**
	 * This constructor does not know the role of the policmean
	 * @param FN = first name
	 * @param LN = last name
	 * @param A = age
	 * @param PN = phone
	 */
	public Police(String FN, String LN, int A, String PN)
	{
		super(FN, LN, A, PN);
		ID = IncreasingID;
		IncreasingID++;
	}
	
	
	/**
	 * Change the role to S.
	 * @param S = new role
	 */
	public void setRole(Role S)
	{
		R = S;
	}
	
	/**
	 * Gets the policeman's role
	 * @return the policeman's current role.
	 */
	public Role getRole()
	{
		return R;
	}
	
	/**
	 * Pay the policeman
	 */
	public float givePay() {return PolicePay;}
	
	/**
	 * Gets the ID of the policeman.
	 */
	public int getID() {return ID;}
}


