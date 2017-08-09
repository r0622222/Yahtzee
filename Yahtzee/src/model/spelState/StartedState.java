package model.spelState;

import model.DomainException;
import model.Spel;
import model.Speler;

public class StartedState implements SpelState{

	@Override
	public void voegSpelerToe(Speler speler) {
		throw new DomainException("Het spel is al begonnen!");
	}

	@Override
	public void start() {
		throw new DomainException("Het spel is al begonnen!");
	}

}
