package zadatak1.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZamenaGUI extends JDialog {
	
	TekstEditorGUI glavniEkran = new TekstEditorGUI();
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtStari;
	private JLabel lblNovi;
	private JTextField txtNovi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ZamenaGUI dialog = new ZamenaGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ZamenaGUI(TekstEditorGUI tekstEditor) {
		this();
		glavniEkran = tekstEditor;
	}
	/**
	 * Create the dialog.
	 */
	public ZamenaGUI() {
		setTitle("Zamena teksta");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblStari = new JLabel("Stari string:");
			lblStari.setBounds(121, 13, 73, 14);
			contentPanel.add(lblStari);
		}
		{
			txtStari = new JTextField();
			txtStari.setBounds(199, 10, 86, 20);
			contentPanel.add(txtStari);
			txtStari.setColumns(10);
		}
		contentPanel.add(getLblNovi());
		contentPanel.add(getTxtNovi());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String stari = txtStari.getText();
						String novi = txtNovi.getText();
						glavniEkran.zamenaTeksta(stari, novi);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private JLabel getLblNovi() {
		if (lblNovi == null) {
			lblNovi = new JLabel("Novi string: ");
			lblNovi.setBounds(121, 65, 73, 14);
		}
		return lblNovi;
	}
	private JTextField getTxtNovi() {
		if (txtNovi == null) {
			txtNovi = new JTextField();
			txtNovi.setBounds(199, 62, 86, 20);
			txtNovi.setColumns(10);
		}
		return txtNovi;
	}
}
