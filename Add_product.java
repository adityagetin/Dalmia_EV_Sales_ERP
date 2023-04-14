import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_product extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfcn;
	private JTextField tfPrice;

	public Add_product() {
		//setFrameIcon(new ImageIcon("C:\\Users\\aditya\\Desktop\\dalmia.png"));
		setTitle("Add Product");
		setIconifiable(true);
		setBounds(100, 100, 451, 396);
		getContentPane().setLayout(null);
		
		JLabel lblcn = new JLabel("Chassis No. :");
		lblcn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcn.setBounds(10, 87, 113, 43);
		getContentPane().add(lblcn);
		
		tfcn = new JTextField();
		tfcn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfcn.setBounds(140, 87, 288, 43);
		getContentPane().add(tfcn);
		tfcn.setColumns(10);
		
		JComboBox<Object> category = new JComboBox<Object>();
		category.setModel(new DefaultComboBoxModel<Object>(new String[] {"EV Bike", "EV Scooter", "EV Rikshaw", "EV Trailer"}));
		category.setFont(new Font("Tahoma", Font.PLAIN, 15));
		category.setBounds(140, 140, 288, 43);
		getContentPane().add(category);
		
		tfPrice = new JTextField();
		tfPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfPrice.setColumns(10);
		tfPrice.setBounds(140, 204, 288, 43);
		getContentPane().add(tfPrice);
		
		JLabel lblPrice = new JLabel("Price  :");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(10, 204, 113, 43);
		getContentPane().add(lblPrice);
		
		JLabel lblProduct = new JLabel("Product :");
		lblProduct.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProduct.setBounds(10, 140, 113, 43);
		getContentPane().add(lblProduct);
		
		JButton btnNewButton = new JButton("Add Product");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dalima_salse?user=root&password=root");
					String query = "INSERT INTO inventry(Chassis_no,`Product _Catagory`,Price) VALUES (?,?,?)";
					PreparedStatement statement = connection.prepareStatement(query);
					statement.setString(1,tfcn.getText());
					String pc = category.getSelectedItem().toString();
					System.out.println(pc);
					statement.setString(2,pc);
					statement.setString(3,tfPrice.getText());

					JOptionPane.showMessageDialog(null,"Data Saved");
					statement.executeUpdate();
					connection.close();
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null ,e1.getMessage());
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 17));
		btnNewButton.setBounds(140, 286, 162, 43);
		getContentPane().add(btnNewButton);

	}
}
