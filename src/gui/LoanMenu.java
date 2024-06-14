package gui;

import controller.LoanController;
import model.Customer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class LoanMenu extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private final JPanel panel = new JPanel();
	private JTextField textField_2;
	private JLabel lblNewLabel_1;
    private JButton btnNewButton_3;
    private JPanel panel_1;
    
    private Customer customer;
    private int duration;
    private LoanController lc;
    private LoanTool loanTool;
    	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoanMenu dialog = new LoanMenu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoanMenu() {
		lc = new LoanController();
		setTitle("Loan Menu");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		
		//Center panel
		
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_panel);
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Indtast telefonnummer:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 1;
		contentPanel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Find kunde");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String text = textField_1.getText();
				
				try {
					int number = Integer.parseInt(text);
					
					customer = lc.findCustomerByPhoneNumber(number);

					lblNewLabel_1.setVisible(true);
					textField_2.setVisible(true);
					btnNewButton_3.setVisible(true);
				
					System.out.println(customer.getName());
			
				} catch (NumberFormatException ex){
					System.out.println("Invalid input, please type in a number.");
					textField_1.setText("");
				} catch (IllegalArgumentException ex) {
		            System.out.println("Kunde findes ikke");
		            textField_1.setText("");
				} 
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 1;
		contentPanel.add(btnNewButton, gbc_btnNewButton);
		
		lblNewLabel_1 = new JLabel("Instast længde på lån");
		lblNewLabel_1.setVisible(false);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setVisible(false);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 2;
		contentPanel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		btnNewButton_3 = new JButton("Bekræft");
		btnNewButton_3.setVisible(false);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String text = textField_2.getText();
				try {
					int number = Integer.parseInt(text);
					duration = number;
					System.out.println(duration);
					System.out.println(customer);
					
				} catch (NumberFormatException ex){
					System.out.println("Invalid input, please type in a number.");
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 3;
		gbc_btnNewButton_3.gridy = 2;
		contentPanel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		
		
		
		
		//South panel
		
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_panel1 = new GridBagLayout();
		gbl_panel1.columnWidths = new int[]{0, 0, 0, 0,};
		gbl_panel1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel1.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel1.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel1);
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("Opret lån");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					createToolLoan();
					setLoanTool(duration, customer);
				}
				catch (IllegalArgumentException ex){
					System.out.println("error!");
					System.out.println("Duration: " + duration);
					System.out.println("Customer: " + customer);
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 4;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Gå tilbage");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goBack();
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 3;
		gbc_btnNewButton_2.gridy = 4;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		
		
		
	}
/*private String customerToString(Customer customer) {
	
	StringBuilder sb = new StringBuilder();
	
    sb.append("Customer Information:\n");
    sb.append("Name: ").append(customer.getName()).append("\n");
    sb.append("Phone Number: ").append(customer.getPhoneNumber()).append("\n");
    sb.append("Name: ").append(customer.getName()).append("\n");
    sb.append("Phone Number: ").append(customer.getPhoneNumber()).append("\n");
    
    return sb.toString();
}*/
	
	private void createToolLoan() {
		loanTool = new LoanTool();
		loanTool.setVisible(true);
	}
	
	private void setLoanTool(int d, Customer c) {
		loanTool.setDuration(d);
		loanTool.setCustomer(c);
		//createLoan();
	}
	//TODO or maybe not? 
	/*private void createLoan() {
		loanTool.createLoan(loanTool.getDuration());
	}*/
	

	
	private void goBack() {
		dispose();
		MainMenu mainMenu = new MainMenu();
		mainMenu.setVisible(true);
	}
}
