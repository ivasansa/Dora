package Explorando;

/**
 * Excepció personalitzada que tracta un error en el Parse del encarament del Robot relativa a 
 * la coordenada xy del mapa a realitzar
 */
public class ParseException extends Exception {
	public ParseException(String message){
		super(message);
	}
	public String getMessage(){
		return super.getMessage();
	}
}
