import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sales extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String Product_id ;
	static String Chassis_no;
	static String Price;
	static String Product_category;
	private JPanel contentPane;
	private JDesktopPane desktopPane;


	public Sales() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aditya\\Desktop\\dalmia.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Sale");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Product View");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get table
				MyProduct mp = new MyProduct();
				mp.setVisible(true);
				desktopPane.add(mp);
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem);
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Sold");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Direct_Sale ds = new Direct_Sale();
				ds.setVisible(true);
				desktopPane.add(ds);
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Sales History");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Sales history
				Sales_History sh = new Sales_History();
				sh.setVisible(true);
				desktopPane.add(sh);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem lo = new JMenuItem("Logout");
		lo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home h =  new Home();
				h.setVisible(true);
				Sales.this.dispose();
			}
		});
		menuBar.add(lo);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}
}
