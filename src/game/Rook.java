package game;

import java.util.ArrayList;

public class Rook extends Piece {
	
	private int x;
	private int y;
	private int type;
	private boolean isDead;
	private int kills;
	
	public Rook(int x, int y, int type) {
		super(x, y, type);
	}
	
	public Rook(Location location, int type) {
		super(location, type);
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
		// black or white does not matter for rooks
		// if one of the x or y is the same, but not both (self)
		if(location.x == this.getX()) {
			// if going up
			if(location.y < this.getY()) {
				// check if there are collisions above
				// we don't need to check location or self again
				for(int i = 1; i <= Math.abs(location.x - this.getX()); i++) {
					// and if a piece is in the way
					if(!Board.matrix[this.getY() - i][this.getX()].toString().equals("XX")) {
						// if that piece is the target piece, return true
						if(location.y == this.getY() - i) {
							return true;
						}
						// if not target, then return false
						return false;
					}
				}
				// if no pieces in the way, return true;
				return true;
			}
			// if going down
			else if(location.y > this.getY()) {
				// same
				for(int i = 1; i <= Math.abs(location.x - this.getX()); i++) {
					if(!Board.matrix[this.getY() + i][this.getX()].toString().equals("XX")) {
						// if that piece is the target piece, return true
						if(location.y == this.getY() + i) {
							return true;
						}
						// if not target, then return false
						return false;
					}
				}
				// if no pieces in the way, return true;
				return true;
			}
		}
		// if moving along the x-axis (left or right)
		else if(location.y == this.getY()) {
			// if going left
			if(location.x < this.getX()) {
				// check if there are collisions to the left
				// we don't need to check location or self again
				for(int i = 1; i <= Math.abs(location.y - this.getY()); i++) {
					// and a piece is in the way, return false
					if(!Board.matrix[this.getY()][this.getX() - i].toString().equals("XX")) {
						// if that piece is the target piece, return true
						if(location.x == this.getX() - i && location.y == this.getY()) {
							return true;
						}
						// if not target, then return false
						return false;
					}
				}
				// if no pieces in the way, return true;
				return true;
			}
			else if(location.x > this.getX()) {
				for(int i = 1; i < Math.abs(location.y - this.getY()); i++) {
					if(!Board.matrix[this.getY()][this.getX() + i].toString().equals("XX")) {
						// if that piece is the target piece, return true
						if(location.x == this.getX() + i && location.y == this.getY()) {
							return true;
						}
						// if not target, then return false
						return false;
					}
				}
				// if no pieces in the way, return true;
				return true;
			}
		}
		return false;
	}
	
	public boolean canMove(Location location) {
		// if user input error is wrong, return false still
		if(location.x < 0 || location.x >= Board.DIMENSIONS ||
				location.y < 0 || location.y >= Board.DIMENSIONS) {
			return false;
		}
		// if a piece is there, can't move
		if(!Board.matrix[location.y][location.x].toString().equals("XX")) {
			return false;
		}
		// if location is the same as current one
		if(location.x == this.getX() && location.y == this.getY()) {
			return false;
		}
		// black or white does not matter for rooks
		// if moving along the y-axis (up or down)
		if(location.x == this.getX()) {
			// if going up
			if(location.y < this.getY()) {
				// check if there are collisions above
				// we don't need to check location or self again
				for(int i = 1; i < Math.abs(location.y - this.getY()); i++) {
					// and a piece is in the way, return false
					if(!Board.matrix[this.getY() - i][this.getX()].toString().equals("XX")) {
						return false;
					}
				}
				// if no pieces in the way, return true
				return true;
			}
			// if going down
			else if(location.y > this.getY()) {
				// same
				for(int i = 1; i < Math.abs(location.y - this.getY()); i++) {
					if(!Board.matrix[this.getY() + i][this.getX()].toString().equals("XX")) {
						return false;
					}
				}
				// if no pieces in the way, return true
				return true;
			}
		}
			
		// if moving along the x-axis (left or right)
		else if(location.y == this.getY()) {
			// if going left
			if(location.x < this.getX()) {
				// check if there are collisions to the left
				// we don't need to check location or self again
				for(int i = 1; i < Math.abs(location.x - this.getX()); i++) {
					// and a piece is in the way, return false
					if(!Board.matrix[this.getY()][this.getX() - i].toString().equals("XX")) {
						return false;
					}
				}
				// if no pieces in the way, return true
				return true;
			}
			else if(location.x > this.getX()) {
				for(int i = 1; i < Math.abs(location.x - this.getX()); i++) {
					if(!Board.matrix[this.getY()][this.getX() + i].toString().equals("XX")) {
						return false;
					}
				}
				// if no pieces in the way, return true
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		if(this.getType() == 0) {
			return "R0";
		}
		else {
			return "R1";
		}
	}
	
	public String getName() {
		if(this.getType() == 0) {
			return "Rook:BLACK";
		}
		else {
			return "Rook:WHITE";
		}
	}
}
