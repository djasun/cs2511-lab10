package application;

public class NewReleasePrice extends Price {

	@Override
	double getCharge(int daysRented){
		return daysRented * 3;
	}
	
	int getFrequentRenterPoints(int daysRented) {
		return (daysRented > 1) ? 2: 1;
	}

}
