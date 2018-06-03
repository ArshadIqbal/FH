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
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.miginfocom.swing.MigLayout;

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
import java.awt.Font;
import com.jgoodies.forms.factories.DefaultComponentFactory;


public class TeacherWindow extends JFrame {

	private JTextField infoText = new JTextField("Willkommen, ");

	private DefaultListModel<String> model = new DefaultListModel<>();
	private JList<String> listeKurse = new JList<>(model);
	JScrollPane scrollkurse = new JScrollPane(listeKurse);
	
	private DefaultListModel<String> model2 = new DefaultListModel<>();
	private JList<String> listeSwitch = new JList<>(model2);
	JScrollPane scrollswich= new JScrollPane();

	private JLabel statusAusgabe = new JLabel("keine Meldungen");

	private JButton buttonAbbrechen = new JButton("Beenden");
	private JButton buttonAnsicht = new JButton("Zur Studentenansicht");
	private JButton buttonAdd = new JButton("Verwalten");
public TeacherWindow(){
	
	JPanel panel = new JPanel();

	getContentPane().add(panel);
	panel.setLayout(null);
	infoText.setFont(new Font("Tahoma", Font.BOLD, 13));
	infoText.setEditable(false);
	infoText.setBounds(7, 7, 495, 51);
	panel.add(infoText);
	scrollkurse.setBounds(7, 62, 161, 132);
	
	panel.add(scrollkurse);
	scrollkurse.setBorder(new TitledBorder("Liste aller Kurse: "));
	
	listeKurse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
	listeKurse.addListSelectionListener(new ListSelectionListener() {	//Je nach RadioButton werden Studis oder Lektionen gezeigt

		@Override
		public void valueChanged(ListSelectionEvent e) {
			}

		});
	scrollswich.setBounds(289, 62, 213, 132);
	
	panel.add(scrollswich);
	scrollswich.setBorder(new TitledBorder("Liste der Studenten/Lektionen: "));
	scrollswich.setColumnHeaderView(listeSwitch);
	buttonAnsicht.setBounds(7, 215, 161, 23);
	
	panel.add(buttonAnsicht);
	buttonAdd.setBounds(178, 150, 101, 23);
	panel.add(buttonAdd);
	buttonAbbrechen.setBounds(178, 215, 144, 23);
	panel.add(buttonAbbrechen);
	
	JRadioButton student = new JRadioButton("Studenten");
	student.setBounds(174, 81, 91, 23);
	panel.add(student);
	
	JRadioButton lektion = new JRadioButton("Lektionen");
	lektion.setBounds(174, 107, 91, 23);
	panel.add(lektion);

	ButtonGroup bb = new ButtonGroup();	
	bb.add(student);
	bb.add(lektion);
	
	buttonAnsicht.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			StudentWindow sw = new StudentWindow();
			sw.setVisible(true);
			setVisible(false);
			
		}
	});
	
	buttonAbbrechen.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setVisible(false);
			
		}
	});
	
	buttonAdd.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(student.isSelected()) {
				TeacherStudentWindow tsw = new TeacherStudentWindow();
				tsw.setVisible(true);
			}
			
			if(lektion.isSelected()) {
				TeacherKursWindow tkw = new TeacherKursWindow();
				tkw.setVisible(true);
			}
		}
	});
	
setTitle("Lektoren Bereich");
setSize(550, 300);	
setVisible(true); 
setLocation(100, 100); 
setDefaultCloseOperation(EXIT_ON_CLOSE);

getContentPane().add(panel);
JLabel lblBitteWhlen = DefaultComponentFactory.getInstance().createLabel("Bitte w\u00E4hlen");
lblBitteWhlen.setBounds(178, 62, 112, 14);
panel.add(lblBitteWhlen);
	}


public static void main(String[] args) {
	// TODO Auto-generated method stub
	TeacherWindow tw = new TeacherWindow();
	tw.setVisible(true);
	}
}