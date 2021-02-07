package JavaActivity1;
import java.util.*;

//writing a program to check if the sum of all the 10's in the array is exactly 30. 
//The program returns false if the condition does not satisfy, otherwise returns true.

public class Activity1_2 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] intArray = {10, 77, 10, 54, -11, 10};
		int findnum=10,sum=30;
		
		System.out.println("Original Array is: " +Arrays.toString(intArray));
		System.out.println("Result: " + result (intArray, findnum, sum));
	}
	
	public static boolean result (int[] numbers, int findnum, int sum)
	{
		int tempsum=0;
		for (int i : numbers)
		{
			if(i==findnum)
			{
				tempsum=tempsum+findnum;
			}			
			
		}
		//Return true if condition satisfies
		if(tempsum==sum)
		{
			System.out.println("Sum of all numbers in an Array is: " +tempsum);
			return true;
		}
		else
		{
			System.out.println("Sum of all numbers in an Array is: " +tempsum);
			return false;	
		}
	}
	
	
}
