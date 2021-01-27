package JavaActivity1;

public class Activity1 {

		public static void main(String[] args) {
		Car Toyota = new Car();
		Toyota.color= "Red";
		Toyota.make = 2020;
		Toyota.transmission="Manual";
		
		//Call methods
		Toyota.displayCharacteristics();
		Toyota.accelarate();
		Toyota.brake();
		
	}

}
