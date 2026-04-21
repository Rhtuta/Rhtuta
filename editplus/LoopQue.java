class LoopQue 
{
	public static void main(String[] args) 
	{
		for(int i=1; i<=9; i++){
			if(i==2 || i==4 || i==6 || i==8){
				continue;
			}
			System.out.println("Hello world "+i);
		}
		
	    for(int i=1; i<=9; i+=2){
			System.out.println("Hello world "+i);
		}
		
		for(int i=1; i<=9; i++){
			if(i%2!=0){
			    System.out.println("Hello world "+i);	
			}
			
		}	
	}
}
