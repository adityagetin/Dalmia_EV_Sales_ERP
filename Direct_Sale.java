import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.lang.*;
import java.awt.Font;
import javax.swing.JTextField;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Direct_Sale extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField p_id;
	private JTextField cn;
	private JTextField rn;
	private JTextField On;
	private JTextField Mob;
	private JTextField Address;
	private JTextField Price;
	private JTextField category;
	private JTextField Dos;

	public Direct_Sale() {
		setTitle("Direct Sale");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 452, 538);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product Id : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 10, 113, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel lblChassisNo = new JLabel("Chassis no : ");
		lblChassisNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChassisNo.setBounds(10, 54, 113, 34);
		getContentPane().add(lblChassisNo);
		
		JLabel lblRegNo = new JLabel("Reg. No.  : ");
		lblRegNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegNo.setBounds(10, 98, 113, 34);
		getContentPane().add(lblRegNo);
		
		JLabel lblOwnersName = new JLabel("Owner's name : ");
		lblOwnersName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOwnersName.setBounds(10, 142, 125, 34);
		getContentPane().add(lblOwnersName);
		
		JLabel lblMobileNo = new JLabel("Mobile no . : ");
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMobileNo.setBounds(10, 190, 113, 34);
		getContentPane().add(lblMobileNo);
		
		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(10, 246, 113, 34);
		getContentPane().add(lblAddress);
		
		JLabel lblPrice = new JLabel("Price: ");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(10, 290, 113, 34);
		getContentPane().add(lblPrice);
		
		JLabel lblCategory = new JLabel("Category: ");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategory.setBounds(10, 334, 113, 34);
		getContentPane().add(lblCategory);
		
		JLabel lblDateOfPurchase = new JLabel("Date Of Purchase : ");
		lblDateOfPurchase.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateOfPurchase.setBounds(10, 378, 148, 34);
		getContentPane().add(lblDateOfPurchase);
		
		p_id = new JTextField();
		p_id.setBounds(207, 13, 223, 34);
		getContentPane().add(p_id);
		p_id.setColumns(10);
		
		cn = new JTextField();
		cn.setColumns(10);
		cn.setBounds(207, 64, 223, 34);
		getContentPane().add(cn);
		
		rn = new JTextField();
		rn.setColumns(10);
		rn.setBounds(207, 108, 223, 34);
		getContentPane().add(rn);
		
		On = new JTextField();
		On.setColumns(10);
		On.setBounds(207, 152, 223, 34);
		getContentPane().add(On);
		
		Mob = new JTextField();
		Mob.setColumns(10);
		Mob.setBounds(207, 200, 223, 34);
		getContentPane().add(Mob);
		
		Address = new JTextField();
		Address.setColumns(10);
		Address.setBounds(106, 256, 324, 34);
		getContentPane().add(Address);
		
		Price = new JTextField();
		Price.setColumns(10);
		Price.setBounds(207, 300, 223, 34);
		getContentPane().add(Price);
		
		category = new JTextField();
		category.setColumns(10);
		category.setBounds(207, 344, 223, 34);
		getContentPane().add(category);
		
		Dos = new JTextField();
		Dos.setColumns(10);
		Dos.setBounds(207, 388, 223, 34);
		getContentPane().add(Dos);
		
		JButton btngetData = new JButton("Get Data");
		btngetData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// get data
				p_id.setText(Sales.Product_id);
				cn.setText(Sales.Chassis_no);
				Price.setText(Sales.Price);
				category.setText(Sales.Product_category);
			}
		});
		btngetData.setFont(new Font("Tahoma", Font.BOLD, 14));
		btngetData.setBounds(10, 465, 148, 34);
		getContentPane().add(btngetData);
		
		JButton btnSold = new JButton("Sold");
		btnSold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Sold 
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dalima_salse?user=root&password=root");
					java.lang.String query = "INSERT INTO soled_product VALUES(?,?,?,?,?,?,?,?,?)";
					PreparedStatement statement = connection.prepareStatement(query);
					
					statement.setString(1,p_id.getText());
					statement.setString(2,cn.getText());
					statement.setString(3,rn.getText());
					statement.setString(4,On.getText());
					statement.setString(5,Mob.getText());
					statement.setString(6,Address.getText());
					statement.setString(7,Price.getText());
					statement.setString(8,category.getText());
					statement.setString(9,Dos.getText());
					JOptionPane.showMessageDialog(null,"Data Saved");
					statement.executeUpdate();
					
					
					java.lang.String q2= "DELETE FROM inventry WHERE Product_ID ='"+p_id.getText()+"' ";
					PreparedStatement s2 = connection.prepareStatement(q2);
					s2.executeUpdate();
					
					
					connection.close();
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null ,e1.getMessage());
					
				}
				
			}
		});
		btnSold.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSold.setBounds(282, 465, 148, 34);
		getContentPane().add(btnSold);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					p_id.setText("");
					cn.setText("");
					rn.setText("");
					On.setText("");
					Mob.setText("");
					Address.setText("");
					Price.setText("");
					category.setText("");
					Dos.setText("");
					
					

			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setBounds(178, 465, 80, 34);
		getContentPane().add(btnClear);

	}
}
