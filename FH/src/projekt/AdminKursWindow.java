package projekt;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.RadialGradientPaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;


public class AdminKursWindow extends JFrame {

JPanel panel = new JPanel();
private JTextField kurs = new JTextField(25);
private JTextField knr = new JTextField(25);
private JTextField titel = new JTextField(25);
private JTextField einheiten = new JTextField(25);

private DefaultListModel<String> model = new DefaultListModel<>();
private JList<String> list = new JList<>(model);
JScrollPane testscroll = new JScrollPane(list);


private JLabel statusAusgabe = new JLabel("keine Meldungen");

private JButton buttonAbbrechen = new JButton("Abbrechen");
private JButton buttonOK = new JButton("Anlegen");
private JButton buttonDB = new JButton("Verwerfen");


public AdminKursWindow(){
	
	JPanel panel = new JPanel(new BorderLayout());
	JPanel south = new JPanel(new BorderLayout());

	getContentPane().add(panel);
	
	list.setVisibleRowCount(4);
	panel.add(testscroll, BorderLayout.CENTER);

	JPanel textPanel = new JPanel(new GridLayout(1, 0));
	textPanel.add(kurs);
	textPanel.add(knr);
	textPanel.add(titel);
	textPanel.add(einheiten);

	south.add(textPanel, BorderLayout.NORTH);

	kurs.setBorder(new TitledBorder("Kurs: "));
	list.setBorder(new TitledBorder("Liste aller Kurse: "));
	knr.setBorder(new TitledBorder("Kursnummer: "));
	titel.setBorder(new TitledBorder("Titel: "));
	einheiten.setBorder(new TitledBorder("Einheiten(in Nr): "));


	panel.add(south, BorderLayout.SOUTH);
	JPanel buttonPanel = new JPanel();
	buttonPanel.add(buttonOK);
	buttonPanel.add(buttonDB);
	south.add(buttonPanel, BorderLayout.CENTER);
	buttonPanel.add(buttonAbbrechen);
	south.add(statusAusgabe, BorderLayout.SOUTH);
	
	buttonAbbrechen.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setVisible(false);
		}
	});
	
	buttonDB.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			knr.setText("");
			titel.setText("");
			kurs.setText("");
			einheiten.setText("");
		}
	});
	
setTitle("Kurse Verwalten");
setSize(540, 300);	
setVisible(true); 
setLocation(100, 100); 
setDefaultCloseOperation(EXIT_ON_CLOSE);
getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));


	}


public static void main(String[] args) {
	// TODO Auto-generated method stub
	AdminKursWindow akw = new AdminKursWindow();
	akw.setVisible(true);
	}
}