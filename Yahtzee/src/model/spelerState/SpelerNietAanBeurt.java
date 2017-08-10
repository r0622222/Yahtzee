package model.spelerState;

import model.Categorieen;
import model.Dobbelsteen;
import model.DomainException;
import model.Speler;
import model.dobbelsteenState.DobbelsteenOpzij;

public class SpelerNietAanBeurt implements SpelerState {

	private Speler speler;
	
	public SpelerNietAanBeurt(Speler speler)
	{
		setSpeler(speler);
	}
	
	private void setSpeler(Speler speler)
	{
		this.speler = speler;
	}
	@Override
	public void dobbelstenenRollen() {
		throw new DomainException("Dobbelstenen kunnen niet gerold worden ,je bent niet aan de beurt!");
	}

	@Override
	public void dobbelsteenOpzijLeggen(int dobbelsteen) {
		throw new DomainException("Dobbelsteen kan niet opzij gelegd worden, je bent niet aan de beurt!");
	}

	@Override
	public void beginBeurt() {
		for (Dobbelsteen dobbelsteen : speler.getDobbelstenen())
		{
			if (dobbelsteen.getState() instanceof DobbelsteenOpzij)
			{
				dobbelsteen.dobbelsteenInSpelLeggen();
			}
		}
		speler.setState(new SpelerAanBeurt(speler));
	}

	@Override
	public void beeindigBeurt() {
		throw new DomainException("Beurt kan niet beeindigd worden, je bent niet aan de beurt!");
	}

	@Override
	public void updateCategorie(Categorieen categorie) {
		throw new DomainException("Kan categorie niet updaten, je bent niet aan de beurt!");
	}

}
