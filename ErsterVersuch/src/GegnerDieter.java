
public class GegnerDieter extends Gegner{
	
	Waffe waffeGegnerDieter;
	double spielerWaffeHaltbarkeitAbzug = 1.5;
	
	//Konstruktor
	public GegnerDieter() {
		super("King Dieter", 60);
		StarkesSchwert waffeGegnerDieter = new StarkesSchwert();
		this.waffeGegner = waffeGegnerDieter;
	}

	//Methoden
	@Override
	public void angriff() {
		// TODO Auto-generated method stub
		
	}

}
