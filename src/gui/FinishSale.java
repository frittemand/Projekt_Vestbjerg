package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SaleController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FinishSale extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfPaidAmount;
	private JLabel lblTotalPrice;
	private static double convertedTotal;
	private static SaleController sl;
	private JLabel lblChange;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FinishSale dialog = new FinishSale(convertedTotal, sl);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param sl 
	 */
	public FinishSale(double convertedTotal2, SaleController sl) {
		this.convertedTotal = convertedTotal;
		getContentPane().setMaximumSize(new Dimension(1000, 1080));
		setMaximumSize(new Dimension(150, 100));
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 192, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 14, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Total Price");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			lblTotalPrice = new JLabel("");
			GridBagConstraints gbc_lblTotalPrice = new GridBagConstraints();
			gbc_lblTotalPrice.insets = new Insets(0, 0, 5, 5);
			gbc_lblTotalPrice.gridx = 1;
			gbc_lblTotalPrice.gridy = 2;
			contentPanel.add(lblTotalPrice, gbc_lblTotalPrice);
			setLblTotalPriceText(convertedTotal2 + " DKK");
			
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Enter amount paid");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 3;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			tfPaidAmount = new JTextField();
			GridBagConstraints gbc_tfPaidAmount = new GridBagConstraints();
			gbc_tfPaidAmount.insets = new Insets(0, 0, 5, 5);
			gbc_tfPaidAmount.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfPaidAmount.gridx = 1;
			gbc_tfPaidAmount.gridy = 4;
			contentPanel.add(tfPaidAmount, gbc_tfPaidAmount);
			tfPaidAmount.setColumns(10);
		}
		{
			JLabel lblChange = new JLabel("Change:");
			GridBagConstraints gbc_lblChange = new GridBagConstraints();
			gbc_lblChange.insets = new Insets(0, 0, 5, 5);
			gbc_lblChange.gridx = 1;
			gbc_lblChange.gridy = 5;
			contentPanel.add(lblChange, gbc_lblChange);
		}
		{
			lblChange = new JLabel("******");
			GridBagConstraints gbc_lblChange = new GridBagConstraints();
			gbc_lblChange.insets = new Insets(0, 0, 5, 5);
			gbc_lblChange.gridx = 1;
			gbc_lblChange.gridy = 6;
			contentPanel.add(lblChange, gbc_lblChange);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Calculating the total amount paid
						double convertedTemp = (Double.parseDouble(tfPaidAmount.getText()));
						lblChange.setText(convertedTemp - convertedTotal + " DKK");
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				
			}
			
		}
		tfPaidAmount.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			}
			}});
		}
	
	public String getLblTotalPriceText() {
		return lblTotalPrice.getText();
	}
	public void setLblTotalPriceText(String text) {
		lblTotalPrice.setText(text);
	}
	public String getLblChangeText() {
		return lblChange.getText();
	}
	public void setLblChangeText(String text_1) {
		lblChange.setText(text_1);
	}
	public String getLblChange_1Text() {
		return lblChange.getText();
	}
	public void setLblChange_1Text(String text_2) {
		lblChange.setText(text_2);
	}
	
}

