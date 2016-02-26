package Explorando;

/**
 * Clase Posició, que representa una posisión con coordenadas x e y; 
 * además mantiene el seguimiento de si dicha posición está ocupada o no
 *
 */
public class Posicio {
	public int x;
	public int y;
	public int estat;
	
	public Posicio(int x, int y, int estat) {
		super();
		this.x = x;
		this.y = y;
		this.estat = estat;
	}
	
	
}
