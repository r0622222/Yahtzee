package model;

import java.util.ArrayList;
import java.util.List;

import model.spelerState.SpelerAanBeurt;
import model.spelerState.SpelerNietAanBeurt;
import model.spelerState.SpelerState;

public class Speler {

	private String naam;
	private int score;
	private List<Dobbelsteen> dobbelstenen = new ArrayList<>();
	private SpelerState state;

	public Speler(String naam)
	{
		this.setNaam(naam);
		this.score = 0;
		this.setState(new SpelerNietAanBeurt());
		this.genereerDobbelstenen();
	}
	
	public SpelerState getState() {
		return state;
	}

	private void setState(SpelerState state) {
		this.state = state;
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

	public List<Dobbelsteen> dobbelstenenRollen()
	{
		state.dobbelstenenRollen();
		return getDobbelstenen();
	}
	
	public void dobbelsteenOpzijLeggen(int dobbelsteen)
	{
		state.dobbelsteenOpzijLeggen(dobbelsteen);	
	}
	
	public void beeindigBeurt()
	{
		this.setState(new SpelerNietAanBeurt());
	}
	
	public void beginBeurt()
	{
		this.setState(new SpelerAanBeurt(this));
	}
	
	public void genereerDobbelstenen()
	{
		for (int i = 0; i < 5; i++)
		{
			dobbelstenen.add(new Dobbelsteen());
		}
	}
}
