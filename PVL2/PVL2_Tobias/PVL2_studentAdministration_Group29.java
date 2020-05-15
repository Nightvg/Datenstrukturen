package PVL2_Tobias;

import java.util.ArrayList;

public class PVL2_studentAdministration_Group29 implements StudentAdministration
{
	private ArrayList<Student> students;
	
	private boolean matricleExists(int matriculationNumber)
	{
		if(matriculationNumber < 1 || matriculationNumber > 999) return false;
		for(int i = 0; i < this.students.size();i++)
		{
			if(this.students.get(i).getMatriculationNumber() == matriculationNumber) return true;
		}
		
		return false;
	}
	
	private Student binarySearch(Integer matriculationNumber)
	{
		if(matriculationNumber == null) return null;
		int top = this.students.size() - 1, bot = 0;
		
		do
		{
			if(this.students.get((int) ((top + bot) / 2)).getMatriculationNumber()  == matriculationNumber) 
			{
				return this.students.get((int) ((top + bot) / 2));
			}
			if(this.students.get((int) ((top + bot) / 2)).getMatriculationNumber() > matriculationNumber)
			{
				top = (int) ((top + bot) / 2);
			}
			else bot = (int) ((top + bot) / 2); 
				
		} while(top > bot && top - bot != 1);
		
		if(this.students.get(top).getMatriculationNumber() == matriculationNumber)
		{
			return this.students.get(top);
		}
		if(this.students.get(bot).getMatriculationNumber() == matriculationNumber)
		{
			return this.students.get(bot);
		}
		
		return null;
	}
	
	public PVL2_studentAdministration_Group29()
	{
		this.students = new ArrayList<Student>();
	}
	
	public Integer matriculate(String firstName, String lastName)
	{
		if(firstName == null || lastName == null) return null;
		if(this.students.size() >= 999) return -1;
		Student s = new Student(firstName, lastName);
		if(this.students.size() == 0)
		{
			s.setMatriclenumber(1);
			this.students.add(0, s);
			return 1;
		}
		
		if(this.students.get(this.students.size() - 1).getMatriculationNumber() > this.students.size())
		{
			for(int i = 0; i < this.students.size(); i++)
			{
				if(i + 1 != this.students.get(i).getMatriculationNumber())
				{
					s.setMatriclenumber(i + 1);
					this.students.add(i, s);
					return i + 1;
				}
			}
		}

		s.setMatriclenumber(this.students.size() + 1);
		this.students.add(s);
		return s.getMatriculationNumber();
	}
	
	public Boolean deregister(Integer matriculationNumber)
	{
		if(matriculationNumber == null) return null;
		if(!this.matricleExists(matriculationNumber)) return false;
		for(int i = 0; i < this.students.size(); i++)
		{
			if(this.students.get(i).getMatriculationNumber() == matriculationNumber)
			{
				this.students.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public String find(Integer matriculationNumber)
	{
		if(matriculationNumber == null || matriculationNumber < 1 || matriculationNumber > 999) return null;
		Student tmp = this.binarySearch(matriculationNumber);
		if(tmp == null) return null;
		return tmp.getStudent();
	}
	
	public String takeExam(Integer matriculationNumber, String courseID, Boolean passed)
	{
		if(matriculationNumber == null || courseID == null || passed == null) return null;
		if(!this.matricleExists(matriculationNumber)) return "";
		
		Student tmp = this.binarySearch(matriculationNumber);
		Cours c = tmp.updateCours(courseID, passed);
		if(c.getTries() >= 3 && !c.getPassed())
		{			
			this.deregister(matriculationNumber);
		}
		
		return c.getCours();
	}
	
	public String dataBase()
	{
		String s = "";
		for(int i = 0; i < this.students.size(); i++)
		{
			s += this.students.get(i).getStudent() + "\n\n";
		}
		
		return s;
	}
}
