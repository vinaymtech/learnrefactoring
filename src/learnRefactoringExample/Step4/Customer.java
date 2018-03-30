package learnRefactoringExample.Step4;
import java.util.Enumeration;
import java.util.Vector;

import learnRefactoringExample.FirstExample.Movie;
import learnRefactoringExample.Step4.Rentals;

public class Customer {

	private static String name;
	private static Vector rentals = new Vector();

	public Customer (String name){
		this.name = name;
	}

	public static void addRental(Rentals arg) {
		rentals.addElement(arg);
	}

	public  static String getName (){
		return name;
	}


	// removing the variable thisAmount which is used once in loop and not modified
	public static String statement() {
		Enumeration rentalsEnum = ((Vector) rentals).elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentalsEnum.hasMoreElements()) {
			Rentals each =(Rentals) rentalsEnum.nextElement();
			result += "\t" + each.getMovie().getTitle()+ "\t" +
					String.valueOf(Rentals.findAmount(each)) + "\n";			
		}
		result = String.valueOf(findFinalAmount());
		return result;
	}
	
	public static double findFinalAmount() {
		double result = 0;
		Enumeration rentals = ((Vector) Customer.rentals).elements();
		while (rentals.hasMoreElements()) {
		Rentals each = (Rentals) rentals.nextElement();
		result += Rentals.findAmount(each);
		}
		return result;
	}
	
	public static int findAllReEntry(Rentals aRentals) {
		int points=0;
		if ((aRentals.getMovie().getPriceCode() == Movie.NEW_RELEASE) && aRentals.getDaysRented() > 1) {
			points=points + 2;
		} else points = points + 1;
		return points;
	}
	
	
	public static void main(String[] args) {
		
		Movie movie1 = new Movie("Transformers",1);
		Rentals rental1= new Rentals(movie1, 2);
		
		Movie movie2 = new Movie("Third Eye",2);
		Rentals rental2 = new Rentals(movie2,1);
		
		Customer customer = new Customer("Vinay");
		customer.addRental(rental1);
		customer.addRental(rental2);
		String result = customer.statement();
		System.out.println(result);
	}

}
