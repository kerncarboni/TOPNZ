import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentManager
	{

	private static LinkedList<Student> students = new LinkedList<>();

	public static void main(String[] args)
		{
		int menuOption;
		if (readFile("students.txt"))
			{
			do
				{
				displayMenu();
				menuOption = selectMenuOption();
				switch (menuOption)
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
					case 3:
						{
						addNewStudent();
						break;
						}
					case 4:
						{
						removeStudent(1);
						break;
						}
					case 5:
						{
						System.exit(0);
						break;
						}
					}
				}
			while (menuOption != 5);
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
		int option;

		do
			{
			System.out.println("Select an option between 1 and 5: ");
			option = scanner.nextInt();
			}
		while(option < 1 || option > 5);

		return option;
		}

	public static boolean readFile(String filename)
		{
		try
			{
			Scanner scanner = new Scanner(new File(filename));
			while (scanner.hasNextLine())
				{
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
		catch (FileNotFoundException e)
			{
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
		Scanner scanner = new Scanner(System.in);
		int id, mathsMark1, mathsMark2, mathsMark3, englishMark1, englishMark2, englishMark3;
		String firstName, lastName;
		System.out.println("Please enter the students id: ");
		id = scanner.nextInt();
		System.out.println("Please enter the students first name: ");
		firstName = scanner.next();
		System.out.println("Please enter the students last name: ");
		lastName = scanner.next();
		System.out.println("Please enter the students Maths Mark 1: ");
		mathsMark1 = scanner.nextInt();
		System.out.println("Please enter the students Maths Mark 2: ");
		mathsMark2 = scanner.nextInt();
		System.out.println("Please enter the students Maths Mark 3: ");
		mathsMark3 = scanner.nextInt();
		System.out.println("Please enter the students English Mark 1: ");
		englishMark1 = scanner.nextInt();
		System.out.println("Please enter the students English Mark 2: ");
		englishMark2 = scanner.nextInt();
		System.out.println("Please enter the students English Mark 3: ");
		englishMark3 = scanner.nextInt();
		addStudent(id, firstName, lastName, mathsMark1,mathsMark2,mathsMark3, englishMark1, englishMark2, englishMark3);
		}

	private static void removeStudent(int id)
		{
		if(id <= students.size())
			students.remove(id);
		}

	private static void displayReportByMarks()
		{
		System.out.println("Name           Course    A1  A2  A3  Grade");
		System.out.println("------------------------------------------");
		for (Student student : students)
			{
			System.out.println(String.format("%-15s%-10s%-4d%-4d%-4d%-4d",
					student.getFullName(),
					student.getMathsMarks().getCourseName(),
					student.getMathsMarks().getMark(1),
					student.getMathsMarks().getMark(2),
					student.getMathsMarks().getMark(3),
					student.getMathsMarks().getAverageMark()


			));
			System.out.println(String.format("%-15s%-10s%-4d%-4d%-4d%-4d",
					"",
					student.getEnglishMarks().getCourseName(),
					student.getEnglishMarks().getMark(1),
					student.getEnglishMarks().getMark(2),
					student.getEnglishMarks().getMark(3),
					student.getMathsMarks().getAverageMark()

			));
			}
		}

	private static void displayReportByGrades()
		{
		System.out.println("Name           Course    A1  A2  A3  Grade");
		System.out.println("------------------------------------------");
		for (Student student : students)
			{
			System.out.println(String.format("%-15s%-10s%-4s%-4s%-4s%-4s",
					student.getFullName(),
					student.getMathsMarks().getCourseName(),
					student.getMathsMarks().getGrade(1),
					student.getMathsMarks().getGrade(2),
					student.getMathsMarks().getGrade(3),
					student.getEnglishMarks().getAverageGrade()
					));
			System.out.println(String.format("%-15s%-10s%-4s%-4s%-4s%-4s",
					"",
					student.getEnglishMarks().getCourseName(),
					student.getEnglishMarks().getGrade(1),
					student.getEnglishMarks().getGrade(2),
					student.getEnglishMarks().getGrade(3),
					student.getEnglishMarks().getAverageGrade()
			));
		}}
	}
