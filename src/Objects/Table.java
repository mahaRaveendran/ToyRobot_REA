package Objects;

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
	
	public boolean isValidPosition(Position position){
		boolean result = true;
		if((position.getX() > this.column) || (position.getY() > this.row) ||
				(position.getX() < 0) || (position.getY() < 0))
			result = false;
		return result;
	}
}
