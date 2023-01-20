
import java.io.FileWriter;
import java.io.IOException; // Import the IOException class to handle errors
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
	
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		try {
			FileWriter myWriter = new FileWriter("/Users/Marina/eclipse-workspace/W2BE/Progetto2/dati.txt");
			myWriter.write("lets go!");
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		

		List<Catalogo> catalogo = new ArrayList<>() {
			{
				add(new Libri(18988981, "Il Conte di Montecristo", LocalDate.of(1815, 3, 3), 340, "Alexandre Dumas",
						"storico"));
				add(new Riviste(18988982, "Mag44", LocalDate.of(2022, 3, 4), 30, Period.SETTIMANALE));
				add(new Libri(18988983, "Alla ricerca del tempo perduto", LocalDate.of(1920, 3, 4), 3724,
						"Marcel Proust", "filosofico"));
			}
		};
		
		int num = -1;
		
		do {
			System.out.println("*************************************************************************************************");
			System.out.println("Seleziona l'azione che vuoi svolgere (0 annulla la richiesta):");
			System.out.println("1 > Aggiungi Libro al catalogo");
			System.out.println("2 > Aggiungi Rivista al catalogo");
			System.out.println("3 > Trova Elemento nel catalogo inserendo il codice ISBN");
			System.out.println("4 > Trova Elemento nel catalogo inserendo Data di Pubblicazione");
			System.out.println("5 > Trova Libro nel catalogo inserendo il nome dell'Autore");
			System.out.println("6 > Rimuovi Elemento dal catalogo inserendo il codice ISBN");
			System.out.println("7 > Stampa catalogo");
			try {
				num = in.nextInt();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			switch (num) {
				case 1:
					addBook(catalogo); //libro
				break;
				case 2:
					addMag(catalogo); //rivista
				break;
				case 3:
					findItemByCode(catalogo);
				break;
				case 4:
					findItemByDate(catalogo);
				break;
				case 5:
					findItemByAuthor(catalogo);
				break;
				case 6:
					removeItemByCode(catalogo);
					break;
				case 7:
					System.out.println("----------------------------- Catalogo ------------------------------");
					System.out.println(catalogo);
					System.out.println();
					break;
				case 0:
					System.out.println("RICHIESTA INTERROTTA");
					break;
				default:
					System.out.println("Attenzione - inserisci un numero corretto!");
			}
		}while(num != 0);
		
	}

	public static void addBook(List<Catalogo> list) {
		System.out.println("Inserisci titolo libro:");
		String titolo = in.next();
		System.out.println("Inserisci anno di uscita:");
		int year = in.nextInt();
		System.out.println("Inserisci mese di uscita:");
		int month = in.nextInt();
		System.out.println("Inserisci giorno di uscita:");
		int day = in.nextInt();
		System.out.println("Inserisci numero di pagine:");
		int pag = in.nextInt();
		System.out.println("Inserisci autore libro:");
		String autore = in.next();
		System.out.println("Inserisci genere libro:");
		String genere = in.next();
		list.add(new Libri(0, titolo, LocalDate.of(year, month, day), pag, autore, genere));
		System.out.println("----------------------------- Catalogo con Aggiunta ------------------------------");
		System.out.println(list);
		System.out.println();
		modifyDati(list);
	}
	
	public static void addMag(List<Catalogo> list) {
		System.out.println("Inserisci titolo rivista:");
		String titolo = in.next();
		System.out.println("Inserisci anno di pubblicazione:");
		int year = in.nextInt();
		System.out.println("Inserisci mese di pubblicazione:");
		int month = in.nextInt();
		System.out.println("Inserisci giorno di pubblicazione:");
		int day = in.nextInt();
		System.out.println("Inserisci numero di pagine:");
		int pag = in.nextInt();
		System.out.println("Inserisci periodicità della rivista: \n 1.settimanale \n 2.mensile \n 3.semestrale");
		int period = in.nextInt();
		list.add(new Riviste(18988984, titolo, LocalDate.of(year, month, day), pag, period(period)));
		System.out.println("----------------------------- Catalogo con Aggiunta ------------------------------");
		System.out.println(list);
		System.out.println();
		modifyDati(list);
	}
	
	public static Period period(int period) {
		switch(period) {
		case 1:
			return Period.SETTIMANALE;

		case 2:
			return Period.MENSILE;

		case 3:
			return Period.SEMESTRALE;

			default:
				System.out.println("Ridigita");
		}
		return null;
	}

	public static void removeItemByCode(List<Catalogo> list) {
		for (int i = 0; i<list.size(); i++) {
			if(list.get(i) != null && list.get(i).getCod() == 18988983) {
				list.remove(i);
			}
		};
		System.out.println("----------------------------- Catalogo con Rimozione ------------------------------");
		System.out.println(list);
		System.out.println();
		modifyDati(list);
	}

	public static void findItemByCode(List<Catalogo> list) {
		Stream<Catalogo> stream = list.stream().filter((p) -> p.getCod() == 18988982);
		System.out.println("----------------------------- Cerca elemento con ISBN ------------------------------");
		if(stream.findAny().isPresent()) {
			stream.forEach(p -> System.out.println(p));
			System.out.println();
		}else {
			System.out.println("L'elemento cercato non esiste!");
			System.out.println();
		}
	}

	public static void findItemByDate(List<Catalogo> list) {
		Stream<Catalogo> stream = list.stream().filter((p) -> p.getDate() == LocalDate.of(9999,3,4));
		System.out.println("----------------------------- Cerca elemento con Data ------------------------------");
		if(stream.findAny().isPresent()) {
			stream.forEach(p -> System.out.println(p));
			System.out.println();
		}else {
			System.out.println("L'elemento cercato non esiste!");
			System.out.println();
		}
	}

	public static void findItemByAuthor(List<Catalogo> list) {
		Stream<Catalogo> stream = list.stream().filter((p) -> p.getClass() == Libri.class).filter(p-> ((Libri) p).getAutore() == "Dumas");
		System.out.println("----------------------------- Cerca elemento per Autore ------------------------------");
		if(stream.findAny().isPresent()) {
			stream.forEach(p -> System.out.println(p));
			System.out.println();
		}else {
			System.out.println("L'elemento cercato non esiste!");
			System.out.println();
		}
	}

	public static void modifyDati( List<Catalogo> list) {
		try {
			FileWriter myWriter = new FileWriter("/Users/Marina/eclipse-workspace/W2BE/Progetto2/dati.txt");
			myWriter.write(list.toString());
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
//	public static void removeDati(List<Catalogo> list) {
//		try {
//			FileWriter myWriter = new FileWriter("/Users/Marina/eclipse-workspace/W2BE/Progetto2/dati.txt");
//			myWriter.write(list.toString());
//			myWriter.close();
//		} catch (IOException e) {
//			System.out.println("An error occurred.");
//			e.printStackTrace();
//		}
//	}

}
