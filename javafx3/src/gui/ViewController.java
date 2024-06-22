package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class ViewController {
    
	/* Os atributos que estarão declarados aqui serão correspondentes
	 * aos controles da tela, em outras palavras, aqui eu estou fazendo
	 * um mapeamento do meu controller para a minha view, ou seja, dizendo
	 * qual atributo corresponde ou é equivalente a qual controle da tela, é
	 * exatamente para isso que serve a annotation @FXML, para que esse
	 * atributo apareça no meu SceneBuilder.
	 * */
	@FXML
	private Button btTest; // atributo correspondente a um botão na view.
	
	/* Esse método é um eventHandler, responsável por tratar as intera
	 * ções do usuário com o controle visual identificado por btTest, os
	 * eventHandlers seguem um padrão de escrita no javaFX, que é o seguinte,
	 * a palavra on + NomeDoControleVisual + NomeDoEvento, eles seguem
	 * o padrão de escrita studly case.
	 * 
	 * Todo controle possui um evento principal, no nosso caso, o tipo de
	 * evento principal de um controle do tipo Button é o Action, que 
	 * se refere ao evento do clique.
	 * 
	 * Esse método trata o evento do click no botão btnTest.
	 **/
	@FXML
	public void onBtnTestAction() {
		Alerts.showAlert("Alert title", null, "Hello", AlertType.ERROR);
	}
}
