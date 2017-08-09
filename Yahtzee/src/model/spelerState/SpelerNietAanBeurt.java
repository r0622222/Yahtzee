package model.spelerState;

import model.DomainException;
import model.Speler;

public class SpelerNietAanBeurt implements SpelerState {

	@Override
	public void dobbelstenenRollen() {
		throw new DomainException("Dobbelstenen kunnen niet gerold worden ,je bent niet aan de beurt!");
	}

	@Override
	public void dobbelsteenOpzijLeggen(int dobbelsteen) {
		throw new DomainException("Dobbelsteen kan niet opzij gelegd worden, je bent niet aan de beurt!");
	}

}
