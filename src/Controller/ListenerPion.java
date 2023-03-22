package Controller;

import ModelView.Board;
import ModelView.Pawn;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ListenerPion implements MouseListener {
	
	private Board plateau;
	private Pawn pion;
	
	public ListenerPion(Pawn pion, Board plateau){
		this.plateau=plateau;
		this.pion=pion;
	}

	public void mouseClicked(MouseEvent arg0) {
		
	}

	public void mouseEntered(MouseEvent arg0) {
	
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent arg0) {
		plateau.allPosibilities(pion);
	}

	public void mouseReleased(MouseEvent arg0) {
		
	}

}
