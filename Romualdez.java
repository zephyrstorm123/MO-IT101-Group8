package LoginSys;



import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Romualdez {
	 JFrame frame = new JFrame();
	 JTextField textField = new JTextField();
	 JTextField txtJoseCrisostomo = new JTextField();
	 JTextField txtFebruary = new JTextField();
	 JTextField txtStrackeVia = new JTextField();
	 JTextField textField_4 = new JTextField();
	 private JTextField txtaUptonIsle;
	 
	 Romualdez(){
		 
		 frame.getContentPane().setBackground(new Color(255, 0, 255));
			frame.setBounds(0, 0, 480, 360);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			frame.setVisible(true);
			JLabel lblNewLabel = new JLabel("Dashboard");
			lblNewLabel.setForeground(new Color(0, 0, 0));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 18));
			lblNewLabel.setBounds(110, 11, 224, 34);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_1.setBounds(49, 66, 57, 14);
			frame.getContentPane().add(lblNewLabel_1);
			
			JLabel lblNewLabel_1_1 = new JLabel("Employee Number:");
			lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_1_1.setBounds(49, 91, 119, 14);
			frame.getContentPane().add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("Name:");
			lblNewLabel_1_1_1.setForeground(new Color(0, 0, 0));
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_1_1_1.setBounds(49, 127, 119, 14);
			frame.getContentPane().add(lblNewLabel_1_1_1);
			
			JLabel lblNewLabel_1_1_2 = new JLabel("Birthday:");
			lblNewLabel_1_1_2.setForeground(new Color(0, 0, 0));
			lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_1_1_2.setBounds(49, 164, 119, 14);
			frame.getContentPane().add(lblNewLabel_1_1_2);
			
			JLabel lblNewLabel_1_1_3 = new JLabel("Address:");
			lblNewLabel_1_1_3.setForeground(new Color(0, 0, 0));
			lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_1_1_3.setBounds(49, 203, 119, 14);
			frame.getContentPane().add(lblNewLabel_1_1_3);
			
			JLabel lblNewLabel_1_1_4 = new JLabel("Phone Number:");
			lblNewLabel_1_1_4.setForeground(new Color(0, 0, 0));
			lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_1_1_4.setBounds(49, 245, 119, 14);
			frame.getContentPane().add(lblNewLabel_1_1_4);
			
			textField = new JTextField();
			textField.setForeground(new Color(0, 0, 0));
			textField.setEditable(false);
			textField.setBackground(new Color(255, 0, 255));
			textField.setFont(new Font("STZhongsong", Font.BOLD, 14));
			textField.setText("10005");
			textField.setBounds(178, 89, 57, 20);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
			
			txtJoseCrisostomo = new JTextField();
			txtJoseCrisostomo.setForeground(new Color(0, 0, 0));
			txtJoseCrisostomo.setEditable(false);
			txtJoseCrisostomo.setBackground(new Color(255, 0, 255));
			txtJoseCrisostomo.setFont(new Font("STZhongsong", Font.BOLD, 14));
			txtJoseCrisostomo.setText("Alice Romualdez");
			txtJoseCrisostomo.setColumns(10);
			txtJoseCrisostomo.setBounds(178, 125, 126, 20);
			frame.getContentPane().add(txtJoseCrisostomo);
			
			txtFebruary = new JTextField();
			txtFebruary.setForeground(new Color(0, 0, 0));
			txtFebruary.setEditable(false);
			txtFebruary.setFont(new Font("STZhongsong", Font.BOLD, 14));
			txtFebruary.setText("May 14, 1992");
			txtFebruary.setBackground(new Color(255, 0, 255));
			txtFebruary.setColumns(10);
			txtFebruary.setBounds(178, 162, 155, 20);
			frame.getContentPane().add(txtFebruary);
			
			txtStrackeVia = new JTextField();
			txtStrackeVia.setForeground(new Color(0, 0, 0));
			txtStrackeVia.setEditable(false);
			txtStrackeVia.setText("12A/33 Upton Isle Apt. 420, Roxas City 1814 Surigao del Norte ");
			txtStrackeVia.setFont(new Font("STZhongsong", Font.BOLD, 10));
			txtStrackeVia.setBackground(new Color(255, 0, 255));
			txtStrackeVia.setColumns(10);
			txtStrackeVia.setBounds(178, 203, 234, 21);
			frame.getContentPane().add(txtStrackeVia);
			
			txtaUptonIsle = new JTextField();
			txtaUptonIsle.setForeground(new Color(0, 0, 0));
			txtaUptonIsle.setHorizontalAlignment(SwingConstants.CENTER);
			txtaUptonIsle.setText("983-606-799");
			txtaUptonIsle.setFont(new Font("STZhongsong", Font.BOLD, 14));
			txtaUptonIsle.setBackground(new Color(255, 0, 255));
			txtaUptonIsle.setColumns(10);
			txtaUptonIsle.setBounds(178, 243, 126, 20);
			frame.getContentPane().add(txtaUptonIsle);
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBackground(new Color(255, 0, 255));
			frame.setJMenuBar(menuBar);
			
			JMenu mnNewMenu = new JMenu("Menu");
			mnNewMenu.setForeground(new Color(0, 0, 0));
			mnNewMenu.setBackground(new Color(255, 128, 255));
			mnNewMenu.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
			menuBar.add(mnNewMenu);
			
			JMenuItem mntmNewMenuItem = new JMenuItem("Hours Worked");
			mntmNewMenuItem.setForeground(new Color(0, 0, 0));
			mntmNewMenuItem.setBackground(new Color(255, 128, 255));
			mnNewMenu.add(mntmNewMenuItem);
			
			JMenuItem mntmNewMenuItem_1 = new JMenuItem("Payslip");
			mntmNewMenuItem_1.setForeground(new Color(0, 0, 0));
			mntmNewMenuItem_1.setBackground(new Color(255, 128, 255));
			mnNewMenu.add(mntmNewMenuItem_1);
			
			JMenuItem mntmNewMenuItem_2 = new JMenuItem("Logout");
			mntmNewMenuItem_2.setForeground(new Color(0, 0, 0));
			mntmNewMenuItem_2.setBackground(new Color(255, 128, 255));
			mnNewMenu.add(mntmNewMenuItem_2);
		 
	 }

	public static void main(Object object) {
		// TODO Auto-generated method stub
		
	}

}
