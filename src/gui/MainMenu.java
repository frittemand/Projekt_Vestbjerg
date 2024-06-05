package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setTitle("Main menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnSaleMenu = new JButton("Sale menu");
		btnSaleMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 enableSaleMenu();					
			}
		});
		GridBagConstraints gbc_btnSaleMenu = new GridBagConstraints();
		gbc_btnSaleMenu.insets = new Insets(0, 0, 5, 0);
		gbc_btnSaleMenu.gridx = 5;
		gbc_btnSaleMenu.gridy = 1;
		panel.add(btnSaleMenu, gbc_btnSaleMenu);
		
		JButton btnLoanMenu = new JButton("Loan menu");
		btnLoanMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				enableLoanMenu();
			}

		});
		GridBagConstraints gbc_btnLoanMenu = new GridBagConstraints();
		gbc_btnLoanMenu.insets = new Insets(0, 0, 5, 0);
		gbc_btnLoanMenu.gridx = 5;
		gbc_btnLoanMenu.gridy = 2;
		panel.add(btnLoanMenu, gbc_btnLoanMenu);
		
		JButton btnProducts = new JButton("Products");
		btnProducts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				//TODO implement method for Products
				System.out.println("Nothing to see here");
			}
		});
		GridBagConstraints gbc_btnProducts = new GridBagConstraints();
		gbc_btnProducts.insets = new Insets(0, 0, 5, 0);
		gbc_btnProducts.gridx = 5;
		gbc_btnProducts.gridy = 3;
		panel.add(btnProducts, gbc_btnProducts);
		
		JButton btnGenerateTestData = new JButton("Generate Test Data");
		btnGenerateTestData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ui.TryMe tryMe = new ui.TryMe();
				System.out.println("Test data has been generated");
			}
		});
		GridBagConstraints gbc_btnGenerateTestData = new GridBagConstraints();
		gbc_btnGenerateTestData.insets = new Insets(0, 0, 5, 0);
		gbc_btnGenerateTestData.gridx = 5;
		gbc_btnGenerateTestData.gridy = 4;
		panel.add(btnGenerateTestData, gbc_btnGenerateTestData);
		
		
		JLabel lblNewLabel = new JLabel("Main menu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{81, 89, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{23, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnCancel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnCancel.gridx = 0;
		gbc_btnCancel.gridy = 0;
		panel_1.add(btnCancel, gbc_btnCancel);
	}
	
	public void enableSaleMenu() {
		SaleMenu saleMenu = new SaleMenu();
		saleMenu.setVisible(true);
	}
	private void enableLoanMenu() {
		LoanMenu loanMenu = new LoanMenu();
		loanMenu.setVisible(true);
	}

}
