import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public String logo;
	private JTextField tfUN;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setTitle("Dalmia EV");
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aditya\\Desktop\\dalmia.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Dalmia EV");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 38));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name: ");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUserName.setBounds(160, 189, 134, 48);
		panel.add(lblUserName);
		
		tfUN = new JTextField();
		tfUN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfUN.setBounds(304, 189, 383, 48);
		panel.add(tfUN);
		tfUN.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(160, 247, 134, 48);
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(304, 247, 383, 48);
		panel.add(passwordField);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Plant Manager", "Sales Manager"}));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox.setBounds(160, 322, 526, 48);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Welcome to Login");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				//login
				if(comboBox.getSelectedItem().toString().equals("Plant Manager")) {
					if((tfUN.getText().toString().equals("plantmanager"))&&(passwordField.getText().toString().equals("password"))) {
						Inventory in = new Inventory();
						in.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "invalid credentials");
					}
				}else  {
					if((tfUN.getText().toString().equals("salesmanager"))&&(passwordField.getText().toString().equals("password"))) {
						//
						Sales s = new Sales();
						s.setVisible(true);
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
		
		
		
	}
}
