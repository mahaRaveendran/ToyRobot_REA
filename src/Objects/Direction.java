package Objects;

public enum Direction {
	NORTH(0), EAST(1), SOUTH(2), WEST(3);

	private int directionInd;
	
	private Direction(int directionInd){
		this.directionInd = directionInd;
	}
	
	public Direction leftDirection() {
		return rotate(-1);
	}

	public Direction rightDirection() {
		return rotate(1);
	}

	private Direction rotate(int i) {
		Direction[] dir = Direction.values();
		int dirSize = dir.length;
		int newDirectionInd = (this.directionInd + i) < 0 ? 
				dirSize - 1
				: (this.directionInd + i) % dirSize ;
		return dir[newDirectionInd];
	}
	
	
}
