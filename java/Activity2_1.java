package JavaActivity2;

/*Create an abstract class Book that has:
title of type String
an abstract method setTitle() that takes one String argument.
a concrete method getTitle() that returns the value of title.
Create another class that extends the abstract class called MyBook.
MyBook defines the setTitle() method to assign the value of title as the argument.
In the main method, create an object of MyBook class - newNovel.
Use the setTitle() method to book title to the variable title.
Use the getTitle() method to print the name of the book
*/
//Abstract class
abstract class Book {
  String title;
  //Abstract method
  abstract void setTitle(String s);
  
  //Concrete method
  String getTitle() {
      return title;
  }
}

class MyBook extends Book {
  //Define abstract method
  public void setTitle(String s) {
      title = s;
  }
}

public class Activity2_1 {
  
  public static void main(String []args) {
      //Initialize title of the book
      String title = "Hover Car Racer";
      //Create object for MyBook
      Book newNovel = new MyBook();
      //Set title
      newNovel.setTitle(title);
      
      //Print result
      System.out.println("The title is: " + newNovel.getTitle());
  }
}