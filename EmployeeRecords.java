import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class EmployeeRecords {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeRecords window = new EmployeeRecords();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeeRecords() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"10001", "Crisostomo", "Jose", "49-1632020-8", "382189453145", "317-674-022-000", "441093369646"},
				{"10002", "Mata ", "Christian", "49-2959312-6", "824187961962", "103-100-522-000", "631052853464"},
				{"10003", "San Jose", "Brad", "40-2400714-1", "239192926939", "672-474-690-000", "210850209964"},
			},
			new String[] {
				"Employee Number", "Last Name", "First Name", "SSS #", "PhilHealth #", "TIN ", "PagIBIG #"
			}
		));
	}
}
