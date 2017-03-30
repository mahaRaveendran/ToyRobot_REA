package ToyRobotJunit;

import ToyRobotSimulator.ToyRobotSimulator;

import java.util.List;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Objects.Table;
import Objects.ToyRobot;
import ToyRobotException.ToyRobotException;

/**
* The ToyRobotTest class consists of the Junit Test cases for the 
* various unit test cases of Toy Robot
*
* @author  Mahalakshmi Raveendran
* @version 1.0
* @since   2017-03-29
*/

public class ToyRobotTest {
	
		ToyRobot robot = new ToyRobot();
		Table table = new Table(5,5);
		ToyRobotSimulator testerRobot = new ToyRobotSimulator(robot, table);
		List<String> commands;

		/**
		 * throw When Invalid Commands.
		 * @result Throws a toy Robot Exception when there is no 
		 * 			Valid Place Commands found in the input
		 */
		@Test
		public void WhenInvalidCommads() throws ToyRobotException{
			
			int count = 0;
			
			ArrayList<String> input = new ArrayList<String>();
			input.add("MOVE\n REPORT");
			input.add("PLACE 0\nMOVE\nREPORT");
			input.add("PLACE 0,0\nMOVE\nREPORT");
			input.add("PLACE 0,NORTH\nMOVE\nREPORT");
			input.add("PLACE NORTH\nMOVE\nREPORT");
			
			ArrayList<String> output = new ArrayList<String>();
			output.add("INVALID INPUT FILE :: No Valid Place Commands Found in Input File");
			output.add("INVALID PLACE COMMAND :: Invalid Place Command Parameters");
			output.add("INVALID PLACE COMMAND :: Invalid Place Command Parameters");
			output.add("INVALID PLACE COMMAND :: Invalid Place Command Parameters");
			output.add("INVALID PLACE COMMAND :: Invalid Place Command Parameters");
			
			for(String cmd: input){
				commands = new ArrayList<String>();
				commands = getCommandList(cmd);
				assertEquals("When Invalid Commands are given to the robot",output.get(count),testerRobot.executeCommands(commands));
				count++;
			}
		}
		
		/**
		 * throw When Invalid Move Command Type has parameters.
		 * @result Throws a toy Robot Exception when the move command
		 * 			contains any extra parameters
		 */
		@Test
		public void throwWhenInvalidMoveCommadParams() throws ToyRobotException{
			
			String input = "PLACE 0,0,NORTH\nMOVE 0\nLEFT\nRIGHT\nREPORT";
			commands = getCommandList(input);
			assertEquals("When Invalid move Commands are given to the robot",
					"INVALID COMMAND TYPE :: Only PLACE command can have parameters",testerRobot.executeCommands(commands));
		}
		
		/**
		 *  throw When Invalid Left Command Type.
		 * @result Throws a toy Robot Exception when the left command
		 * 			contains any extra parameters
		 */
		@Test
		public void throwWhenInvalidLeftCommadParams() throws ToyRobotException{
			
			String input = "PLACE 0,0,NORTH\nMOVE\nLEFT 0\nRIGHT\nREPORT";
			commands = getCommandList(input);
			assertEquals("When Invalid left Commands are given to the robot",
					"INVALID COMMAND TYPE :: Only PLACE command can have parameters",testerRobot.executeCommands(commands));
		}
		
		/**
		 *  throw When Invalid Right Command Type.
		 * @result Throws a toy Robot Exception when the Right command
		 * 			contains any extra parameters
		 */
		@Test
		public void throwWhenInvalidRightCommadParams() throws ToyRobotException{
			
			String input = "PLACE 0,0,NORTH\nMOVE\nLEFT\nRIGHT 0\nREPORT";
			commands = getCommandList(input);
			assertEquals("When Invalid right Commands are given to the robot",
					"INVALID COMMAND TYPE :: Only PLACE command can have parameters",testerRobot.executeCommands(commands));
		}
		
		/**
		 *  throw  When Invalid Report Command Type.
		 * @result Throws a toy Robot Exception when the REport command
		 * 			contains any extra parameters
		 */
		@Test
		public void throwWhenInvalidReportCommadParams() throws ToyRobotException{
			
			String input = "PLACE 0,0,NORTH\nMOVE\nLEFT\nRIGHT\nREPORT 0";
			commands = getCommandList(input);
			assertEquals("When Invalid report Commands are given to the robot",
					"INVALID COMMAND TYPE :: Only PLACE command can have parameters",testerRobot.executeCommands(commands));
		}
		
		/**
		 *  throw  When Invalid Report Command Type.
		 * @result Throws a toy Robot Exception when the REport command
		 * 			contains any extra parameters
		 */
		@Test
		public void throwWhenInvalidPlaceCommadParams() throws ToyRobotException{
			
			String input = "PLACE0,0,NORTH\nMOVE\nREPORT";
			commands = getCommandList(input);
			assertEquals("When Invalid report Commands are given to the robot",
					"INVALID PLACE COMMAND :: Invalid Place Command Parameters",testerRobot.executeCommands(commands));
		}
		
		/**
		 *  Ignore Commands when Movement of robot causes it To Fall Off The Table.
		 * @result Ignore the commands which causes the robot to fall off the table
		 */
		@Test
		public void MovementToFallOffTheTable() throws ToyRobotException{
			
			int count = 0;
			
			ArrayList<String> input = new ArrayList<String>();
			input.add("PLACE 4,4,EAST\nMOVE\nMOVE\nRIGHT\nMOVE\nREPORT");
			input.add("PLACE 0,0,EAST\nMOVE\nMOVE\nMOVE\nMOVE\nMOVE\nMOVE\nRIGHT\nMOVE\nREPORT");
			input.add("PLACE 4,4,WEST\nMOVE\nMOVE\nMOVE\nMOVE\nMOVE\nRIGHT\nMOVE\nREPORT");
			input.add("PLACE 0,0,WEST\nMOVE\nMOVE\nMOVE\nMOVE\nMOVE\nMOVE\nRIGHT\nMOVE\nREPORT");
			input.add("PLACE 4,4,NORTH\nMOVE\nMOVE\nRIGHT\nMOVE\nMOVE\nMOVE\nREPORT");
			input.add("PLACE 0,0,NORTH\nMOVE\nMOVE\nMOVE\nMOVE\nMOVE\nMOVE\nRIGHT\nMOVE\nREPORT");
			input.add("PLACE 4,4,SOUTH\nMOVE\nMOVE\nMOVE\nMOVE\nMOVE\nRIGHT\nMOVE\nREPORT");
			input.add("PLACE 0,0,SOUTH\nMOVE\nMOVE\nMOVE\nMOVE\nMOVE\nMOVE\nRIGHT\nMOVE\nREPORT");
			input.add("PLACE 0,0,NORTH\nMOVE\nREPORT");
			input.add("Place 0,0,north\nMove\nreport");
			
			ArrayList<String> output = new ArrayList<String>();
			output.add("5,3,SOUTH");
			output.add("5,0,SOUTH");
			output.add("0,5,NORTH");
			output.add("0,1,NORTH");
			output.add("5,5,EAST");
			output.add("1,5,EAST");
			output.add("3,0,WEST");
			output.add("0,0,WEST");
			output.add("0,1,NORTH");
			output.add("0,1,NORTH");
			
			for(String cmd: input){
				commands = new ArrayList<String>();
				commands = getCommandList(cmd);
				assertEquals("Movement that will make the robot fall off the table",output.get(count),testerRobot.executeCommands(commands));
				count++;
			}
		}
		
		/**
		 *  Discard any Command until Valid Place Command.
		 * @result Discard any command until a valid Place command
		 * 			is issued
		 */
		@Test
		public void DiscardanyCommanduntilValidPlaceCommand() throws ToyRobotException{
			
			String input = "MOVE\nREPORT\nPLACE 0,0,NORTH\nMOVE\nREPORT\nLEFT\nPLACE 1,2,EAST\nMOVE\nMOVE\nMOVE\nMOVE\nMOVE\nMOVE"
					+ "\nMOVE\nPLACE 3,3,SOUTH\nPLACE 1,2,WEST\nMOVE\nREPORT\nRIGHT\nREPORT\nLEFT\nREPORT\nREPORT";
			commands = getCommandList(input);
			assertEquals("Discard any command until a valid Place Command","0,2,WEST",testerRobot.executeCommands(commands));
		}
		
		/**
		 *  Unordered Multiple Place Commands.
		 * @result Set of commands with multiple unordered Place Commands
		 */
		@Test
		public void UnorderedMultiplePlaceCommands() throws ToyRobotException{
			
			String input = "PLACE 0,0,NORTH\nMOVE\nREPORT\nMOVE\nREPORT\nLEFT\nPLACE 1,2,EAST\nMOVE\nMOVE\nMOVE\nMOVE"
					+ "\nMOVE\nMOVE\nMOVE\nPLACE 3,3,SOUTH\nPLACE 1,2,WEST\nMOVE\nREPORT\nRIGHT\nREPORT\nLEFT\nREPORT\nREPORT";
			commands = getCommandList(input);
			assertEquals("Unordered Multiple Place Command","0,2,WEST",testerRobot.executeCommands(commands));
		}
		
		/**
		 *  Move Cmd Moves One Step Forward.
		 * @result Move command will move only one step forward
		 */
		@Test
		public void MoveCmdMovesOneStepForward() throws ToyRobotException{
			
			String input = "PLACE 4,0,NORTH\nMOVE\nREPORT";
			commands = getCommandList(input);
			assertEquals("Move Command moves only one step forward","4,1,NORTH",testerRobot.executeCommands(commands));
		}
		
		/**
		 *  Move Cmd Does Not Move IF Robot Is Going To Fall.
		 * @result Move command will not move if the robot is 
		 * 			about to fall off from the table
		 */
		@Test
		public void MoveCmdDoesNotMoveIFRobotIsGoingToFall() throws ToyRobotException{
			
			String input = "PLACE 0,5,NORTH\nMOVE\nREPORT";
			commands = getCommandList(input);
			assertEquals("Move command does not move if the Robot is about to fall off the table",
					"0,5,NORTH",testerRobot.executeCommands(commands));
		}
		
		/**
		 *  Left Cmd Rotates Left Without Changing Position.
		 * @result Left command will only rotate left without
		 * 			changing the robot position
		 */
		@Test
		public void LeftCmdRotatesLeftWithoutChangingPosition() throws ToyRobotException{
			
			String input = "PLACE 0,1,NORTH\nLEFT\nREPORT";
			commands = getCommandList(input);
			assertEquals("Left Command will rotate left without changing Position","0,1,WEST",testerRobot.executeCommands(commands));
		}
		
		/**
		 *  Right Cmd Rotates Left Without Changing Position.
		 * @result Right command will only rotate left without
		 * 			changing the robot position
		 */
		@Test
		public void RightCmdWillRotateWithoutChangingPosition() throws ToyRobotException{
			
			String input = "PLACE 0,1,NORTH\nRIGHT\nREPORT";
			commands = getCommandList(input);
			assertEquals("Right Command will rotate left without changing Position","0,1,EAST",testerRobot.executeCommands(commands));
		}
		
		/**
		 *  Report Cmd Report sPosition.
		 * @result Report command will only report the position of the 
		 * 			robot in the table
		 */
		@Test
		public void ReportCmdReportsPosition() throws ToyRobotException{
			
			String input = "PLACE 5,5,NORTH\nREPORT";
			commands = getCommandList(input);
			assertEquals("Report Command reports Robot Position","5,5,NORTH",testerRobot.executeCommands(commands));
		}
		
		/**
		 *  Ignore Cmd Outside Table
		 * @result Ignore the command that is made outside the square board
		 */
		@Test
		public void IgnoreCmdOutsideTable() throws ToyRobotException{
			
			String input = "PLACE 20,5,NORTH\nMOVE\nREPORT\nLEFT\nRIGHT\nREPORT";
			commands = getCommandList(input);
			assertEquals("Ignore Commands that move the ronot outside the Table"," ",testerRobot.executeCommands(commands));
		}
		
		/**
		 *  Report Cmd Alone Reports Position
		 * @result Report command will alone report the position of the 		
		 * 			robot in the table
		 */
		@Test
		public void ReportCmdAloneReportsPosition() throws ToyRobotException{
			
			ArrayList<String> input = new ArrayList<String>();
			input.add("PLACE 20,5,NORTH\nMOVE\nREPORT\nLEFT\nRIGHT");
			input.add("PLACE 20,5,NORTH\nMOVE\nREPORT\nLEFT");
			input.add("PLACE 20,5,NORTH\nMOVE");
			input.add("PLACE 20,5,NORTH\nMOVE");
			
			for(String cmd: input){
				commands = new ArrayList<String>();
				commands = getCommandList(cmd);
				assertEquals("Only Report Command reports Position"," ",testerRobot.executeCommands(commands));
			}
		}
		
		/**
		 *  Reports if any other word is given in place of a command
		 * @result Report command will alone report the position of the 		
		 * 			robot in the table
		 */
		@Test
		public void InvalidCommand() throws ToyRobotException{
			
			String input = "PLACE 0,0,EAST\nMOVE\nJUMP\nMOVE\nMOVE\nMOVE\nMOVE\nRIGHT\nMOVE\nREPORT";
			commands = getCommandList(input);
			assertEquals("Reports if any other word is given in place of a command",
					"INVALID INPUT FILE :: Invalid Command found in input file",testerRobot.executeCommands(commands));
		}
		
		/**
		 *  Reports commands that were issued out of the table
		 * @result Report command will alone report the position of the 		
		 * 			robot in the table
		 */
		@Test
		public void ignoreCommandsOutisdeTable() throws ToyRobotException{
			
			String input = "MOVE\nMOVE\nREPORT\nLEFT\nRIGHT\nMOVE\nREPORT";
			commands = getCommandList(input);
			assertEquals("Reports commands that were issued out of the table",
					"INVALID INPUT FILE :: No Valid Place Commands Found in Input File",testerRobot.executeCommands(commands));
		}
		
		/**
		 *  Reports commands if they are not PLACE,MOVE,LEFT,RIGHT,REPORT
		 * @result Report command will alone report the position of the 		
		 * 			robot in the table
		 */
		@Test
		public void throwInvalidCommands() throws ToyRobotException{
			
			String input = "PLACE 0,0,EAST\nMOVE\nJUMP\nMOVE\nMOVE\nMOVE\nMOVE\nRIGHT\nMOVE\nREPORT";
			commands = getCommandList(input);
			assertEquals("Reports commands that are not PLACE, MOVE, LEFT, RIGHT, REPORT ",
					"INVALID INPUT FILE :: Invalid Command found in input file",testerRobot.executeCommands(commands));
		}
		
		
		
		/**
		 *  Get command list from the String input
		 * @param cmds String
		 * @return 	List<String> 		
		 * 			
		 */
		public List<String> getCommandList(String cmds){
			List<String> commands = new ArrayList<String>();
			
			if(cmds != null){
				String[] cmdList = cmds.split("\n");
				for(String cmd: cmdList){
					commands.add(cmd);}
			}
			
			return commands;
		}
}
