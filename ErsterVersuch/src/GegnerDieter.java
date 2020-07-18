
public class GegnerDieter extends Gegner{
	
	int goldFuerSpieler = 20; //So viel Gold bekommt der Spieler wenn er diesen Gegner tötet
	double spielerWaffeHaltbarkeitAbzug = 1.5; //So viel wird der Waffe nach dem tötet dieses Gegenrs abgezogen
	
	//Konstruktor
	public GegnerDieter() {
		super("King Dieter", 70);
		StarkesSchwert waffeGegnerDieter = new StarkesSchwert();
		this.waffeGegner = waffeGegnerDieter;
	}

	//Methoden

	
	@Override
	public void angriff() {
		// TODO Auto-generated method stub
		
	}

}
