package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.CD;
import model.PortaCD;

public class PortaCDController {
	
	private static final String ERRORE_INPUT_INVALIDO = "input invalido";
	private static final String ERRORE_INSERIMENTO_VUOTO = "inserisci i dati per continuare";
	private static final String ERRORE_TROPPI_PORTACD = "non puoi creare troppi portacd (max 10)";
	private static final String ERRORE_LUNGHEZZA_INVALIDA = "lunghezza invalida";
	private static final String ERRORE_NOME_INVALIDO = "nome non valido";
	private static final String ERRORE_NON_TROVATO = "Non trovato";
	
	private static final int MAX_NUM_PORTACD = 10;
	
	@FXML private Button lunghezzaSubmitBtn; 
	@FXML private Label erroreLunghezza;
	@FXML private Label portaCdSelezionato;
	@FXML private Label stampaOutput;
	
	@FXML private TextField lunghezzaPortaCd;
	@FXML private TextField nomePortaCd;
	@FXML private TextField lunghezzaCdPortaCd;
	
	@FXML private TextField indiceTextField;
	@FXML private TextField titoloTextField;
	@FXML private ChoiceBox sceltaPortaCd;
	
	
	
	
	private PortaCD[] portaCD = new PortaCD[MAX_NUM_PORTACD];
	private PortaCD gestionePortaCd = new PortaCD();
	private int portaCdIndex;
	private int portaCdIndexInUso;
	private final int MAX_PORTACD = 10;
	
	
	public DatiInputUtente getDatiFromTextField() {
		String messaggio = "";
		int lunghezza = 0;
		int lunghezzaCd = 0;
		String nome;
		DatiInputUtente dati = null;
		try {
			
			lunghezza = Integer.parseInt(this.lunghezzaPortaCd.getText());
			nome = nomePortaCd.getText();
			dati = new DatiInputUtente(nome, lunghezza, lunghezzaCd);
		} catch(Exception exception) {
			messaggio = ERRORE_INPUT_INVALIDO;
		}
		erroreLunghezza.setText(messaggio);
		return dati;
	}
	
	@FXML
	public void creaPortaCd(MouseEvent event) {
		DatiInputUtente dati = getDatiFromTextField();
		String messaggio = "";
		if(portaCdIndex > MAX_PORTACD) {
			messaggio = ERRORE_TROPPI_PORTACD;
		} else if(dati == null) {
			messaggio = ERRORE_INSERIMENTO_VUOTO;
		} else if(dati.getLunghezza() <= 0){
			messaggio = ERRORE_LUNGHEZZA_INVALIDA;
		} else if(dati.getNome().isEmpty()) {
			messaggio = ERRORE_NOME_INVALIDO;
		} else { 
			// creo il porta cd
			portaCD[portaCdIndex] = new PortaCD(dati.getLunghezza(), dati.getNome());
			setPortaCdInUso(portaCdIndex);
			portaCdIndex++;
		}
		
		erroreLunghezza.setText(messaggio);
		
		
	}
	
	
	public void setPortaCdInUso(int indice) {
		this.portaCdIndexInUso = indice;
	}
	
	public int getPortaCdInUso() {
		return this.portaCdIndexInUso;
	}
	
	
	//metodo controller per restituire un cd dato l'indice
	@FXML
	public void restituireCdConIndice(MouseEvent event) {
		String messaggio = "";
		int indice = -1;
		try {
			indice = Integer.parseInt(indiceTextField.getText());
			if(indice == -1) {
				messaggio = ERRORE_INSERIMENTO_VUOTO;
			} else {
				CD cdDaTrovare = gestionePortaCd.getCd(indice);
				if(cdDaTrovare == null) {
					messaggio = ERRORE_NON_TROVATO;
				} else {
					stampaOutput.setText(cdDaTrovare.toString());
				}
			}
			
		} catch (NumberFormatException e) {
			messaggio = ERRORE_INPUT_INVALIDO;
		}
		
		erroreLunghezza.setText(messaggio);
		
		
	}
	
	//metodo controller per creare un cd dato indice
	@FXML
	public void creaCdConIndice(MouseEvent event) {
		
	}
	
	//metodo per eliminare un cd dato indice
	@FXML
	public void eliminaCdConIndice(MouseEvent event) {
		
	}
	
	//metodo per restituire tutti i cd
	@FXML
	public void restituireTuttiCd(MouseEvent event) {
		
	}
	
	//metodo per cercare cd dal titolo
	@FXML
	public void cercaCdTitolo(MouseEvent event) {
		
	}
	
	//metodo per confrontare i portacd con i titoli
	@FXML
	public void confrontaPortaCd(MouseEvent event) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
