package ToyRobotSimulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import Objects.Table;
import Objects.ToyRobot;
import ToyRobotException.ToyRobotException;

/**
* The ToyRobotSimulatorMain class is the main point of execute to 
* place the commands of the Toy Robot
*
* @author  Mahalakshmi Raveendran
* @version 1.0
* @since   2017-03-29
*/

public class ToyRobotSimulatorMain {
	
	/**
	 * Main Method : main thread of execution
	 * @param args String[]
	 * @return void
	 */
	public static void main(String[] args) throws IOException, ToyRobotException{
		
		// InputFile.txt - contains the commands that are execute for the movement of the Toy Robot
		InputStream is = new FileInputStream(new File("/Users/nav/Documents/sowmya/ToyRobot/ToyRobot_REA/src/ToyRobotInput/InputFile"));
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		List<String> commands = new ArrayList<String>();
		System.out.println("Input Line : ");
		String line = null;
		//Read File
		while((line = br.readLine()) != null){
			System.out.println(line);
			commands.add(line);
		}
		
		//Initialize Square Board(5*5) as the Table 
		Table table = new Table(5,5);
		ToyRobot robot = new ToyRobot();
		ToyRobotSimulator robotSimulator = new ToyRobotSimulator(robot, table);
		//Execute Commands
		String output = robotSimulator.executeCommands(commands);
		
		System.out.println("\n"+output);
		br.close();
	}
}
