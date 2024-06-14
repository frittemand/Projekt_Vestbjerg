package gui;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Copy;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Customer;
import model.Product;
import model.ToolCopy;
import controller.LoanController;
import controller.ToolController;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class LoanTool extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private ToolCopy copy;
	private JTable table;
	private LoanController lc;
	private ToolController tc;
	private String toolName;
	private Customer customer;
	private int duration;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoanTool dialog = new LoanTool();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoanTool() {
		
		/*lc = new LoanController();
		lc.createLoan(duration);*/
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		
		
		//North Panel
		
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{};
		gbl_panel.rowWeights = new double[]{};
		contentPanel.setLayout(gbl_panel);
		
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("Tilføj");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				toolName = textField.getText();
				
				if(lc.addCopyToLoan(toolName) != null) {
					addCopy();
					textField.setText("");
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Tool name:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		contentPanel.add(textField, gbc_textField);
		textField.setColumns(10);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 0;
		contentPanel.add(btnNewButton, gbc_btnNewButton);
		
		//Center Panel
		
		JPanel panel = new JPanel();
		GridBagLayout gbl_panel1 = new GridBagLayout();
		gbl_panel1.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel1.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel1.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_panel1);
		
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Item", "Duration", "Total Price"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		
		
		
		
	}
	
	private void addCopy() {
		
		lc.addCopyToLoan(toolName);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.insertRow(0, new Object[] {toolName , duration, tc.findDayRate(toolName)*duration});
	}
	public void setDuration(int d) {
		duration = d;
	}
	
	public void setCustomer(Customer c) {
		customer = c;
	}
	
	public void createLoan(int d) {
		lc.createLoan(duration);
	}
	
	public int getDuration() {
		return duration;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	
}