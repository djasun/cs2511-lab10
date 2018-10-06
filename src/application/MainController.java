package application;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainController{
	@FXML
	private ListView<String> rentalOffering;
	@FXML
	private ListView<String> rentalInBasket;
	@FXML
	private TextField totalCost;
		
    @FXML
    public void initialize() {
    	ArrayList<Rental> offering = MainClass.offering.getComponents();
    	for (Rental r: offering) {
    		rentalOffering.getItems().add(r.toString());
    	}
    }
    
    @FXML
    public void addButtonPressed() {
    	int index = rentalOffering.getSelectionModel().getSelectedIndex();
    	String s = rentalOffering.getItems().get(index);
    	rentalOffering.getItems().remove(index);
    	rentalInBasket.getItems().add(s);
    	
    	ArrayList<Rental> offering = MainClass.offering.getComponents();
    	for (Rental r: offering) {
    		if (r.toString().equals(s)) {
    			MainClass.offering.remove(r);
    			MainClass.cart.add(r);
    			break;
    		}
    	}
    	updatePrice();
    }
    
    @FXML
    public void removeButtonPressed() {
    	int index = rentalInBasket.getSelectionModel().getSelectedIndex();
    	String s = rentalInBasket.getItems().get(index);
    	rentalInBasket.getItems().remove(index);
    	rentalOffering.getItems().add(s);
    	
    	ArrayList<Rental> cart = MainClass.cart.getComponents();
    	for (Rental r: cart) {
    		if (r.toString().equals(s)) {
    			MainClass.cart.remove(r);
    			MainClass.offering.add(r);
    			break;
    		}
    	}
    	updatePrice();
    }
    public void updatePrice() {
    	Double newCost = MainClass.cart.getCost();	
    	totalCost.setText(String.format("$%s", newCost.toString()));
    }
}
