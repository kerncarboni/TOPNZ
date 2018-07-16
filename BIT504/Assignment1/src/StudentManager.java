import java.util.Scanner;

public class StudentManager
	{
	public static void main(String[] args)
		{
		while (selectMenuOption() != 5)
			{
			displayMenu();
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


		}

	private static int selectMenuOption()
		{
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
		}
	}
