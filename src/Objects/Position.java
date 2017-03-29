package Objects;

/**
* The Position class determines the exact 
* position of the toy robot
*
* @author  Mahalakshmi Raveendran
* @version 1.0
* @since   2017-03-29
*/

public class Position {
	private int x;
	private int y;
	private Direction direction;

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
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public Position(){
		this.x = 0;
		this.x = 0; 
		this.direction = Direction.NORTH;
	}
	public Position(int x, int y, Direction direction){
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	public Position(Position p){
		this.x = p.x;
		this.y = p.y;
		this.direction = p.direction;
	}
	
	/**
	 * Method : changePosition
	 * 			Change the position of the toy robot
	 * 			to a new position from the current position
	 * @param p Position
	 * @return Position
	 */
	public Position changePosition(Position p){
		Position pos = new Position();
		pos.x = this.x+p.x;
		pos.y = this.y+p.y;
		pos.direction = p.direction;
		return pos;
		
	}
	
	/**
	 * Method : moveForward
	 * 			move forward by one position in the direction specified
	 * @return Position
	 */
	public Position moveForward(){
		if(this.direction != null){
			//Exception
		}
		Position newPosition = new Position(this);
		switch(this.direction){
		case NORTH:
			newPosition.add(0, 1);
			break;
		case SOUTH:
			newPosition.add(0, -1);
			break;
		case EAST:
			newPosition.add(1, 0);
			break;
		case WEST:
			newPosition.add(-1, 0);
			break;
		}
		
		return newPosition;
	}
	/**
	 * Method : add
	 * 			add the new position to the current position 
	 * 			of the toy robot
	 * @param x int 
	 * @param y int
	 * @return void
	 */
	public void add(int x, int y){
		this.x+=x;
		this.y+=y;
	}
}
