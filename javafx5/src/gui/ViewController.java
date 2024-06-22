package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import model.entities.Person;

public class ViewController implements Initializable {
    
	/* O controle ComboBox é um tipo genérico, ou seja,
	 * é parametrizado por tipo, na exibição dos items do 
	 * ComboBox ele por padrão usará o toString do objeto passado
	 * como parâmetro ele */
	@FXML
	private ComboBox<Person> comboBoxPerson;
	
	@FXML
	private Button btAll;
	
	/* ObservableList é um tipo especial de list do próprio
	 * javafx que já fica associado ao meu componente visual, então
	 * ele já implementa um comportamento de interação entre o componente
	 * visual que é o ComboBox e a minha coleção.
	 **/
	private ObservableList<Person> obsList; 
	
	/* O prefixo on é utilizado para padronizar as funções que são
	 * tratamento de eventos.
	 * 
	 * Método responsável por tratar o evento de seleção de um item
	 * do comboBox.
	 * */
	@FXML
	public void onComboBoxPersonAction() {
		/* Aqui estou obtendo o objeto correspondente ao item do ComboBox que foi selecionado */
		Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
		System.out.println(person.printFormatter(person));
	}
	
	/* Método responsável por tratar o evento do clique no controle btAll */
	@FXML
	public void onBtAllAction() {
		/* O método getItems pega os elementos de um ComboBox */
		for(Person person : comboBoxPerson.getItems()) {
			System.out.println(person);
		}
	}
	
	/* Esse método é executado quando o controller é instânciado */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		List<Person> list = new ArrayList<>();
		list.add(new Person(1, "maria", "maria@gmail.com"));
		list.add(new Person(2, "alex", "alex@gmail.com"));
		list.add(new Person(3, "bob", "bob@gmail.com"));
		
		
		/* Convertendo uma list comum(implementação ArrayList) para um ObservableList */
		obsList = FXCollections.observableArrayList(list);
		
		/* Aqui estou carregando o meu ObservableList no ComboBox */
		comboBoxPerson.setItems(obsList);
		
		/* Esse é um código muito específico para definir oque mostrar
		 * no ComboBox, código muito verboso e difícil de entender, em 
		 * vez disso mudo simplesmente o método toString, uma vez que a
		 * exibição dos items do ComboBox se baseia no método toString.
		 * */
		/*
		Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() { 
			 @Override
			 protected void updateItem(Person item, boolean empty) { 
			 super.updateItem(item, empty); 
			 setText(empty ? "" : item.getName()); 
			 } 
		}; 
		
		comboBoxPerson.setCellFactory(factory); 
		comboBoxPerson.setButtonCell(factory.call(null));
		*/ 
	}
	
	
	

	
}
