package zadatak1.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import zadatak1.poslovna_logika.TekstDemo;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class TekstEditorGUI extends JFrame {
	
	
	private TekstDemo tekstDemo = new TekstDemo();
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea txtArea;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField txtField;
	private JButton btnUcitaj;
	private JButton btnZameni;
	private JButton btnObrisi;
	private JButton btnSacuvaj;
	private JButton btnAnaliza;
	private JButton btnIzadji;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TekstEditorGUI frame = new TekstEditorGUI();
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
	public TekstEditorGUI() {
		setTitle("Tekst Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTxtArea());
			scrollPane.setRowHeaderView(getPanel());
		}
		return scrollPane;
	}
	private JTextArea getTxtArea() {
		if (txtArea == null) {
			txtArea = new JTextArea();
		}
		return txtArea;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{46, 0};
			gbl_panel.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			panel.add(getLblNewLabel(), gbc_lblNewLabel);
			GridBagConstraints gbc_txtField = new GridBagConstraints();
			gbc_txtField.insets = new Insets(0, 0, 5, 0);
			gbc_txtField.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtField.gridx = 0;
			gbc_txtField.gridy = 1;
			panel.add(getTxtField(), gbc_txtField);
			GridBagConstraints gbc_btnUcitaj = new GridBagConstraints();
			gbc_btnUcitaj.insets = new Insets(0, 0, 5, 0);
			gbc_btnUcitaj.gridx = 0;
			gbc_btnUcitaj.gridy = 2;
			panel.add(getBtnUcitaj(), gbc_btnUcitaj);
			GridBagConstraints gbc_btnZameni = new GridBagConstraints();
			gbc_btnZameni.insets = new Insets(0, 0, 5, 0);
			gbc_btnZameni.gridx = 0;
			gbc_btnZameni.gridy = 3;
			panel.add(getBtnZameni(), gbc_btnZameni);
			GridBagConstraints gbc_btnObrisi = new GridBagConstraints();
			gbc_btnObrisi.insets = new Insets(0, 0, 5, 0);
			gbc_btnObrisi.gridx = 0;
			gbc_btnObrisi.gridy = 4;
			panel.add(getBtnObrisi(), gbc_btnObrisi);
			GridBagConstraints gbc_btnSacuvaj = new GridBagConstraints();
			gbc_btnSacuvaj.insets = new Insets(0, 0, 5, 0);
			gbc_btnSacuvaj.gridx = 0;
			gbc_btnSacuvaj.gridy = 5;
			panel.add(getBtnSacuvaj(), gbc_btnSacuvaj);
			GridBagConstraints gbc_btnAnaliza = new GridBagConstraints();
			gbc_btnAnaliza.insets = new Insets(0, 0, 5, 0);
			gbc_btnAnaliza.gridx = 0;
			gbc_btnAnaliza.gridy = 6;
			panel.add(getBtnAnaliza(), gbc_btnAnaliza);
			GridBagConstraints gbc_btnIzadji = new GridBagConstraints();
			gbc_btnIzadji.gridx = 0;
			gbc_btnIzadji.gridy = 7;
			panel.add(getBtnIzadji(), gbc_btnIzadji);
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Ime fajla:");
		}
		return lblNewLabel;
	}
	private JTextField getTxtField() {
		if (txtField == null) {
			txtField = new JTextField();
			txtField.setColumns(10);
		}
		return txtField;
	}
	private JButton getBtnUcitaj() {
		if (btnUcitaj == null) {
			btnUcitaj = new JButton("Ucitaj");
			btnUcitaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String imeFajla = txtField.getText();
					try {
						String tekst = tekstDemo.ucitajTekst(imeFajla);
						txtArea.setText(tekst);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Greska prilikom ucitavanja",
								"Greska",JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return btnUcitaj;
	}
	private JButton getBtnZameni() {
		if (btnZameni == null) {
			btnZameni = new JButton("Zameni");
			btnZameni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ZamenaGUI zamena = new ZamenaGUI(TekstEditorGUI.this);
					zamena.setVisible(true);
				}
			});
		}
		return btnZameni;
	}
	private JButton getBtnObrisi() {
		if (btnObrisi == null) {
			btnObrisi = new JButton("Obrisi");
			btnObrisi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtArea.setText("");
				}
			});
		}
		return btnObrisi;
	}
	private JButton getBtnSacuvaj() {
		if (btnSacuvaj == null) {
			btnSacuvaj = new JButton("Sacuvaj");
			btnSacuvaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String imeFajla = txtField.getText();
					String tekst = txtArea.getText();
					try {
						tekstDemo.upisiTekst(imeFajla, tekst);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Greska prilikom upisivanja",
								"Greska",JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return btnSacuvaj;
	}
	private JButton getBtnAnaliza() {
		if (btnAnaliza == null) {
			btnAnaliza = new JButton("Analiza");
			btnAnaliza.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String tekst = txtArea.getText();
					int brojZnakova = tekst.length();
					String[] reci = tekst.split(" ");
					int brojReci = reci.length;
					JOptionPane.showMessageDialog(null, "Broj znakova: "+brojZnakova+" Broj reci: "+brojReci,"Analiza",
							JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
		return btnAnaliza;
	}
	private JButton getBtnIzadji() {
		if (btnIzadji == null) {
			btnIzadji = new JButton("Izadji");
			btnIzadji.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int odgovor = //storuje odgovor
							JOptionPane.showConfirmDialog(null, "Da li zelite da izadjete iz programa?",
							"Potvrda",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(odgovor == JOptionPane.YES_NO_OPTION) {
						dispose();
					}
				}
			});
		}
		return btnIzadji;
	}
	public void zamenaTeksta(String stari, String novi) {
		String tekst = txtArea.getText();
		String noviTekst = tekst.replaceAll(stari, novi);
		txtArea.setText(noviTekst);
	}
}
