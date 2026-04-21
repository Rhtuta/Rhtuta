import java.util.Scanner;
class SwitchDemo 
{
	public static void main(String[] args) 
	{
		System.out.println("Choice 1: English");
		System.out.println("Choice 2: Hindi");
		System.out.println("Choice 3: Math");
		System.out.println("Choice 4: Science");
		System.out.println("Choice 5: Social Science");
		
		System.out.println("Enter your Choice:- Ex:Choice 2  ");
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		
		switch(choice)
		{
			case "Choice 1": 
				System.out.println("English");
			    break;
			case "Choice 2": 
				System.out.println("Hindi");
			    break;
			case "Choice 3": 
				System.out.println("Math");
			    break;
			case "Choice 4": 
				System.out.println("Science");
			    break;
			case "Choice 5": 
				System.out.println("Social Science");
			    break;
			default:
				System.out.println("choice not exist");
				
			
		}
		
	}
}
