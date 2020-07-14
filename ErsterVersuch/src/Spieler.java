import java.util.Scanner;



public class Spieler implements IMethoden {

	// Eigenschaften
	private String nameSpieler;
	private int lebenSpieler;
	int gold;
	int heiltrank = 3;
	Waffe waffeSpieler;
	Gegner gegner;

	// Konstruktor
	public Spieler(String nameSpieler, int lebenSpieler) {
		this.nameSpieler = nameSpieler;
		this.lebenSpieler = lebenSpieler;
	}

	// Methoden

	public void angriff(Spieler spielerID) {
		Gegner gegnerID = null;// Dort ist die Referenz zum gegner objekt gespereichert
		double spielerWaffeHaltbarkeitAbzug = 0;
		// Hier kommt ein zufallsgenerator der entscheiden soll welcher gegner erstellt
		// wird
		int min = 1;
		int max = 3;
		int zufallsZahl = min + (int) (Math.random() * ((max - min) + 1));

		if (zufallsZahl == 1) { // Gegnerobjekt Olaf
			GegnerOlaf olaf = new GegnerOlaf();
			setGegner(olaf);
			spielerWaffeHaltbarkeitAbzug = olaf.spielerWaffeHaltbarkeitAbzug; // Um des Spieler Waffe die haltbarkeit zu
																				// vermindern
			gegnerID = olaf;

		} else if (zufallsZahl == 2) { // Gegnerobjekt Jürgen
			GegnerJürgen juergen = new GegnerJürgen();
			setGegner(juergen);
			spielerWaffeHaltbarkeitAbzug = juergen.spielerWaffeHaltbarkeitAbzug; // Um des Spieler Waffe die haltbarkeit
																					// zu vermindern
			gegnerID = juergen;

		} else if (zufallsZahl == 3) { // Gegnerobjekt Dieter
			GegnerDieter dieter = new GegnerDieter();
			setGegner(dieter);
			spielerWaffeHaltbarkeitAbzug = dieter.spielerWaffeHaltbarkeitAbzug; // Um des Spieler Waffe die haltbarkeit
																				// zu vermindern
			gegnerID = dieter;

		}

		// Hier wird der aktuelle Gegner ermittelt und dessen Stats herausgefunden
		int lebenGegner = gegnerID.getLeben();
		System.out.println("Dein aktueller Gegner: " + gegnerID.getName() + " hat " + gegnerID.getLeben()
				+ " Leben\n================================================");
		System.out.println(gegnerID.getName() + " hat die Waffe " + gegnerID.getWaffe(gegnerID).nameWaffe
				+ ",\nsie hat diese Stats:\n---------------------- \nSchaden:"
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

			// Erst wird abgefragt ob der Spieler angreifen will
			System.out.println(
					"===================================\nWillst du den Gegner angreifen?\n*Antworte mit 1(ja) oder 2(nein)");
			Scanner scan = new Scanner(System.in);
			int eingabeString = scan.nextInt();

			// Hier wird der angriff abgebrochen
			if (eingabeString == 2) {
				System.out.println("Du hast den Angriff abgebrochen!");
				gegnerID.setLeben(lebenGegner);
				angriff = false;
			}

			// Wenn der Spieler den Gegner angreifen will, wird der Schaden der Spielerwaffe
			// ermittelt und dem Gegner vom Leben abgezogen
			else if (eingabeString == 1) {
				lebenGegner -= this.waffeSpieler.schadenWaffe;
				System.out.println("Du hast dem Gegner " + this.gegner.getName() + " " + this.waffeSpieler.schadenWaffe
						+ " Leben abgezogen!");

				// Hier wird überprüft ob der Gegner noch lebt
				// Wenn der Gegner tot ist...
				if (lebenGegner <= 0) {
					System.out.println("Du hast den Gegner " + gegnerID.getName() + " besiegt!");
					angriff = false;
					this.waffeSpieler.haltbarkeitWaffe = this.waffeSpieler.haltbarkeitWaffe - spielerWaffeHaltbarkeitAbzug;
					System.out.println("Deiner Waffe " + this.waffeSpieler.nameWaffe + " wurde " + spielerWaffeHaltbarkeitAbzug + " Haltbarkeit abgezogen!");
					System.out.println("Deine Waffe " + this.waffeSpieler.nameWaffe + " hat noch " + this.waffeSpieler.haltbarkeitWaffe + " Hatlbarkeit!");
				}
				// Wenn der gegner noch lebt...
				else if (lebenGegner > 0) {
					System.out.println(gegnerID.getName() + " hat noch " + lebenGegner
							+ " Leben!\n=============================================");
					gegnerID.setLeben(lebenGegner);

					//Der Spieler kann sich auch Heilen
					System.out.println("Willst du dich Heilen?JA: 1   NEIN:2");
					eingabeString = scan.nextInt();
					//Wenn der Spieler nicht Heilen will
					if (eingabeString == 2) {
						System.out.println("Du hast dich nicht geheilt!");
					
						//Wenn der Spieler sich heilen will
					}else if (eingabeString == 1) {
						this.setLeben((this.getLeben() + 10));
						this.heiltrank -= 1;
						System.out.println("Dir wurden 10 Leben hinzugefügt. Du hast jetzt " + this.getLeben() + " Leben!");
					}
					
					
					// Danach kommt gleich der Angriff ds Gegners in einer Methode.
					// Diese Methode erkennt die Lebenanzahl des Spieler und zieht den Schaden der
					// Gegnerwaffe vom Leben des Spielers ab
					gegnerID.angriff(spielerID, gegnerID);

					// Hier wird überprüft ob du noch Lebst
					// Wenn du noch lebst...
					if (getLeben() > 0) {
						System.out.println("Du hast noch " + getLeben() + " Leben!");

					}
					// Wenn du tot bist...
					else if (getLeben() <= 0) {
						System.out.println("Der Gegner " + gegnerID.getName() + " hat dich getötet! :(");
						angriff = false;
					}
				}
			}
		}
	}

	@Override
	public void heilen() {
		if (heiltrank > 0) {
			lebenSpieler += 10;
			heiltrank--;
			System.out.println("==========================================\nDir wurden 10 Leben hinzugefügt, du hast "
					+ getLeben() + " Leben!");
		} else {
			System.out.println("===============================\nDu hast keine Heiltränke mehr!");
		}

	}

	@Override
	public String getName() { // Um den Namen vom Spieler/ Gegner zu bekommen
		// TODO Auto-generated method stub
		return this.nameSpieler;
	}

	@Override
	public int getLeben() { // Um die LP vom Gegner/ Spieler zu bekommen
		// TODO Auto-generated method stub
		return this.lebenSpieler;
	}

	@Override
	public void setLeben(int neueLeben) { // Um nach angriffen oder nach dem Heilen die LP zu aktualisieren
		this.lebenSpieler = neueLeben;

	}

	public void setGegner(Gegner gegner) {
		this.gegner = gegner;
	}

	public void setWaffe(Waffe waffeSpieler) { // Hier wird dem Spieler eine Waffe zugewiesen

		this.waffeSpieler = waffeSpieler;
	}

	@Override
	public void angriff() {
		// TODO Auto-generated method stub
	}

}
