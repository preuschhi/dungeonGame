
public class GegnerJürgen extends Gegner {

	int goldFuerSpieler = 10; //So viel Gold bekommt der Spieler wenn er diesen Gegner tötet
	double spielerWaffeHaltbarkeitAbzug = 1; //So viel wird der Waffe nach dem tötet dieses Gegenrs abgezogen

	// Konstruktor
	public GegnerJürgen() {
		super("Jürgen", 45);
		MittelStarkesSchwert waffeGegnerJuergen = new MittelStarkesSchwert();
		this.waffeGegner = waffeGegnerJuergen;
	}

	// Methoden
	public void angriff() {
		// TODO Auto-generated method stub

	}

}
