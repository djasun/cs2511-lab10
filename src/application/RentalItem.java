package application;

public class RentalItem implements Rental {
	private int _daysRented;
	private Movie _movie;
	
	public RentalItem(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}
	
	public double getCost() {
		return _movie.getPriceCode().getCharge(_daysRented);
	}

	public int getDaysRented() {
		return _daysRented;
	}
	
	public Movie getMovie() {
		return _movie;
	}

	double getCharge() {
		return _movie.getCharge(_daysRented);
	}

	int getFrequentRenterPoints() {
		
		 return _movie.getFrequentRenterPoints(_daysRented);
	}
	@Override
	public String toString() {
		return String.format("%s\t$%.2f \t%s", _movie.getTitle(),
				 _movie.getCharge(_daysRented),_movie.getPriceCode().getClass().getSimpleName());
	}
}
