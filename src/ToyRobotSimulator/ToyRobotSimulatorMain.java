package ToyRobotSimulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import Objects.Command;
import Objects.Table;
import Objects.ToyRobot;

public class ToyRobotSimulatorMain {
	public static void main(String[] args) throws IOException{
		
		InputStream is = new FileInputStream(new File("/Users/nav/Documents/sowmya/ToyRobot/ToyRobot_REA/src/ToyRobotInput/InputFile"));
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		List<String> commands = new ArrayList<String>();

		String line = null;
		while((line = br.readLine()) != null){
			System.out.println("Input Line : " + line);
			commands.add(line);
		}
		
		Table table = new Table(5,5);
		boolean output = placeRobot(0,0);
		ToyRobot robot = new ToyRobot();
		
		
		for(String command : commands){
			Command commandType = getCommandType(command);
			switch(commandType){
			
				case LEFT:
					output = robot.turnLeft();
							break;
				case RIGHT:
					output = robot.turnRight();
							break;
				case MOVE:
					
							break;
				case PLACE:
							break;
				case REPORT:
							break;
			}
		}
		br.close();
	}

	private static boolean placeRobot(int i, int j) {

		
		
		return false;
	}

	private static Command getCommandType(String command) {
		
		Command inputCommand = null;
		Command[] commands = Command.values();
		for(Command com: commands){
			if(command.contains(com.toString())){
				 inputCommand = com;
				break;
			}
		}
		return inputCommand;
	}
}
