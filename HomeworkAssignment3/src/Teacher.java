
/**
 * Teacher class: A class of teachers which are persons and employees.
 * @author swynsma18
 *
 */
public class Teacher extends Person implements Employee{
	int GradeLevel;
	String Certification;
	float pay = 10000;
	private static int ID = 1;
	private int TID;
	
	/**
	 * Main constructor for teacher.
	 * @param FN = first name
	 * @param LN = last name
	 * @param A = age
	 * @param PN = phone
	 */
	public Teacher(String FN, String LN, int A, String PN)
	{
		super(FN, LN, A, PN);
		TID = ID;
		ID++;
		GradeLevel = 0;
		Certification = "Yes";
	}
	
	/**
	 * This constructor is the same as the previous, but sets the certification and the grade level.
	 * @param G = grade level
	 * @param C = certification
	 * @param FN = first name
	 * @param LN = last name
	 * @param A = age
	 * @param PN = phone
	 */
	public Teacher(int G, String C, String FN, String LN, int A, String PN)
	{
		super(FN, LN, A, PN);
		TID = ID;
		ID++;
		GradeLevel = G;
		Certification = C;
	}
	
	/**
	 * Gets the grade level.
	 * @return grade level.
	 */
	public int getGradeLevel() {return GradeLevel;}
	/**
	 * Gets the certification
	 * @return certification
	 */
	public String getCertification() {return Certification;}
	
	/**
	 * Sets the grade level.
	 * @param GL is the grade level we are setting it to.
	 */
	public void setGradeLevel(int GL) {GradeLevel = GL;}
	
	/**
	 * Pays the teacher.
	 */
	public float givePay() {return pay;}
	
	/**
	 * Gets the teacher's employee ID.
	 */
	public int getID() {return TID;}
	
}
