package model;

import java.util.ArrayList;
import java.util.List;

import model.dobbelsteenState.DobbelsteenInSpel;

public class YahtzeeModel {

	private Spel spel;
	
	public YahtzeeModel()
	{
		spel = new Spel();
	}
	
	public void voegSpelerToe(String naam)
	{
		spel.voegSpelerToe(naam);
	}
	
	public int getAantalSpelers()
	{
		return spel.aantalSpelers();
	}
	
	public List<Speler> getSpelers()
	{
		return spel.getSpelers();
	}
	
	public List<Dobbelsteen> getDobbelstenen(int speler)
	{
		return getSpelers().get(speler).getDobbelstenen();
	}
	
	public ArrayList<Categorieen> getAllCategorieen()
	{
		return Categorieen.getAllCategorieen();
	}
	
	public void startSpel()
	{
		spel.start();
	}
	
	public int huidigeSpelerAanBeurt()
	{
		return spel.huidigeSpelerAanBeurt();
	}
	
	public void zetVolgendeSpelerAanBeurt()
	{
		spel.zetVolgendeSpelerAanBeurt();
	}
	
	public List<Dobbelsteen> dobbelstenenRollen(int spelernr)
	{
		return spel.getSpelers().get(spelernr).dobbelstenenRollen();
	}
	
	public void dobbelsteenOpzijLeggen(int spelernr, int dobbelsteennr)
	{
		spel.getSpelers().get(spelernr).dobbelsteenOpzijLeggen(dobbelsteennr);
	}
	
	public void geefSpelerPunten(int spelernr, int punten)
	{
		spel.geefSpelerPunten(spelernr, punten);
	}
	
	public void updateCategorie(Categorieen categorie, int spelernr)
	{
		spel.getSpelers().get(spelernr).updateCategorie(categorie);
	}
	
	public int getAantalKeerGerold(int spelernr)
	{
		return spel.getSpelers().get(spelernr).getAantalKeerGerold();
	}
	
	public int getMaxAantalKeerGerold()
	{
		return Speler.ROL_KANSEN;
	}
	
	public void legAlleDobbelstenenSpelerOpzij(int spelernr)
	{
		for (Dobbelsteen dobbelsteen : spel.getSpelers().get(spelernr).getDobbelstenen())
		{
			if (dobbelsteen.getState() instanceof DobbelsteenInSpel) 
			{
				dobbelsteen.dobbelsteenOpzijLeggen();
			}
		}
	}
	
	public boolean zijnAlleDobbelstenenSpelerOpzij(int spelernr)
	{
		for (Dobbelsteen dobbelsteen : spel.getSpelers().get(spelernr).getDobbelstenen())
		{
			if (dobbelsteen.getState() instanceof DobbelsteenInSpel)
			{
				return false;
			}
		}
		return true;
	}
}
