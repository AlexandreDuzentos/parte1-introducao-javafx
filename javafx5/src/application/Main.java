package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	/*
	 *  Podemos desenhar a tela tanto no código java, instânciando
	 *  objetos ou a partir do FXML, ou seja, de um referência a ele
	 *  atribuída para um objeto de um tipo correspondente.
	 *  
	 *  BorderPane borderPane = new BorderPane() - usando código java
	 *  Parent parent = FXMLLoader.load(getClass().getResource("/gui/View.fxml")); - usando código FXML
	 *  
	 *  Um componente do tipo Parent, é o mais genérico na
	 *  hierárquia de componentes do javafx, o que significa que
	 *  ele pode receber a referência de qualquer documento FXML
	 *  que contenha qualquer objeto mais específico como componente
	 *  pai.
	 **/
	@Override
	public void start(Stage stage) { 
		try { 
			 AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/gui/View.fxml")); 
			 Scene scene = new Scene(anchorPane); 
			 stage.setScene(scene); 
			 stage.show(); 
		 } 
			catch (IOException e) { 
			 e.printStackTrace(); 
		 } 
	} 

	
	public static void main(String[] args) {
		launch(args);
	}
}
