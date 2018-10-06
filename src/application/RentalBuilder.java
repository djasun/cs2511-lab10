package application;

public class RentalBuilder {
	Rental rental;
	public RentalBuilder(Rental r) {
		rental = r;
	}
	public RentalBuilder addDiscount(double percent) {
		rental = new DiscountedRental(rental, percent);
		return this;
	}
	public RentalBuilder addSurcharge(double percent) {
		rental = new SurchargedRental(rental, percent);
		return this;
	}
	public Rental build() {
		return rental;
	}
}
