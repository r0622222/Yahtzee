package model.dobbelsteenState;

import java.util.Random;

import model.Dobbelsteen;

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
		dobbelsteen.setState(new DobbelsteenOpzij());
	}

	@Override
	public void dobbelstenenRollen() {
		int getal = (int) (Math.random() * 6 + 1);
		dobbelsteen.setWaarde(getal);
	}

}
