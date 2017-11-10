package game;

import java.util.ArrayList;

public abstract class Piece {
	int x;
	int y;
	// 0 for black, 1 for white
	int type;
	boolean isDead;
	
	// constructor with x and y
	public Piece(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.isDead = false;
	}
	
	// constructor with Location class
	public Piece(Location location, int type) {
		this.x = location.x;
		this.y = location.y;
		this.type = type;
		this.isDead = false;
	}

	abstract boolean canKill(Location location);
	
	abstract boolean canMove(Location location);
	
	public void move(Location location) {
		// verify that it can move
		if(canMove(location)) {
			// set the piece's location to a new location
			this.x = location.x;
			this.y = location.y;
		}
	}
	
	public void kill(Location location) {
		// if the piece can kill, then
		if(canKill(location)) {
			// set dead piece to dead
			Board.matrix[location.y][location.x].isDead = true;
			// move the killer piece
			this.x = location.x;
			this.y = location.y;
			// add the dead piece to graveyard
			Board.graveyard[Board.openIndex] = Board.matrix[location.y][location.x];
			Board.openIndex++;
		}
	}
	
	public ArrayList<Location> getPossibleMoves() {
		ArrayList<Location> moves = new ArrayList<Location>();
		for(int i = 0; i < Board.DIMENSIONS; i++) {
			for(int j = 0; j < Board.DIMENSIONS; j++) {
				Location loc = new Location(i, j);
				if(canMove(loc)) {
					moves.add(loc);
				}
			}
		}
		return moves;
	}
	
	public ArrayList<Location> getPossibleKills() {
		ArrayList<Location> kills = new ArrayList<Location>();
		for(int i = 0; i < Board.DIMENSIONS; i++) {
			for(int j = 0; j < Board.DIMENSIONS; j++) {
				Location loc = new Location(i, j);
				if(canKill(loc)) {
					kills.add(loc);
				}
			}
		}
		return kills;
	}
	
	
}
