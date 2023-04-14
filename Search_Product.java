import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;

public class Search_Product extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private DefaultTableModel tmodel;

	/**
	 * Launch the application.
	 */
	void disp() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dalima_salse?user=root&password=root");
		String query = "select * from inventry ";
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet result = statement.executeQuery();
		ResultSetMetaData rsmd = (ResultSetMetaData) result.getMetaData();
		tmodel = new DefaultTableModel();
		for (int i =1 ; i <= rsmd.getColumnCount(); i++ ) {
			tmodel.addColumn(rsmd.getColumnName(i));
		}
		while(result.next()) {
			String row[]= new String[rsmd.getColumnCount()];
			for (int i =1 ; i <= rsmd.getColumnCount(); i++ ) {
				row[i-1]= result.getString(i);
				
				
			}
			tmodel.addRow(row);
			
			
		}
		table.setModel(tmodel);
		connection.close();
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	
	void disp(String s) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dalima_salse?user=root&password=root");
		String query = "select * from inventry where `Product _Catagory`='"+s+"'";
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet result = statement.executeQuery();
		ResultSetMetaData rsmd = (ResultSetMetaData) result.getMetaData();
		tmodel = new DefaultTableModel();
		for (int i =1 ; i <= rsmd.getColumnCount(); i++ ) {
			tmodel.addColumn(rsmd.getColumnName(i));
		}
		while(result.next()) {
			String row[]= new String[rsmd.getColumnCount()];
			for (int i =1 ; i <= rsmd.getColumnCount(); i++ ) {
				row[i-1]= result.getString(i);
				
				
			}
			tmodel.addRow(row);
			
			
		}
		table.setModel(tmodel);
		connection.close();
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	void disp(int p) {
		String q = String.valueOf(p);
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dalima_salse?user=root&password=root");
		String query = "select * from inventry where `Chassis_no`='"+q+"'";
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet result = statement.executeQuery();
		ResultSetMetaData rsmd = (ResultSetMetaData) result.getMetaData();
		tmodel = new DefaultTableModel();
		for (int i =1 ; i <= rsmd.getColumnCount(); i++ ) {
			tmodel.addColumn(rsmd.getColumnName(i));
		}
		while(result.next()) {
			String row[]= new String[rsmd.getColumnCount()];
			for (int i =1 ; i <= rsmd.getColumnCount(); i++ ) {
				row[i-1]= result.getString(i);
				
				
			}
			tmodel.addRow(row);
			
			
		}
		table.setModel(tmodel);
		connection.close();
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	
	public Search_Product() {
		//setFrameIcon(new ImageIcon("C:\\Users\\aditya\\Desktop\\dalmia.png"));
		setClosable(true);
		setTitle("Search Product");
		setResizable(true);
		setIconifiable(true);
		setBounds(100, 100, 850, 541);
		getContentPane().setLayout(null);
		
		JLabel lblcn = new JLabel("Chassis No. :");
		lblcn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcn.setBounds(10, 10, 113, 43);
		getContentPane().add(lblcn);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//disp
				disp(Integer.parseInt(textField.getText()));
				
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(140, 10, 288, 43);
		getContentPane().add(textField);
		
		JLabel lblProduct = new JLabel("Product :");
		lblProduct.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProduct.setBounds(10, 63, 113, 43);
		getContentPane().add(lblProduct);
		
		JComboBox<Object> category = new JComboBox<Object>();
		category.setModel(new DefaultComboBoxModel<Object>(new String[] {"EV Bike", "EV Scooter", "EV Rikshaw", "EV Trailer"}));
		category.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				disp(category.getSelectedItem().toString());
			}
		});
		category.setFont(new Font("Tahoma", Font.PLAIN, 15));
		category.setBounds(140, 63, 288, 43);
		getContentPane().add(category);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 122, 804, 362);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		disp();

	}
}
