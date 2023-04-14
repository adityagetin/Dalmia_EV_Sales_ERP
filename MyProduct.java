import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyProduct extends JInternalFrame {

	private DefaultTableModel tmodel;

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
	
	private static final long serialVersionUID = 1L;
	private JComboBox<?> comboBox;
	private JTable table;
	private JScrollPane scrollPane;

	public MyProduct() {
		setTitle("My Products");
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 384, 578);
		getContentPane().setLayout(null);
		table = new JTable();
		disp();
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				disp(comboBox.getSelectedItem().toString());
				System.out.println("Hello"+comboBox.getSelectedItem().toString());
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"EV Bike", "EV Scooter", "EV Rikshaw", "EV Trailer"}));
		comboBox.setBounds(0, 0, 372, 47);
		getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Select Product");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				int row = table.getSelectedRow();
				Sales.Product_id =table.getModel().getValueAt(row, 0).toString();
				Sales.Chassis_no = table.getModel().getValueAt(row, 1).toString();
				Sales.Product_category =table.getModel().getValueAt(row, 2).toString();
				Sales.Price =table.getModel().getValueAt(row, 3).toString();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(0, 511, 372, 38);
		getContentPane().add(btnNewButton);
		
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setBounds(10, 62, 352, 439);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 352, 444);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		disp();
		

		

	}
}
