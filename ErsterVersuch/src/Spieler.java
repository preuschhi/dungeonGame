import java.util.Scanner;

public class Spieler {

	// Eigenschaften
	private String nameSpieler;
	private int lebenSpieler;
	Waffe waffeSpieler;
	Gegner gegner;
	CustomArray inventar[]; // In dieser Klasse werden Anzahl und Name von Gegenständen gespeichert
							// In diesem Fall "Heiltrank" & "Gold"

	// Konstruktor
	public Spieler(String nameSpieler, int lebenSpieler) {
		this.nameSpieler = nameSpieler;
		this.lebenSpieler = lebenSpieler;

	}

	// Methoden

	public void angriff(Spieler spielerID, CustomArray heiltrankID, CustomArray goldID) { // Über die IDs kann auf das
																							// Objekt zugreifen
																							// und damit arbeiten

		Gegner gegnerID = null;// Dort ist die Referenz zum zufällig erstellten gegner objekt gespereichert
		double spielerWaffeHaltbarkeitAbzug = 0; // Hier wird der Abzugswert für das Waffenobjekt des Spieler
													// gespeichert
		int goldFuerSpieler = 0; // Hier ist das Gold welches der Spieler mit nach erfolgreichen Fight bekommt
									// gespeichert

		// Hier kommt ein zufallsgenerator der entscheiden soll welcher gegner erstellt
		// wird
		int min = 1;
		int max = 3;
		int zufallsZahl = min + (int) (Math.random() * ((max - min) + 1));

		if (zufallsZahl == 1) { // Gegnerobjekt Olaf
			GegnerOlaf olaf = new GegnerOlaf();
			setGegner(olaf);
			spielerWaffeHaltbarkeitAbzug = olaf.spielerWaffeHaltbarkeitAbzug; // Um des Spielers Waffe die haltbarkeit
																				// zu
																				// vermindern
			goldFuerSpieler = olaf.goldFuerSpieler;// Hier ist das Gold welches der Spieler nach erfolgreichen Fight
													// bekommt gespeichert
			gegnerID = olaf; // Über diese ID greit man fast immer auf den Gegner zu

		} else if (zufallsZahl == 2) { // Gegnerobjekt Jürgen
			GegnerJürgen juergen = new GegnerJürgen();
			setGegner(juergen);
			spielerWaffeHaltbarkeitAbzug = juergen.spielerWaffeHaltbarkeitAbzug; // Um des Spielers Waffe die
																					// haltbarkeit
																					// zu vermindern
			goldFuerSpieler = juergen.goldFuerSpieler;// Hier ist das Gold welches der Spieler nach erfolgreichen Fight
														// bekommt gespeichert
			gegnerID = juergen; // Über diese ID greit man fast immer auf den Gegner zu

		} else if (zufallsZahl == 3) { // Gegnerobjekt Dieter
			GegnerDieter dieter = new GegnerDieter();
			setGegner(dieter);
			spielerWaffeHaltbarkeitAbzug = dieter.spielerWaffeHaltbarkeitAbzug; // Um des Spielers Waffe die haltbarkeit
																				// zu vermindern
			goldFuerSpieler = dieter.goldFuerSpieler;// Hier ist das Gold welches der Spieler nach erfolgreichen Fight
														// bekommt gespeichert
			gegnerID = dieter; // Über diese ID greit man fast immer auf den Gegner zu

		}

		// Hier wird der aktuelle Gegner ermittelt und dessen Stats herausgefunden

		System.out.println("=====================================\nDein aktueller Gegner: " + gegnerID.getName() + " hat " + gegnerID.getLeben() + " Leben.");
		System.out.println(gegnerID.getName() + " hat die Waffe " + gegnerID.getWaffe(gegnerID).nameWaffe
				+ ".\nSie hat diese Stats:\nSchaden:"
				+ gegnerID.getWaffe(gegnerID).schadenWaffe);

		// Hier läuft der eigentliche Angriff ab
		boolean angriff = true;
		/*
		 * Dieser boolean ist auf true wenn der Spieler angreifen will. Wenn der Spieler
		 * den Angriff abbricht wird sie auf false gesetzt. Wenn der Gegner besiegt wird
		 * wird sie auch auf false gesetzt. Damit der Gegnerangriff abgebrochen werden
		 * kann, this.lebenGegner übertragen und lebenGegner wird auf 0 gesetzt.
		 * 
		 */
		while (angriff == true) {
			spielerID.checkWaffeHaltbarkeit();// Hier wird geprüft ob die Waffe vom Spieler nochh Haltbarkeit hat. Wenn
												// nicht wird sie durch ein Standartschwert ersetzt.
			// Erst wird abgefragt ob der Spieler angreifen will
			System.out.println(
					"===================================\nWillst du den Gegner angreifen?\n*Antworte mit\n [1]Ja\n [2]Nein");
			Scanner scan = new Scanner(System.in);
			String eingabeString = scan.nextLine();

			// Hier wird der angriff abgebrochen
			if (eingabeString.equals("2")) {

				System.out.println("Du hast den Angriff abgebrochen!\n=========================================");
				angriff = false;
			}

			// Wenn der Spieler den Gegner angreifen will, wird der Schaden der Spielerwaffe
			// ermittelt und dem Gegner vom Leben abgezogen
			else if (eingabeString.equals("1")) {

				gegnerID.setLeben(gegnerID.getLeben() - waffeSpieler.schadenWaffe);
				System.out.println("=============================================\nDu hast dem Gegner "
						+ this.gegner.getName() + " " + this.waffeSpieler.schadenWaffe + " Leben abgezogen!");

				// Hier wird überprüft ob der Gegner noch lebt
				// Wenn der Gegner tot ist...
				if (gegnerID.getLeben() <= 0) {

					System.out.println("Du hast den Gegner " + gegnerID.getName() + " besiegt!");
					angriff = false;
					this.waffeSpieler.haltbarkeitWaffe = this.waffeSpieler.haltbarkeitWaffe
							- spielerWaffeHaltbarkeitAbzug;
					System.out.println("Deiner Waffe " + this.waffeSpieler.nameWaffe + " wurde "
							+ spielerWaffeHaltbarkeitAbzug + " Haltbarkeit abgezogen!");
					System.out.println("Deine Waffe " + this.waffeSpieler.nameWaffe + " hat noch "
							+ this.waffeSpieler.haltbarkeitWaffe + " Hatlbarkeit!");

					System.out.println("Du hast " + goldID.getWertID() + " Gold!");
					System.out.println("Du hast " + goldFuerSpieler + " Gold bekommen!");
					goldID.setWertID(goldID.getWertID() + goldFuerSpieler);
					System.out.println("Du hast " + goldID.getWertID() + " Gold!");

					// Hier kann der Spieler, die Waffe vom Gegner aufheben
					System.out.println("Willst du die Waffe vom Gegner aufheben?\nJA: [1]\nNEIN: [2]\nName: "
							+ this.gegner.getWaffe(gegnerID).nameWaffe + "\nSchaden: "
							+ this.gegner.getWaffe(gegnerID).schadenWaffe);

					eingabeString = scan.nextLine();

					if (eingabeString.equals("2")) { // Der Spieler nimmt die Waffe nicht

						System.out.println("Du hast die Waffe nicht aufgehoben!");
					}
					// Der Spieler nimmt die Waffe
					else if (eingabeString.equals("1")) {

						this.waffeSpieler = this.gegner.getWaffe(gegnerID);
						System.out.println("Du hast die Waffe vom Gegner aufgehoben!");
					}
				}
				// Wenn der gegner noch lebt...
				else if (gegnerID.getLeben() > 0) {

					System.out.println(gegnerID.getName() + " hat noch " + gegnerID.getLeben()
							+ " Leben!\n=============================================");

					// Danach kommt gleich der Angriff des Gegners in einer Methode.
					// Diese Methode erkennt die Lebenanzahl des Spieler und zieht den Schaden der
					// Gegnerwaffe vom Leben des Spielers ab
					gegnerID.angriff(spielerID, gegnerID);

					// Hier wird überprüft ob du noch Lebst
					// Wenn du noch lebst
					if (getLeben() > 0) {

						// Der Spieler kann sich auch Heilen
						// Erst wird überprüft Ob der Spieler heiltränke hat
						// Wenn er welche hat....
						if (heiltrankID.getWertID() > 0) {

							System.out.println("Willst du dich Heilen?\nJA: [1]\nNEIN:[2]");
							System.out.println("Du hast " + heiltrankID.getWertID() + " Heiltränke");
							eingabeString = scan.nextLine();

							// Wenn der Spieler nicht Heilen will
							if (eingabeString.equals("2")) {

								System.out.println("Du hast dich nicht geheilt!");

								// Wenn der Spieler sich heilen will
							} else if (eingabeString.equals("1")) {

								heilen(heiltrankID);
							}
						}
					} else if (getLeben() <= 0) {

						System.out.println("Der Gegner " + gegnerID.getName() + " hat dich getötet! :(");
						angriff = false;
					}

				}
			}

		}
	}

	public void heilen(CustomArray heiltrankID) {
		if (heiltrankID.getWertID() > 0) {

			lebenSpieler = lebenSpieler + 10;
			heiltrankID.setWertID(heiltrankID.getWertID() - 1);
			System.out.println(
					"=======================================\nDir wurde ein Heiltrank abgezogen. Du hast noch " + heiltrankID.getWertID() + " Heiltränke!");
			System.out.println("Dir wurden 10 Leben hinzugefügt, du hast " + lebenSpieler + " Leben!");
		} else {

			System.out.println("===============================\nDu hast keine Heiltränke mehr!");
		}

	}

	public String getName() { // Um den Namen vom Spieler/ Gegner zu bekommen
		// TODO Auto-generated method stub
		return this.nameSpieler;
	}

	public int getLeben() { // Um die LP vom Gegner/ Spieler zu bekommen
		// TODO Auto-generated method stub
		return this.lebenSpieler;
	}

	public void setLeben(int neueLeben) { // Um nach angriffen oder nach dem Heilen die LP zu aktualisieren
		this.lebenSpieler = neueLeben;

	}

	public void setGegner(Gegner gegner) { // Um dem Spieler einen Gegner zuzuweisen
		this.gegner = gegner;
	}

	public void setWaffe(Waffe waffeSpieler) { // Hier wird dem Spieler eine Waffe zugewiesen

		this.waffeSpieler = waffeSpieler;
	}

	public void checkWaffeHaltbarkeit() {
		if (waffeSpieler.haltbarkeitWaffe <= 0) {

			StandartSchwert waffeSchwert = new StandartSchwert();
			System.out.println("Deine aktuelle Waffe " + waffeSpieler.nameWaffe
					+ " ist kaputt.\nDu bekommst als Standartwaffe ein " + waffeSchwert.nameWaffe + " mit "
					+ waffeSchwert.schadenWaffe + " Schaden!");
			this.waffeSpieler = waffeSchwert;
		}
	}

	public void showInventar(CustomArray goldID, CustomArray heiltrankID) {
		System.out.println("=======================\nDas ist dein Inventar:");

		System.out.println("Name Waffe: " + waffeSpieler.nameWaffe + "\nSchaden Waffe: " + waffeSpieler.schadenWaffe
				+ "\nHeilränke: " + heiltrankID.getWertID() + "\nGold: " + goldID.getWertID() + "\n===============================");
	}

	public boolean auswahlMethode(CustomArray goldID, CustomArray heiltrankID, Spieler spielerID) {
		System.out.println(
				"Du kannst zwischen\n[1]: Angriff\n[2]: Heilen\n[3]: Inventar zeigen\n[4]: Neuer Raum\n[5]: Spiel beenden\nwählen!");
		boolean spielBeenden = false;

		Scanner scanner = new Scanner(System.in);
		String eingabeString = scanner.nextLine();

		while (spielBeenden == false) {
			switch (eingabeString) {
			case "1": {
				// Angriff
				angriff(spielerID, heiltrankID, goldID);
				return spielBeenden = false;
			}
			case "2": {
				// Heilen
				heilen(heiltrankID);
				return spielBeenden = false;
			}
			case "3": {
				// Inventar zeigen
				showInventar(goldID, heiltrankID);
				return spielBeenden = false;
			}
			case "4": {
				// Neun Raum erstellen, für Gegner
				erstelleRaum(goldID, heiltrankID);
				return spielBeenden = false;
			}
			case "5": {
				// Um die Spielschleife zu stoppen
				spielBeenden = true;
				return spielBeenden;
			}
			}
		}
		return spielBeenden = false;
	}

	public void erstelleRaum(CustomArray goldID, CustomArray heiltrankID) { // In dieser Methode wird durch zufall ein
																			// Raum und/oder ein Händler erstellt
		System.out.println("Du betrittst einen neuen Raum!");

		// Zufällige (25%) erstellung einer Kiste mit Gold und Heiltrank
		int min = 1;
		int max = 4;
		int zufallsZahlKiste = min + (int) (Math.random() * ((max - min) + 1));// Zufallszahl wird generiert

		// Hier bekommt der Spieler Gold
		if (zufallsZahlKiste == 1) {

			System.out.println("========================\nDu hast eine Kiste gefunden!");
			System.out.println("Du hast 5 Gold bekommen!");
			goldID.setWertID(goldID.getWertID() + 5);
			System.out.println("Du hast jetzt " + goldID.getWertID() + " Gold\n---------------------------");

			// Hier bekommt der Spieler einen Heiltrank
			System.out.println("Du hast einen Heiltrank bekommen!");
			heiltrankID.setWertID(heiltrankID.getWertID() + 1);
			System.out.println(
					"Du hast jetzt " + heiltrankID.getWertID() + " Heiltränke!\n=============================");

		} else
			System.out.println("In diesem Raum gibt es keine Kiste!");

		// Zufällige (20%) erstellung eines Händlers der Waffen oder Heiltränke für Gold
		// verkauft
		boolean kauf = true; // Durch diesen bool kann man nach z.B. einem Heiltrankkauf einen weiteren
								// kaufen, oder wenn man nicht genug geld für das DiaSchwert hat, einen
								// heiltrank kaufen
		int min2 = 1;
		int max2 = 5;
		int zufallsZahlhaendler = min2 + (int) (Math.random() * ((max2 - min2) + 1));
	
		while (kauf == true) {
			if (zufallsZahlhaendler == 1) {

				System.out.println("============================\nDu hast einen Händler gefunden!");
				System.out.println("Du hast " + goldID.getWertID() + " Gold!");
				System.out.println(
						"Du kannst Heiltränke oder ein Schwert kaufen\nDas Schwert ist ein Diamant Schwert mit 55 Schaden und 3 Haltbarkeit");
				System.out
						.println("[1]: Schwert\n[2]: Heiltrank\n[3]: Abbrechen\n====================================");
				Scanner scan = new Scanner(System.in);
				String eingabeString = scan.nextLine();

				// Hier wird gekauft
				// Hier wird das Schwert gekauft
				if (eingabeString.equals("1")) {

					// Erst muss geprüft werden ob der Spieler genug gold hat
					if (goldID.getWertID() >= 40) {

						System.out.println(
								"=======================================\nDu hast das Diamantschwert gekauft!");
						goldID.setWertID(goldID.getWertID() - 40);
						System.out
								.println("Dir wurden 40 Gold abgezogen. Du hast noch " + goldID.getWertID() + " Gold!");
						DiaSchwert diaSchwert = new DiaSchwert(); // Hier wird das DiaObjekt erstellt. Das DiaObjekt
																	// wird
																	// mit dem aktuellen WaffenObjekt des Spielers
																	// ausgetauscht
						this.waffeSpieler = diaSchwert;
						System.out.println("Deine Waffe: " + this.waffeSpieler.nameWaffe + "\nSchaden: "
								+ this.waffeSpieler.schadenWaffe );

					} else {

						System.out.println("Du hast nicht genug Gold für das Schwert!");
					}
					// Hier wird der Heiltrank gekauft
				} else if (eingabeString.equals("2")) {

					// Erst muss geprüft werden ob der Spieler genug gold hat
					if (goldID.getWertID() >= 15) {

						System.out.println("=========================\nDu hast einen Heiltrank gekauft");
						heiltrankID.setWertID(heiltrankID.getWertID() + 1);// Hier wird der Heiltrank hinzugefügt
						goldID.setWertID(goldID.getWertID() - 15);// Hier wird das Gold abgezogen
						System.out.println("Du hast jetzt " + heiltrankID.getWertID() + " Heiltränke!");
						System.out.println("Dir wurden 15 Gold abgezogen. Du hast noch " + goldID.getWertID()
								+ " Gold!\n==============================================");

					} else {

						System.out.println("Du hast nicht genug Gold!");
					}
				} else if (eingabeString.equals("3")) {

					System.out.println("Du hast den Einkauf abgebrochen!\n=============================");
					kauf = false;
				}

			} else {

				System.out.println("In diesem Raum gibt es keinen Händler!\n========================================");
				kauf = false;
			}
		}
	}
}