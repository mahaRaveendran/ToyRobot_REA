package Objects;

/**
* The Direction enum contains the valid direction
* 	and the operations on direction for Toy Robot 
* Simulator
*
* @author  Mahalakshmi Raveendran
* @version 1.0
* @since   2017-03-29
*/
public enum Direction {
	NORTH(0), EAST(1), SOUTH(2), WEST(3);

	private int directionInd;
	
	private Direction(int directionInd){
		this.directionInd = directionInd;
	}
	
	/**
	 * Method : leftDirection
	 * 			rotates left from the current position
	 * 			of the toy Robot
	 * @return Direction
	 */
	public Direction leftDirection() {
		return rotate(-1);
	}

	/**
	 * Method : rightDirection
	 * 			rotates right from the current position
	 * 			of the toy Robot
	 * @return Direction
	 */
	public Direction rightDirection() {
		return rotate(1);
	}

	/**
	 * Method : rotate
	 * 			rotates left/right from the current position
	 * 			of the toy Robot as per the input
	 * @param i int
	 * @return Direction
	 */
	private Direction rotate(int i) {
		Direction[] dir = Direction.values();
		int dirSize = dir.length;
		int newDirectionInd = (this.directionInd + i) < 0 ? 
				dirSize - 1
				: (this.directionInd + i) % dirSize ;
		return dir[newDirectionInd];
	}
	
	
}
