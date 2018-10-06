package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass extends Application {
	public static RentalBasket offering = new RentalBasket();
	public static RentalBasket cart = new RentalBasket();
	
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Window.fxml"));
		Parent root = loader.load();
		MainController controller = loader.<MainController>getController();
		
		Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());
		stage.setTitle("FXML Welcome");
		stage.setScene(scene);		
		stage.show();
	}
	
	public static void main(String[] args) {
		Price p = new RegularPrice();
		Movie m = new Movie("Return of Darth Maul", p);
		RentalItem r = new RentalItem(m, 5);
		MainClass.offering.add(r);
		
		p = new NewReleasePrice();
		m = new Movie("Movie2", p);
		r = new RentalItem(m, 20);
		MainClass.offering.add(r);
		
		launch(args);
	}
}
