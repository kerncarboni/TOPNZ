public class Student
	{
	private int id;
	private String firstName;
	private String lastName;
	private AssignmentMarks mathsMarks;
	private AssignmentMarks englishMarks;

	public Student(int id, String firstName, String lastName, int mathsMark1, int mathsMark2, int mathsMark3, int englishMark1, int englishMark2, int englishMark3)
		{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mathsMarks = new AssignmentMarks("Maths", mathsMark1, mathsMark2, mathsMark3);
		this.englishMarks = new AssignmentMarks("English", englishMark1, englishMark2, englishMark3);
		}

	public String getFullName()
		{
		return String.format("%s %s", firstName, lastName);
		}

	public AssignmentMarks getMathsMarks()
		{
		return mathsMarks;
		}

	public AssignmentMarks getEnglishMarks()
		{
		return englishMarks;
		}
	}
