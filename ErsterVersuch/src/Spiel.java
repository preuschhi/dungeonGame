

public class Spiel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean spielBeenden = false;
		Spieler spieler = new Spieler("Leon", 100); //Spielerobjekt wird erstellt
		Spieler spielerID = spieler;
		StandartSchwert waffe = new StandartSchwert();//Waffenobjekt als Startwaffe
		spieler.setWaffe(waffe); // dem spieler wird die  Standartwaffe zugewiesen
		
		
		//Hier wird das Array erstellt
		CustomArray [] inventar = new CustomArray[2];
		//Heiltrank
		inventar[0] = new CustomArray();
		CustomArray heiltrankID = inventar[0];

		inventar[0].setObjectName("Heiltank");
		inventar[0].setWertID(2);

		
		//Gold
		inventar[1] = new CustomArray();
		CustomArray goldID = inventar[1];

		inventar[1].setObjectName("Gold");
		inventar[1].setWertID(10200);

		
		
		do {
			spielBeenden = spieler.auswahlMethode(goldID, heiltrankID, spielerID);
		} while (spielBeenden == false);
		
		System.out.println("Du hast das Spiel beendet!");
		
		
		
		
		
		
		
	
		
		
		
	}

}
