package projekt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;

public class TeacherLectureWindow extends JFrame{

	private JButton buttonAbbrechen = new JButton("Beenden");
	private JTextField info;
	private JTextField auf1;
	private JTextField info1;
	private JTextField txtLektionErstellen;
	private JTextField auf2;
	private JTextField info2;
	
	public TeacherLectureWindow() {
		JPanel panel = new JPanel();

		getContentPane().add(panel);
		panel.setLayout(null);
		buttonAbbrechen.setBounds(249, 277, 113, 23);
		
		getContentPane().add(panel);
			
		
		panel.add(buttonAbbrechen);
		
		info = new JTextField();
		info.setBounds(7, 50, 355, 42);
		panel.add(info);
		info.setColumns(10);
		info.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Information zur Lektion eingeben", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		auf1 = new JTextField();
		auf1.setBounds(7, 94, 355, 42);
		panel.add(auf1);
		auf1.setColumns(10);
		auf1.setBorder(new TitledBorder(null, "Aufgabe 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		info1 = new JTextField();
		info1.setBounds(7, 135, 355, 42);
		panel.add(info1);
		info1.setColumns(10);
		info1.setBorder(new TitledBorder(null, "Information Aufgabe 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton verwerfen = new JButton("Verwerfen");
		verwerfen.setBounds(126, 277, 113, 23);
		panel.add(verwerfen);
		
		JButton ok = new JButton("Ok");
		ok.setBounds(7, 277, 113, 23);
		panel.add(ok);
		
		txtLektionErstellen = new JTextField();
		txtLektionErstellen.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtLektionErstellen.setText("Lektion erstellen");
		txtLektionErstellen.setEditable(false);
		txtLektionErstellen.setBounds(7, 11, 355, 31);
		panel.add(txtLektionErstellen);
		txtLektionErstellen.setColumns(10);
		
		auf2 = new JTextField();
		auf2.setColumns(10);
		auf2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Aufgabe 2", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		auf2.setBounds(10, 184, 352, 42);
		panel.add(auf2);
		
		info2 = new JTextField();
		info2.setColumns(10);
		info2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Information Aufgabe 2", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		info2.setBounds(7, 224, 355, 42);
		panel.add(info2);
		
		JLabel status = DefaultComponentFactory.getInstance().createLabel("Keine Meldung");
		status.setBounds(7, 307, 311, 14);
		panel.add(status);
		
		buttonAbbrechen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
		verwerfen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				info.setText("");
				info1.setText("");
				info2.setText("");
				auf1.setText("");
				auf2.setText("");
				
			}
		});
		
		setTitle("Lektion");
		setSize(400, 360);	
		setVisible(true); 
		setLocation(100, 100); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
