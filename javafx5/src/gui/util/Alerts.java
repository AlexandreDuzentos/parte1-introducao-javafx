package gui.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/* Essa é uma classe utilitária da minha camada de visão */
public class Alerts {
   
	/* Método responsável por exibir um componente visual de alerta */
	public static void showAlert(String title, String header, String content, AlertType type) {
	   Alert alert = new Alert(type);
	   alert.setTitle(title);
	   alert.setHeaderText(header);
	   alert.setContentText(content);
	   alert.show();
	}
}
