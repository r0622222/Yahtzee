package model;

import java.util.Random;

import model.dobbelsteenState.DobbelsteenInSpel;
import model.dobbelsteenState.DobbelsteenState;

public class Dobbelsteen {

	private int waarde;
	private DobbelsteenState state;
	
	public Dobbelsteen()
	{
		setWaarde(1);
		this.setState(new DobbelsteenInSpel(this));
	}
	
	public void setState(DobbelsteenState state)
	{
		this.state = state;
	}
	
	public DobbelsteenState getState()
	{
		return state;
	}
	
	public void dobbelstenenRollen()
	{
		state.dobbelstenenRollen();
	}
	
	public void dobbelsteenOpzijLeggen()
	{
		state.dobbelsteenOpzijLeggen();
	}

	public int getWaarde() {
		return waarde;
	}

	public void setWaarde(int waarde) {
		if (waarde < 1 || waarde > 6) throw new DomainException("Ongeldige waarde dobbelsteen!");
		this.waarde = waarde;
	}
}
