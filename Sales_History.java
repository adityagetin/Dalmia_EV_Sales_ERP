import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.FileWriter;   
import java.io.IOException;

public class Sales_History extends JInternalFrame {
	private JTextField ref;
	private JTable table;
	private DefaultTableModel tmodel;
	static private String p_id_print;
	static private String cn_print;
	static private String rn_print;
	static private String On_print;
	static private String Mob_print;
	static private String Address_print;
	static private String Price_print;
	static private String category_print;
	static private String Dos_print;
	static private int gst;
	static private int total;

	void disp(String s) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dalima_salse?user=root&password=root");
		String query = "select * from soled_product where Reg_no ='"+s+"'";
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
	void disp() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dalima_salse?user=root&password=root");
		String query = "select * from soled_product ";
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
	
	public Sales_History() {
		setTitle("Sales History");
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 664, 492);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reg. No :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 10, 97, 38);
		getContentPane().add(lblNewLabel);
		

		
		table = new JTable();
		table.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBackground(new Color(0, 128, 255));
		table.setBounds(10,67, 628, 367);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 632, 362);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		disp();
		
		JButton Bill = new JButton("Generate Bill");
		Bill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//billcode
				int row = table.getSelectedRow();
				//System.out.println(row);
				p_id_print = table.getValueAt(row,0).toString();
				System.out.println(p_id_print);
				cn_print = table.getValueAt(row,1).toString();
				System.out.println(cn_print);
				rn_print = table.getValueAt(row,2).toString();
				On_print = table.getValueAt(row,3).toString();
				Mob_print = table.getValueAt(row,4).toString();
				Address_print = table.getValueAt(row,5).toString();
				Price_print = table.getValueAt(row,6).toString();
				category_print= table.getValueAt(row,7).toString();
				Dos_print = table.getValueAt(row,8).toString();
				int k = 0;
				while(k==0) {
					try {
						JFrame f = new JFrame();
						String G_s_t= JOptionPane.showInputDialog(f,"Enter the GST for:"+category_print+"");
						gst = Integer.parseInt(G_s_t);
						int p= Integer.parseInt(Price_print);
						total =p +((p/100)*gst);
						k = 1;
					}catch(Exception ex){
						JOptionPane.showMessageDialog(null,"Enter the valid Input");
						
					}
					}
				System.out.println(gst);
				System.out.println(total);
				
				
				try {
					FileWriter bills = new FileWriter("d:\\bill.txt");
					bills.write("Dalmia EV"+"\n");
					bills.write("Chassis no : "+cn_print+""+"\n");
					bills.write("Registation no : "+rn_print+""+"\n");
					bills.write("EV Category : "+category_print+""+"\n");
					bills.write("Owners Name : "+On_print+"");
					bills.write("Owners Mobile no : "+Mob_print+""+"\n");
					bills.write("Address : "+Address_print+""+"\n");
					bills.write("Price : "+Price_print+""+"\n");
					bills.write("GST : "+gst+"%"+"\n");
					bills.write("Total Amount : "+total+"/-"+"\n");
					bills.write("Date of sale  : "+Dos_print+""+"\n");
					bills.write(""+"\n");
					bills.write(""+"\n");
					bills.write(""+"\n");
					bills.write("Saler Name:___________________"+"\n");
					bills.write("Signature:_____________________"+"\n");
					bills.write(""+"\n");
					bills.write(""+"\n");
					bills.write(""+"\n");
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
					LocalDateTime now = LocalDateTime.now();  
					bills.write("Print Date&Time : "+now+""+"\n");
					bills.close();
					
					
				}catch(Exception exp) {
					JOptionPane.showMessageDialog(null, exp.getMessage());
				}
					
				
				
			}
		});
		Bill.setFont(new Font("Tahoma", Font.BOLD, 17));
		Bill.setBounds(406, 10, 236, 38);
		getContentPane().add(Bill);
		
		ref = new JTextField();
		ref.addKeyListener(new KeyAdapter() {


			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println(ref.getText().toString());
				disp(ref.getText().toString());
			}
		});
		
		ref.setBounds(113, 10, 283, 38);
		getContentPane().add(ref);
		ref.setColumns(10);
		

	}
}
