package Controller;

import ModelView.Board;
import ModelView.Case;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ListenerCase implements MouseListener{
	
	private Case case1;
	private Board board;

	
	public ListenerCase(Case case1, Board plateau) {
		super();
		this.case1 = case1;
		this.board = plateau;
	}


	public void mouseClicked(MouseEvent arg0) {
	
	}


	public void mouseEntered(MouseEvent arg0) {
		
	}


	public void mouseExited(MouseEvent arg0) {
		
	}


	public void mousePressed(MouseEvent arg0) {
		if(case1.isSelected()){
			board.move(case1);
		}
	}


	public void mouseReleased(MouseEvent arg0) {
		
	}
	
	

}
