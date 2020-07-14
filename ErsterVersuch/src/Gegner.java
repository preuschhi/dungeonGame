
public abstract class Gegner implements IMethoden {

	// Eigenschaften
	private String nameGegner;
	private int lebenGegner;
	Waffe waffeGegner;
	Spieler spieler;

	// Konstruktor
	public Gegner(String nameGegner, int lebenGegner) {
		super();
		this.nameGegner = nameGegner;
		this.lebenGegner = lebenGegner;

//		Waffe waffeGegnerWaffe = new Waffe(90, "Schwert", 10);
//		this.waffeGegner = waffeGegnerWaffe;
	}

	// Methoden

	public void angriff(Spieler spielerID, Gegner gegnerID) {

		// Erst wird das Leben des Spielers ermittelt
		int lebenSpieler = spielerID.getLeben();

		// Dann wir durch zufall ermittelt ob der Gegner den Spieler angreift oder ob er
		// ihn verfehlt
		int min = 1;
		int max = 10;
		int zahl = min + (int) (Math.random() * ((max - min) + 1));
		// Hier wird angeriffen
		if ((zahl == 1) || (zahl == 2) || (zahl == 3) || (zahl == 4) || (zahl == 5) || (zahl == 6)) {
			lebenSpieler -= getWaffe(gegnerID).schadenWaffe;
			spielerID.setLeben(lebenSpieler);
			System.out.println("Der Gegner " + getName() + " hat dir " + getWaffe(gegnerID).schadenWaffe + " Leben abgezogen!");
		} else {
			System.out.println("Der Gegner " + getName() + " hat dich nicht Getroffen");
		}

	}

	@Override
	public void heilen() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.nameGegner;
	}

	@Override
	public int getLeben() {
		// TODO Auto-generated method stub
		return this.lebenGegner;
	}

	@Override
	public void setLeben(int neueLeben) {
		this.lebenGegner = neueLeben;

	}

	public void setGegnerSpieler(Spieler spieler) { // Um dem Gegner die möglichkeit zu geben den Spieler anzugreifen
		this.spieler = spieler;
	}

	public Waffe getWaffe(Gegner gegnerID) { // Um die WaffenID vom SpielerGegner Objekt zu bekommen, z.B. Olaf
		
		return gegnerID.waffeGegner;
	}

}
