public class AssignmentMarks
	{
	private String courseName;
	private int mark1;
	private int mark2;
	private int mark3;

	public AssignmentMarks(String courseName, int mark1, int mark2, int mark3)
		{
		setCourseName(courseName);
		setMark(1, mark1);
		setMark(2, mark2);
		setMark(3, mark3);
		}

	public String getCourseName()
		{
		return courseName;
		}

	public void setCourseName(String courseName)
		{
		this.courseName = courseName;
		}

	public int getMark(int assignmentNumber)
		{
		int mark = 0;
		switch (assignmentNumber) {
			case 1:
				mark = mark1;
				break;
			case 2:
				mark = mark2;
				break;
			case 3:
				mark = mark3;
		}
		return mark;
		}

	public void setMark(int assignmentNumber, int mark)
		{
		switch (assignmentNumber) {
			case 1:
				mark1 = mark;
				break;
			case 2:
				mark2 = mark;
				break;
			case 3:
				mark3 = mark;
		}
		}

	public int getAverageMark()
		{
		return (mark1 + mark2 + mark3) / 3;
		}

	public String getAverageGrade()
		{
		return markToGrade(getAverageMark());
		}

	private String markToGrade(int mark)
		{
		String grade;
		if(mark <= 100 && mark >= 95)
			{
			grade = "A+";
			}
		else if(mark <= 94 && mark >= 90)
			{
			grade = "A";
			}
		else if(mark <= 89 && mark >= 85)
			{
			grade = "A-";
			}
		else if(mark <= 84 && mark >= 80)
			{
			grade = "B+";
			}
		else if(mark <= 79 && mark >= 75)
			{
			grade = "B";
			}
		else if(mark <= 74 && mark >= 70)
			{
			grade = "B-";
			}
		else if(mark <= 69 && mark >= 60)
			{
			grade = "C+";
			}
		else if(mark <= 59 && mark >= 50)
			{
			grade = "C";
			}
		else if(mark <= 49 && mark >= 40)
			{
			grade = "C-";
			}
			else
				grade = "D";
		return grade;
		}

	public String getGrade(int assignmentNumber)
		{
		return markToGrade(getMark(assignmentNumber));
		}
	}
