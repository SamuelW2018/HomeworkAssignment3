import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

/**
 * This is the main class for homework assignment 3. It handles the entirety of the city view.
 * @author swynsma18
 *
 */
public class CityViewer extends JComponent implements MouseMotionListener, MouseListener{
	Image image, imageField;
	boolean dragging;
	static Image BuildingImage;
	static Image PoliceImage;
	static Image KidImage;
	static Image TeacherImage;
	static Image CityImage;
	static Image SchoolImage;
	static Image Back;
	static int imageWidth = 150, imageHeight = 150;
	static int imageWidth2 = 40, imageHeight2 = 40;
	static int BackWidth = 800, BackHeight = 800;
	static ArrayList<PersonCoordinates> PCo = new ArrayList<PersonCoordinates>();
	static ArrayList<BuildingCoordinates> BCo = new ArrayList<BuildingCoordinates>();
	
	
	JFrame frame;
	
	/**
	 * This is the starting function for objects. It adds a mouse motion listener and mouse listener to the object.
	 */
	public CityViewer()
	{
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	/**
	 * This function is the mouse dragging function. It checks to see if the mouse is being dragged while on a person object.
	 * In the case that the mouse is dragging a Person Coordinates object, it only lets the mouse drag one object.
	 * It also checks if the mouse has dragged a distance away from the object to prevent sudden jumps.
	 */
	public void mouseDragged(MouseEvent e)
	{
		if (!dragging) {
			
			for (PersonCoordinates PC: PCo)
			{
				if (PC.getX() < e.getX() && PC.getX()+40 > e.getX() && PC.getY() < e.getY() && PC.getY()+40 > e.getY())
				{
					dragging = true;
					PC.setX(e.getX()-20);
					PC.SetY(e.getY()-20);
					break;
				}
			}
		}
		else
		{
			for (PersonCoordinates PC: PCo)
			{
				if (!(PC.getX()-50 < e.getX() && PC.getX()+10 > e.getX() && PC.getY()-50 < e.getY() && PC.getY()+10 > e.getY()))
				{
					dragging = false;
				}
			}
		}
		repaint();
	}
	
	/**
	 * This is the mouse clicked event. First, it checks all buildings and sees if the mouse clicked inside of any of them.
	 * If the mouse did click inside any of the buildings, then information for the buildings is shown.
	 * If there are any people within the vicinity of the building, they are considered inside the building. 
	 * Second, the program will output this information associated with the building in the form of a message box.
	 * Third, the program will check if the mouse clicked on any of the people.
	 * Finally, it will display this information to the screen in the form of a message box.
	 */
	public void mouseClicked(MouseEvent e)
	{
		JFrame frame2 = new JFrame();
		frame2.setSize(200, 200);
		String message = "";
		for (BuildingCoordinates BC: BCo)
		{
			int count = 0;
			int kid = 0;
			int teach = 0;
			int police = 0;
			String InsO = "";
			if (BC.getX() < e.getX() && BC.getX()+150 > e.getX() && BC.getY() < e.getY() && BC.getY()+150 > e.getY())
			{
				message += "Building name: " + BC.getB().getName() + " \n";
				for (PersonCoordinates PC: PCo)
				{
					if (PC.getX() > BC.getX() && BC.getX()+150 > PC.getX() && BC.getY() < PC.getY() && BC.getY()+150 > PC.getY())
					{
						count++;
						if (PC.getP() instanceof Kid)
						{
							InsO="Kid";
							if (BC.getB() instanceof School)
								kid++;
						}
						else if (PC.getP() instanceof Teacher)
						{
							InsO="Teacher";
							if (BC.getB() instanceof School)
								teach++;
						}
						else
						{
							InsO="Police " + ((Police)PC.getP()).getRole().toString();
							if (BC.getB() instanceof CityHall)
								police++;
						}
						message += PC.getP().getFirstName() + " " + PC.getP().getLastName() + ", who is a " + InsO + ", is in this building. \n";
					}
				}
				if (BC.getB() instanceof School)
				{
					message += "There are a total of " + kid + " kid(s) and " + teach + " teacher(s) in this school.\n";
				}
				else if (BC.getB() instanceof CityHall)
				{
					message += "There are a total of " + police + " police officer(s) currently in the city hall. \n";
				}
				
				message += "In total, there are " + count + " people currently in this building.\n";
				JOptionPane.showMessageDialog(frame2, message, "Building Information", JOptionPane.INFORMATION_MESSAGE);
				message = "";
			}
		}
		for (PersonCoordinates PC : PCo)
		{
			if (PC.getX() < e.getX() && PC.getX()+40 > e.getX() && PC.getY() < e.getY() && PC.getY()+40 > e.getY())
			{
				message += "Person name: " + PC.getP().getFirstName() + " " + PC.getP().getLastName() + ".\n";
				message += PC.getP().getFirstName() + " " + PC.getP().getLastName() + " is a ";
				if (PC.getP() instanceof Kid)
				{
					message += "kid.\n";
				}
				else if (PC.getP() instanceof Teacher)
				{
					message += "teacher.\n";
				}
				else
				{
					message += "Police " + ((Police)PC.getP()).getRole().toString() + ".\n";
				}
				
				message += PC.getP().getFirstName() + " " + PC.getP().getLastName() + " is " + PC.getP().getAge() + " years old.\n";
				JOptionPane.showMessageDialog(frame2, message, "Person Information", JOptionPane.INFORMATION_MESSAGE);
				message = "";
			}
		}
	}
	
	public void mouseMoved(MouseEvent e) {}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * This is the paint function for the viewer. It draws the background first,
	 * then it draws all building and person objects at their locations specified by
	 * getting the X and Y coordinates of each.
	 */
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(Back, 0, 0, this);
		for (BuildingCoordinates BC: BCo) {
			if (BC.getB() instanceof CityHall)
			{
				g2.drawImage(CityImage, BC.getX(), BC.getY(), this);
			}
			else if (BC.getB() instanceof School)
			{
				g2.drawImage(SchoolImage, BC.getX(), BC.getY(), this);
			}
			else
				g2.drawImage(BuildingImage, BC.getX(), BC.getY(), this);
		}
		for (PersonCoordinates PC: PCo)
		{
			if (PC.getP() instanceof Police)
			{
				g2.drawImage(PoliceImage, PC.getX(), PC.getY(), this);
			}
			else if (PC.getP() instanceof Teacher)
			{
				g2.drawImage(TeacherImage, PC.getX(), PC.getY(), this);
			}
			else
			{
				g2.drawImage(KidImage, PC.getX(), PC.getY(), this);
			}
		}
	}
	
	/**
	 * This is the main function for the cityViewer. It handles all of the image information first.
	 * After it has downloaded all of the images from graphics, it then displays the buildings and people on screen.
	 * It generates X and Y coordinates for all of the people and buildings.
	 * Finally, it displays all of these objects to the screen.
	 * @param args is required for the main.
	 */
	public static void main(String[] args)
	{
		
		City C = new City();
		String BackString = "/graphics/GenericBackground.png";
		String Building = "/graphics/Building.png";
		String CityHall = "/graphics/CityHall.png";
		String Kid = "/graphics/Kid.png";
		String Police = "/graphics/Police.png";
		String School = "/graphics/School.png";
		String Teacher = "/graphics/Teacher.png";
		
		Back = Toolkit.getDefaultToolkit().getImage(CityViewer.class.getResource(BackString));
		Back = Back.getScaledInstance(BackWidth, BackHeight, Image.SCALE_DEFAULT);
		CityImage = Toolkit.getDefaultToolkit().getImage(CityViewer.class.getResource(CityHall));
		CityImage = CityImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
		BuildingImage = Toolkit.getDefaultToolkit().getImage(CityViewer.class.getResource(Building));
		BuildingImage = BuildingImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
		KidImage = Toolkit.getDefaultToolkit().getImage(CityViewer.class.getResource(Kid));
		KidImage = KidImage.getScaledInstance(imageWidth2, imageHeight2, Image.SCALE_DEFAULT);
		PoliceImage = Toolkit.getDefaultToolkit().getImage(CityViewer.class.getResource(Police));
		PoliceImage = PoliceImage.getScaledInstance(imageWidth2, imageHeight2, Image.SCALE_DEFAULT);
		SchoolImage = Toolkit.getDefaultToolkit().getImage(CityViewer.class.getResource(School));
		SchoolImage = SchoolImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
		TeacherImage = Toolkit.getDefaultToolkit().getImage(CityViewer.class.getResource(Teacher));
		TeacherImage = TeacherImage.getScaledInstance(imageWidth2, imageHeight2, Image.SCALE_DEFAULT);
		
		JFrame frame = new JFrame("CityViewer");
		frame.setSize(800,  800);
		
		frame.setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		
		
		for (int i = 0; i < C.GetBuildings().size(); i++)
		{
			Random rand = new Random();
			int XVal = rand.nextInt(700);
			int YVal = rand.nextInt(700);
			if (C.GetBuildings().get(i) instanceof CityHall)
				BCo.add(new BuildingCoordinates(C.GetBuildings().get(i), XVal, YVal));
			else if (C.GetBuildings().get(i) instanceof School)
				BCo.add(new BuildingCoordinates(C.GetBuildings().get(i), XVal, YVal));
			else
				BCo.add(new BuildingCoordinates(C.GetBuildings().get(i), XVal, YVal));
		}
		
		frame.add(p, BorderLayout.CENTER);
		
		for (int i = 0; i < C.GetPeople().size(); i++)
		{
			Random rand = new Random();
			int XVal = rand.nextInt(770);
			int YVal = rand.nextInt(770);
			if (C.GetPeople().get(i) instanceof Police)
				PCo.add(new PersonCoordinates(C.GetPeople().get(i), XVal, YVal));
			else if (C.GetPeople().get(i) instanceof Teacher)
				PCo.add(new PersonCoordinates(C.GetPeople().get(i), XVal, YVal));
			else
				PCo.add(new PersonCoordinates(C.GetPeople().get(i), XVal, YVal));
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CityViewer CV =new CityViewer();
		frame.add(CV, BorderLayout.CENTER);
		frame.setVisible(true);
	}


	
}
