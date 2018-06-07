package projekt;

public class Lektionen {
	
	private String titel;
	private String beschreibung;
	private String hilfestellung;
	private String loesung;
	
	public Lektionen(String titel, String beschreibung, String hilfestellung, String loesung) {
		
		this.titel = titel;
		this.beschreibung = beschreibung;
		this.hilfestellung = hilfestellung;
		this.loesung = loesung;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public String getHilfestellung() {
		return hilfestellung;
	}

	public void setHilfestellung(String hilfestellung) {
		this.hilfestellung = hilfestellung;
	}

	public String getLoesung() {
		return loesung;
	}

	public void setLoesung(String loesung) {
		this.loesung = loesung;
	}
	
	public String toString() {

		return "["+ titel +"]";
	}

}
