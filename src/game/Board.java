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
		// initialize dummies (empty spots)
		this.clearBoard();
		
		// insert other methods here
		//pawnTest();
		//bishopTest();
		rookTest();
	}
	
	public void updateBoard() {
		System.out.println("\n    0  1  2  3  4  5  6  7");
		for(int i = 0; i < DIMENSIONS; i++) {
			System.out.print(i + " [ ");
			for(int j = 0; j < DIMENSIONS; j++) {
				System.out.print(Board.matrix[i][j].toString() + " ");
			}
			System.out.println("]");
		}
		System.out.println();
	}
	
	public void clearBoard() {
		// initialize dummies (empty spots)
		for(int i = 0; i < DIMENSIONS; i++) {
			for(int j = 0; j < DIMENSIONS; j++) {
				Board.matrix[i][j] = new Dummy(j, i, -1);
			}
		}
	}
	
	public void fillPawns(int type) {
		// initialize dummies (empty spots)
		for(int i = 0; i < DIMENSIONS; i++) {
			for(int j = 0; j < DIMENSIONS; j++) {
				Board.matrix[i][j] = new Pawn(j, i, type);
			}
		}
	}
	
	/**
	 * PAWN:
	 * Cases tested:
	 * 
	 * (MOVE):
	 * - Black/white move 2 spaces from start works
	 * - Black/white move 1 space works
	 * - Anything else does not work
	 * (KILL):
	 * - Black/white killing opposite type piece works
	 * - Black/white killing same type piece does not work
	 */
	public void pawnTest() {
		// test canMove
		Board.matrix[6][3] = new Pawn(3, 6, 1);
		for(int i = 0; i < DIMENSIONS; i++) {
			for(int j = 0; j < DIMENSIONS + 1; j++) {
				if(Board.matrix[6][3].canMove(new Location(i, j))) {
					System.out.println(Board.matrix[6][3].getName() + " at (" +
							Board.matrix[6][3].getX() + ", " + Board.matrix[6][3].getY() +
							") can move to given location: (" + i + ", " + j + ")");
				}
			}
		}
		System.out.println();
		clearBoard();
		// test canKill
		Board.matrix[4][2] = new Bishop(2, 4, 1);
		Board.matrix[4][3] = new Bishop(3, 4, 1);
		Board.matrix[4][4] = new Bishop(4, 4, 0);
		Board.matrix[6][2] = new Bishop(2, 6, 1);
		Board.matrix[6][3] = new Bishop(3, 6, 1);
		Board.matrix[6][4] = new Bishop(4, 6, 1);
		Board.matrix[5][2] = new Bishop(2, 5, 1);
		Board.matrix[5][4] = new Bishop(4, 5, 1);
		Board.matrix[5][3] = new Pawn(3, 5, 0);

		for(int i = 0; i < DIMENSIONS; i++) {
			for(int j = 0; j < DIMENSIONS + 1; j++) {
				if(Board.matrix[5][3].canKill(new Location(i, j))) {
					System.out.println(Board.matrix[5][3].getName() + " at (" +
							Board.matrix[5][3].getX() + ", " + Board.matrix[5][3].getY() +
							") can kill at given location: (" + i + ", " + j + ")");
				}
			}
		}
	}
	
	public void bishopTest() {
		fillPawns(1);
		Board.matrix[4][4] = new Bishop(4, 4, 0);
		Board.matrix[3][3] = new Bishop(3, 3, 1);
		Board.matrix[3][5] = new Bishop(5, 3, 0);
		Board.matrix[5][5] = new Bishop(5, 5, 1);
		//Board.matrix[5][3] = new Bishop(3, 5, 1);
		Board.matrix[6][2] = new Bishop(2, 6, 1);
		
		for(int i = 0; i < DIMENSIONS; i++) {
			for(int j = 0; j < DIMENSIONS + 1; j++) {
				if(Board.matrix[4][4].canMove(new Location(i, j))) {
					System.out.println(Board.matrix[4][4].getName() + " at (" +
							Board.matrix[4][4].getX() + ", " + Board.matrix[4][4].getY() +
							") can move to given location: (" + i + ", " + j + ")");
				}
			}
		}
		Board.matrix[5][3] = new Dummy(3, 5, -1);
		
		for(int i = 0; i < DIMENSIONS; i++) {
			for(int j = 0; j < DIMENSIONS + 1; j++) {
				if(Board.matrix[4][4].canKill(new Location(i, j))) {
					System.out.println(Board.matrix[4][4].getName() + " at (" +
							Board.matrix[4][4].getX() + ", " + Board.matrix[4][4].getY() +
							") can kill at given location: (" + i + ", " + j + ")");
				}
			}
		}
	}
	
	public void rookTest() {
		Board.matrix[4][4] = new Rook(4, 4, 0);
		Board.matrix[4][2] = new Rook(2, 4, 1);
		Board.matrix[4][5] = new Rook(5, 4, 0);
		Board.matrix[3][4] = new Rook(4, 3, 1);
		for(int i = 0; i < DIMENSIONS; i++) {
			for(int j = 0; j < DIMENSIONS + 1; j++) {
				if(Board.matrix[4][4].canMove(new Location(i, j))) {
					System.out.println(Board.matrix[4][4].getName() + " at (" +
							Board.matrix[4][4].getX() + ", " + Board.matrix[4][4].getY() +
							") can move to given location: (" + i + ", " + j + ")");
				}
			}
		}
	}
}
