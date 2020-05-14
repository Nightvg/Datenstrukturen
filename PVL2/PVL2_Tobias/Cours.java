package PVL2_Tobias;

public class Cours {
	private boolean passed;
	private int tries;
	private String courseID;
	
	public Cours(String courseID)
	{
		this.passed = false;
		this.tries = 0;
		this.courseID = courseID;
	}
	
	public String getCourseID()
	{
		return this.courseID;
	}
	
	public boolean getPassed()
	{
		return this.passed;
	}
	
	public int getTries()
	{
		return this.tries;
	}
	
	public String getCours()
	{
		return this.courseID + "\t" + String.valueOf(this.tries) + "\t" + String.valueOf(this.passed);
	}
	
	public void examCours(boolean passed)
	{
		this.tries++;
		this.passed = passed;
	}
}
