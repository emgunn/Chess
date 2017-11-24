package game;

import java.util.ArrayList;

public class Bishop extends Piece {
	
	private int x;
	private int y;
	private int type;
	private boolean isDead;
	private int kills;
	
	public Bishop(int x, int y, int type) {
		super(x, y, type);
	}
	
	public Bishop(Location location, int type) {
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
		// if either both x's or both y's are the same, return false
		if(location.x == this.getX() || location.y == this.getY()) {
			return false;
		}
		// if same team, return false
		if(this.getType() == Board.matrix[location.y][location.x].getType()) {
			return false;
		}
		
		// if movement is diagonal
		if(Math.abs(location.x - this.getX()) == Math.abs(location.y - this.getY())) {
			// if northeast
			if(location.x > this.getX() && location.y < this.getY()) {
				for(int i = 1; i <= Math.abs(location.x - this.getX()); i++) {
					if(!Board.matrix[this.getY() - i][this.getX() + i].toString().equals("XX")) {
						// if that piece is the target piece, return true
						if(location.x == this.getX() + i && location.y == this.getY() - i) {
							return true;
						}
						// if not target, then something else is in the way, so return false
						return false;
					}
				}
			}
			// if southeast
			else if(location.x > this.getX() && location.y > this.getY()) {
				for(int i = 1; i <= Math.abs(location.x - this.getX()); i++) {
					if(!Board.matrix[this.getY() + i][this.getX() + i].toString().equals("XX")) {
						// if that piece is the target piece, return true
						if(location.x == this.getX() + i && location.y == this.getY() + i) {
							return true;
						}
						// if not target, then return false
						return false;
					}
				}
			}
			// if southwest
			else if(location.x < this.getX() && location.y > this.getY()) {
				for(int i = 1; i <= Math.abs(location.x - this.getX()); i++) {
					if(!Board.matrix[this.getY() + i][this.getX() - i].toString().equals("XX")) {
						// if that piece is the target piece, return true
						if(location.x == this.getX() - i && location.y == this.getY() + i) {
							return true;
						}
						// if not target, then return false
						return false;
					}
				}
			}
			// if northwest
			else {
				for(int i = 1; i <= Math.abs(location.x - this.getX()); i++) {
					if(!Board.matrix[this.getY() - i][this.getX() - i].toString().equals("XX")) {
						// if that piece is the target piece, return true
						if(location.x == this.getX() - i && location.y == this.getY() - i) {
							return true;
						}
						// if not target, then return false
						return false;
					}
				}
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
		// if location contains a piece, can't move
		if(!Board.matrix[location.y][location.x].toString().equals("XX")) {
			return false;
		}
		// if either both x's or both y's are the same, return false
		if(location.x == this.getX() || location.y == this.getY()) {
			return false;
		}
		// if movement is diagonal
		if(Math.abs(location.x - this.getX()) == Math.abs(location.y - this.getY())) {
			// if northeast
			if(location.x > this.getX() && location.y < this.getY()) {
				for(int i = 1; i < Math.abs(location.x - this.getX()); i++) {
					if(!Board.matrix[this.getY() - i][this.getX() + i].toString().equals("XX")) {
						return false;
					}
				}
				return true;
			}
			// if southeast
			else if(location.x > this.getX() && location.y > this.getY()) {
				for(int i = 1; i < Math.abs(location.x - this.getX()); i++) {
					if(!Board.matrix[this.getY() + i][this.getX() + i].toString().equals("XX")) {
						return false;
					}
				}
				return true;
			}
			// if southwest
			else if(location.x < this.getX() && location.y > this.getY()) {
				for(int i = 1; i < Math.abs(location.x - this.getX()); i++) {
					if(!Board.matrix[this.getY() + i][this.getX() - i].toString().equals("XX")) {
						return false;
					}
				}
				return true;
			}
			// if northwest
			else {
				for(int i = 1; i < Math.abs(location.x - this.getX()); i++) {
					if(!Board.matrix[this.getY() - i][this.getX() - i].toString().equals("XX")) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		if(this.getType() == 0) {
			return "B0";
		}
		else {
			return "B1";
		}
	}
	
	public String getName() {
		if(this.getType() == 0) {
			return "Bishop:BLACK";
		}
		else {
			return "Bishop:WHITE";
		}
	}
}
