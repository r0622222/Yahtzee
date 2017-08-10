package model.dobbelsteenState;

import model.Dobbelsteen;
import model.DomainException;

public class DobbelsteenInSpel implements DobbelsteenState {

	private Dobbelsteen dobbelsteen;
	
	public DobbelsteenInSpel(Dobbelsteen dobbelsteen)
	{
		setDobbelsteen(dobbelsteen);
	}
	
	private void setDobbelsteen(Dobbelsteen dobbelsteen)
	{
		this.dobbelsteen = dobbelsteen;
	}
	
	@Override
	public void dobbelsteenOpzijLeggen() {
		dobbelsteen.setState(new DobbelsteenOpzij(dobbelsteen));
	}

	@Override
	public void dobbelstenenRollen() {
		int getal = (int) (Math.random() * 6 + 1);
		dobbelsteen.setWaarde(getal);
	}

	@Override
	public void dobbelsteenInSpelLeggen() {
		throw new DomainException("Kan dobbelsteen niet in spel leggen, dobbelsteen is al in spel!");
	}

}
