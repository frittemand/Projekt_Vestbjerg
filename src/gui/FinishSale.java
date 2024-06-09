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

public class FinishSale extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfPaidAmount;
	private JLabel lblTotalPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FinishSale dialog = new FinishSale();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FinishSale() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{434, 0};
		gridBagLayout.rowHeights = new int[]{228, 33, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagConstraints gbc_contentPanel = new GridBagConstraints();
		gbc_contentPanel.fill = GridBagConstraints.BOTH;
		gbc_contentPanel.insets = new Insets(0, 0, 5, 0);
		gbc_contentPanel.gridx = 0;
		gbc_contentPanel.gridy = 0;
		getContentPane().add(contentPanel, gbc_contentPanel);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{192, 50, 0};
		gbl_contentPanel.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Total Price");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			lblTotalPrice = new JLabel("");
			GridBagConstraints gbc_lblTotalPrice = new GridBagConstraints();
			gbc_lblTotalPrice.insets = new Insets(0, 0, 5, 5);
			gbc_lblTotalPrice.gridx = 0;
			gbc_lblTotalPrice.gridy = 1;
			contentPanel.add(lblTotalPrice, gbc_lblTotalPrice);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Enter amount paid");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			tfPaidAmount = new JTextField();
			GridBagConstraints gbc_tfPaidAmount = new GridBagConstraints();
			gbc_tfPaidAmount.insets = new Insets(0, 0, 5, 5);
			gbc_tfPaidAmount.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfPaidAmount.gridx = 0;
			gbc_tfPaidAmount.gridy = 3;
			contentPanel.add(tfPaidAmount, gbc_tfPaidAmount);
			tfPaidAmount.setColumns(10);
		}
		{
			JLabel lblChange = new JLabel("Change:");
			GridBagConstraints gbc_lblChange = new GridBagConstraints();
			gbc_lblChange.insets = new Insets(0, 0, 5, 5);
			gbc_lblChange.gridx = 0;
			gbc_lblChange.gridy = 4;
			contentPanel.add(lblChange, gbc_lblChange);
		}
		{
			JLabel lblChange = new JLabel("******");
			GridBagConstraints gbc_lblChange = new GridBagConstraints();
			gbc_lblChange.insets = new Insets(0, 0, 5, 5);
			gbc_lblChange.gridx = 0;
			gbc_lblChange.gridy = 5;
			contentPanel.add(lblChange, gbc_lblChange);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			GridBagConstraints gbc_buttonPane = new GridBagConstraints();
			gbc_buttonPane.anchor = GridBagConstraints.NORTH;
			gbc_buttonPane.fill = GridBagConstraints.HORIZONTAL;
			gbc_buttonPane.gridx = 0;
			gbc_buttonPane.gridy = 1;
			getContentPane().add(buttonPane, gbc_buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
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
		}

}

