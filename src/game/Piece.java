package game;

import java.util.ArrayList;

public abstract class Piece {
	
	public final int UP = 0;
	public final int RIGHT = 1;
	public final int DOWN = 2;
	public final int LEFT = 3;
	
	private int x;
	private int y;
	// 0 for black, 1 for white
	// black is bottom side, white is top side
	private int type;
	private boolean isDead;
	private int kills;
	
	// constructor with x and y
	public Piece(int x, int y, int type) {
		this.setX(x);
		this.setY(y);
		this.setType(type);
		this.setDead(false);
		this.setKills(0);
	}
	
	// constructor with Location class
	public Piece(Location location, int type) {
		this.setX(location.x);
		this.setY(location.y);
		this.setType(type);
		this.setDead(false);
		this.setKills(0);
	}

	abstract boolean canKill(Location location);
	
	abstract boolean canMove(Location location);
	
	public boolean move(Location location) {
		// verify that it can move
		if(canMove(location)) {
			// old spot is now empty
			int tempX = this.getX();
			int tempY = this.getY();
			Board.matrix[tempY][tempX] = new Dummy(tempX, tempY, -1);
			// set the piece's location to a new location
			this.setX(location.x);
			this.setY(location.y);
			Board.matrix[this.getY()][this.getX()] = this;
			return true;
		}
		else {
			System.out.println(this.getName() + " at (" + this.getX() + ", " +
					this.getY() + ") can't move to given location: (" + location.x +
					", " + location.y + ")");
			return false;
		}
	}
	
	// move using enumerated direction and number of spaces 
	public boolean move(int direction, int spaces) {
		Location location;
		// if up
		if(direction == 0) {
			location = new Location(this.getX(), this.getY() - 1);
		}
		// if right
		else if(direction == 1) {
			location = new Location(this.getX() + 1, this.getY());
		}
		// if down
		else if(direction == 2) {
			location = new Location(this.getX(), this.getY() + 1);
		}
		// if left
		else {
			location = new Location(this.getX() - 1, this.getY());
		}
		if(canMove(location)) {
			// old spot is now empty
			int tempX = this.getX();
			int tempY = this.getY();
			Board.matrix[tempY][tempX] = new Dummy(tempX, tempY, -1);
			// set the piece's location to a new location
			this.setX(location.x);
			this.setY(location.y);
			Board.matrix[this.getY()][this.getX()] = this;
			return true;
		}
		else {
			System.out.println(this.getName() + " at (" + this.getX() + ", " +
					this.getY() + ") can't move to given location: (" + location.x +
					", " + location.y + ")");
			return false;
		}
	}
	
	public boolean kill(Location location) {
		// if the piece can kill, then
		if(canKill(location)) {
			// set dead piece to dead
			Board.matrix[location.y][location.x].setDead(true);
			// old spot of killer is now empty
			int tempX = this.getX();
			int tempY = this.getY();
			Board.matrix[tempY][tempX] = new Dummy(tempX, tempY, -1);
			// move the killer piece
			this.setX(location.x);
			this.setY(location.y);
			Board.matrix[this.getY()][this.getX()] = this;
			// add the dead piece to graveyard
			Board.graveyard[Board.openIndex] = Board.matrix[location.y][location.x];
			Board.openIndex++;
			return true;
		}
		else {
			System.out.println(this.getName() + " at (" + this.getX() + ", " +
					this.getY() + ") can't kill at given location: (" + location.x + 
					", " + location.y + ")");
			return false;
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
	
	public String locationAndTypeToString() {
		return "(x = " + this.getX() + ", y = " + this.getY() + ", type = " + this.getType() + ")";
	}
	
	public String toString() {
		return "?";
	}
	
	public String getName() {
		if(this.getType() == 0) {
			return "Piece:BLACK";
		}
		else {
			return "Piece:WHITE";
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}
}
