package learnRefactoringExample.Step4;

import java.util.Enumeration;

import learnRefactoringExample.FirstExample.Movie;

public class Rentals {

	private Movie movie;
	private int daysRented;

	public Rentals(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return this.daysRented;
	}

	public Movie getMovie() {
		return this.movie;
	}

	// Moving the method to Rental as the method uses Rentals as parameter 
	public static double findAmount(Rentals aRentals) {
		double thisAmount=0;
		switch (aRentals.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (aRentals.getDaysRented() > 2)
				thisAmount += (aRentals.getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			thisAmount += aRentals.getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (aRentals.getDaysRented() > 3)
				thisAmount += (aRentals.getDaysRented() - 3) * 1.5;
			break;
		}
		return thisAmount;
	}
	
	public static int findReEntryPoints(Rentals aRentals) {
		if ((aRentals.getMovie().getPriceCode() == Movie.NEW_RELEASE) && aRentals.getDaysRented() > 1) {
			return 2;
		} else return 1;
	}
	
	

	
}
