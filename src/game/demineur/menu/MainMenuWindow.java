package game.demineur.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import game.demineur.ingame.LaunchGame;
import game.demineur.menu.settings.SettingPopup;
import game.demineur.menu.settings.SettingReader;
import game.demineur.menu.settings.SettingsUtils;
import game.demineur.popup.Popup;
import game.demineur.utils.GameConstants;
import game.demineur.utils.ImagesSettings;
import game.demineur.utils.Path;
import game.demineur.utils.Reset;
import game.library.Restart;

public class MainMenuWindow {

	private JFrame frmMenu;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();
	private final Action action_6 = new SwingAction_6();
	private final Action action_7 = new SwingAction_7();

	private SettingReader settings;

	private String[] settingData = new String[3];

	public JFrame getFrmMenu() {
		return frmMenu;
	}

	public void setFrmMenu(JFrame frmMenu) {
		this.frmMenu = frmMenu;
		frmMenu.setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenuWindow.class.getResource(Path.MENU_PICTURE)));
	}

	public MainMenuWindow(SettingReader settings) {
		this.settings = settings;
		settingData[0] = this.settings.getProfilName();
		settingData[1] = this.settings.getDefaultGridSize();
		settingData[2] = this.settings.getDefaultColorGrid();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmMenu(new JFrame());
		getFrmMenu().setTitle("Menu");
		getFrmMenu().setBounds(100, 100, 600, 500);
		getFrmMenu().setLocationRelativeTo(null);
		getFrmMenu().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmMenu.setJMenuBar(menuBar);

		JMenu mnDmineur = new JMenu("D\u00E9mineur");
		menuBar.add(mnDmineur);

		JMenu mnProfils = new JMenu("Profils");
		mnDmineur.add(mnProfils);

		JMenu mnListeDesProfils = new JMenu("Liste des profils");
		mnProfils.add(mnListeDesProfils);

		mnListeDesProfils = addListProfileToMenu(mnListeDesProfils);

		JSeparator separator_1 = new JSeparator();
		mnProfils.add(separator_1);

		JMenuItem mntmNouveauProfil = new JMenuItem("Nouveau profil");
		mntmNouveauProfil.setAction(action_5);
		mnProfils.add(mntmNouveauProfil);

		JMenuItem mntmSupprimerUnProfil = new JMenuItem("Supprimer un profil");
		mntmSupprimerUnProfil.setAction(action_6);
		File file = new File(Path.PROFIL_PATH);
		if (file.listFiles().length <= 1) {
			mntmSupprimerUnProfil.setEnabled(false);
		}
		mnProfils.add(mntmSupprimerUnProfil);

		JSeparator separator_2 = new JSeparator();
		mnProfils.add(separator_2);

		JMenuItem mntmCurrentprofile = new JMenuItem("profil actuel : " + settings.getProfilName());
		mntmCurrentprofile.setEnabled(false);
		mnProfils.add(mntmCurrentprofile);

		JMenuItem mntmParamtres = new JMenuItem("Param???tres");
		mntmParamtres.setAction(action_4);
		mnDmineur.add(mntmParamtres);

		JSeparator separator_3 = new JSeparator();
		mnDmineur.add(separator_3);

		JMenuItem mntmRinitialiser = new JMenuItem("R???initialiser");
		mntmRinitialiser.setAction(action_7);
		mnDmineur.add(mntmRinitialiser);

		JMenuItem mntmQuitter = new JMenuItem("Quitter le jeu");
		mnDmineur.add(mntmQuitter);

		JMenu mnAide = new JMenu("Aide");
		menuBar.add(mnAide);

		JMenuItem mntmRglesDuJeu = new JMenuItem("R???gles du jeu");
		mntmRglesDuJeu.setAction(action_3);
		mnAide.add(mntmRglesDuJeu);

		JMenu mnPropos = new JMenu("A propos");
		menuBar.add(mnPropos);

		JMenuItem mntmProposDu = new JMenuItem("\u00C1 propos du d\u00E9veloppeur");
		mntmProposDu.setAction(action_1);
		mnPropos.add(mntmProposDu);

		JMenuItem mntmChangelog = new JMenuItem("Changelog");
		mntmChangelog.setAction(action_2);
		mnPropos.add(mntmChangelog);

		JSeparator separator = new JSeparator();
		mnPropos.add(separator);

		JMenuItem mntmVersion = new JMenuItem("Version " + GameConstants.VERNUM);
		mntmVersion.setEnabled(false);
		mnPropos.add(mntmVersion);
		frmMenu.getContentPane().setLayout(new BorderLayout(0, 0));

		JButton btnDmarrerLaPartie = new JButton("D\u00E9marrer la partie");
		btnDmarrerLaPartie.setAction(action);
		frmMenu.getContentPane().add(btnDmarrerLaPartie, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel();
		ImagesSettings resizePicture = new ImagesSettings();
		lblNewLabel = resizePicture.displayImage(lblNewLabel, Path.MENU_PICTURE, 280, 400);
		frmMenu.getContentPane().add(lblNewLabel, BorderLayout.EAST);

		JTextArea txtpnPane = new JTextArea();
		txtpnPane.setWrapStyleWord(true);
		txtpnPane.setLineWrap(true);
		txtpnPane.setDisabledTextColor(Color.BLACK);
		txtpnPane.setEnabled(false);
		txtpnPane.setEditable(false);
		txtpnPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtpnPane.setText(
				"Bienvenue dans le jeu du d???mineur d??velopper par les etudiants l'ESP  !\n\nPour commencer une partie cliquez sur le bouton ci-dessous.\n\n\n\n\n\n\n\n\n\n\nLes developpeurs \nAmadou Lamine SARR \nMamadou Moustapha NDOUR \nRobert Emmanuel Mamadou SAGNE \nYacine NDIAYE");
		frmMenu.getContentPane().add(txtpnPane, BorderLayout.CENTER);

		JEditorPane txtpnJeuDuDmineur = new JEditorPane();
		txtpnJeuDuDmineur.setContentType("text/html");
		txtpnJeuDuDmineur.setDisabledTextColor(Color.BLACK);
		txtpnJeuDuDmineur.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtpnJeuDuDmineur.setEditable(false);
		txtpnJeuDuDmineur.setEnabled(false);
		txtpnJeuDuDmineur.setText("<html><center>Menu pricipal</center></html>");
		frmMenu.getContentPane().add(txtpnJeuDuDmineur, BorderLayout.NORTH);
	}

	@SuppressWarnings("serial")
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "D???marrer la partie");
			putValue(SHORT_DESCRIPTION, "Cliquez ici pour commencer une nouvelle partie.");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			frmMenu.setVisible(false);
			LaunchGame game = new LaunchGame();
			game.newGame(settingData, settings, getFrmMenu());
		}
	}

	@SuppressWarnings("serial")
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "A propos des d???veloppeurs");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Mamadou Moustapha NDOUR\n Robert Emmanuel Mamadou SAGNE\n Amadou Lamine SARR \nYacine NDIAYE\n???tudiants ??? l'ESP", "Les developpeurs",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@SuppressWarnings("serial")
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Changelog");
			putValue(SHORT_DESCRIPTION, "Voir les nouveaut???s");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}

	@SuppressWarnings("serial")
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "R???gles du jeu");
			putValue(SHORT_DESCRIPTION, "Afficher les r???gles du jeu");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}

	@SuppressWarnings("serial")
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "Param???tres");
			putValue(SHORT_DESCRIPTION, "Options du jeu");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			SettingPopup parametre = new SettingPopup(null, "Param???tre", true, settings);
			settingData = parametre.showSettingPopup();
			if (settingData[0] != null && settingData[1] != null && settingData[2] != null) {
				updateSettingData();
			}

		}
	}

	protected void updateSettingData() {
		SettingsUtils.changeProfile(settingData[0], settings);
		SettingsUtils.changeGridSize(settingData[1], settings);
		SettingsUtils.changeColorGrid(settingData[2], settings);

	}

	protected JMenu addListProfileToMenu(JMenu menuToUpdate) {
		File profileDirectory = new File(Path.PROFIL_PATH);
		File[] profilList = profileDirectory.listFiles();

		if (profilList.length == 1 && profilList[0].getName().equals(settings.getProfilName())) {
			menuToUpdate.setEnabled(false);
		} else if (profilList.length != 0) {
			for (int i = 0; i < profilList.length; i++) {
				if (!(profilList[i].getName().equals(settings.getProfilName()))) {
					Action action_changeUser = new SwingAction_changeUser(profilList[i].getName());
					JMenuItem menuItem = new JMenuItem(profilList[i].getName());
					menuItem.setAction(action_changeUser);
					menuToUpdate.add(menuItem);
				}
			}
		} else {
			JMenuItem menuItem = new JMenuItem("Aucun profil enregistr???");
			menuItem.setEnabled(false);
			menuToUpdate.add(menuItem);
		}

		return menuToUpdate;
	}

	@SuppressWarnings("serial")
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "Nouveau profil");
			putValue(SHORT_DESCRIPTION, "Ajouter un nouveau profil");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			boolean confirmed = Popup.askForRestart();

			if (confirmed) {
				String profileName = Popup.addNewProfile();
				SettingsUtils.addNewProfile(profileName, settings, true);
				Restart restart = new Restart();
				restart.restartApplication();
			}
		}
	}

	@SuppressWarnings("serial")
	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "Supprimer un profil");
			putValue(SHORT_DESCRIPTION, "Supprimer les donn???es d'un profil");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			boolean confirmed = Popup.askForRestart();

			if (confirmed) {
				File[] listOfFiles = new File(Path.PROFIL_PATH).listFiles();
				int numberOfFiles = listOfFiles.length;

				ArrayList<String> listOfProfileName = new ArrayList<String>();

				for (int i = 0; i < numberOfFiles; i++) {
					if (!listOfFiles[i].getName().equals(settingData[0])) {
						listOfProfileName.add(listOfFiles[i].getName());
					}
				}

				String toDelete = Popup.selectProfileToDelete(listOfProfileName.toArray());

				if (toDelete != null) {
					SettingsUtils.deleteProfile(toDelete, settings);
				}
			}
		}
	}

	@SuppressWarnings("serial")
	private class SwingAction_7 extends AbstractAction {
		public SwingAction_7() {
			putValue(NAME, "R???initialiser");
			putValue(SHORT_DESCRIPTION, "Delete all files");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			boolean restartAllowed = Popup.askForRestart();
			boolean allowReset = Popup.confirmReset();

			if (restartAllowed && allowReset) {
				@SuppressWarnings("unused")
				Reset reset = new Reset(settings);

				Restart restart = new Restart();
				restart.restartApplication();
			}
		}
	}

	@SuppressWarnings("serial")
	private class SwingAction_changeUser extends AbstractAction {
		String profile;

		public SwingAction_changeUser(String userName) {
			putValue(NAME, userName);
			putValue(SHORT_DESCRIPTION, "Changer d'utilisateur");

			profile = userName;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			SettingsUtils.changeProfile(profile, settings);
		}
	}
}