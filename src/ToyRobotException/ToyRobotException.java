package ToyRobotException;

/**
* The ToyRobotException class contains the custom exception
* 	for the Toy Robot Simulator
*
* @author  Mahalakshmi Raveendran
* @version 1.0
* @since   2017-03-29
*/
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
