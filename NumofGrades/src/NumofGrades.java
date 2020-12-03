/*
 * Author: Toan Huynh
 * Project: GradeCalculator
 * Summary: A simple grades calculator that...
 * 			calculate the average, highest, and median grades
 * 			from a list of inputed grades.
 */
import java.util.Scanner;
public class NumofGrades
{	
	//public static void start() {}
	static Scanner keybrd = new Scanner(System.in);
	public static void main(String[] args)
	{		
		/*
		 * Initialization of variables.
		 */
		int[] grades;
		double avergGrade = 0;
		int total = 0;
		int highest = 0;
		double median = 0;
		int numOfGrades = 0;
		
		/*
		 * Ask user for input,
		 * validate input,
		 * and ask for new input if invalid.
		 */
		System.out.print("How many grades are there to calculate: ");
		String input = keybrd.next();
		if (!inputCheck(input)) {
			System.out.println("Invalid entry, please try again!");
			NumofGrades.main(args);
		}
		else {
			numOfGrades = Integer.parseInt(input);
		}
		
		System.out.println("");
		if (numOfGrades <= 0)
		{
			/*
			 * if there are no grade,
			 * there is no need to calculate.
			 */
			System.out.println("There were no grade to calculate! Restart?");
			System.out.println("Yes - Y");
			System.out.println("Exit - Anything else");
			input = keybrd.next();
			
			if (input.equalsIgnoreCase("y")) {
				NumofGrades.main(args);
			}
			else {
				System.exit(0);
			}

		}
		else
		{
			grades = new int[numOfGrades];
			
			for(int i = 0; i < numOfGrades; i++)
			{
				System.out.print("Please enter a grade between 0 and 100: ");
				//check input.
				grades[i] = gradeInputs();	
			}
			
			//calculate the average.
			for(int element: grades)
			{
				avergGrade = avergGrade + element;
			}
			avergGrade = avergGrade/numOfGrades;
			
			//Display all grades.
			System.out.println("\nThese are the grades to be calculated:");
			for (int i = 0; i < numOfGrades; i++) {
				if (i == grades.length - 1) {
					System.out.println(grades[i] + ".");
				}
				else {
					System.out.print(grades[i] + ", ");
				}
			}
			
			//Calculate the highest grades.
			for (int element: grades) {
				if (highest <= element) {
					highest = element;
				}
			}
			
			//Calculate the Median of the grades.
			if (numOfGrades % 2 == 0) {
				int sumOfMiddle = grades[numOfGrades/2] + grades[numOfGrades/ 2 - 1];
				median = ((double) sumOfMiddle) / 2;
			}
			else {
				median = (double) grades[grades.length / 2];
			}
			
			System.out.println("\nThe Highest grade is: " + highest);
			System.out.println("The Median of the grades is: " + median);
			System.out.println("The Average grade is: " + avergGrade + "\n");
			System.out.println("The grades above the average grade are:");
			
			//Display all grades above the average.
			for(int element: grades)
			{
				if(element > avergGrade)
				{
					System.out.println(element);
					total++;
				}
			}
			System.out.println("for a total of " + total + "\n");
			
			System.out.println("Calculations Finished! Restart?");
			System.out.println("Yes - Y");
			System.out.println("Exit - Anything else");
			input = keybrd.next();
			
			/*
			 * Restart program,
			 * else exit program.
			 */
			if (input.equalsIgnoreCase("y")) {
				NumofGrades.main(args);
			}
			else {
				System.exit(0);
			}
		}
	}
	
	/*
	 * Validate user input,
	 * must be a valid number,
	 * and within the range.
	 */
	public static int gradeInputs () {
		String in = keybrd.next();
		int grade = 0;
		if (!inputCheck(in)) {
			System.out.print("Invalid grade, please enter another grade: ");
			grade = gradeInputs();
		}
		else {
			grade = Integer.parseInt(in);
		}
		if(grade < 0 || grade > 100)
		{
			/*
			 * grades must be between 0 and 100.
			 */
			System.out.print("Invalid grade, please enter another grade: ");
			grade = gradeInputs();
		}
		return grade;
	}
	
	/*
	 * validate user input,
	 * must be a valid integer,
	 * throw exception if not.
	 */
	static boolean inputCheck(String input) {
        try
        {
            Integer.parseInt(input);
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
        return true;
	}
}