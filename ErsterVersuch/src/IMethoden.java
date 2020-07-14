
public interface IMethoden {

	//Methoden
	
	public abstract void angriff(); //Angreifen
	public abstract void heilen();	//Heilen
	public abstract String getName();	//Um den Namen vom Spieler/ Gegner zu bekommen
	public abstract int getLeben();//Um die LP vom Gegner/ Spieler zu bekommen
	public abstract void setLeben(int neueLeben);//Um nach angriffen oder nach dem Heilen die LP zu aktualisieren
	
}