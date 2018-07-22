public class AssignmentMarks
	{
	private String courseName;
	private int mark1;
	private int mark2;
	private int mark3;

	public AssignmentMarks(String courseName, int mark1, int mark2, int mark3)
		{
		this.courseName = courseName;
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
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
		switch (assignmentNumber)
			{
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
	}
