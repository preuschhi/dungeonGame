
public class GegnerOlaf extends Gegner {

	Waffe waffeGegnerOlaf;
	double spielerWaffeHaltbarkeitAbzug = 0.5;

	public GegnerOlaf() {
		super("Olaf", 30);
		StandartSchwert waffeGegnerOlaf = new StandartSchwert();
		this.waffeGegner = waffeGegnerOlaf;
	}

	// Methoden

	public double getSpielerWaffeHaltbarkeitAbzug() {
		return this.spielerWaffeHaltbarkeitAbzug;
	}
	
	@Override
	public void angriff() {
		// TODO Auto-generated method stub

	}

}
