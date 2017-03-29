package Objects;

/**
* The Table class outlines the structure 
* of the board for the movement of the toy robot
*
* @author  Mahalakshmi Raveendran
* @version 1.0
* @since   2017-03-29
*/

public class Table {
	
	int row;
	int column;
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}	
	
	public Table(int row, int column){
		this.row = row;
		this.column = column;
	}
	
	public Table(){
		this.row = 0; 
		this.column = 0;
	}
	
	/**
	 * Method : isValidPosition
	 * 			finds if the given position if a valid position
	 * 			that is inside the square board for the toy robot to move
	 * @param p Position
	 * @return Position
	 */
	public boolean isValidPosition(Position position){
		boolean result = true;
		if((position.getX() > this.column) || (position.getY() > this.row) ||
				(position.getX() < 0) || (position.getY() < 0))
			result = false;
		return result;
	}
}
