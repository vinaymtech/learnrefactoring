import static org.junit.Assert.assertEquals;
import org.junit.Test;
import learnRefactoringExample.FirstExample.Customer;
import learnRefactoringExample.FirstExample.Movie;
import learnRefactoringExample.FirstExample.Rentals;

public class RefactorTestingClass {
	@Test
	public void CustomerRentals() {
		Movie movie1 = new Movie("Transformers",2);
		Rentals rental1= new Rentals(movie1, 2);
		Movie movie2 = new Movie("Third Eye",2);
		Rentals rental2 = new Rentals(movie2,1);
		Customer customer= new Customer("Vinay");
		customer.addRental(rental1);
		customer.addRental(rental2);
		String result=customer.statement();
		assertEquals(result, "3.0");		
	}

}
