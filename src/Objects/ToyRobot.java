package Objects;

import ToyRobotException.ToyRobotException;

/**
* The ToyRobot class outlines the operations specific to the
* toy robot movement
*
* @author  Mahalakshmi Raveendran
* @version 1.0
* @since   2017-03-29
*/

public class ToyRobot {
	private Position position;
	
	public ToyRobot(){
		this.position = new Position();
	}

	public ToyRobot(Position position){
		this.position = position;
	}
	public Position getPosition() {
		return position;
	}

	/**
	 * Method : turnLeft
	 *  		turns left from the given direction by 90 degrees 
	 *  		without changing the position of the toy robot
	 * @return void
	 */
	public void turnLeft() throws ToyRobotException{
		if(this.position.getDirection() == null)
			throw new ToyRobotException("INVALID DIRECTION: Direction is null");
		this.position.setDirection(this.position.getDirection().leftDirection());
	}
	
	/**
	 * Method : turnRight
	 *  		turns Right from the given direction by 90 degrees 
	 *  		without changing the position of the toy robot
	 * @return void
	 */
	public void turnRight() throws ToyRobotException{
		if(this.position.getDirection() == null)
			throw new ToyRobotException("INVALID DIRECTION: Direction is null");
		this.position.setDirection(this.position.getDirection().rightDirection());
	}
	
	/**
	 * Method : setPosition
	 * 			set the position of the toy robot to the given position
	 * @param position Position
	 * @return void
	 */
	public void setPosition(Position position) throws ToyRobotException {
		if(position == null)
			throw new ToyRobotException("INVALID POSITION: Position is null");
		this.position = position;
	}
	
	/**
	 * Method : moveRobot
	 * 			move the toy robot to the new position from its current position 
	 * 			in the square board
	 * @param newPosition Position
	 * @return void
	 */
	public void moveRobot(Position newPosition) throws ToyRobotException{
		if(newPosition == null)
			throw new ToyRobotException("INVALID DIRECTION: New Position is null");
		this.position = newPosition;
	}
}
