package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Categorieen;
import model.Speler;

public class Speelveld extends JFrame {

	private JLabel naamLabel;
	private JLabel dobbelsteen1;
	private JLabel dobbelsteen2;
	private JLabel dobbelsteen3;
	private JLabel dobbelsteen4;
	private JLabel dobbelsteen5;
	private JButton rolDobbelstenen;
	private JButton beeindigBeurt;
	private String naam;
	private JComboBox categorieen;
	private Categorieen geselecteerdeCategorie;
	private List<JLabel> dobbelsteenLabels = new ArrayList<JLabel>();
	
	public Categorieen getGeselecteerdeCategorie() {
		return geselecteerdeCategorie;
	}

	private void setGeselecteerdeCategorie(Categorieen geselecteerdeCategorie) {
		this.geselecteerdeCategorie = geselecteerdeCategorie;
	}

	private final static int HEIGHT_FRAME = 400;
	private final static int WIDTH_FRAME = 400;
	
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
		
		this.naamLabel = new JLabel(naam + " playing");
		this.naamLabel.setLocation(5, 0);
		this.naamLabel.setSize(WIDTH_FRAME, 30);
		this.add(naamLabel);
		
		this.dobbelsteen1 = new JLabel("1", SwingConstants.CENTER);
		this.dobbelsteen1.setLocation(85, 60);
		this.dobbelsteen1.setSize(30, 30);
		this.add(dobbelsteen1);
		this.dobbelsteenLabels.add(dobbelsteen1);
		
		this.dobbelsteen2 = new JLabel("1", SwingConstants.CENTER);
		this.dobbelsteen2.setLocation(135, 60);
		this.dobbelsteen2.setSize(30, 30);
		this.add(dobbelsteen2);
		this.dobbelsteenLabels.add(dobbelsteen2);
		
		this.dobbelsteen3 = new JLabel("1", SwingConstants.CENTER);
		this.dobbelsteen3.setLocation(185, 60);
		this.dobbelsteen3.setSize(30, 30);
		this.add(dobbelsteen3);
		this.dobbelsteenLabels.add(dobbelsteen3);
		
		this.dobbelsteen4 = new JLabel("1", SwingConstants.CENTER);
		this.dobbelsteen4.setLocation(235, 60);
		this.dobbelsteen4.setSize(30, 30);
		this.add(dobbelsteen4);
		this.dobbelsteenLabels.add(dobbelsteen4);
		
		this.dobbelsteen5 = new JLabel("1", SwingConstants.CENTER);
		this.dobbelsteen5.setLocation(285, 60);
		this.dobbelsteen5.setSize(30, 30);
		this.add(dobbelsteen5);
		this.dobbelsteenLabels.add(dobbelsteen5);
		
		this.rolDobbelstenen = new JButton("Rol dobbelstenen");
		this.rolDobbelstenen.setLocation(85, 100);
		this.rolDobbelstenen.setSize(230, 30);
		this.add(rolDobbelstenen);
		disableRollButton();
		
		this.beeindigBeurt = new JButton("Beëindig beurt");
		this.beeindigBeurt.setLocation(115, 250);
		this.beeindigBeurt.setSize(170, 30);
		this.add(beeindigBeurt);
		disableBeeindigBeurtButton();
		
		this.categorieen = new JComboBox<>(Categorieen.getAllCategorieen().toArray());
		this.geselecteerdeCategorie = Categorieen.ACES;
		this.categorieen.setLocation(115, 210);
		this.categorieen.setSize(170, 30);
		this.add(categorieen);
		
		this.categorieen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setGeselecteerdeCategorie((Categorieen) categorieen.getSelectedItem());
			}
		});
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
	
	public void addMouseClickListenerToBeeindigBeurtButton(MouseListener listener)
	{
		this.beeindigBeurt.addMouseListener(listener);
	}
	
	public void enableRollButton()
	{
		this.rolDobbelstenen.setEnabled(true);
	}
	
	public void disableRollButton()
	{
		this.rolDobbelstenen.setEnabled(false);
	}
	
	public boolean isRollButtonEnabled()
	{
		return this.rolDobbelstenen.isEnabled();
	}
	
	public void addMouseClickListenerToDobbelsteen1(MouseListener listener)
	{
		this.dobbelsteen1.addMouseListener(listener);
	}
	
	public void addMouseClickListenerToDobbelsteen2(MouseListener listener)
	{
		this.dobbelsteen2.addMouseListener(listener);
	}
	
	public void addMouseClickListenerToDobbelsteen3(MouseListener listener)
	{
		this.dobbelsteen3.addMouseListener(listener);
	}
	
	public void addMouseClickListenerToDobbelsteen4(MouseListener listener)
	{
		this.dobbelsteen4.addMouseListener(listener);
	}
	
	public void addMouseClickListenerToDobbelsteen5(MouseListener listener)
	{
		this.dobbelsteen5.addMouseListener(listener);
	}
	
	public void veranderAchtergrondKleurDobbelsteen(int dobbelsteennr)
	{
		this.dobbelsteenLabels.get(dobbelsteennr).setBackground(Color.gray);
		this.dobbelsteenLabels.get(dobbelsteennr).setOpaque(true);
	}
	
	public void enableBeeindigBeurtButton()
	{
		this.beeindigBeurt.setEnabled(true);
	}
	
	public void disableBeeindigBeurtButton()
	{
		this.beeindigBeurt.setEnabled(false);
	}
	
	public boolean isBeeindigBeurtButtonEnabled()
	{
		return this.beeindigBeurt.isEnabled();
	}
	
	public void veranderAchtergrondKleurAlleDobbelstenenDefault()
	{
		for (int i = 0; i < 5; i++)
		{
			this.dobbelsteenLabels.get(i).setBackground(getBackground());
			this.dobbelsteenLabels.get(i).setOpaque(true);
		}
	}
}
