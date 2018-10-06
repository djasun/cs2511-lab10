package application;

import java.util.ArrayList;
import java.util.Iterator;

public class RentalBasket implements Rental {
	private ArrayList<Rental> components;
	public RentalBasket() {
		this.components = new ArrayList<>();
	}
	public double getCost() {
		double cost = 0;
		for (Rental c: this.components) {
			cost += c.getCost();
		}		
		return cost;
	}
	public void add(Rental r) {
		this.components.add(r);
	}
	public void remove(Rental r) {
		int index = this.components.indexOf(r);
		this.components.remove(index);
	}
	
	public ArrayList<Rental> getComponents(){
		return this.components;
	}
}
