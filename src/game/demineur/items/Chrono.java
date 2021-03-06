package game.demineur.items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Chrono extends JLabel {
	private static int heure = 0, minute = 0, seconde = 0;
	private static Timer chronometer;
	private static String timeText;

	public Chrono() {
		int delais = 1000;
		ActionListener tache_timer;

		modifyText();
		final JButton debut = new JButton("Start");
		JButton fin = new JButton("Remise ? z?ro");

		// Gestion des minutes et des heures
		tache_timer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e1) {
				seconde++;
				if (seconde == 60) {
					seconde = 0;
					minute++;
				}
				if (minute == 60) {
					minute = 0;
					heure++;
				}
				modifyText();
			}
		};

		chronometer = new Timer(delais, tache_timer);

		this.setBorder(new EmptyBorder(5, 5, 10, 10));

		debut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String texte;
				texte = debut.getText();
				if (texte.compareTo("Start") == 0) {
					debut.setText("Stop ");
					chronometer.start();
				} else if (texte.compareTo("Stop ") == 0) {
					debut.setText("Start");
					chronometer.stop();
				}
			}
		});

		fin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String texte;
				texte = debut.getText();
				if (texte.compareTo("Start") == 0) {
					heure = 0;
					minute = 0;
					seconde = 0;
					debut.setText("Start");
					modifyText();
				}
			}
		});
	}

	public void initialize() {
		heure = 0;
		minute = 0;
		seconde = 0;
		timeText = null;
	}

	private void modifyText() {
		String text = "<html> <Font size = \"5\" color = \"white\">" + heure + ":" + minute + ":" + seconde
				+ "</font> </html>";
		this.setTimeText(text);
		this.setText(text);
	}

	public void startTimer() {
		chronometer.start();
	}

	public void stopTimer() {
		chronometer.stop();
	}

	/**
	 * @return the timeText
	 */
	public static String getTimeText() {
		return timeText;
	}

	/**
	 * @param timeText
	 *            the timeText to set
	 */
	private void setTimeText(String timeText) {
		Chrono.timeText = timeText;
	}

	public int[] getHeuresMinutesAndSecondes() {
		int[] time = { heure, minute, seconde };

		return time;
	}
}