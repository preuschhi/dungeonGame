
public class CustomArray {

	
	// Eigenschaften
	String objectNameString;
	int wertID;

	// Methoden

	public void setObjectName(String objectNameString) { // Hier wird der Name des Objektes bestimmt
		this.objectNameString = objectNameString;
	}

	public String getObjectName() { // Hier wird der Name des Objektes ausgegeben
		return this.objectNameString;
	}

	public void setWertID(int wertID) { // Hier wird der Wert des Objektes bestimmt, z.B. "3" Heiltränke
		this.wertID = wertID;
	}

	public int getWertID() { //Hier wird der Wert des Objektes ausgegeben
		return this.wertID;
	}
}


//Hier speicher ich das array für später wenn die main geschrieben wird

//CustomArray [] inventar = new CustomArray[2];
////Heiltrank
//inventar[0] = new CustomArray();
//CustomArray heiltrankID = inventar[0];
//System.out.println(heiltrankID);
//inventar[0].setObjectName("Heiltank");
//inventar[0].setWertID(2);
//System.out.println(inventar[0].getObjectName() + " " + inventar[0].getWertID());
//
////Gold
//inventar[1] = new CustomArray();
//CustomArray goldID = inventar[1];
//System.out.println(goldID);
//inventar[1].setObjectName("Gold");
//inventar[1].setWertID(10);
//System.out.println(inventar[1].getObjectName() + " " + inventar[1].getWertID());
