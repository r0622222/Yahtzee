package model.dobbelsteenState;

import javax.swing.JOptionPane;

import model.Dobbelsteen;
import model.DomainException;

public class DobbelsteenOpzij implements DobbelsteenState{

	@Override
	public void dobbelsteenOpzijLeggen() {
		throw new DomainException("Deze dobbelsteen ligt al opzij!");		
	}

	@Override
	public void dobbelstenenRollen() {
		throw new DomainException("Dobbelsteen kan niet meer gerold worden");
	}

}
