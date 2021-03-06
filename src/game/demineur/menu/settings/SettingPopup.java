package game.demineur.menu.settings;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class SettingPopup extends JDialog {
	// Donn?es de la popup
	private SettingReader settings;

	// ?l?ments de la popup
	private String[] settingList = new String[3];
	private JLabel profilLabel, generalSettingsLabel, gameSizeLabel;
	private JRadioButton profilListBox1, profilListBox2, profilListBox3;
	private JComboBox<String> globalSettingsChoice, profilChoiceList;

	public SettingPopup(JFrame parent, String title, boolean modal, SettingReader settings) {
		super(parent, title, modal);
		this.settings = settings;
		this.setSize(550, 270);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.initComponent();
	}

	public String[] showSettingPopup() {
		this.setVisible(true);
		return this.settingList;
	}

	private void initComponent() {
		JPanel profilPan = new JPanel();
		profilPan.setBackground(Color.white);
		profilPan.setPreferredSize(new Dimension(220, 90));
		profilChoiceList = new JComboBox<String>();
		profilChoiceList = SettingsUtils.updateProfilBox(profilChoiceList, settings);
		profilChoiceList.setPreferredSize(new Dimension(190, 25));
		profilPan.setBorder(BorderFactory.createTitledBorder("Profil"));
		profilLabel = new JLabel("S?lectionnez un profil :");
		profilPan.add(profilLabel);
		profilPan.add(profilChoiceList);

		JPanel gridSize = new JPanel();
		gridSize.setBackground(Color.white);
		gridSize.setBorder(BorderFactory.createTitledBorder("Param?tre du jeu"));
		gridSize.setPreferredSize(new Dimension(220, 90));
		gameSizeLabel = new JLabel("Taille de la grille :");
		profilListBox1 = new JRadioButton("9x9");
		profilListBox1.setSelected(true);
		profilListBox2 = new JRadioButton("16x16");
		profilListBox3 = new JRadioButton("30x16");
		ButtonGroup group = new ButtonGroup();
		group.add(profilListBox1);
		group.add(profilListBox2);
		group.add(profilListBox3);
		group = SettingsUtils.selectDefaultElement(profilListBox3, profilListBox2, profilListBox1, settings, group);
		gridSize.add(gameSizeLabel);
		gridSize.add(profilListBox1);
		gridSize.add(profilListBox2);
		gridSize.add(profilListBox3);

		JPanel colorGridSettings = new JPanel();
		colorGridSettings.setBackground(Color.white);
		colorGridSettings.setPreferredSize(new Dimension(440, 60));
		colorGridSettings.setBorder(BorderFactory.createTitledBorder("Couleur de la grille"));
		globalSettingsChoice = new JComboBox<String>();
		globalSettingsChoice.addItem("Gris");
		globalSettingsChoice.addItem("Bleu");
		globalSettingsChoice.addItem("Vert");
		globalSettingsChoice.addItem("Rouge");
		globalSettingsChoice = SettingsUtils.selectColor(globalSettingsChoice, settings);
		generalSettingsLabel = new JLabel("");
		colorGridSettings.add(generalSettingsLabel);
		colorGridSettings.add(globalSettingsChoice);

		JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(profilPan);
		content.add(gridSize);
		content.add(colorGridSettings);

		JPanel control = new JPanel();
		JButton okBouton = new JButton("OK");

		okBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				settingList[0] = (String) profilChoiceList.getSelectedItem();
				settingList[1] = getGridSize();
				settingList[2] = (String) globalSettingsChoice.getSelectedItem();
				setVisible(false);
			}

			public String getGridSize() {
				return (profilListBox1.isSelected()) ? profilListBox1.getText()
						: (profilListBox2.isSelected()) ? profilListBox2.getText()
								: (profilListBox3.isSelected()) ? profilListBox3.getText() : profilListBox1.getText();
			}
		});

		JButton cancelBouton = new JButton("Annuler");
		cancelBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});

		control.add(okBouton);
		control.add(cancelBouton);

		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(control, BorderLayout.SOUTH);
	}
}
