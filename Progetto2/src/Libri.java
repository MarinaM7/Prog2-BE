import java.time.LocalDate;

public class Libri extends Catalogo {
	
	private String autore;
	private String genere;

	public Libri(long cod, String titolo, LocalDate date, int num, String autore, String genere) {
		super(cod, titolo, date, num);
		this.setAutore(autore);
		this.setGenere(genere);
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	@Override
	public String toString() {
		return "\n Titolo libro: " + getTitolo() + " || Autore: " + getAutore() + " || Genere: " + getGenere() + " || Data pubblicazione: " + getDate();
	}
	

}
