
public class GegnerOlaf extends Gegner {

	int goldFuerSpieler = 5; //So viel Gold bekommt der Spieler wenn er diesen Gegner tötet
	double spielerWaffeHaltbarkeitAbzug = 0.5; //So viel wird der Waffe nach dem tötet dieses Gegenrs abgezogen

	public GegnerOlaf() {
		super("Olaf", 30);
		StandartSchwert waffeGegnerOlaf = new StandartSchwert();
		this.waffeGegner = waffeGegnerOlaf;
	}

	// Methoden

	
	
	@Override
	public void angriff() {
		// TODO Auto-generated method stub

	}

	@Override
	public void heilen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void heilen(CustomArray heiltrankID) {
		// TODO Auto-generated method stub
		
	}

}
