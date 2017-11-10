package game;

import java.util.ArrayList;

public class Pawn extends Piece {

	int x;
	int y;
	int type;
	boolean isDead;
	
	public Pawn(int x, int y, int type) {
		super(x, y, type);
	}
	
	public Pawn(Location location, int type) {
		super(location, type);
	}
	
	public boolean canKill(Location location) {
		// if user input error is wrong, return false still
		if(location.x < 0 || location.x >= Board.DIMENSIONS ||
				location.y < 0 || location.y >= Board.DIMENSIONS) {
			return false;
		}
		// if no piece is there, can't kill
		if(Board.matrix[location.y][location.x] == null) {
			return false;
		}
		// if location is the same as current one
		if(location.x == this.x && location.y == this.y) {
			return false;
		}
		// if same team, return false
		if(this.type == Board.matrix[location.y][location.x].type) {
			return false;
		}
		// if black
		if(this.type == 0) {
			// can kill these spots
			if(location.x == this.x - 1 || location.x == this.x + 1 &&
				location.y == this.y - 1 && this.y > 0) {
				return true;
			}
			return false;
		}
		// if white
		else {
			// can kill these spots
			if(location.x == this.x - 1 || location.x == this.x + 1 &&
				location.y == this.y + 1 && this.y < Board.DIMENSIONS - 1) {
				return true;
			}
			return false;
		}
	}
	
	public boolean canMove(Location location) {
		// if user input error is wrong, return false still
		if(location.x < 0 || location.x >= Board.DIMENSIONS ||
				location.y < 0 || location.y >= Board.DIMENSIONS) {
			return false;
		}
		// if location contains a piece, can't move
		if(Board.matrix[location.y][location.x] != null) {
			return false;
		}
		// if location is the same as current one
		if(location.x == this.x && location.y == this.y) {
			return false;
		}
		// if black, can move up
		if(this.type == 0) {
			// if pawn is at starting pos and wants to move 2 spaces
			if(location.x == this.x && location.y == Board.DIMENSIONS - 2) {
				return true;
			}
			// if the given spot is one above the current spot
			// and if the pawn is not all the way on the top row
			if(location.x == this.x && location.y == this.y - 1 && this.y > 0) {
				return true;
			}
			return false;
		}
		// if white, can move down
		else {
			// if pawn is at starting pos and wants to move 2 spaces
			if(location.x == this.x && location.y == 1) {
				return true;
			}
			// if the given spot is one below the current spot
			// and if the pawn is not all the way on the bottom row
			if(location.x == this.x && location.y == this.y + 1 &&
					this.y < Board.DIMENSIONS - 1) {
				return true;
			}
			return false;
		}
	}
	
	public void move(Location location) {
		super.move(location);
	}
	
	public void kill(Location location) {
		super.kill(location);
	}
	
	public ArrayList<Location> getPossibleMoves() {
		return super.getPossibleMoves();
	}
	
	public ArrayList<Location> getPossibleKills() {
		return super.getPossibleKills();
	}
	
}
