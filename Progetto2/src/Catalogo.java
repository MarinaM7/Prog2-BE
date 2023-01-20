import java.time.LocalDate;

public class Catalogo {
	
	private long code;
	private String titolo;
	private LocalDate date;
	private int num;
	
	public Catalogo(long code, String titolo, LocalDate date, int num) {
		this.setCod(code);
		this.setTitolo(titolo);
		this.setDate(date);
		this.setNum(num);
	}

	public long getCod() {
		return code;
	}

	public void setCod(long cod) {
		this.code = cod;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
