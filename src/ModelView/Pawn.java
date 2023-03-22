package ModelView;

import ModelView.Couleur;

import javax.swing.*;
import java.awt.*;


public class Pawn extends JPanel {

	private Couleur couleur;
	private boolean deplaced;


	/**
	 * Constructor
	 * @param couleur
	 * @param monte
	 */
	public Pawn(Couleur couleur, boolean monte) {
		this.deplaced =monte;
		this.couleur = couleur;
		setOpaque(false);
		switch (couleur) {
			case WHITY :
			setForeground(new Color(214, 232, 238));
			setBackground(new Color(214, 232, 238));
			break;
			case BLACKY :
			setForeground(new Color(0, 27, 72));
			setBackground(new Color(0, 27, 72));
			break;
		}
	}
	


	public Couleur getCouleur() {
		return couleur;
	}

	public boolean isDeplaced() {
		return deplaced;
	}

	public void setDeplaced(boolean deplaced) {
		this.deplaced = deplaced;
	}

	@Override
	public void paintComponent(Graphics g){
		Paint paint;
		Graphics2D g2d;
		if (g instanceof Graphics2D) {
			g2d = (Graphics2D) g;
		}
		else {
			System.out.println("Error");
			return;
		}
		paint = new GradientPaint(0,0, getBackground(), getWidth(), getHeight(), getForeground());
		g2d.setPaint(paint);
		g.fillOval(5, 5, getWidth()-10, getHeight()-10);

	}
}
