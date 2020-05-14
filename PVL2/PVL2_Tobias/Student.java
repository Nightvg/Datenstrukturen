package PVL2_Tobias;

import java.util.ArrayList;

public class Student {
	private String preName;
	private String surName;
	private Integer matriculationNumber;
	private ArrayList<Cours> courses;
	
	public Student(String preName, String surName) 
	{
		this.matriculationNumber = null;
		this.preName = preName;
		this.surName = surName;
		this.courses = new ArrayList<Cours>();
	}
	
	public int getMatriculationNumber()
	{
		return this.matriculationNumber;
	}
	
	public String getStudent()
	{
		if(this.matriculationNumber == null) return null;
		String s = this.preName + "\n" + this.surName + "\n" + String.valueOf(this.matriculationNumber) + "\n";
		for(int i = 0; i < this.courses.size(); i++)
		{
			s += this.courses.get(i).getCours() + "\n";
		}
		
		return s;
	}
	
	public void setMatriclenumber(int matriculationNumber)
	{
		this.matriculationNumber = matriculationNumber;
	}
	
	public Cours updateCours(String courseID, boolean passed)
	{
		Cours tmp = this.hasCourse(courseID); 
		if(tmp == null)
		{
			tmp = new Cours(courseID);
			tmp.examCours(passed);
			this.courses.add(tmp);
			
			return tmp;
		}
		
		if(tmp.getPassed()) return tmp;
		
		tmp.examCours(passed);
		return tmp;
		
	}
	
	private Cours hasCourse(String courseID)
	{
		for(int i = 0; i < this.courses.size(); i++)
		{
			if(this.courses.get(i).getCourseID() == courseID) return this.courses.get(i);
		}
		
		return null;
	}
}
