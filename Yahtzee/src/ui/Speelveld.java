package ui;

import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Speler;

public class Speelveld extends JFrame {

	private JLabel naamLabel;
	private JLabel dobbelsteen1;
	private JLabel dobbelsteen2;
	private JLabel dobbelsteen3;
	private JLabel dobbelsteen4;
	private JLabel dobbelsteen5;
	private JButton rolDobbelstenen;
	private String naam;
	
	private final static int HEIGHT_FRAME = 500;
	private final static int WIDTH_FRAME = 600;
	
	public Speelveld(String naam) {
		super();
		this.naam = naam;
	}
	
	public void launch()
	{
		this.setSize(WIDTH_FRAME, HEIGHT_FRAME);
		this.setResizable(false);
		this.setLayout(null);
		this.setTitle("Yahtzee");
		
		this.naamLabel = new JLabel(naam);
		this.naamLabel.setLocation(200, 200);
		this.naamLabel.setSize(350, 40);
		this.add(naamLabel);
		
		this.dobbelsteen1 = new JLabel("1");
		this.dobbelsteen1.setLocation(300, 50);
		this.dobbelsteen1.setSize(30, 30);
		this.add(dobbelsteen1);
		
		this.dobbelsteen2 = new JLabel("1");
		this.dobbelsteen2.setLocation(300, 100);
		this.dobbelsteen2.setSize(30, 30);
		this.add(dobbelsteen2);
		
		this.dobbelsteen3 = new JLabel("1");
		this.dobbelsteen3.setLocation(300, 150);
		this.dobbelsteen3.setSize(30, 30);
		this.add(dobbelsteen3);
		
		this.dobbelsteen4 = new JLabel("1");
		this.dobbelsteen4.setLocation(300, 200);
		this.dobbelsteen4.setSize(30, 30);
		this.add(dobbelsteen4);
		
		this.dobbelsteen5 = new JLabel("1");
		this.dobbelsteen5.setLocation(300, 250);
		this.dobbelsteen5.setSize(30, 30);
		this.add(dobbelsteen5);
		
		this.rolDobbelstenen = new JButton("Rol dobbelstenen");
		this.rolDobbelstenen.setLocation(100, 400);
		this.rolDobbelstenen.setSize(200, 30);
		this.add(rolDobbelstenen);
	}
	
	public void updateDobbelsteen1(String waarde)
	{
		this.dobbelsteen1.setText(waarde);
	}
	
	public void updateDobbelsteen2(String waarde)
	{
		this.dobbelsteen2.setText(waarde);
	}
	
	public void updateDobbelsteen3(String waarde)
	{
		this.dobbelsteen3.setText(waarde);
	}
	
	public void updateDobbelsteen4(String waarde)
	{
		this.dobbelsteen4.setText(waarde);
	}
	
	public void updateDobbelsteen5(String waarde)
	{
		this.dobbelsteen5.setText(waarde);
	}
	
	public void addMouseClickListenerToRollButton(MouseListener listener)
	{
		this.rolDobbelstenen.addMouseListener(listener);
	}
}
