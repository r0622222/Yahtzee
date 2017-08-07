package model;

import java.util.Random;

public class DobbelsteenInSpel implements DobbelsteenState {

	@Override
	public void dobbelsteenOpzijLeggen(Dobbelsteen dobbelsteen) {
		dobbelsteen.setState(new DobbelsteenOpzij());
	}

	@Override
	public void dobbelstenenRollen(Dobbelsteen dobbelsteen) {
		int getal = (int) (Math.random() * 6 + 1);
		dobbelsteen.setWaarde(getal);
	}

}
