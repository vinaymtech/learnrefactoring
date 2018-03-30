package learnRefactoringExample.Step1;
import java.util.Enumeration;
import java.util.Vector;

import learnRefactoringExample.FirstExample.Movie;
import learnRefactoringExample.FirstExample.Rentals;

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


	public static String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentalsEnum = ((Vector) rentals).elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentalsEnum.hasMoreElements()) {
			double thisAmount = 0;
			Rentals each =(Rentals) rentalsEnum.nextElement();
			totalAmount+=findAmount(each);
			frequentRenterPoints ++;
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&&
					each.getDaysRented() > 1) frequentRenterPoints ++;
			result += "\t" + each.getMovie().getTitle()+ "\t" +
					String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
//		result += "Amount owed is " + String.valueOf(totalAmount) +
//				"\n";
//		result += "You earned " + String.valueOf(frequentRenterPoints)
//		+
//		" frequent renter points";
		result = String.valueOf(totalAmount) ;
		return result;
	}
	
	// Refactored switch into one more method
	public static double findAmount(Rentals each) {
		double thisAmount=0;
		switch (each.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (each.getDaysRented() > 2)
				thisAmount += (each.getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			thisAmount += each.getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (each.getDaysRented() > 3)
				thisAmount += (each.getDaysRented() - 3) * 1.5;
			break;
		}
		return thisAmount;
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
