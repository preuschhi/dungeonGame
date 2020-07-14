
public class GegnerJürgen extends Gegner {

	Waffe waffeGegnerJuergen;
	double spielerWaffeHaltbarkeitAbzug = 1;

	// Konstruktor
	public GegnerJürgen() {
		super("Jürgen", 45);
		MittelStarkesSchwert waffeGegnerJuergen = new MittelStarkesSchwert();
		this.waffeGegner = waffeGegnerJuergen;
	}

	// Methoden
	@Override
	public void angriff() {
		// TODO Auto-generated method stub

	}

}
