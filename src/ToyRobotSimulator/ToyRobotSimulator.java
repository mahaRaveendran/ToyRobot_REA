package ToyRobotSimulator;

import java.util.List;

import Objects.Command;
import Objects.Direction;
import Objects.Position;
import Objects.Table;
import Objects.ToyRobot;
import ToyRobotException.ToyRobotException;

/**
* The ToyRobotSimulatorMain class contains the basic methods
* 	for the movement of the toy robot
*
* @author  Mahalakshmi Raveendran
* @version 1.0
* @since   2017-03-29
*/

public class ToyRobotSimulator {
	
	ToyRobot robot;
	Table table;
	
	public ToyRobotSimulator(ToyRobot robot, Table table){
		this.robot = robot;
		this.table = table;
	}
	
	/**
	 * Method : placeRobot
	 * 			Places the robot in the position specified
	 * @param position Position
	 * @return boolean
	 */
	private boolean placeRobot(Position position) throws ToyRobotException {
		
		if(position!= null && position.getDirection() != null && table != null)
		{
			robot.setPosition(position);
		}
		return false;
	}

	/**
	 * Method : getCommandType
	 * 			Retrieves the type of command from the input string
	 * @param command String
	 * @return Command
	 */
	private static Command getCommandType(String command) {
		
		Command inputCommand = null;
		Command[] commands = Command.values();
		for(Command com: commands){
			if(command.toUpperCase().contains(com.toString().toUpperCase())){
				 inputCommand = com;
				break;
			}
		}
		return inputCommand;
	}
	
	/**
	 * Method : executeCommands
	 * 			Executes the commands on the toy robot
	 * @param commands List<String>
	 * @return String
	 */
	public String executeCommands(List<String> commands) throws ToyRobotException {
		// TODO Auto-generated method stub
		String output = null;
		int count = 0;
		boolean flag = false;
		
		for(String command : commands){
			//retrieve Command type
			Command commandType = getCommandType(command);
			if(commandType != null){
			//check if a valid place command is present in the entire set of input
			if(commandType.toString().equalsIgnoreCase(Command.PLACE.toString()))
				count++;
			switch(commandType){
				
				case LEFT:
							if(flag){
								if(validateFormat(command)){
								robot.turnLeft();
								output = "";
								}else{
									output = "INVALID COMMAND TYPE :: Only PLACE command can have parameters";
									return output;
							}}
							break;
				case RIGHT:
							if(flag){
								if(validateFormat(command)){
								robot.turnRight();
								output = "";
								}else{
									output = "INVALID COMMAND TYPE :: Only PLACE command can have parameters";
									return output;
								}}
							break;
				case MOVE:
							if(flag){
								if(validateFormat(command)){
								Position newPosition = robot.getPosition().moveForward();
								if(table.isValidPosition(newPosition))
									robot.moveRobot(newPosition);
								output = " ";
								}else{
									output = "INVALID COMMAND TYPE :: Only PLACE command can have parameters";
									return output;
								}}
							break;
				case PLACE:
							if(isValidPlaceCommand(command)){
							Position position = getPlaceParameters(command);
							if(table.isValidPosition(position)){
								output = String.valueOf(placeRobot(position));
								flag = true;}
							else{
								output = " ";}}else {
									output = "INVALID PLACE COMMAND :: Invalid Place Command Parameters";
									return output;
								}
							break;
				case REPORT:
							if(flag){
								if(validateFormat(command)){
								output = report();
								}else{
									output = "INVALID COMMAND TYPE :: Only PLACE command can have parameters";
									return output;
								}}
							break;
				default:
							output = "";
			}
		}else{
			output = "INVALID INPUT FILE :: Invalid Command found in input file";
			return output;
		}
		}
		if(count == 0)
			output = "INVALID INPUT FILE :: No Valid Place Commands Found in Input File";
		
		return output;
	}
	
	/**
	 * Method : isValidPlaceCommand
	 * 			VAlidate the format of the Place Command
	 * @param commands String
	 * @return boolean
	 */
	private boolean isValidPlaceCommand(String command) {

		boolean flag = true;
		String[] placeArguments = command.split(" ");
		if(placeArguments.length < 2){
			flag = false;
			return flag;
		}
		String[] positionParams = placeArguments[1].split(",");
		if(positionParams.length < 3 || positionParams[0] == null || 
				positionParams[1] == null || positionParams[2] == null)
			flag = false;
		
		return flag;
	}

	/**
	 * Method : validateFormat
	 * 			VAlidate the format of the various input commands
	 * @param commands String
	 * @return boolean
	 */
	private boolean validateFormat(String command) throws ToyRobotException {
		// TODO Auto-generated method stub
		boolean output = true;
		if(command.toUpperCase().contains(Command.MOVE.toString().toUpperCase()) || 
				command.toUpperCase().contains(Command.REPORT.toString().toUpperCase()) ||
				command.toUpperCase().contains(Command.LEFT.toString().toUpperCase()) ||
				command.toUpperCase().contains(Command.RIGHT.toString().toUpperCase())){
			String[] cmdParams = command.split(" ");
			if(cmdParams.length > 1)
				output = false;
		}
		return output;
	}
	
	/**
	 * Method : report
	 * 			reports the position of the robot on the table
	 * @return String
	 * @throws ToyRobotException 
	 */
	private String report() throws ToyRobotException {
		if(robot.getPosition() == null){
			throw new ToyRobotException("report :: Position Object is null");
		}
		return robot.getPosition().getX()+","+robot.getPosition().getY()+","+robot.getPosition().getDirection().toString()+"";
	}
	
	/**
	 * Method : getPlaceParameters
	 * 			Retrieves the place parameters from the input command
	 * @param commands String
	 * @return Position
	 */
	private Position getPlaceParameters(String command) throws ToyRobotException {
		
		String[] placeArguments = command.split(" ");
		String[] positionParams = placeArguments[1].split(",");
		Position position = new Position(Integer.parseInt(positionParams[0]), 
				Integer.parseInt(positionParams[1]), Direction.valueOf(positionParams[2].toUpperCase()));
		return position;
	}
}
