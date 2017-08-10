package model.spelerState;

import model.Categorieen;
import model.Speler;

public interface SpelerState {

	public void dobbelstenenRollen();
	
	public void dobbelsteenOpzijLeggen(int dobbelsteen);
	
	public void beginBeurt();
	
	public void beeindigBeurt();
	
	public void updateCategorie(Categorieen categorie);

}
