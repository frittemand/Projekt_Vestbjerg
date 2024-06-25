package gui;
import controller.ProductController;
import controller.SaleController;
import model.Orderline;
import model.Product;
import ui.TryMe;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.Button;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.Box;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;

public class SaleMenu extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField tfBarcode;
	private SaleController sl;
	private ProductController pc;
	private JTextField tfQuantity;
	private JLabel totalPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SaleMenu dialog = new SaleMenu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SaleMenu() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		ui.TryMe tryMe = new ui.TryMe(); // Laver testData så man ikke skal state fra Main hvergang man tester
	 sl = new SaleController();
	 pc = new ProductController();
		setTitle("Sale Menu");
		setBounds(100, 100, 550, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("Finish Sale");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishSale();
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Go back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBack();
			}
		});
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.EAST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblTotalPrice = new JLabel("Total Price    ");
		GridBagConstraints gbc_lblTotalPrice = new GridBagConstraints();
		gbc_lblTotalPrice.insets = new Insets(0, 0, 5, 0);
		gbc_lblTotalPrice.gridx = 0;
		gbc_lblTotalPrice.gridy = 0;
		panel_1.add(lblTotalPrice, gbc_lblTotalPrice);
		
		totalPrice = new JLabel("");
		GridBagConstraints gbc_totalPrice = new GridBagConstraints();
		gbc_totalPrice.gridx = 0;
		gbc_totalPrice.gridy = 1;
		panel_1.add(totalPrice, gbc_totalPrice);
		
		JPanel middle = new JPanel();
		middle.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(middle, BorderLayout.CENTER);
		middle.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		middle.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Item", "Quantity", "Line Price"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.NORTH);
		
		JButton btnAddProduct = new JButton("Add Product");
		btnAddProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(pc.findProductByBarcode(Integer.parseInt(tfBarcode.getText())) != null && tfQuantity.getText() != null){
				addProductToTable();
				clearTextFields();
				updateDisplay();
				}
				else {
					clearTextFields();
				}
				}
		});
		
		tfBarcode = new JTextField();
		tfBarcode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				checkIfDigit(e);
			}
		});
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblBarcode = new JLabel("Barcode:");
		panel_2.add(lblBarcode);
		panel_2.add(tfBarcode);
		tfBarcode.setColumns(10);
		
		tfQuantity = new JTextField();
		tfQuantity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				checkIfDigit(e);
			}
		});
		
		JLabel lblQuantity = new JLabel("Quantity");
		panel_2.add(lblQuantity);
		panel_2.add(tfQuantity);
		tfQuantity.setColumns(10);
		panel_2.add(btnAddProduct);
	}

	private void addProductToTable() {
		int barcode = Integer.parseInt(tfBarcode.getText());
		int quantity = Integer.parseInt(tfQuantity.getText());
		sl.addProduct(quantity, barcode);
		Product p = pc.findProductByBarcode(barcode);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.insertRow(0, new Object[] {p.getItemName() , quantity, p.getCurrentPrice()*quantity});
		
			
	}
	
	
	private void checkIfDigit(KeyEvent e) { //Checker om brugerens input er et tal, hvis ikke fjerner den inputet 
		char barcode = e.getKeyChar();
		
		if(!Character.isDigit(barcode)) {
			e.consume();
		}
	}
	private void clearTextFields() {//Sætter textFields tilbage til start
		tfBarcode.setText("");
		tfQuantity.setText("");
	}
private void updateDisplay() { //Opdatere TextField med totalPrice
	Double d = sl.getTotalPriceFromSale();
 String total = String.valueOf(d);
 totalPrice.setText(total);
}
private void goBack() {
	dispose();
	MainMenu mainMenu = new MainMenu();
	mainMenu.setVisible(true);
}
private void finishSale() {
	Double d = sl.getTotalPriceFromSale();
	FinishSale fs = new FinishSale(d, sl);
	fs.setVisible(true);
	dispose();
}
}
