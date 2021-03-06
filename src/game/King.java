package game;

public class King extends Piece {

	private int x;
	private int y;
	private int type;
	private boolean isDead;
	private int kills;
	
	public King(int x, int y, int type) {
		super(x, y, type);
	}
	
	public King(Location location, int type) {
		super(location, type);
	}
	
	public boolean canKill(Location location) {
		return false;
	}
	
	public boolean canMove(Location location) {
		return false;
	}
	
	public String toString() {
		if(this.getType() == 0) {
			return "K0";
		}
		else {
			return "K1";
		}
	}
	
	public String getName() {
		if(this.getType() == 0) {
			return "King:BLACK";
		}
		else { 
			return "King:WHITE";
		}
	}
	
}