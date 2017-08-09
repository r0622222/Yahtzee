package model.spelState;

import model.Spel;
import model.Speler;

public interface SpelState {

	public void voegSpelerToe(Speler speler);
	
	public void start();
}
