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
		view.addMouseClickListenerToBeeindigBeurtButton(new BeeindigBeurtButtonHandler());
		view.addMouseClickListenerToDobbelsteen1(new Dobbelsteen1LabelHandler());
		view.addMouseClickListenerToDobbelsteen2(new Dobbelsteen2LabelHandler());
		view.addMouseClickListenerToDobbelsteen3(new Dobbelsteen3LabelHandler());
		view.addMouseClickListenerToDobbelsteen4(new Dobbelsteen4LabelHandler());
		view.addMouseClickListenerToDobbelsteen5(new Dobbelsteen5LabelHandler());
		model.startSpel();
		view.startSpel();
	}
	
	public void dobbelstenenRollen(int spelernr)
	{
		List<Dobbelsteen> dobbelstenen = model.dobbelstenenRollen(spelernr);
		for (int i = 0; i < model.getAantalSpelers(); i++){
			view.updateDobbelsteen1(Integer.toString(dobbelstenen.get(0).getWaarde()), i);
			view.updateDobbelsteen2(Integer.toString(dobbelstenen.get(1).getWaarde()), i);
			view.updateDobbelsteen3(Integer.toString(dobbelstenen.get(2).getWaarde()), i);
			view.updateDobbelsteen4(Integer.toString(dobbelstenen.get(3).getWaarde()), i);
			view.updateDobbelsteen5(Integer.toString(dobbelstenen.get(4).getWaarde()), i);
		}
	}
	
	public void dobbelsteenOpzijLeggen(int dobbelsteen)
	{
		int b = view.huidigeSpelerAanBeurt();
		if ((model.getAantalKeerGerold(b) != model.getMaxAantalKeerGerold()) && model.getAantalKeerGerold(b) != 0) {
			try {
				model.dobbelsteenOpzijLeggen(b, dobbelsteen);
				view.veranderAchtergrondKleurDobbelsteen(dobbelsteen, b);
			} catch (Exception e) {
				view.showError(e.getMessage());
			}
		}
		else if (model.getAantalKeerGerold(b) == 0) 
		{
			view.showError("Je hebt nog niet gerold!");
		}
		else 
		{
			view.showError("Je beurt is over, je kan enkel nog een categorie kiezen!");
		}
	}
	
	private class RollButtonHandler extends MouseAdapter
	{
		public void mouseClicked(MouseEvent event)
		{
			int huidigeSpelerAanBeurt = view.huidigeSpelerAanBeurt();
			if (!model.zijnAlleDobbelstenenSpelerOpzij(huidigeSpelerAanBeurt)) {
				try {
					dobbelstenenRollen(huidigeSpelerAanBeurt);
				} catch (Exception e) {
					view.showError(e.getMessage());
				}
			}
			if (model.getAantalKeerGerold(huidigeSpelerAanBeurt) == model.getMaxAantalKeerGerold()) 
			{
				view.veranderAchtergrondKleurAlleDobbelstenen(huidigeSpelerAanBeurt);
			}
		}
	}
	
	private class BeeindigBeurtButtonHandler extends MouseAdapter
	{
		public void mouseClicked(MouseEvent event)
		{
			int huidigeSpeler = view.huidigeSpelerAanBeurt();
			model.updateCategorie(view.getGeselecteerdeCategorieActieveSpeler(), huidigeSpeler);
			model.zetVolgendeSpelerAanBeurt();
			view.volgendeSpeler();
		}
	}
	
	private class Dobbelsteen1LabelHandler extends MouseAdapter
	{
		public void mouseClicked(MouseEvent event)
		{
			dobbelsteenOpzijLeggen(0);
		}
	}
	
	private class Dobbelsteen2LabelHandler extends MouseAdapter
	{
		public void mouseClicked(MouseEvent event)
		{
			dobbelsteenOpzijLeggen(1);
		}
	}
	
	private class Dobbelsteen3LabelHandler extends MouseAdapter
	{
		public void mouseClicked(MouseEvent event)
		{
			dobbelsteenOpzijLeggen(2);
		}
	}
	
	private class Dobbelsteen4LabelHandler extends MouseAdapter
	{
		public void mouseClicked(MouseEvent event)
		{
			dobbelsteenOpzijLeggen(3);
		}
	}
	
	private class Dobbelsteen5LabelHandler extends MouseAdapter
	{
		public void mouseClicked(MouseEvent event)
		{
			dobbelsteenOpzijLeggen(4);
		}
	}
}
