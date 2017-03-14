package Tools;

import java.util.ArrayList;

public final class LevelGenerator {

	private static int[][] arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady = new int[16][26];
	private static OwnFileReader fileReader = new OwnFileReader();
	private static ArrayList<String> levelList;
	
	public static int[][] generateLevel(int level) {
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady = new int[16][26];
		//SETUP
		switch(level){
			case 1:	
			levelList = fileReader.stringFromFile("Level/1.txt");
			for(String levelPart : levelList){
				String[] values = levelPart.split(";");
				arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[Integer.parseInt(values[0])][Integer.parseInt(values[1])] = Integer.parseInt(values[2]);	
			}
		break;
		case 2:
			levelList = fileReader.stringFromFile("Level/2.txt");
			for(String levelPart : levelList){
				String[] values = levelPart.split(";");
				arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[Integer.parseInt(values[0])][Integer.parseInt(values[1])] = Integer.parseInt(values[2]);	
			}
		break;
		case 3:				
			levelList = fileReader.stringFromFile("Level/3.txt");
			for(String levelPart : levelList){
				String[] values = levelPart.split(";");
				arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[Integer.parseInt(values[0])][Integer.parseInt(values[1])] = Integer.parseInt(values[2]);	
			}
			break;
			default:				
			levelList = fileReader.stringFromFile("Level/default.txt");
			for(String levelPart : levelList){
				String[] values = levelPart.split(";");
				arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[Integer.parseInt(values[0])][Integer.parseInt(values[1])] = Integer.parseInt(values[2]);	
			}
			break;
		}
		return arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady;
	}
}
