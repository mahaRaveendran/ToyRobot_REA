package Objects;

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
	
	public Position changePosition(Position p){
		Position pos = new Position();
		pos.x = this.x+p.x;
		pos.y = this.y+p.y;
		pos.direction = p.direction;
		return pos;
		
	}
	
	public Position moveForward(){
		if(this.direction != null){
			
		}
		
		Position newPosition = new Position(this);
		
		
		return newPosition;
	}
}
