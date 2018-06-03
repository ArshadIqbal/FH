package projekt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.UIManager;
import java.awt.Color;

public class TeacherStudentWindow extends JFrame{
	
	private DefaultListModel<String> model = new DefaultListModel<>();
	private JList<String> listeKurse = new JList<>(model);
	JScrollPane scrollkurse = new JScrollPane(listeKurse);
	
	private DefaultListModel<String> model2 = new DefaultListModel<>();
	private JList<String> listeStudents = new JList<>(model2);
	JScrollPane scrollstudents = new JScrollPane();
	
	private DefaultListModel<String> model3 = new DefaultListModel<>();
	private JList<String> listeAlleStudents = new JList<>(model3);
	private final JScrollPane scrollPane = new JScrollPane();
	
	
	public TeacherStudentWindow() {
		
		
		
		
		JPanel panel = new JPanel();

		getContentPane().add(panel);
		panel.setLayout(null);
		scrollkurse.setBounds(7, 11, 190, 132);
		
		panel.add(scrollkurse);
		scrollkurse.setBorder(new TitledBorder("Liste aller Kurse: "));
		
		listeKurse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		listeKurse.addListSelectionListener(new ListSelectionListener() {	//Je nach RadioButton werden Studis oder Lektionen gezeigt

			@Override
			public void valueChanged(ListSelectionEvent e) {
				}

			});
		scrollstudents.setBounds(7, 153, 190, 132);
		
		panel.add(scrollstudents);
		scrollstudents.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Liste der Studenten", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollstudents.setColumnHeaderView(listeStudents);
		
		JLabel status = DefaultComponentFactory.getInstance().createLabel("Statusanzeige");
		status.setBounds(10, 297, 187, 14);
		panel.add(status);
		
		JButton add = new JButton("Hinzuf\u00FCgen");
		add.setBounds(228, 167, 130, 23);
		panel.add(add);
		
		JButton delete = new JButton("L\u00F6schen");
		delete.setBounds(228, 201, 130, 23);
		panel.add(delete);
		
		JButton btnBeenden = new JButton("Beenden");
		btnBeenden.setBounds(269, 277, 89, 23);
		panel.add(btnBeenden);
		
		scrollPane.setBounds(205, 11, 169, 132);
		panel.add(scrollPane);
		scrollPane.setViewportView(listeAlleStudents);
		listeAlleStudents.setBorder(new TitledBorder(null, "Lister aller Studenten", TitledBorder.LEADING, TitledBorder.TOP, null, null));


		btnBeenden.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 setVisible(false);
			}
		});
		
	setTitle("Lektoren Bereich");
	setSize(400, 350);	
	setVisible(true); 
	setLocation(100, 100); 
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
