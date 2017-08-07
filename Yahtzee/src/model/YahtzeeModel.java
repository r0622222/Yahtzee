package model;

import java.util.List;

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
}
