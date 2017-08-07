package model;

import javax.swing.JOptionPane;

public class DobbelsteenOpzij implements DobbelsteenState{

	@Override
	public void dobbelsteenOpzijLeggen(Dobbelsteen dobbelsteen) {
		throw new DomainException("Deze dobbelsteen ligt al opzij!");		
	}

	@Override
	public void dobbelstenenRollen(Dobbelsteen dobbelsteen) {
		throw new DomainException("Dobbelsteen kan niet meer gerold worden");
	}

}
