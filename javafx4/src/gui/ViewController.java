package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController implements Initializable {
    
	/* Os atributos que estarão declarados aqui serão correspondentes
	 * aos controles da tela, em outras palavras, aqui eu estou fazendo
	 * um mapeamento do meu controller para a minha view, ou seja, dizendo
	 * qual atributo corresponde ou é equivalente a qual controle ou componente da tela, é
	 * exatamente para isso que serve a annotation @FXML, para que esses
	 * atributos apareça no meu SceneBuilder e possam ser associados com a tela.
	 * 
	 * Os componentes visuais são objetos no meu programa java.
	 * */
	
	// atributo correspondente a um TextField na view.
	@FXML
	private TextField txtNumber1;
	
	// atributo correspondente a um TextField na view.
	@FXML
	private TextField txtNumber2;

	// atributo correspondente a um Label na view.
	@FXML 
	private Label labelResult;
	
	// atributo correspondente a um botão na view.
	@FXML
	private Button btSum;
	
	/* Esse método é um eventHandler, responsável por tratar as intera
	 * ções do usuário com o controle visual identificado por btSum, os
	 * eventHandlers seguem um padrão de escrita no javaFX, que é o seguinte,
	 * a palavra on + NomeDoControleVisual + NomeDoEvento, eles seguem
	 * o padrão de escrita studly case.
	 * 
	 * Todo controle possui um evento principal, no nosso caso, o tipo de
	 * evento principal de um controle do tipo Button é o Action, que 
	 * se refere ao evento do clique.
	 * 
	 * Esse método trata o evento do click no botão btnSum.
	 **/
	@FXML
	public void onBtSumAction(Event event) {
		/*
		 * Essa configuração permite ao meu programa ler valores
		 * com pontos flutuantes usando o ponto(.) como separador
		 * de decimais.
		 * */
		
		try {
		Locale.setDefault(Locale.US);
		
		/* Em muitos casos, conversões podem lançar uma exceção */
		Double number1 = Double.parseDouble(txtNumber1.getText());
		Double number2 = Double.parseDouble(txtNumber2.getText());
		
		Double sum = number1 + number2;
		
        /* Retorna uma String formatada usando a string de
         * formatação especificada e argumentos.
         * */ 
		 labelResult.setText(String.format("%.2f", sum));
		
		} catch(NumberFormatException e) {
			Alerts.showAlert("Error", "parse error", e.getMessage(), AlertType.ERROR);
		}
	}

	/* Esse método é executado na hora que o nosso controller 
	 * é instânciado, então dentro dele terá ações que eu quero
	 * que sejam executadas na hora da instânciação do controlador.
	 * 
	 * O parâmetro url é o caminho até a sua tela, e o resourceBundle
	 * é uma série de recursos que você pode utilizar.
	 * */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldDouble(txtNumber1);
		Constraints.setTextFieldDouble(txtNumber2);
		Constraints.setTextFieldMaxLength(txtNumber1, 12);
		Constraints.setTextFieldMaxLength(txtNumber2, 12);
		
	}
}
