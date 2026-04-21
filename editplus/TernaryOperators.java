class TernaryOperators 
{
	public static void main(String[] args) 
	{
		int marks = 32;
		String res = (marks>=33) ? "pass" : "fail";  //Condition? true:false;
		System.out.println(res);
		char r = (marks>=33) ? 'P' : 'F';
		System.out.println(r);
		int result = (marks>=33) ? 1 : 0;
		System.out.println(result);
	}
}
