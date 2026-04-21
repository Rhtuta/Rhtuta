import java.util.Scanner;
class homeworkTwo 
{
	public static void main(String[] args) 
	{
		//int[] arr = new int[3]; //for all possible pairs
		int[] arr = new int[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array elements: ");
		for(int i=0; i<arr.length; i++)
		{
			arr[i] = sc.nextInt();
		}
		/*int large = arr[0];
		int seclarge = arr[1];
		for (int i=0; i<arr.length ; i++ )
		{
			if (arr[i]>large)
			{
				seclarge = large;
				large = arr[i];
			}
			else if ((arr[i]<large && arr[i]>seclarge) || (seclarge==large && arr[i]<large))
			{
				seclarge = arr[i];
			}
			
		}
		System.out.println("largest element is: "+large);
		System.out.println("second largest element is: "+seclarge);
		int large = arr[0];
		int seclarge = arr[1];
		int index = 0;
		int secindex = 1;
		
        for(int i=1; i<arr.length; i++)
		{
			if(arr[i]>large)
			{	
				large = arr[i];
				index = i;
			}
		
			else if(arr[i]==large)
			{
				seclarge = arr[i];
				secindex = i;
			}
	     
		}
		    
				for(int i=0; i<arr.length; i++)
			  {		
				if ((arr[i]<large && arr[i]>seclarge) || (arr.length<=2 && arr[i]<large && large==seclarge))
			    {
				    seclarge = arr[i];
				    secindex = i;
				}
				
				
			  }	
			
			
		
		System.out.println("largest element is: "+large +" at index: "+index);
		System.out.println("second largest element is: "+seclarge +" at index: "+secindex);
		int even = 0;
		int odd = 0;
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i]%2==0)
				even++;
			else
				odd++;
		}
		System.out.println("Total no of even elements are: "+even);
		System.out.println("Total no of odd elements are: "+odd);
		
		for(int i=0; i<=arr.length/2; i++)
		{
			int temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		
		}
		
		int start = 0;
		int end = arr.length-1;
		while (start < end)
		{
			int temp = arr[start];
			arr[start ]= arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		for(int data:arr)
			System.out.println(data);
		
		
		System.out.println("All possible pairs");
		for(int i=0; i<arr.length; i++)
		{
			for(int j=i; j<arr.length; j++)// OR j = i+1
			{
				
				System.out.print(arr[i]+","+arr[j] +"  ,  " );
				
			}
		}
		
		System.out.println("-------------Check given array is palindrome------------");
		int start = 0;
		int end = arr.length-1;
		String isPalindrom = "Yes"; 
		while (start < end)
		{
			if (arr[start] != arr[end] )
			{
				isPalindrom = "Not";
			}
			start++;
			end--;
		}
		System.out.println(isPalindrom+ " : Palindrome Array");*/
		
		System.out.println("-------------Check frequency of each element of array------------");
		/*int freq = 0;
		int k=0;
		boolean isCounted = false;
		int[] alreadyCounted = new int[5];
		for(int i=0; i<arr.length; i++)
		{
		  for(int data:alreadyCounted)
		  {	
		   	  
		   if(arr[i]==data)	  
			   isCounted =true;
		  }
		  if(isCounted == false)
		  {  
			for(int j=0; j<arr.length; j++)
			{
				if (arr[i] == arr[j])
				{
					
					freq++;
					
				}
				
			}
		  
			System.out.println("frequency of " + arr[i] + " is " + freq);
			
			alreadyCounted[k] = arr[i];
			k++;
			freq = 0;
		  }	
		}*/
		
		int freq = 0;
		boolean isCounted;
		for(int i=0; i<arr.length; i++)
		{
			isCounted = false;
		  for(int k=0; k<i ; k++)
		  {	
		   	  
		   if(arr[i]==arr[k])	  
			   isCounted =true;
		  }
		  if(isCounted)
			  continue;
		  
			for(int j=0; j<arr.length; j++)
			{
				if (arr[i] == arr[j])
				{
					
					freq++;
					
				}
				
			}
		  
			System.out.println("frequency of " + arr[i] + " is " + freq);
			freq = 0;
		  
		}
		
		
		
		
	}
}
