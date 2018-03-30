package learnRefactoringExample.Step3;
import java.util.Enumeration;
import java.util.Vector;

import learnRefactoringExample.FirstExample.Movie;
import learnRefactoringExample.Step3.Rentals;

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
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentalsEnum = ((Vector) rentals).elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentalsEnum.hasMoreElements()) {
			//double thisAmount = 0;
			Rentals each =(Rentals) rentalsEnum.nextElement();
			//thisAmount=Rentals.findAmount(each);
			frequentRenterPoints ++;
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) {
				frequentRenterPoints ++;
			}
			result += "\t" + each.getMovie().getTitle()+ "\t" +
					String.valueOf(Rentals.findAmount(each)) + "\n";
			totalAmount += Rentals.findAmount(each);
		}
		result = String.valueOf(totalAmount) ;
		return result;
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
