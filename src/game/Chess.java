package game;

import java.util.ArrayList;

public class Chess {

	public static void main(String[] args) {

		Board gameboard = new Board();
		
		
		gameboard.updateBoard();
		printRowTypes(gameboard, 1);
	}
	
	public static void printRowTypes(Board gameboard, int row) {
		System.out.print(row + " [ ");
		for(int j = 0; j < 8; j++) {
			if(gameboard.matrix[row][j].getType() == -1) {
				System.out.print("XX ");
			}
			else {
				System.out.print(gameboard.matrix[row][j].getType() + "" +
					gameboard.matrix[row][j].getType() + " ");
			}
		}
		System.out.print("]\n");
	}
	
	// same as Board.updateBoard();
	public static void printRowStrings(Board gameboard, int row) {
		System.out.print(row + " [ ");
		for(int j = 0; j < 8; j++) {
			System.out.print(gameboard.matrix[row][j].toString() + " ");
		}
		System.out.print("]\n");
	}
}
