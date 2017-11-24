package game;

import java.util.ArrayList;

public class Dummy extends Piece {
	
	private int x;
	private int y;
	private int type;
	private boolean isDead;
	private int kills;
	
	public Dummy(int x, int y, int type) {
		super(x, y, type);
	}
	
	public Dummy(Location location, int type) {
		super(location, type);
	}
	
	public boolean canKill(Location location) {
		return false;
	}
	
	public boolean canMove(Location location) {
		return false;
	}
	
	public String toString() {
		return "XX";
	}
	
	public String getName() {
		return "Dummy";
	}
}
