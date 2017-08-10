package model.spelerState;

import model.Categorieen;
import model.Dobbelsteen;
import model.DomainException;
import model.Speler;
import model.dobbelsteenState.DobbelsteenInSpel;

public class SpelerAanBeurt implements SpelerState {

	private Speler speler;
	
	public SpelerAanBeurt(Speler speler)
	{
		setSpeler(speler);
	}
	
	private void setSpeler(Speler speler)
	{
		this.speler = speler;
	}
	
	@Override
	public void dobbelstenenRollen() {
		for (Dobbelsteen dobbelsteen : speler.getDobbelstenen())
		{
			if (dobbelsteen.getState() instanceof DobbelsteenInSpel)
			{
				dobbelsteen.dobbelstenenRollen();
			}
		}
	}

	@Override
	public void dobbelsteenOpzijLeggen(int dobbelsteen) {
		speler.getDobbelstenen().get(dobbelsteen).dobbelsteenOpzijLeggen();
	}

	@Override
	public void beginBeurt() {
		throw new DomainException("Kan beurt niet beginnen, beurt is al begonnen!");
	}

	@Override
	public void beeindigBeurt() {
		speler.setState(new SpelerNietAanBeurt(speler));
		speler.setAantalKeerGerold(0);
	}

	@Override
	public void updateCategorie(Categorieen categorie) {
		speler.setCategorie(categorie);
	}

}
