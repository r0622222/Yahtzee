package model;

import java.util.ArrayList;
import java.util.List;

public class Speler {

	private String naam;
	private int score;
	private List<Dobbelsteen> dobbelstenen = new ArrayList<>();
	
	public Speler(String naam)
	{
		this.setNaam(naam);
		this.score = 0;
	}

	public String getNaam() {
		return naam;
	}

	private void setNaam(String naam) {
		if (naam == null || naam.trim().isEmpty()) throw new DomainException("Naam mag niet leeg zijn!");
		this.naam = naam;
	}

	public int getScore() {
		return score;
	}

	private void setScore(int score) {
		this.score = score;
	}
	
	public List<Dobbelsteen> getDobbelstenen() {
		return dobbelstenen;
	}

	public void setDobbelstenen(List<Dobbelsteen> dobbelstenen) {
		this.dobbelstenen = dobbelstenen;
	}

	public void dobbelstenenRollen()
	{
		for (Dobbelsteen dobbelsteen : dobbelstenen)
		{
			if (dobbelsteen.getState() instanceof DobbelsteenInSpel)
			{
				dobbelsteen.dobbelstenenRollen();
			}
		}
	}
	
	public void dobbelsteenOpzijLeggen(int dobbelsteen)
	{
		dobbelstenen.get(dobbelsteen).dobbelsteenOpzijLeggen();
	}
}
