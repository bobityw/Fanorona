package ModelView;

import Controller.ListenerCase;
import Controller.ListenerPion;

import javax.swing.*;
import java.awt.*;


public class Board extends JPanel {

	//private static final long serialVersionUID = 6726708245444190460L;

	private static final int SIZE =9;

	private Case currentCase;

	private boolean tourNoir;

	public Board(int size){
		tourNoir=false;
		setLayout(new GridLayout(SIZE, SIZE));
		for(int i = 0; i< SIZE; i++){
			for(int j = 0; j< SIZE; j++){
				if((j%2==0 && i%2==0) || (j%2!=0 && i%2!=0)){
					addCase(Couleur.BLACKY);
				}
				else{
					addCase(Couleur.WHITY);
				}
			}
		}
		init();
	}

	private void addCase(Couleur couleur){
		Case case1 = new Case(couleur);
		case1.addMouseListener(new ListenerCase(case1, this));
		add(case1);
	}

	private Pawn createPawn(Couleur couleur, boolean monte){
		Pawn pion = new Pawn(couleur, monte);
		pion.addMouseListener(new ListenerPion(pion, this));
		return pion;
	}

	private void init(){
		for(int j = 0; j< SIZE *3; j+=2){
			getCase(j).add(createPawn(Couleur.BLACKY, false));
			getCase(SIZE * SIZE -j-1).add(createPawn(Couleur.WHITY, true));
		}
	}

	public Case getCase(int i, int j){
		return (Case) getComponent(j+i* SIZE);
	}

	public Case getCase(int i){
		return (Case) getComponent(i);
	}

	public void allPosibilities(Pawn p){
		if((p.getCouleur().equals(Couleur.BLACKY) && tourNoir) || (p.getCouleur().equals(Couleur.WHITY) && !tourNoir)){
			int i=0;
			int j=0;
			for(int k = 0; k< SIZE * SIZE; k++){
				getCase(k).setSelected(false);
				if(getCase(k).getComponentCount()!=0 && getCase(k).getComponent(0).equals(p)){
					currentCase =getCase(k);
					i=k/ SIZE;
					j=k% SIZE;

				}
			}
			selectedCases(i, j, p.getCouleur());
		}
	}

	public void selectedCases(int i, int j, Couleur couleur){
		Pawn pion = (Pawn)(getCase(i, j).getComponent(0));
		if(pion.isDeplaced()){
			if(i-1>=0 && j-1>=0 && getCase(i-1, j-1).getComponentCount()==0){
				getCase(i-1, j-1).setSelected(true);
			}
			else if(i-2>=0 && j-2>=0 && getCase(i-2, j-2).getComponentCount()==0 && !((Pawn)(getCase(i-1, j-1).getComponent(0))).getCouleur().equals(couleur)){
				getCase(i-2, j-2).setSelected(true);
			}
			if(i-1>=0 && j+1< SIZE && getCase(i-1, j+1).getComponentCount()==0){
				getCase(i-1, j+1).setSelected(true);
			}
			else if(i-2>=0 && j+2< SIZE && getCase(i-2, j+2).getComponentCount()==0 && !((Pawn)(getCase(i-1, j+1).getComponent(0))).getCouleur().equals(couleur)){
				getCase(i-2, j+2).setSelected(true);
			}
		}
		else{
			if(i+1< SIZE && j+1< SIZE && getCase(i+1, j+1).getComponentCount()==0){
				getCase(i+1, j+1).setSelected(true);
			}
			else if(i+2< SIZE && j+2< SIZE && getCase(i+2, j+2).getComponentCount()==0 && !((Pawn)(getCase(i+1, j+1).getComponent(0))).getCouleur().equals(couleur)){
				getCase(i+2, j+2).setSelected(true);
			}
			if(i+1< SIZE && j-1>=0 && getCase(i+1, j-1).getComponentCount()==0){
				getCase(i+1, j-1).setSelected(true);
			}
			else if(i+2< SIZE && j-2>=0 && getCase(i+2, j-2).getComponentCount()==0 && !((Pawn)(getCase(i+1, j-1).getComponent(0))).getCouleur().equals(couleur)){
				getCase(i+2, j-2).setSelected(true);
			}
			
		}
	}

	public void move(Case case1){
		case1.add(currentCase.getComponent(0));
		for(int k = 0; k< SIZE * SIZE; k++){
			getCase(k).setSelected(false);
		}
		if(Math.abs(getRaw(case1)- getRaw(currentCase))==2){
			int i = (getRaw(case1)+ getRaw(currentCase))/2;
			int j = (getColumn(case1)+ getColumn(currentCase))/2;
			getCase(i, j).removeAll();
			getCase(i, j).validate();
			getCase(i, j).repaint();
		}
		tourNoir=!tourNoir;
		currentCase.removeAll();
		currentCase.repaint();
		currentCase =null;
		case1.repaint();
		if(getRaw(case1)==0){
			Pawn p=(Pawn)(case1.getComponent(0));
			p.setDeplaced(false);
		}
		if(getRaw(case1)== SIZE -1){
			Pawn p=(Pawn)(case1.getComponent(0));
			p.setDeplaced(true);
		}
	}

	private int getRaw(Case case1){
		int res=0;
		for(int i = 0; i< SIZE * SIZE; i+=2){
			if(getCase(i).equals(case1)){
				res=i/ SIZE;
			}
		}
		return res;
	}

	private int getColumn(Case case1){
		int res=0;
		for(int i = 0; i< SIZE * SIZE; i+=2){
			if(getCase(i).equals(case1)){
				res=i% SIZE;
			}
		}
		return res;
	}
	
	


}
