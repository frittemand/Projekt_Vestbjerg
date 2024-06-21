package gui;

import controller.LoanController;
import controller.ToolController;
import model.Customer;
import model.ToolOrderline;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
    private JTable table;
    private String toolText;
    	
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
		
		//North panel
		
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_panel);
		
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Indtast telefonnummer:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		contentPanel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Find kunde");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String text = textField.getText();
				
				try {
					int number = Integer.parseInt(text);
					
					customer = lc.findCustomerByPhoneNumber(number);
				
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
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		contentPanel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		btnNewButton_3 = new JButton("Bekræft");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String text = textField_1.getText();
				try {
					int number = Integer.parseInt(text);
					duration = number;
					lc.createLoan(duration);
					
					System.out.println(duration);
					System.out.println(customer);
					
					
					contentPanel.setVisible(false);
					
					
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
		
		
		
		
		
		
		//Center panel
		
		
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new BorderLayout());
		getContentPane().add(panelCenter, BorderLayout.CENTER);
		
		
		
		
		JPanel panel_2 = new JPanel();
		GridBagLayout gbl_panel1 = new GridBagLayout();
		gbl_panel1.columnWidths = new int[]{0, 0, 0};
		gbl_panel1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel1.columnWeights = new double[]{1.0, 1.0, 1.0}; 
		gbl_panel1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0}; 
		panel_2.setLayout(gbl_panel1);
		panel_2.setLayout(gbl_panel1);
		panelCenter.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel1 = new JLabel("Tool name:");
		GridBagConstraints gbc_lblNewLabel1 = new GridBagConstraints();
		gbc_lblNewLabel1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel1.gridx = 0;
		gbc_lblNewLabel1.gridy = 0;
		panel_2.add(lblNewLabel1, gbc_lblNewLabel1);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 0;
		panel_2.add(textField_2, gbc_textField_2);
		
		JButton btnNewButton_4 = new JButton("Tilføj");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ToolController tc = new ToolController();
				toolText = textField_2.getText();
				double dayRate = tc.findDayRate(toolText);
				
				if(tc.findToolByToolName(toolText) != null) {
					lc.addCopyToLoan(toolText);
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.insertRow(0, new Object[] {toolText , dayRate, dayRate*duration});
				} else {
					System.out.println("Error! Tool doesn't exist");
				}
				
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 2;
		gbc_btnNewButton_4.gridy = 0;
		panel_2.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JPanel panel_3 = new JPanel();
		GridBagLayout gbl_panel3 = new GridBagLayout();
		gbl_panel3.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel3.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel3.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel3);
		panelCenter.add(panel_3, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = GridBagConstraints.REMAINDER;
		gbc_scrollPane.gridheight = GridBagConstraints.REMAINDER;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_3.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Item", "DayRate", "Total Price"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		
		
		
		
		
		//South panel
		
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_panel2 = new GridBagLayout();
		gbl_panel2.columnWidths = new int[]{0, 0, 0, 0,};
		gbl_panel2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel2.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel2.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel2);
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("Opret lån");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					finishLoan();
					endFinishLoan();
				}
				catch (IllegalArgumentException ex){
					System.out.println("error!");
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
		
		
		
		
	private void finishLoan() {
		System.out.println("Vestbjerg Byggecenter");
		System.out.println("Receipt");
		System.out.println("xxxxxxxxxxxxxx");
		System.out.println("Name: ");
		System.out.println("Loan items: ");
		
		ArrayList<ToolOrderline> printLines = lc.getToolOrderLines();
		
		for (ToolOrderline orderline : printLines) {
		System.out.println("Tool: "+orderline.getToolName());
		System.out.println(" Copy Number: "+ orderline.getCopy().getCopyNumber());
		System.out.println(" Day rate: " + orderline.getToolDayRate());
		System.out.println(" Price for period: "+ orderline.getLinePrice());
		System.out.println("___");
		
		}
		System.out.println("xxxxxxxxxxxxxx");

	}
	
	private void endFinishLoan() {
		FinishLoan finishLoan = new FinishLoan();
		finishLoan.setVisible(true);
	}
	
	

	
	private void goBack() {
		dispose();
		MainMenu mainMenu = new MainMenu();
		mainMenu.setVisible(true);
	}
}
