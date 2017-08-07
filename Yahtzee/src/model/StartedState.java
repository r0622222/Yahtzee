package model;

public class StartedState implements SpelState{

	@Override
	public void voegSpelerToe(Spel spel, Speler speler) {
		throw new DomainException("Het spel is al begonnen!");
	}

}
