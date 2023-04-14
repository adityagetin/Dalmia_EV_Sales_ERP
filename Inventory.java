import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inventory extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane desktopPane;

	public Inventory() {
		setTitle("Factory Portal");
		//setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aditya\\Desktop\\dalmia.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 872, 44);
		contentPane.add(menuBar);
		
		JMenu mnadd = new JMenu("Add Product");
		mnadd.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnadd);
		
		JMenuItem mntmADD = new JMenuItem("Add Item");
		mntmADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Add open");
				Add_product ap = new Add_product();
				ap.setVisible(true);
				desktopPane.add(ap);
				//System.out.println("Add close");
				
			}
		});
		mntmADD.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnadd.add(mntmADD);
		
		JMenu mnSearch = new JMenu("Search");
		mnSearch.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnSearch);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Search Product");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Search open");
				Search_Product sp = new Search_Product();
				sp.setVisible(true);
				desktopPane.add(sp);
				//System.out.println("Search close");
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnSearch.add(mntmNewMenuItem);
		
		JMenuItem Logout = new JMenuItem("Log Out");
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home h = new Home();
				h.setVisible(true);
				Inventory.this.dispose();
				
			}
		});
		Logout.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(Logout);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}
}
