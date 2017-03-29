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

public class ToyRobotSimulatorMain {
	
	public static void main(String[] args) throws IOException, ToyRobotException{
		
		InputStream is = new FileInputStream(new File("/Users/nav/Documents/sowmya/ToyRobot/ToyRobot_REA/src/ToyRobotInput/InputFile"));
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		List<String> commands = new ArrayList<String>();
		System.out.println("Input Line : ");
		String line = null;
		while((line = br.readLine()) != null){
			System.out.println(line);
			commands.add(line);
		}
		
		Table table = new Table(5,5);
		ToyRobot robot = new ToyRobot();
		ToyRobotSimulator robotSimulator = new ToyRobotSimulator(robot, table);
		String output = robotSimulator.executeCommands(commands);
		
		System.out.println("\n"+output);
		br.close();
	}
}
