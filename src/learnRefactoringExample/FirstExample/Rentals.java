package learnRefactoringExample.FirstExample;

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

}
