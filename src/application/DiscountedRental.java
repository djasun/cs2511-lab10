package application;

public class DiscountedRental implements Rental {
	private Rental rental;
	private double percent;
	public DiscountedRental(Rental r, double percent) {
		rental = r;
		this.percent = percent;
	}
	
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 0;
	}

}
