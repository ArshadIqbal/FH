package projekt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.miginfocom.swing.MigLayout;
import javax.swing.JRadioButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.mysql.jdbc.Statement;

public class LogInWindow extends JFrame {
	String username;
	String password;
	private JTextField todo = new JTextField();
	
	private JTextField name = new JTextField();
	private JTextField pw = new JTextField();
	
	private JLabel statusAusgabe = new JLabel("Ich melde falsche Log In Daten");

	private JButton buttonAbbrechen = new JButton("Abbrechen");
	private JButton buttonOk = new JButton("Einloggen");
	
	public LogInWindow() {
		
		JPanel panel = new JPanel();

		getContentPane().add(panel);
		panel.setLayout(null);
		todo.setBounds(6, 6, 261, 33);
		panel.add(todo);
		todo.setEditable(false);
		todo.setText("Bitte geben Sie Ihre Log-In Daten ein");
		pw.setBounds(6, 102, 261, 39);
		panel.add(pw);
		pw.setBorder(new TitledBorder("Passwort eingeben"));
		name.setBounds(6, 51, 261, 39);
		
		panel.add(name);
		name.setBorder(new TitledBorder("Namen eingeben"));
		
		JRadioButton admin = new JRadioButton("Admin");
		admin.setBounds(6, 179, 100, 23);
		panel.add(admin);
		
		JRadioButton lektor = new JRadioButton("Lektor");
		lektor.setBounds(82, 179, 100, 23);
		panel.add(lektor);
		
		JRadioButton student = new JRadioButton("Student");
		student.setBounds(158, 179, 109, 23);
		panel.add(student);

		ButtonGroup bb = new ButtonGroup();	
		bb.add(admin);
		bb.add(lektor);
		bb.add(student);
		
		JLabel lblWhlenSieIhre = DefaultComponentFactory.getInstance().createTitle("Wählen Sie Ihre Log-In Art aus");
		lblWhlenSieIhre.setBounds(10, 153, 218, 14);
		panel.add(lblWhlenSieIhre);
		statusAusgabe.setBounds(6, 254, 261, 14);
		panel.add(statusAusgabe);
		
		JLabel lblNewLabel = new JLabel("");
		//Image img = new ImageIcon(this.getClass().getResource("/Logo.png")).getImage();
		//lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(6, 280, 196, 84);
		panel.add(lblNewLabel);
		buttonAbbrechen.setBounds(137, 214, 109, 28);
		panel.add(buttonAbbrechen);
		buttonOk.setBounds(16, 214, 109, 28);
		panel.add(buttonOk);
		
		
		buttonOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Todo: �berpr�fe, ob der Button ausgew�hlt ist, wenn ja sucht er in der ArrayList nach dem User
				//User not found, oder passwort falsch --> setAusgabe
				
				if(admin.isSelected()) {
					AdminWindow aw = new AdminWindow();
					aw.setVisible(true);
					setVisible(false);
					
					username = name.getText().trim();
					password = pw.getText().trim();
					
					try {
						SQLFunctions.insertAdmin();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				
				if(student.isSelected()) {
					StudentWindow sw = new StudentWindow();
					sw.setVisible(true);
					setVisible(false);
					
					username = name.getText().trim();
					password = pw.getText().trim();
				}
				
				if(lektor.isSelected()) {
					TeacherWindow lw = new TeacherWindow();
					lw.setVisible(true);
					setVisible(false);
					username = name.getText().trim();
					password = pw.getText().trim();
				}
				
				
				
			}

		});
		
		buttonAbbrechen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				dispose();
			}
		});
		

		
		setTitle("User Log-In");
		setSize(310, 400);
		setLocation(50, 50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogInWindow tw = new LogInWindow();
		tw.setVisible(true);
	}*/
}

