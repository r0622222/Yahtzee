package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import model.Dobbelsteen;
import model.Speler;
import model.YahtzeeModel;
import ui.YahtzeeView;

public class Controller {

	private YahtzeeView view;
	private YahtzeeModel model;
	
	public Controller()
	{
		view = new YahtzeeView();
		model = new YahtzeeModel();
		this.startGame();
	}
	
	public void registreerSpelers()
	{
		int aantalSpelers = view.vraagAantalSpelers();
		while(aantalSpelers != 0)
		{
			try {
				String naam = view.getSpelerNaam();
				model.voegSpelerToe(naam);
				aantalSpelers--;
			} catch (Exception e) {
				view.showError(e.getMessage());
			}
		}
	}
	
	public void startGame()
	{
		this.registreerSpelers();
		List<Speler> alleSpelers = model.getSpelers();
		for(int i = 0; i < model.getAantalSpelers(); i++)
		{
			view.maakSpeelveldAan(alleSpelers.get(i).getNaam());
		}
		view.addMouseClickListenerToRollButton(new RollButtonHandler());
	}
	
	public void updateDobbelstenen(int spelernr)
	{
		List<Dobbelsteen> dobbelstenen = model.getDobbelstenen(spelernr);
		view.updateDobbelsteen1(Integer.toString(dobbelstenen.get(0).getWaarde()), spelernr);
		view.updateDobbelsteen2(Integer.toString(dobbelstenen.get(1).getWaarde()), spelernr);
		view.updateDobbelsteen3(Integer.toString(dobbelstenen.get(2).getWaarde()), spelernr);
		view.updateDobbelsteen4(Integer.toString(dobbelstenen.get(3).getWaarde()), spelernr);
		view.updateDobbelsteen5(Integer.toString(dobbelstenen.get(4).getWaarde()), spelernr);
	}
	
	private class RollButtonHandler extends MouseAdapter
	{
		public void MouseClicked(MouseEvent event)
		{
			
		}
	}
}
