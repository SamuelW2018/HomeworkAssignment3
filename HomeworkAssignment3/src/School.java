import java.util.ArrayList;

/**
 * A type of building where kids and teachers teach and learn.
 * @author swynsma18
 *
 */
public class School extends Building{
	private ArrayList<Kid> ChildrenPresent;
	private ArrayList<Teacher> TeachersPresent;
	
	/**
	 * This constructor takes an arrayList of kids and an arrayList of teachers. It sets the building name to "School"
	 * @param K = arrayList of kids
	 * @param T = arrayList of teachers
	 */
	public School(ArrayList<Kid> K, ArrayList<Teacher> T)
	{
		ChildrenPresent = K;
		TeachersPresent = T;
		Name = "School";
	}
	
	/**
	 * Gets the names of the kids in the school in order to list out the kids for the city class.
	 * @return list of kid first names.
	 */
	public ArrayList<String> GetStudents()
	{
		ArrayList<String> S = new ArrayList<String>();
		for (int i = 0; i < ChildrenPresent.size(); i++)
		{
			S.add(ChildrenPresent.get(i).getFirstName());
		}
		
		return S;
	}
	
	/**
	 * Gets the names of the teachers in the school.
	 * @return list of teacher first names.
	 */
	public ArrayList<String> GetTeachers()
	{
		ArrayList<String> S = new ArrayList<String>();
		for (int i = 0; i < TeachersPresent.size(); i++)
		{
			S.add(TeachersPresent.get(i).getFirstName());
		}
		
		return S;
	}
	
	/**
	 * Adds a kid to the school.
	 * @param S: The kid that we are adding.
	 */
	public void AddChild(Kid S)
	{
		ChildrenPresent.add(S);
	}
	
	/**
	 * Adds a teacher to the school
	 * @param T = the teacher that we are adding.
	 */
	public void AddTeacher(Teacher T)
	{
		TeachersPresent.add(T);
	}
}
