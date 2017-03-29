package ToyRobotSimulator;

import java.util.List;

import Objects.Command;
import Objects.Direction;
import Objects.Position;
import Objects.Table;
import Objects.ToyRobot;
import ToyRobotException.ToyRobotException;

public class ToyRobotSimulator {
	
	ToyRobot robot;
	Table table;
	
	public ToyRobotSimulator(ToyRobot robot, Table table){
		this.robot = robot;
		this.table = table;
	}
	
	private boolean placeRobot(Position position) {
		
		if(position!= null && position.getDirection() != null && table != null)
		{
			robot.setPosition(position);
		}
		return false;
	}

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
	public String executeCommands(List<String> commands) throws ToyRobotException {
		// TODO Auto-generated method stub
		String output = null;
		int count = 0;
		
		for(String command : commands){
			Command commandType = getCommandType(command);
			if(commandType.toString().equalsIgnoreCase(Command.PLACE.toString()))
				count++;
			switch(commandType){
				
				case LEFT:
					output = String.valueOf(robot.turnLeft());
							break;
				case RIGHT:
					output = String.valueOf(robot.turnRight());
							break;
				case MOVE:
				    Position newPosition = robot.getPosition().moveForward();
				    if(table.isValidPosition(newPosition)){
				    	output = String.valueOf(robot.moveRobot(newPosition));
				    }else{
				    	output = String.valueOf(false);
				    }
							break;
				case PLACE:
					Position position = getPlaceParameters(command);
					output = String.valueOf(placeRobot(position));
							break;
				case REPORT:
					output = report();
							break;
				default:
					output = report();
					//exception;
			}
		}
		if(count == 0)
			output = "INVALID INPUT FILE :: No Valid Place Commands Found in Input File";
		return output;
	}

	private String report() {
		if(robot.getPosition() == null){
			//exception
		}
		// TODO Auto-generated method stub
		return robot.getPosition().getX()+","+robot.getPosition().getY()+","+robot.getPosition().getDirection().toString()+"";
	}

	private Position getPlaceParameters(String command) throws ToyRobotException {
		
		String[] placeArguments = command.split(" ");
		String[] positionParams = placeArguments[1].split(",");
		if(positionParams.length < 3 || positionParams[0] == null || 
				positionParams[1] == null || positionParams[2] == null){
			throw new ToyRobotException("INVALID PLACE COMMAND STRUCTURE");
		}
		Position position = new Position(Integer.parseInt(positionParams[0]), 
				Integer.parseInt(positionParams[1]), Direction.valueOf(positionParams[2].toUpperCase()));
		return position;
	}
}
