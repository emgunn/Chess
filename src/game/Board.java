package game;

import java.util.ArrayList;

public class Board {
	
	// black pieces start at bottom facing up
	// white pieces start at top facing down
	
	static final int DIMENSIONS = 8;
	static final int NUM_PIECES = 32;
	
	static Piece[][] matrix = new Piece[DIMENSIONS][DIMENSIONS];
	static Piece[] graveyard = new Piece[NUM_PIECES];
	static int openIndex = 0;
	
	public Board() {
		this.initialize();
	}
	
	private void initialize() {
		
	}
	
	private void updateBoard() {
		
	}
}
