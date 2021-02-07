package JavaActivity1;
import java.util.*;


//Initialize an array with numbers in random order
//Use the insertion sort logic to sort the array in ascending order.
//Display the array before and after sorting

public class Activity1_4 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] data = { 9, 5, 1, 4, 3 };
		ascendingSort(data);
		System.out.println("Sorted Array in Ascending Order: ");
		System.out.println(Arrays.toString(data));
	}
    static void ascendingSort(int array[]) 
    {
        int size = array.length, i;
        
        for (i = 1; i < size; i++) 
        {
            int key = array[i];
            int j = i - 1;
            
            while (j >= 0 && key < array[j]) 
            {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    }		
}

