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
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.SpringLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.mysql.jdbc.Statement;


public class AdminWindow extends JFrame {
	
JPanel panel = new JPanel();
private JTextField introText;
private JTextField infoText;
private static String vorname = null;
private static String nachName = null;


public AdminWindow(String name){
	

getContentPane().add(panel);
panel.setLayout(null);
introText = new JTextField("Willkommen, " + getAdminName(name)); //AdminName
introText.setFont(new Font("Tahoma", Font.BOLD, 13));
introText.setEditable(false);
introText.setBounds(10, 11, 464, 20);
panel.add(introText);
introText.setColumns(10);
infoText = new JTextField("Was möchten Sie tun?");
infoText.setEditable(false);
infoText.setBounds(10, 40, 180, 20);
panel.add(infoText);
infoText.setColumns(10);
JButton btnStudent = new JButton("Studenten Verwaltung");
btnStudent.setBounds(10, 78, 180, 23);
panel.add(btnStudent);
JButton btnLektor = new JButton("Lektoren Verwaltung");
btnLektor.setBounds(10, 112, 180, 23);
panel.add(btnLektor);
JButton btnKurs = new JButton("Kurse Verwaltung");
btnKurs.setBounds(10, 146, 180, 23);
panel.add(btnKurs);
JButton btnZurStudentenansicht = new JButton("Zur Studentenansicht");
btnZurStudentenansicht.setBounds(10, 197, 180, 23);
panel.add(btnZurStudentenansicht);
JButton btnZurLektorenansicht = new JButton("Zur Lektorenansicht");
btnZurLektorenansicht.setBounds(10, 227, 180, 23);
panel.add(btnZurLektorenansicht);
JLabel lblAnsichtWechseln = DefaultComponentFactory.getInstance().createLabel("Ansicht wechseln");
lblAnsichtWechseln.setBounds(10, 180, 180, 14);
panel.add(lblAnsichtWechseln);
JLabel lblVerwaltung = DefaultComponentFactory.getInstance().createLabel("Verwaltung");
lblVerwaltung.setBounds(10, 63, 92, 14);
panel.add(lblVerwaltung);
JLabel profilePicHolder = DefaultComponentFactory.getInstance().createLabel("InsertPic");
profilePicHolder.setBounds(277, 43, 140, 126);
panel.add(profilePicHolder);
JLabel lblVorname = DefaultComponentFactory.getInstance().createLabel("Vorname:");
lblVorname.setBounds(263, 180, 78, 14);
panel.add(lblVorname);
JLabel vn = DefaultComponentFactory.getInstance().createLabel(vorname);
vn.setBounds(339, 180, 92, 14);
panel.add(vn);
JLabel lblNachname = DefaultComponentFactory.getInstance().createLabel("Nachname: ");
lblNachname.setBounds(264, 201, 92, 14);
panel.add(lblNachname);
JLabel nn = DefaultComponentFactory.getInstance().createLabel(nachName);
nn.setBounds(339, 201, 92, 14);
panel.add(nn);
JButton btnBeenden = new JButton("Beenden");
btnBeenden.setBounds(385, 227, 89, 23);
panel.add(btnBeenden);

btnBeenden.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dispose();
	}
});

btnStudent.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		AdminStudentWindow asw = new AdminStudentWindow();
		asw.setVisible(true);
	}
});

btnZurStudentenansicht.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		StudentWindow sw = new StudentWindow();
		sw.setVisible(true);
		
	}
});

btnLektor.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		AdminTeacherWindow atw = new AdminTeacherWindow();
		atw.setVisible(true);
	}
});

btnZurLektorenansicht.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		TeacherWindow tw = new TeacherWindow();
		tw.setVisible(true);
	}
});

btnKurs.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		AdminKursWindow akw = new AdminKursWindow();
		akw.setVisible(true);
		
	}
});

setTitle("Verwaltung");
setSize(500, 300);	
setVisible(true); 
setLocation(100, 100); 
setDefaultCloseOperation(EXIT_ON_CLOSE);


	}

public static String getAdminName(String user) {
	ResultSet rs;
	Statement st;
	
	String SQLStatement = "select vorName, nachName from Admin where Username = '" + user + "'";

	try {
		Connection con = Connect.getConnection();
		st = (Statement) con.createStatement();
		rs = st.executeQuery(SQLStatement);
		while (rs.next()) {
			vorname = rs.getString(1);
			nachName = rs.getString(2);
			
		}
		
	} catch (Exception e) {
		System.out.println(e.getLocalizedMessage());
	}
	
	return vorname + " " +  nachName;
}

}