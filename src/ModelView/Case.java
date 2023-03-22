package ModelView;

import javax.swing.*;
import java.awt.*;


public class Case extends JPanel {
	
	private static final long serialVersionUID = -1839026893240660968L;
	
	private Couleur couleur;
	private boolean selected;

	public Case(Couleur couleur){
		setLayout(new GridLayout(1,0));
		this.couleur=couleur;
		initCouleur();
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
		if(selected){
			setBackground(new Color(151,202,219));
			setForeground(new Color(151,202,219));
		}
		else {
			initCouleur();
		}
	}
	
	private void initCouleur(){
		switch(couleur){
			case WHITY :
				setBackground(new Color(214, 232, 238));
				setForeground(new Color(214, 232, 238));
			
			break;
			case BLACKY :
			setBackground(new Color(2, 69, 122));
			setForeground(new Color(2,69,122));
			break;
		}
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
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
