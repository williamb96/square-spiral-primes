enum SquareSpiralCursorDirection {
	UP(0, -1),
	RIGHT(1, 0),
	DOWN(0, 1),
	LEFT(-1, 0);
	
	private int x;
	private int y;
	
	SquareSpiralCursorDirection(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public SquareSpiralCursorDirection next() {
		switch (this) {
			case UP: return RIGHT;
			case RIGHT: return DOWN;
			case DOWN: return LEFT;
			case LEFT: return UP;
			default: return null;
		}
	}
}