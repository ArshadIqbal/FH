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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class StudentWindow extends JFrame {

	private JTextField infoText = new JTextField("Willkommen, ");

	private DefaultListModel<String> model = new DefaultListModel<>();
	private JList<String> listeKurse = new JList<>(model);
	JScrollPane scrollkurse = new JScrollPane(listeKurse);
	
	private DefaultListModel<Lektionen> model2 = new DefaultListModel<>();
	private JList<Lektionen> listeLektionen = new JList<>(model2);
	JScrollPane scrollswich= new JScrollPane(listeLektionen);
	
	private SQLStatements mysql = new SQLStatements();
	
	ArrayList<Lektionen> alleLektionen = new ArrayList<>();
	static Lektionen o = null;

	private JLabel statusAusgabe = new JLabel("keine Meldungen");

	private JButton buttonAbbrechen = new JButton("Beenden");

public StudentWindow(){
	
	alleLektionen = mysql.selectAll();
	for(Lektionen l: alleLektionen) {
		model2.addElement(l);
	}
	
	JPanel panel = new JPanel();

	getContentPane().add(panel);
	panel.setLayout(null);
	infoText.setFont(new Font("Tahoma", Font.BOLD, 13));
	infoText.setEditable(false);
	infoText.setBounds(7, 7, 310, 44);
	panel.add(infoText);
	scrollkurse.setBounds(7, 62, 151, 132);
	
	panel.add(scrollkurse);
	scrollkurse.setBorder(new TitledBorder("Liste aller Kurse: "));
	
	listeKurse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
	listeKurse.addListSelectionListener(new ListSelectionListener() {	//Je nach RadioButton werden Studis oder Lektionen gezeigt

		@Override
		public void valueChanged(ListSelectionEvent e) {
			}

		});
	scrollswich.setBounds(162, 62, 155, 132);
	
	panel.add(scrollswich);
	scrollswich.setBorder(new TitledBorder("Liste der Lektionen: "));
	buttonAbbrechen.setBounds(7, 205, 113, 23);
	
	getContentPane().add(panel);
	JButton btnLektionBeginnen = new JButton("Lektion beginnen");
	btnLektionBeginnen.setBounds(162, 205, 155, 23);
	panel.add(btnLektionBeginnen);
		
	
	panel.add(buttonAbbrechen);
	
	buttonAbbrechen.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setVisible(false);
		}
	});
	
	btnLektionBeginnen.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(listeLektionen.isSelectionEmpty()) {
				statusAusgabe.setText("Bitte wählen Sie etwas aus!");
			}else {
			o = listeLektionen.getSelectedValue();
			LectureWindow slw = new LectureWindow();
			}
		}
	});
	
	
setTitle("Students Bereich");
setSize(400, 300);	
setVisible(true); 
setLocation(100, 100); 
setDefaultCloseOperation(EXIT_ON_CLOSE);

}

public static Lektionen getLektionen() {
	return o;
}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	StudentWindow tw = new StudentWindow();
	tw.setVisible(true);
	}
}