package game;

import java.util.ArrayList;

public class Pawn extends Piece {

	private int x;
	private int y;
	private int type;
	private boolean isDead;
	private int kills;

	public Pawn(int x, int y, int type) {
		super(x, y, type);
	}
	
	public Pawn(Location location, int type) {
		super(location, type);
	}
	
	public boolean isReadyForPromotion() {
		// if black
		if(this.getType() == 0) {
			// if pawn has reached top of board
			if(this.getY() == 0) {
				return true;
			}
			return false;
		}
		// if white
		else {
			// if pawn has reached bottom of board
			if(this.getY() == Board.DIMENSIONS - 1) {
				return true;
			}
			return false;
		}
	}
	
	public boolean canKill(Location location) {
		// if user input error is wrong, return false still
		if(location.x < 0 || location.x >= Board.DIMENSIONS ||
				location.y < 0 || location.y >= Board.DIMENSIONS) {
			return false;
		}
		// if no piece is there, can't kill
		if(Board.matrix[location.y][location.x].toString().equals("XX")) {
			return false;
		}
		// if location is the same as current one
		if(location.x == this.getX() && location.y == this.getY()) {
			return false;
		}
		// if same team, return false
		if(this.getType() == Board.matrix[location.y][location.x].getType()) {
			return false;
		}
		// if black
		if(this.getType() == 0) {
			// can kill these spots
			if((location.x == this.getX() - 1 || location.x == this.getX() + 1) &&
				location.y == this.getY() - 1 && this.getY() > 0) {
				return true;
			}
			return false;
		}
		// if white
		else {
			// can kill these spots
			if((location.x == this.getX() - 1 || location.x == this.getX() + 1) &&
				location.y == this.getY() + 1 && this.getY() < Board.DIMENSIONS - 1) {
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
		if(!Board.matrix[location.y][location.x].toString().equals("XX")) {
			return false;
		}
		// if location is the same as current one
		if(location.x == this.getX() && location.y == this.getY()) {
			return false;
		}
		// if black, can move up
		if(this.getType() == 0) {
			// if pawn is at starting pos and wants to move 2 spaces
			if(location.x == this.getX() && this.getY() == Board.DIMENSIONS - 2 &&
					location.y == Board.DIMENSIONS - 4) {
				return true;
			}
			// if the given spot is one above the current spot
			// and if the pawn is not all the way on the top row
			if(location.x == this.getX() && location.y == this.getY() - 1 && this.getY() > 0) {
				return true;
			}
			return false;
		}
		// if white, can move down
		else {
			// if pawn is at starting pos and wants to move 2 spaces
			if(location.x == this.getX() && this.getY() == 1 && location.y == 3) {
				return true;
			}
			// if the given spot is one below the current spot
			// and if the pawn is not all the way on the bottom row
			if(location.x == this.getX() && location.y == this.getY() + 1 &&
					this.getY() < Board.DIMENSIONS - 1) {
				return true;
			}
			return false;
		}
	}
	
	public String toString() {
		if(this.getType() == 0) {
			return "P0";
		}
		else {
			return "P1";
		}
	}
	
	public String getName() {
		if(this.getType() == 0) {
			return "Pawn:BLACK";
		}
		else {
			return "Pawn:WHITE";
		}
	}
	
}
