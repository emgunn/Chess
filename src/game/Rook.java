package game;

import java.util.ArrayList;

public class Rook extends Piece {
	
	int x;
	int y;
	int type;
	boolean isDead;
	
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
		// black or white does not matter for rooks
		// if one of the 
		if(location.x == this.x ^ location.y == this.y) {
			return true;
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
		if(Board.matrix[location.y][location.x] != null) {
			return false;
		}
		// if location is the same as current one
		if(location.x == this.x && location.y == this.y) {
			return false;
		}
		// black or white does not matter for rooks
		if(location.x == this.x ^ location.y == this.y) {
			// if moving along the y-axis (up or down)
			if(location.x == this.x) {
				// if going up
				if(location.y < this.y) {
					// check if there are collisions above
					// we don't need to check location or self again
					for(int i = 1; i < Math.abs(location.x - this.x); i++) {
						// and a piece is in the way, return false
						if(Board.matrix[this.y - i][this.x] != null) {
							return false;
						}
					}
					// if no pieces in the way, return true;
					return true;
				}
				// if going down
				else if(location.y > this.y) {
					// same
					for(int i = 1; i < Math.abs(location.x - this.x); i++) {
						if(Board.matrix[this.y + i][this.x] != null) {
							return false;
						}
					}
					// if no pieces in the way, return true;
					return true;
				}
			}
				
			// if moving along the x-axis (left or right)
			else if(location.y == this.y) {
				// if going left
				if(location.x < this.x) {
					// check if there are collisions to the left
					// we don't need to check location or self again
					for(int i = 1; i < Math.abs(location.y - this.y); i++) {
						// and a piece is in the way, return false
						if(Board.matrix[this.y][this.x - i] != null) {
							return false;
						}
					}
					// if no pieces in the way, return true;
					return true;
				}
				else if(location.x > this.x) {
					for(int i = 1; i < Math.abs(location.y - this.y); i++) {
						if(Board.matrix[this.y][this.x + i] != null) {
							return false;
						}
					}
					// if no pieces in the way, return true;
					return true;
				}
			}
		}
		return false;
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
