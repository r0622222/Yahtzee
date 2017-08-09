package model.spelState;

import javax.swing.JOptionPane;

import model.DomainException;
import model.Spel;
import model.Speler;

public class RegisteredState implements SpelState{
	
	private Spel spel;
	
	public RegisteredState(Spel spel)
	{
		setSpel(spel);
	}
	
	private void setSpel(Spel spel)
	{
		if (spel == null) throw new DomainException("Spel mag niet null zijn!");
		this.spel = spel;
	}

	@Override
	public void voegSpelerToe(Speler speler) {
		spel.getSpelers().add(speler);
	}

	@Override
	public void start() {
		spel.setState(new StartedState());
	}

}
