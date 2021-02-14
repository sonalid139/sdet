package JavaActivity2;
/*
 Create a class named CustomException that extends the Exception class.
Add a private String variable named message that is going to be the exception message.
Add constructor that initializes the message variable with the custom String passed in.
Add an Override annotation for getMessage() that returns the custom message.
Now create the main class that contains the main function.

Add a method to this class called exceptionTest() that will throw the CustomException if the string value is null. Otherwise, it simply prints the string.
In the main method, call the exceptionTest() method with a non-null string and also a method call with a null argument.
In the catch block, add a print statement to print the custom error message
 */

class CustomException extends Exception {
    private String message = null;

    public CustomException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

public class Activity2_4 {
    public static void main(String[] a){
        try {
            Activity2_4.exceptionTest("Will print to console");
            Activity2_4.exceptionTest(null);
            Activity2_4.exceptionTest("Won't execute");
        } catch(CustomException mae) {
            System.out.println("Inside catch block: " + mae.getMessage());
        }
    }

    static void exceptionTest(String str) throws CustomException {
        if(str == null) {
            throw new CustomException("String value is null");
        } else {
            System.out.println(str);
        }
    }
}
