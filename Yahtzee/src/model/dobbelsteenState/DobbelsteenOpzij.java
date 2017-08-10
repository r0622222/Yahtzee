package model.dobbelsteenState;

import model.Dobbelsteen;
import model.DomainException;

public class DobbelsteenOpzij implements DobbelsteenState{
	
	private Dobbelsteen dobbelsteen;
	
	public DobbelsteenOpzij(Dobbelsteen dobbelsteen)
	{
		setDobbelsteen(dobbelsteen);
	}
	
	private void setDobbelsteen(Dobbelsteen dobbelsteen)
	{
		this.dobbelsteen = dobbelsteen;
	}
	
	@Override
	public void dobbelsteenOpzijLeggen() {
		throw new DomainException("Deze dobbelsteen ligt al opzij!");		
	}

	@Override
	public void dobbelstenenRollen() {
		throw new DomainException("Dobbelsteen kan niet meer gerold worden");
	}

	@Override
	public void dobbelsteenInSpelLeggen() {
		dobbelsteen.setState(new DobbelsteenInSpel(dobbelsteen));
	}

}
