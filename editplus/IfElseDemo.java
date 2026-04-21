class IfElseDemo 
{
	public static void main(String[] args) 
	{
		int a = 4;
		System.out.println("bhai 10 de de");
		if(a>9)
		{
			System.out.println("chal bhai 10 le le");
			a = a - 10;
		}
		else if(a>=5)
		{
			System.out.println("bhai 10 nhi h mere pass");
			System.out.println("chal bhai 5 hi de de");
			if(a>4)
			{
				System.out.println("chal bhai 5 le le ");
				a = a - 5;
			}
			else
				System.out.println("bhai 5 nhi h mere pass");
		}
		else
			System.out.println("bhai pese hi nhi h mere pass");
			
	}
}
