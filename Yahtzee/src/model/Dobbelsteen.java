package model;

import java.util.Random;

public class Dobbelsteen {

	private int waarde;
	private boolean opzijGelegd;
	private DobbelsteenState state;
	
	public Dobbelsteen()
	{
		this.setState(new DobbelsteenInSpel());
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
		state.dobbelstenenRollen(this);
	}
	
	public void dobbelsteenOpzijLeggen()
	{
		state.dobbelsteenOpzijLeggen(this);
	}

	public int getWaarde() {
		return waarde;
	}

	public void setWaarde(int waarde) {
		if (waarde < 1 || waarde > 6) throw new DomainException("Ongeldige waarde dobbelsteen!");
		this.waarde = waarde;
	}

	public boolean isOpzijGelegd() {
		return opzijGelegd;
	}

	private void setOpzijGelegd(boolean opzijGelegd) {
		this.opzijGelegd = opzijGelegd;
	}
}
