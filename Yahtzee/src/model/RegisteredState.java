package model;

import javax.swing.JOptionPane;

public class RegisteredState implements SpelState{

	@Override
	public void voegSpelerToe(Spel spel, Speler speler) {
		spel.getSpelers().add(speler);
	}

}
