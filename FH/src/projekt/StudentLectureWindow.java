
package projekt;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class StudentLectureWindow extends JFrame{

	private JLabel statusAusgabe = new JLabel("keine Meldungen");

	private JButton buttonAbbrechen = new JButton("Beenden");
	private JTextField info1;
	private JTextField loesung1;
	private JTextField info2;
	private JTextField loesung2;
	private JTextField hilfestellung;
	
	public StudentLectureWindow() {
		
		JPanel panel = new JPanel();

		getContentPane().add(panel);
		panel.setLayout(null);
		buttonAbbrechen.setBounds(7, 247, 113, 23);
		
		getContentPane().add(panel);
			
		
		panel.add(buttonAbbrechen);
		
		info1 = new JTextField();
		info1.setEditable(false);
		info1.setBounds(7, 50, 269, 42);
		panel.add(info1);
		info1.setColumns(10);
		info1.setBorder(new TitledBorder("�bung 1:"));
		
		loesung1 = new JTextField();
		loesung1.setBounds(7, 94, 269, 42);
		panel.add(loesung1);
		loesung1.setColumns(10);
		loesung1.setBorder(new TitledBorder("L�sung:"));
		
		info2 = new JTextField();
		info2.setEditable(false);
		info2.setBounds(7, 143, 269, 42);
		panel.add(info2);
		info2.setColumns(10);
		info2.setBorder(new TitledBorder("�bung 2:"));
		
		loesung2 = new JTextField();
		loesung2.setBounds(7, 184, 269, 42);
		panel.add(loesung2);
		loesung2.setColumns(10);
		loesung2.setBorder(new TitledBorder("L�sung:"));
		
		JButton hilfe1 = new JButton("Hilfe");
		hilfe1.setBounds(285, 113, 89, 23);
		panel.add(hilfe1);
		
		JButton ok2 = new JButton("Ok");
		ok2.setBounds(285, 162, 89, 23);
		panel.add(ok2);
		
		JButton hilfe2 = new JButton("Hilfe");
		hilfe2.setBounds(285, 203, 89, 23);
		panel.add(hilfe2);
		
		JButton ok1 = new JButton("Ok");
		ok1.setBounds(285, 69, 89, 23);
		panel.add(ok1);
		
		hilfestellung = new JTextField();
		hilfestellung.setEditable(false);
		hilfestellung.setBounds(130, 233, 244, 44);
		panel.add(hilfestellung);
		hilfestellung.setColumns(10);
		hilfestellung.setBorder(new TitledBorder("Hilfestellung:"));
		
		JLabel infotext = DefaultComponentFactory.getInstance().createLabel("Infotext zur Lektion");
		infotext.setBounds(10, 11, 364, 34);
		panel.add(infotext);
		
		buttonAbbrechen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
		ok1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loesung1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
			}
		});
		
		ok2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loesung2.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
			}
		});
		
		
		
	setTitle("Lektion");
	setSize(400, 320);	
	setVisible(true); 
	setLocation(100, 100); 
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentLectureWindow slw = new StudentLectureWindow();
		slw.setVisible(true);
		}
	
	
}


