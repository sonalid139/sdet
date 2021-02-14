package JavaActivity3;
/*
 Create an ArrayList named myList of type String.
Add 5 names to the ArrayList using add() method.
Then print all the names using for loop.
Then use get() method to retrieve the 3rd name in the ArrayList.
Use contains() method to check if a name exists in the ArrayList.
Use size() method to print the number of names in the ArrayList.
Use remove() method to remove a name from the list and print the size() of the list again.
 */
import java.util.ArrayList;

public class Activity3_1 
{
	public static void main(String[] args) 
	{
		ArrayList<String> myList = new ArrayList<String>();
		int i;
		myList.add("Apple"); //added at index 0
		myList.add("Mango"); //added at index 1
		myList.add("Orange"); //added at index 2
		
		// add at specified index
		myList.add(2,"Grapes");// Grapes added at index 2, Orange will be pushed down
		myList.add(2,"Papaya"); // Papaya added at index 2, Grapes will be pushed down
		System.out.println("ArrayList is: ");
		for(i=0;i<myList.size();i++)
		{
			System.out.println(myList.get(i));
		}
		System.out.println("3rd name in the ArrayList is " +myList.get(2));
		System.out.println("Size of the ArrayList is " +myList.size());
		System.out.println("Is Mango in the ArrayList?- " +myList.contains("Mango"));
		System.out.println("Removing " +myList.get(1) +" from ArrayList");
		myList.remove(1);
		System.out.println("Is Mango in the ArrayList?- " +myList.contains("Mango"));
		System.out.print("New ArrayList " +myList);
		System.out.println("\nNew Size of the ArrayList is " +myList.size());
	}
}