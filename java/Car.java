package JavaActivity1;

public class Car 
{
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
//Constructor
public Car() 
{
	tyres = 4;
	doors = 4;
}
	
	public void displayCharacteristics()
	{
		System.out.println("Color of the Car is " +color);
		System.out.println("The Make of the Car is " +make);
		System.out.println("Transmission of the Car is " +transmission);
		System.out.println("Number of tyres to Car " +tyres);
		System.out.println("Number of doors to Car " +tyres);
	}
	
	public void accelarate()
	{
		System.out.println("Car is moving forward.");
	}
			
	public void brake()
	{
		System.out.println("Car has stopped.");
	}
}
