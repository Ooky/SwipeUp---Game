package Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OwnFileReader {
	private BufferedReader bf;
	private FileReader fr;
	
	public ArrayList<String> stringFromFile(String path){
		FileHandle file = Gdx.files.internal(path);
		String text = file.readString();
		ArrayList<String> returnString = new ArrayList<String>();
		for(String string : text.split("\\r?\\n")){
			returnString.add(string);	
		}
		return returnString;
	}
}
