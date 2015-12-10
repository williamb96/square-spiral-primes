public class SquareSpiralCursor {
	private int x;
	private int y;
	private SquareSpiralCursorDirection direction;
	private int tripPosition;
	private int tripDestination;
	private boolean secondTrip;
	
	public SquareSpiralCursor() {
		this.x = 0;
		this.y = 0;
		this.direction = SquareSpiralCursorDirection.RIGHT;
		this.tripPosition = 0;
		this.tripDestination = 1;
		this.secondTrip = false;
	}
	
	public void next() {
		if (tripPosition == tripDestination) {
			direction = direction.next();
			tripPosition = 0;
			secondTrip = !secondTrip;
			
			if (!secondTrip) {
				this.tripDestination++;
			}
		}
		
		x += direction.getX();
		y += direction.getY();
		tripPosition++;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String toString() {
		return "("+x+";"+y+")";
	}
}