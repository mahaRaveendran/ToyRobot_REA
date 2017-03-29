package ToyRobotException;

public class ToyRobotException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ToyRobotException(String string){
		super(string);
	}
	
	public ToyRobotException(String string, Throwable throwable){
		super(string, throwable);
	}
	
	public ToyRobotException(Throwable throwable){
		super(throwable);
	}
}
