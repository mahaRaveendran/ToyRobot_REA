package Objects;

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

	public boolean turnLeft(){
		if(this.position.getDirection() == null)
			return false;
		this.position.setDirection(this.position.getDirection().leftDirection());
		return true;
	}
	
	public boolean turnRight(){
		if(this.position.getDirection() == null)
			return false;
		this.position.setDirection(this.position.getDirection().rightDirection());
		return true;
	}
	
	public boolean setPosition(Position position) {
		if(position == null)
			return false;
		this.position = position;
		return true;
	}
	
	public boolean moveRobot(Position newPosition){
		if(newPosition == null)
			return false;
		this.position = newPosition;
		return true;
	}
}
