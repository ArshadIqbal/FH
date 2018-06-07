
package projekt;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class LectureWindow extends JFrame{

	private JLabel statusAusgabe = new JLabel("keine Meldungen");

	private JButton buttonAbbrechen = new JButton("Beenden");
	private JTextField txtTextWasIst;
	private JTable table;
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JTextArea helptext;
	static Lektionen l;
	private SQLStatements mysql = new SQLStatements();
	
	ArrayList<Lektionen> alleLektionen = new ArrayList<>();
	static Lektionen o = null;
	
	public LectureWindow() {
		l = StudentWindow.getLektionen();
		
		JPanel panel = new JPanel();

		getContentPane().add(panel);
		panel.setLayout(null);
		buttonAbbrechen.setBounds(107, 477, 113, 23);
		
		getContentPane().add(panel);
			
		
		panel.add(buttonAbbrechen);
		
		JLabel infotext = DefaultComponentFactory.getInstance().createLabel(l.getTitel());
		infotext.setFont(new Font("Tahoma", Font.BOLD, 13));
		infotext.setBounds(10, 11, 364, 34);
		panel.add(infotext);
		
		txtTextWasIst = new JTextField();
		txtTextWasIst.setEditable(false);
		txtTextWasIst.setText(l.getBeschreibung());
		txtTextWasIst.setBounds(10, 56, 614, 45);
		txtTextWasIst.setBorder(new TitledBorder("Aufgabe"));
		panel.add(txtTextWasIst);
		txtTextWasIst.setColumns(10);
		
		table = new JTable(tableModel);
		table.setBorder(null);
		table.setBounds(305, 112, 419, 206);
		panel.add(table);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(20, 256, 269, 62);
		panel.add(scrollPane_2);
		
		helptext = new JTextArea();
		scrollPane_2.setViewportView(helptext);
		helptext.setBorder(new TitledBorder(null, "Help", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		helptext.setColumns(10);
		
		JButton btnTry = new JButton("Try");
		btnTry.setBounds(107, 222, 89, 23);
		panel.add(btnTry);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(20, 435, 89, 23);
		panel.add(btnHelp);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 112, 269, 87);
		panel.add(scrollPane_1);
		
		JTextArea sqltext = new JTextArea();
		scrollPane_1.setViewportView(sqltext);
		sqltext.setColumns(10);
		sqltext.setBorder(new TitledBorder("Try Sql Statement"));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(20, 337, 375, 87);
		panel.add(scrollPane_3);
		
		JTextArea loesung = new JTextArea();
		scrollPane_3.setViewportView(loesung);
		loesung.setColumns(10);
		loesung.setBorder(new TitledBorder(null, "L�sung", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnLsung = new JButton("L�sung");
		btnLsung.setBounds(183, 435, 89, 23);
		panel.add(btnLsung);
		
		DefaultListModel<Lektionen> model = new DefaultListModel<>();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(405, 329, 319, 170);
		panel.add(scrollPane);
		JList<Lektionen> list = new JList(model);
		scrollPane.setViewportView(list);
		list.setBorder(new TitledBorder(null, "Chose Lecture", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
		alleLektionen = mysql.selectAll();
		for(Lektionen l: alleLektionen) {
			model.addElement(l);
		}
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				l = list.getSelectedValue();
				infotext.setText(l.getTitel());
				txtTextWasIst.setText(l.getBeschreibung());
				helptext.setText("");
				loesung.setText("");
				table.setModel(tableModel);
			}
		});
		

		buttonAbbrechen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
		btnHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				helptext.setText(l.getHilfestellung());
			}
		});
		
		btnLsung.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loesung.setText(l.getLoesung());
				
				table.setModel(mysql.getResultAsTableModel(l.getLoesung()));
			}
		});
		
		btnTry.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
				table.setModel(mysql.getResultAsTableModel(sqltext.getText()));
				}catch(Exception exc){
					sqltext.setText("this doesn't work");
				}
			}
		});
		
		
	setTitle("Lektion");
	setSize(750, 550);	
	setVisible(true); 
	setLocation(100, 100); 
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LectureWindow tw = new LectureWindow();
		tw.setVisible(true);
		}*/
	}


