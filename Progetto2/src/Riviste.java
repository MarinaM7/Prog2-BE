import java.time.LocalDate;

public class Riviste extends Catalogo {

	private Enum<Period> period;
	
	public Riviste(long code, String titolo, LocalDate date, int num, Enum<Period> period) {
		super(code, titolo, date, num);
		this.setPeriod(period);
	}

	public Enum<Period> getPeriod() {
		return period;
	}

	public void setPeriod(Enum<Period> period) {
		this.period = period;
	}
	
	@Override
	public String toString() {
		return "\n Titolo rivista: " + getTitolo() + " || Periodicità: " + getPeriod() + " || Data pubblicazione: " + getDate();
	}
	
}
