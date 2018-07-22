import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentManager
	{

	private static LinkedList<Student> students = new LinkedList<>();

	public static void main(String[] args)
		{
		if (readFile("students.txt"))
			{
			displayMenu();
			switch (selectMenuOption())
				{
				case 1:
					{
					displayReportByMarks();
					break;
					}
				case 2:
					{
					displayReportByGrades();
					break;
					}
				case 5:
					{
					System.exit(0);
					break;
					}
				}
			}
		}

	private static void displayMenu()
		{
		System.out.println("Student Report System");
		System.out.println("---------------------");
		System.out.println("1) Display Student Marks");
		System.out.println("2) Display Student Grades");
		System.out.println("3) Add new Student");
		System.out.println("4) Remove Student");
		System.out.println("5) Exit");
		System.out.println("Please enter a number ");
		}

	private static int selectMenuOption()
		{
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
		}

	public static boolean readFile(String filename)
		{
		try {
			Scanner scanner = new Scanner(new File(filename));
			while (scanner.hasNextLine()) {
				String[] words = scanner.nextLine().split(",");
				int id = Integer.parseInt(words[0]);
				String firstName = words[1];
				String lastName = words[2];
				int mathMark1 = Integer.parseInt(words[3]);
				int mathMark2 = Integer.parseInt(words[4]);
				int mathMark3 = Integer.parseInt(words[5]);
				int englishMark1 = Integer.parseInt(words[6]);
				int englishMark2 = Integer.parseInt(words[7]);
				int englishMark3 = Integer.parseInt(words[8]);
				addStudent(id, firstName, lastName, mathMark1, mathMark2, mathMark3, englishMark1, englishMark2, englishMark3);
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Failed to read file");
		}
		return true;
		}

	private static void addStudent(int id, String firstName, String lastName, int mathsMark1, int mathsMark2, int mathsMark3, int englishMark1, int englishMark2,
											 int englishMark3)
		{
		students.add(new Student(id, firstName, lastName, mathsMark1, mathsMark2, mathsMark3, englishMark1, englishMark2, englishMark3));
		}

	private static void addNewStudent()
		{

		}

	private static void removeStudent()
		{

		}

	private static void displayReportByMarks()
		{
		System.out.println("Name           Course    A1  A2  A3");
		for (Student student : students) {
			System.out.println(String.format("%-15s%-10s%-4d%-4d%-4d",
					student.getFullName(),
					student.getMathsMarks().getCourseName(),
					student.getMathsMarks().getMark(1),
					student.getMathsMarks().getMark(2),
					student.getMathsMarks().getMark(3)

			));
			System.out.println(String.format("%-15s%-10s%-4d%-4d%-4d",
					student.getFullName(),
					student.getEnglishMarks().getCourseName(),
					student.getEnglishMarks().getMark(1),
					student.getEnglishMarks().getMark(2),
					student.getEnglishMarks().getMark(3)

			));
		}
		}

	private static void displayReportByGrades()
		{
		System.out.println("Name           Course    A1  A2  A3");
		for (Student student : students)
			{
			System.out.println(String.format("%-15s%-10s%-4s%-4s%-4s",
					student.getFullName(),
					student.getMathsMarks().getCourseName(),
					student.getMathsMarks().getGrade(1),
					student.getMathsMarks().getGrade(2),
					student.getMathsMarks().getGrade(3)));
			System.out.println(String.format("%-15s%-10s%-4s%-4s%-4s",
					student.getFullName(),
					student.getEnglishMarks().getCourseName(),
					student.getEnglishMarks().getGrade(1),
					student.getEnglishMarks().getGrade(2),
					student.getEnglishMarks().getGrade(3)

			));
		}}
	}
